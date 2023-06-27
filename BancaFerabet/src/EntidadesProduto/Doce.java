package EntidadesProduto;

public class Doce extends Produto {
	private String marca;

	

	public Doce(String nome, double valor, String marca,int quantidade) {
		super(nome, valor, quantidade);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public double ValorUnitario() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void mostrarItem() {
		// TODO Auto-generated method stub
		System.out.println("Nome: "+this.getNome()+" Preço: "+this.getValor()+" Nome da Marca: "+this.getMarca());
		
	}
	
}
