package EntidadesProduto;

public class Bebida extends Produto {
    private String tipo;

    public Bebida(String nome, double valor, int quantidade, String tipo) {
        super(nome, valor, quantidade);
        this.tipo = tipo;
    }

    public String getMarca() {
        return tipo;
    }

    public void setMarca(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void imprimirInformacoes() {
		System.out.println("-------------------------------------------");
        System.out.println("Bebida: " + getNome());
        System.out.println("Marca: " + tipo);
        System.out.println("Valor: R$" + getValor());
        System.out.println("Quantidade: " + getQuantidade());
		System.out.println("-------------------------------------------");

    }
}

