package produtos;

public class Droga extends Produto {
	
	public Droga(String nome, double preco, String descricao) {
		super(nome, preco, descricao);
	}

	@Override
	public String apresentarProduto() {
		
		return String.format("Nome da Droga: %s\nPreco: R$%,.2f\nDescrição: %s", nome,preco,descricao);
	}
	
}
