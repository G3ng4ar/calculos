package app.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CalculosService;

@SpringBootTest // Contexto do Spring nos testes
public class CalculosServiceTest {

	@Autowired
	private CalculosService calculosService;

	@Test // JUNIT - indicação de método de teste
	@DisplayName("Teste unitário - Cenário de Moda = 2")
	void cenario01() {

		List<Integer> lista = new ArrayList<>();
		lista.add(4);
		lista.add(2);
		lista.add(2);

		List<Integer> moda = calculosService.moda(lista);

		List<Integer> listaEsperada = new ArrayList<>();
		listaEsperada.add(2);

		Assertions.assertEquals(listaEsperada, moda, "Valor não correspondente ao esperado..."); // JUNIT - verificações
																									// - teste em
		// si

	}

	@Test
	@DisplayName("Teste unitário - Valores de Moda não podem ser nulos")
	void cenario02() {

		List<Integer> lista = new ArrayList<>();

		List<Integer> moda = calculosService.moda(lista);

		assertNotNull(moda, "Teste não pode conter valores nulos..."); // JUNIT - verificações - teste em si
	}

	@Test
	@DisplayName("Teste unitário - Cenário de Soma = 11")
	void cenario03() {

		List<Integer> lista = new ArrayList<>();
		lista.add(5);
		lista.add(4);
		lista.add(2);

		int soma = calculosService.somar(lista);

		int resultado = 11;

		assertTrue(soma == resultado, "Valor não correspondente ao esperado...");
	}

	@Test
	@DisplayName("Teste unitário - Valor de Soma não pode ser nulo")
	void cenario04() {
		List<Integer> lista = new ArrayList<>();
		lista.add(0);

		int soma = calculosService.somar(lista);

		assertNotNull(soma, "Lista não pode conter valor nulo");
	}

	@Test
	@DisplayName("Teste unitário - Valor de Media = 3")
	void cenario05() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(5);
		lista.add(3);

		int media = calculosService.media(lista);

		Assertions.assertEquals(media, 3);
	}

	@Test
	@DisplayName("Teste unitario - Valor de Media não pode ser nulo")
	void cenario06() {
		List<Integer> lista = new ArrayList<>();
		lista.add(0);

		int media = calculosService.media(lista);

		assertNotNull(media, "Valor de Media não pode ser nulo...");
	}

	@Test
	@DisplayName("Teste unitário - Teste de Multiplicação = 8")
	void cenario07() {
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(2);
		lista.add(2);

		double mult = calculosService.multiplicar(lista);

		Assertions.assertEquals(mult, 8, "Valor não correspondente ao esperado...");
	}

	@Test
	@DisplayName("Teste unitário - Teste de Multiplicação não pode ser nulo")
	void cenario08() {
		List<Integer> lista = new ArrayList<>();
		lista.add(0);

		double mult = calculosService.multiplicar(lista);

		assertNotNull(mult, "Valor de Multiplicação não pode ser nulo");
	}

	@Test
	@DisplayName("Teste unitário - Teste de Maior Número = 3")
	void cenario09() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);

		double maiorNum = calculosService.maiorNumList(lista);

		assertEquals(maiorNum, 3, "Maior número não corresponde...");
	}

	@Test
	@DisplayName("Teste unitário - Teste de Maior número = 4")
	void cenario10() {
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(3);
		lista.add(4);

		int maiorNum = calculosService.maiorNumList(lista);

		boolean condicao = (maiorNum < 5) ? true : false;

		assertThat(condicao).isTrue();

	}

	@Test
	@DisplayName("Teste unitário - Teste de Menor número = 1")
	void cenario11() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(5);
		lista.add(7);

		int menorNum = calculosService.menorNumList(lista);

		boolean condicao = (menorNum > 0) ? true : false;

		assertThat(condicao).isTrue();
	}

	@Test
	@DisplayName("Teste unitário - Teste de Menor número")
	void cenario12() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(5);
		lista.add(7);

		int menorNum = calculosService.menorNumList(lista);

		assertNotEquals(0, menorNum, "Menor valor não corresponde");
	}

	@Test
	@DisplayName("Teste unitário - Teste total de elementos lista")
	void cenario13() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(5);
		lista.add(7);
		lista.add(11);
		lista.add(25);

		int total = calculosService.totalElementos(lista);

		assertAll("heading", () -> assertEquals(total, 5, "Número de objetos na lista não corresponde..."),
				() -> assertNotNull(total, "A lista deve possuir no mínimo 1 elemento"));
	}

}
