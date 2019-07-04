/**
 * 
 */
package br.org.otojunior.validadornegocio.validador;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;

/**
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 *
 */
@Getter
public class ViolacaoRestricao {
	private String mensagem;
	private List<String> argumentos;

	/**
	 * @param mensagem
	 * @param argumentos
	 */
	private ViolacaoRestricao(String mensagem, List<String> argumentos) {
		this.mensagem = mensagem;
		this.argumentos = argumentos;
	}
	
	/**
	 * 
	 * @param mensagem
	 * @return
	 */
	public static ViolacaoRestricao of(String mensagem) {
		return of(mensagem, Collections.emptyList());
	}
	/**
	 * 
	 * @param mensagem
	 * @param argumentos
	 * @return
	 */
	public static ViolacaoRestricao of(String mensagem, List<String> argumentos) {
		return new ViolacaoRestricao(mensagem, argumentos);
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
	}
}
