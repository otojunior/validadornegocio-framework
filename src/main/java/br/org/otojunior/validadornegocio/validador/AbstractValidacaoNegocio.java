/**
 * 
 */
package br.org.otojunior.validadornegocio.validador;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public abstract class AbstractValidacaoNegocio implements ValidacaoNegocio {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract List<Supplier<List<ViolacaoRestricao>>> validadores();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<List<ViolacaoRestricao>> validar() {
		return validadores()
			.stream()
			.map(Supplier::get)
			.collect(Collectors.toList());
	}
}
