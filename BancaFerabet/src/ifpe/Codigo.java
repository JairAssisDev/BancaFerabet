package ifpe;

public class Codigo {
	private final String valor;
	
	public Codigo(String valor) {
		this.valor = valor;
	}
	
	public Codigo(Produto produto) {
		this.valor = String.valueOf(produto.hashCode()).substring(0, 6);
	}
	public String getValor() {
		return valor;
	}
}
