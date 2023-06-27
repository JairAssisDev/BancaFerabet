package EntidadesProduto;

public class Doce extends Produto {
    private String marca;

    public Doce(String nome, double valor, int quantidade, String marca) {
        super(nome, valor, quantidade);
        this.marca = marca;
    }

    public String getTipo() {
        return marca;
    }

    public void setTipo(String marca) {
        this.marca = marca;
    }

    @Override
    public void imprimirInformacoes() {
		System.out.println("-------------------------------------------");
        System.out.println("Doce: " + getNome());
        System.out.println("Tipo: " + marca);
        System.out.println("Valor: R$" + getValor());
        System.out.println("Quantidade: " + getQuantidade());
		System.out.println("-------------------------------------------");
    }
}
