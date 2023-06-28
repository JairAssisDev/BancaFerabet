package produtos;

public class Camisa extends Produto {

	public Camisa(String nome, double preco, String descricao) {
		super(nome, preco, descricao);
	}
	@Override
	public String apresentarProduto() {
		return String.format("Nome: %s\nPreco: R$%,.2f\nDescrição: %s", nome,preco,descricao);
	}
}
