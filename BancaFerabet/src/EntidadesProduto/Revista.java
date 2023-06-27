package EntidadesProduto;

public class Revista extends Produto {
    private int numeroEdicao;

    public Revista(String nome, double valor, int quantidade, int numeroEdicao) {
        super(nome, valor, quantidade);
        this.numeroEdicao = numeroEdicao;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    @Override
    public void imprimirInformacoes() {
		System.out.println("-------------------------------------------");
        System.out.println("Revista: " + getNome());
        System.out.println("Edição: " + numeroEdicao);
        System.out.println("Valor: R$" + getValor());
        System.out.println("Quantidade: " + getQuantidade());		
        System.out.println("-------------------------------------------");

    }
}
