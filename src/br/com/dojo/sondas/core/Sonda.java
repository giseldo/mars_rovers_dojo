package br.com.dojo.sondas.core;

public class Sonda {

	private int x;
	private int y;
	private char direcao;

	private final char OESTE = 'W';
	private final char LESTE = 'E';
	private final char NORTE = 'N';
	private final char SUL = 'S';

	public Sonda(int x, int y, char direcao) {
		this.x = x;
		this.y = y;
		this.direcao = direcao;
	}

	public void move() {
		switch (direcao) {
		case NORTE:
			y++;
			break;
		case SUL:
			y--;
			break;
		case LESTE:
			x++;
			break;
		case OESTE:
			x--;
			break;
		default:
			break;
		}
	}

	public String getPosition() {
		return x + " " + y + " " + direcao;
	}

	public void gira(char c) throws Exception {
		if (c != 'L' && c != 'R') {
			throw new Exception();
		}
		switch (direcao) {
		case NORTE:
			if (c == 'L')
				direcao = OESTE;
			else
				direcao = LESTE;
			break;
		case SUL:
			if (c == 'L')
				direcao = LESTE;
			else
				direcao = OESTE;
			break;
		case LESTE:
			if (c == 'L')
				direcao = NORTE;
			else
				direcao = SUL;
			break;
		case OESTE:
			if (c == 'L')
				direcao = SUL;
			else
				direcao = NORTE;
			break;
		default:
			break;
		}
	}

}
