/**
 * 
 */
package br.org.otojunior.validadornegocio.validador;

import java.util.List;
import java.util.function.Supplier;

/**
 * 
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public interface ValidacaoNegocio {
	/**
	 * Executa a validação do negócio.
	 * @return
	 */
	public List<List<ViolacaoRestricao>> validar();
	
	/**
	 * Retorna uma lista de validadores.
	 * @return
	 */
	public List<Supplier<List<ViolacaoRestricao>>> validadores();
}
