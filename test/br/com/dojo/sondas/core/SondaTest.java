package br.com.dojo.sondas.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class SondaTest {

	@Test
	public void deveSeMover() {
		Sonda alvo = new Sonda(1, 2, 'N');
		alvo.move();
		assertEquals("Deveria ter se movido 1 posição", "1 3 N",
				alvo.getPosition());
	}

	@Test
	public void deveSeMoverDuasCasas() {
		Sonda alvo = new Sonda(1, 2, 'N');
		alvo.move();
		alvo.move();
		assertEquals("Deveria ter se movido 2 posições", "1 4 N",
				alvo.getPosition());
	}

	@Test
	public void deveMudarDirecao() throws Exception {
		Sonda alvo = new Sonda(1, 2, 'N');
		alvo.gira('L');
		assertEquals("Deveria ter alterado a direção", "1 2 W",
				alvo.getPosition());
	}

	@Test(expected = Exception.class)
	public void deveFalharAoReceberInstrucaoInvalida() throws Exception {
		Sonda alvo = new Sonda(1, 2, 'N');
		alvo.gira('W');
		assertEquals("Deve falhar", "1 2 W", alvo.getPosition());
	}

	@Test
	public void deveMoverRover1Exemplo() throws Exception {
		Sonda alvo = new Sonda(1, 2, 'N');
		alvo.gira('L');
		alvo.move();
		alvo.gira('L');
		alvo.move();
		alvo.gira('L');
		alvo.move();
		alvo.gira('L');
		alvo.move();
		alvo.move();
		assertEquals("Deve mover corretamente", "1 3 N", alvo.getPosition());
	}

	@Test
	public void deveMoverRover2Exemplo() throws Exception {
		Sonda alvo = new Sonda(3, 3, 'E');
		alvo.move();
		alvo.move();
		alvo.gira('R');
		alvo.move();
		alvo.move();
		alvo.gira('R');
		alvo.move();
		alvo.gira('R');
		alvo.gira('R');
		alvo.move();
		assertEquals("Deve mover corretamente", "5 1 E", alvo.getPosition());
	}
	
	

}
