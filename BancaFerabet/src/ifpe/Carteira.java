package ifpe;

public class Carteira {
	private double saldo;
	public Carteira() {
		this.saldo = 0;
	}
	public Carteira(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	public String getSaldoFormatado() {
		return String.format("R$%,.2f", saldo);
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double deposito) {
		this.saldo += deposito;
	}
	public boolean sacar(double saque) {
		if(saldo >= saque) {
			this.saldo -= saque;
			return true;
		}
		return false;
	}
	public boolean transferir(Carteira destino, double valor ) {
		if(this.sacar(valor)) {
			destino.depositar(valor);
			return true;
		}
		return false;
	}
}
