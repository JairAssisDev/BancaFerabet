package EntidadesProduto;

public abstract class Produto {
	
	private String nome;
	
	private double valor;
	
	private int quantidade;
	

	public Produto(String nome, double valor,int quantidade) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public abstract double ValorUnitario();

	public abstract void mostrarItem();
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
	
	
}