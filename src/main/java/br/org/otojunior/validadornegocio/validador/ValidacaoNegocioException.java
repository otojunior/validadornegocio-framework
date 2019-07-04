/**
 * 
 */
package br.org.otojunior.validadornegocio.validador;

import java.util.List;

import lombok.Getter;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Getter
public class ValidacaoNegocioException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private List<ViolacaoRestricao> violacoes;
	
	/**
	 * Contrutor padrão.
	 * @param violacoes
	 */
	public ValidacaoNegocioException(List<ViolacaoRestricao> violacoes) {
		this.violacoes = violacoes;
	}
}
