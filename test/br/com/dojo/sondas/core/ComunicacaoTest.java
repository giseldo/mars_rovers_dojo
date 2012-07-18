package br.com.dojo.sondas.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComunicacaoTest {

	@Test
	public void deveMovimentarSonda() throws Exception {
		Comunicacao aplicacao = new Comunicacao();
		Sonda sonda1 = new Sonda(1, 2, 'N');
		aplicacao.executarInstrucaoProtocolo("LMLMLMLMM", sonda1);
		assertEquals("Deve executar protocolo", "1 3 N", sonda1.getPosition());
	}

	@Test
	public void deveIniciarUmaSonda() throws Exception {
		Comunicacao aplicacao = new Comunicacao();
		Sonda sonda = aplicacao.iniciarSonda("1 2 N");
		assertNotNull(sonda);
	}

	@Test
	public void deveVerificarPosicaoOriginal() throws Exception {
		Sonda sondaEsperada = new Sonda(1, 2, 'N');
		Comunicacao aplicacao = new Comunicacao();
		Sonda sonda = aplicacao.iniciarSonda("1 2 N");
		assertEquals("Deveria ser igual", sondaEsperada.getPosition(),
				sonda.getPosition());
	}

	@Test
	public void deveExecutarProtocoloSonda1() throws Exception {
		Comunicacao aplicacao = new Comunicacao();
		assertEquals("1 3 N",
				aplicacao.executarProtocolo("5 5\n1 2 N\nLMLMLMLMM\n"));
	}
	
	@Test
	public void deveExecutarProtocoloSonda2() throws Exception {
		Comunicacao aplicacao = new Comunicacao();
		assertEquals("5 1 E",
				aplicacao.executarProtocolo("5 5\n3 3 E\nMMRMMRMRRM\n"));
	}
	
	
	
}
