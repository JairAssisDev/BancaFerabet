package ifpe;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class App {
	
	
	
	

	static int page = -1;
	static boolean continuar = true;
	
	public static void h0(){
		Scanner r = new Scanner(System.in);
		System.out.println("Login: ");
		String login = r.nextLine();
		System.out.println("Senha: ");
		String senha = r.nextLine();
		if(Autenticador.autenticar(login,senha)) {
			page = 0;
			System.out.println("LOGADO COM SUCESSO!");
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("LOGIN E/OU SENHA INCORRETO(S)");
			h0();
		}
	}
	static Menu menuAposta = new Menu("Preto","Vermelho","Branco");
	
	public static void startRoleta() {
		Scanner s = new Scanner(System.in);
		Resposta r = new Resposta();
		menuAposta.show();
		r.setValue(s.nextLine());
		int opCor= r.getIntValue();
		if(opCor > 0 && opCor <= 3) {
				System.out.println("Valor da Aposta: ");
				r.setValue(s.nextLine());
				double valorDaAposta = r.getDoubleValue();
				if(valorDaAposta != -1) {
					if(opCor==1) {
						Casa.getRoleta().fazerAposta(RoletaEnum.PRETO, r.getDoubleValue());
					}else if(opCor==2) {
						Casa.getRoleta().fazerAposta(RoletaEnum.VERMELHO, r.getDoubleValue());
					}else{
						Casa.getRoleta().fazerAposta(RoletaEnum.BRANCO, r.getDoubleValue());
					}
					startRoleta();
				}else {
					System.out.println("Inserir valor válido");
					startRoleta();
				}
				
		}else if(opCor != 0) {
			System.out.println("Inserir Resposta Válida");
			startRoleta();
		}
		
	}
	static Menu menu1= new Menu("Roleta", "Foguetinho");
	public static void h1() {
		Scanner s = new Scanner(System.in);
		menu1.show();
		Resposta r = new Resposta();
		r.setValue(s.nextLine());
		switch (r.getIntValue()) {
		case 0:
			break;
		case 1:
			startRoleta();
			h1();
			break;
		default:
			System.out.println("Insira Resposta valida!");
			h1();
		}
	}
	static Menu menu2Cliente = new Menu("Listar","Comprar","Consultar");
	static Menu menu2Gerente = new Menu("Listar","Comprar","Consultar","Cadastrar Produto","Colocar Produto",
			"Remover Produto");
	public static void h2() {
		int maximaResposta;
		if(Autenticador.eGerente()) {
			menu2Gerente.show();
			maximaResposta = 5;
		}else {
			menu2Cliente.show();
			maximaResposta = 3;
		}
	}
	
	static Menu menuPrincipal = new Menu("Jogar","Produtos","Depositar","Sacar","Mudar Conta");
	public static void main(String[] args) {
		Usuario u1 = new Cliente("Marcos","abc","123",new Carteira());
		Usuario u2 = new Gerente("Leo","admin","admin",new Carteira(1500000));
		List<Usuario> usuarios = Arrays.asList(u1,u2);
		
		
		
		Autenticador.setUsuarios(usuarios);
		Casa.setApostaMaxima(400);
		Casa.setApostaMinima(10);
		Casa.setRoleta(new Roleta());
		Casa.setCarteira(new Carteira(10000));
		Resposta respostaPrincipal = new Resposta();
		while(continuar) {
			if(page == -1) {
				h0();
			}
			menuPrincipal.show();
			Scanner sc = new Scanner(System.in);
			respostaPrincipal.setValue(sc.nextLine());
			switch (respostaPrincipal.getIntValue()) {
			case 0:
				continuar = false;
				break;
			case 1:
				h1();
				break;
			default:
				System.out.println("insira resposta válida!");
			}
		}
	}
}
