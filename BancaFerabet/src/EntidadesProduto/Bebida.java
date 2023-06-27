package EntidadesProduto;

public class Bebida extends Produto {
	private String tipo;



	public Bebida(String nome, double valor, String tipo,int quantidade) {
		super(nome, valor,quantidade);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public double ValorUnitario() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void mostrarItem() {
		// TODO Auto-generated method stub
		System.out.println("Nome: "+this.getNome()+" Preço: "+this.getValor()+" Tipo da bebida: "+this.getTipo());
		
	}
	
}
