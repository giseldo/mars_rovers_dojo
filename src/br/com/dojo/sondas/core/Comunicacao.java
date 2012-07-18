package br.com.dojo.sondas.core;

public class Comunicacao {

	public void executarInstrucaoProtocolo(String string, Sonda sonda1)
			throws Exception {
		char[] instrucoes = string.toCharArray();
		for (char instrucao : instrucoes) {
			if (instrucao == 'M') {
				sonda1.move();
			} else {
				sonda1.gira(instrucao);
			}
		}
	}

	public Sonda iniciarSonda(String string) {
		String[] instrucoes = string.split(" ");
		Sonda sonda = new Sonda(Integer.parseInt(instrucoes[0]),
				Integer.parseInt(instrucoes[1]), instrucoes[2].charAt(0));
		return sonda;
	}

	public String executarProtocolo(String string) throws Exception {
		String[] linhas = string.split("\n");
		String platoSize = linhas[0];
		String posicalInicial = linhas[1];
		String instrucao = linhas[2];
		Sonda sonda = iniciarSonda(posicalInicial);
		executarInstrucaoProtocolo(instrucao, sonda);
		return sonda.getPosition();
	}

}
