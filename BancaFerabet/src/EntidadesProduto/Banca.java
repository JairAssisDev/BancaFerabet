package EntidadesProduto;

public class Banca {
	
	private String nome;
	private Estoque estoque;
	public Banca(String nome, Estoque estoque) {
		super();
		this.nome = nome;
		this.estoque = estoque;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	
	
}
	
	
	
	
	

