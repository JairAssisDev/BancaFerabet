package ifpe;

import java.util.ArrayList;
import java.util.List;

public class Roleta {
	private int min;
	private int max;
	private Sorteio sorteador;
	private RoletaEnum aposta;
	private double valorDaAposta;
	public Roleta() {
		sorteador = new Sorteio();
		min = 1;
		max = 37;
	}
	
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void fazerAposta(RoletaEnum aposta, double valorDaAposta) {
		if(valorDaAposta <= Casa.getApostaMaxima() && valorDaAposta >= Casa.getApostaMinima()) {
			if(Autenticador.getUsuario().getCarteira().transferir(Casa.getCarteira(), valorDaAposta)) {
				this.aposta = aposta;
				this.valorDaAposta = valorDaAposta;
				if(girar()) {
					System.out.println("won...");
				}else {
					System.out.println("loss...");
				}
				System.out.println("Saldo atual: " + Autenticador.getUsuario().getCarteira().getSaldoFormatado());
			}else {
				System.out.println("VOCÊ NÃO TEM SALDO SUFICIENTE");
			}
		}else {
			System.out.println("Não foi possivel realizar sua aposta.");
			System.out.println(String.format("Valor máximo: %s\nValor mínimo: %s", Casa.getApostaMaximaFormatada(),
					Casa.getApostaMinimaFormatada()));
		}
		
		
	}
	private boolean girar() {
		int n = sorteador.pegarNumero(min,max);
		List<SimulacaoRoleta> simulacoes = new ArrayList<SimulacaoRoleta>();
		double totalRecebido = 0;
		double totalPago = 0;
		System.out.println("Número: " + n + "\n");
		for(int k=0;k<15;k++) {
			double valorDaAposta =  sorteador.pegarDinheiro(Casa.getApostaMinima(),Casa.getApostaMaxima());
			int numeroApostado = sorteador.pegarNumero(min, max);
			simulacoes.add(new SimulacaoRoleta(valorDaAposta,numeroApostado));
			Casa.getCarteira().depositar(valorDaAposta);
			totalRecebido += valorDaAposta;
		}
		for(SimulacaoRoleta simulacao : simulacoes) {
			double odd = 1.8;
			if(simulacao.numeroApostado%2 == n%2 || simulacao.numeroApostado == n) {
				if(n==14 && simulacao.numeroApostado == 14) {odd=14;}
				Casa.getCarteira().sacar(simulacao.valorDaAposta*odd);
				totalPago += simulacao.valorDaAposta*odd;
			}
		}
		if(Autenticador.eGerente()) {
			System.out.println(String.format("Total arrecadado: R$%,.2f", totalRecebido));
			System.out.println(String.format("Total pago: R$%,.2f", totalPago));
			double dif = totalRecebido - totalPago;
			if(dif>0) {
				System.out.println("LUCROU!");
			}else if(dif == 0) {
				System.out.println("0-0");
			}else {
				System.out.println("PREJUIZO!");
			}
		}
		
		
		if((n%2) == aposta.valor || n == aposta.valor) {
			double odd = 1.8;
			if(n == 14 && aposta.valor ==14) {
				odd = 14;
			}
			Casa.getCarteira().transferir(Autenticador.getUsuario().getCarteira(), valorDaAposta*odd);
			return true;
		}
		return false;
	}
}
