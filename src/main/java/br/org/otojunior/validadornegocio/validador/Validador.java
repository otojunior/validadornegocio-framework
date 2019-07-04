/**
 * 
 */
package br.org.otojunior.validadornegocio.validador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Component
public class Validador {
	/**
	 * Valida uma determinada classe de validação de negócio
	 * @param objValidacaoNegocio
	 */
	public void validar(ValidacaoNegocio objValidacaoNegocio) {
		final List<ViolacaoRestricao> violacoes = objValidacaoNegocio
			.validar()
			.stream()
			.flatMap(List::stream)
			.collect(Collectors.toList());

		if (!violacoes.isEmpty()) {
			throw new ValidacaoNegocioException(violacoes);
		}
	}
}
