package EntidadesProduto;

public class Revista extends Produto {
	private String editora;


	public Revista(String nome, double valor, String editora,int quantidade) {
		super(nome, valor, quantidade);
		this.editora = editora;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	@Override
	public double ValorUnitario() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void mostrarItem() {
		// TODO Auto-generated method stub
		System.out.println("Nome: "+this.getNome()+" Preço: "+this.getValor()+" Nome da Editora: "+this.getEditora());
		
	}
	
}