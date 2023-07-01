package ifpe;

public class Menu {
	String[] opcoes;
	public Menu(String... opcoes) {
		this.opcoes = opcoes;
	}
	public void show() {
		String nome = String.format("%10s %s %10s", " ",Casa.getNome()," ");
		System.out.println("*".repeat(nome.length()));
		System.out.println(nome);
		System.out.println("Nome: " + Autenticador.getUsuario().getNome());
		System.out.println("Seu saldo: "+ Autenticador.getUsuario().getCarteira().getSaldoFormatado());
		if(Autenticador.eGerente()) {
			System.out.println("SALDO DA BANCA: " + Casa.getCarteira().getSaldoFormatado());
		}
		System.out.println("*".repeat(nome.length()));
		for(int i=0;i<opcoes.length;i++) {
			System.out.printf("%2d. %s\n",i+1,opcoes[i]);
		}
		System.out.println(" 0. Voltar");
		
	}
}
