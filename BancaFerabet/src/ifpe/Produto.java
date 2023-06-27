package ifpe;

public abstract class Produto {
	protected String nome;
	protected double preco;
	protected String descricao;
	protected final Codigo codigo;
	public Produto(String nome, double preco, String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.codigo = new Codigo(this);
	}
	public Codigo getCodigo() {
		return this.codigo;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}
	public abstract String apresentarProduto();
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public  boolean igual(Produto produto) {
		if(this.nome.equalsIgnoreCase(produto.getNome())) {
			return true;
		}
		return false;
	}
}
