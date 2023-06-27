package ifpe;

public class Livro extends Produto{

	public Livro(String nome, double preco, String descricao) {
		super(nome, preco, descricao);
	}
	@Override
	public String apresentarProduto() {
		
		return String.format("Nome do Livro: %s\nPreco: R$%,.2f\nDescrição: %s", nome,preco,descricao);
	}
}
