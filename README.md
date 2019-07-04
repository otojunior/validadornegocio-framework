### Exeplo de uso:

DemoApplication.java:
```java
@SpringBootApplication
@ComponentScan(basePackageClasses = {
	SpringBootValidadorApplication.class,
	DemoApplication.class})
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private DemoService service;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		try {
			service.executar(new DemoEntidade());
		} catch (ValidacaoNegocioException e) {
			e.getViolacoes().forEach(System.err::println);
		}
	}
}
```
  
DemoService.java:
```java
@Service
public class DemoService {
	@Autowired private ApplicationContext ctx;
	@Autowired private Validador validador;
		
	public void executar(DemoEntidade entidade) {
		validador.validar(ctx.getBean(DemoValidacaoNegocio.class, entidade));
	}
}
```
  
DemoValidacaoNegocio.java:
```java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DemoValidacaoNegocio extends AbstractValidacaoNegocio {
	private DemoEntidade entidade;
		
	public DemoValidacaoNegocio(DemoEntidade entidade) {
		this.entidade = entidade;
	}
	
	@Override
	public List<Supplier<List<ViolacaoRestricao>>> validadores() {
		return Arrays.asList(
			this::validarRegraNegocio01,
			this::validarRegraNegocio02);
	}
	
	public List<ViolacaoRestricao> validarRegraNegocio01() {
		return Collections.singletonList(ViolacaoRestricao.of("erro1"));
	}
		
	public  List<ViolacaoRestricao> validarRegraNegocio02() {
		return Collections.singletonList(ViolacaoRestricao.of("erro2"));
	}
}
```
