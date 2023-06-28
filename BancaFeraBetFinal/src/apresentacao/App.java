package apresentacao;

import java.util.Arrays;
import java.util.Scanner;

import casa.Carteira;
import casa.Casa;
import casa.Roleta;
import casa.RoletaEnum;
import casa.Vitrine;
import produtos.Codigo;
import usuarios.Autenticador;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Usuario;

import java.util.List;

public class App {
	static int logar = 1;
	static boolean continuar = true;
	static Menu menuPrincipal = new Menu("Jogar", "Produtos", "Depositar", "Sacar", "Mudar Conta");
	public static void main(String[] args) {
		Usuario u1 = new Cliente("Marcos", "abc", "123", new Carteira(10));
		Usuario u2 = new Gerente("Leo", "admin", "admin", new Carteira(1500000));
		List<Usuario> usuarios = Arrays.asList(u1, u2);

		Autenticador.setUsuarios(usuarios);
		Casa.setNome("Banca FeraBet");
		Casa.setApostaMaxima(400);
		Casa.setApostaMinima(10);
		Casa.setRoleta(new Roleta());
		Casa.setCarteira(new Carteira(10000));
		Resposta respostaPrincipal = new Resposta();

		while (continuar) {
			if (logar == 1) {
				h0();
			}
			menuPrincipal.show();
			Scanner sc = new Scanner(System.in);
			respostaPrincipal.setValue(sc.nextLine());
			switch (respostaPrincipal.getIntValue()) {
			case 0:
				continuar = false;
				// ou System.exit(0);
				break;
			case 1:
				h1();
				break;
			case 2:
				h2();
				break;
			case 3:
				h3();
				break;
			case 4:
				h4();
				break;
			case 5:
				logar = 1;
				break;
			default:
				System.out.println("insira resposta válida!");
			}
		}
	}

	public static void h0() {
		Scanner r = new Scanner(System.in);
		System.out.println("Login: ");
		String login = r.nextLine();
		System.out.println("Senha: ");
		String senha = r.nextLine();
		if (Autenticador.autenticar(login, senha)) {
			logar = 0;
			System.out.println("LOGADO COM SUCESSO!");

		} else {
			System.out.println("LOGIN E/OU SENHA INCORRETO(S)");
			h0();
		}
	}

	
	static Menu menu1 = new Menu("Roleta", "Foguteinho");
	static Menu menu1Gerente = new Menu("Roleta", "Foguetinho", "Simulacao");

	public static void h1() {
		Scanner s = new Scanner(System.in);

		int maximaResposta;
		if (Autenticador.eGerente()) {
			menu1Gerente.show();
			maximaResposta = 3;
		} else {
			menu1.show();
			maximaResposta = 2;
		}
		Resposta r = new Resposta();
		r.setValue(s.nextLine());
		if (r.getIntValue() <= maximaResposta) {
			switch (r.getIntValue()) {
			case 0:
				break;
			case 1:
				startRoleta();
				h1();
				break;
			case 2:
				System.out.println("EM BREVE!");
				h1();
				break;
			case 3:
				for (int k = 0; k < 40; k++) {
					Casa.getRoleta().fazerAposta(RoletaEnum.PRETO, 10);
				}

				break;
			default:
				System.out.println("Insira Resposta valida!");
				h1();
			}
		}
	}
	static Menu menuAposta = new Menu("Preto", "Vermelho", "Branco");
	public static void startRoleta() {
		Scanner s = new Scanner(System.in);
		Resposta r = new Resposta();
		menuAposta.show();
		r.setValue(s.nextLine());
		int opCor = r.getIntValue();
		if (opCor > 0 && opCor <= 3) {
			System.out.println("Valor da Aposta: ");
			r.setValue(s.nextLine());
			double valorDaAposta = r.getDoubleValue();
			if (valorDaAposta != -1) {
				if (opCor == 1) {
					Casa.getRoleta().fazerAposta(RoletaEnum.PRETO, r.getDoubleValue());
				} else if (opCor == 2) {
					Casa.getRoleta().fazerAposta(RoletaEnum.VERMELHO, r.getDoubleValue());
				} else {
					Casa.getRoleta().fazerAposta(RoletaEnum.BRANCO, r.getDoubleValue());
				}
				startRoleta();
			} else {
				System.out.println("Inserir valor válido");
				startRoleta();
			}

		} else if (opCor != 0) {
			System.out.println("Inserir Resposta Válida");
			startRoleta();
		}

	}

	static Menu menu2Cliente = new Menu("Listar", "Comprar", "Consultar");
	static Menu menuComprar = new Menu("Por nome", "Por código");
	static Menu menu2Gerente = new Menu("Listar", "Comprar", "Consultar", "Cadastrar Produto", "Colocar Produto",
			"Remover Produto");

	public static void h2() {
		int maximaResposta;
		if (Autenticador.eGerente()) {
			menu2Gerente.show();
			maximaResposta = 6;
		} else {
			menu2Cliente.show();
			maximaResposta = 3;
		}
		Scanner s = new Scanner(System.in);
		Resposta r = new Resposta();
		r.setValue(s.nextLine());
		int rAux = r.getIntValue();
		if (rAux >= 0 && rAux <= maximaResposta) {
			switch (rAux) {
			case 0:
				break;
			case 1:
				Vitrine.mostrarVitrine();
				h2();
				break;
			case 2:
				System.out.println("Nome do Produto: ");
				Scanner s1 = new Scanner(System.in);
				String nomeProduto = s1.nextLine();
				Resposta r1 = new Resposta();
				System.out.println("Quantidade: ");
				r1.setValue(s1.nextLine());
				int qtd = r1.getIntValue();
				Vitrine.comprar(nomeProduto, qtd);
				h2();
				break;
			case 3:
				menuComprar.show();
				Scanner s2 = new Scanner(System.in);
				Resposta r2 = new Resposta();
				r2.setValue(s2.nextLine());
				if (r2.getIntValue() == 2 || r2.getIntValue() == 1) {
					Scanner s3 = new Scanner(System.in);
					System.out.println("PESQUISAR: ");
					Vitrine.switchConsultar(r2.getIntValue(), s3.nextLine());
				}
				h2();
				break;
			case 4:
				Scanner s3 = new Scanner(System.in);
				Resposta r3 = new Resposta();
				System.out.println("Nome : ");
				String nome = s3.nextLine();
				System.out.println("Descrição: ");
				String desc = s3.nextLine();
				System.out.println("1. Droga\n2. Camisa\n3. Livro");
				r3.setValue(s3.nextLine());
				int auxTipo = r3.getIntValue();
				System.out.println("Preço: ");
				r3.setValue(s3.nextLine());
				double auxPreco = r3.getDoubleValue();
				if ((auxTipo >= 1 && auxTipo <= 3) && auxPreco > 0) {
					Vitrine.criar(nome, auxPreco, desc, auxTipo);
				} else {
					System.out.println("Inválido!");
				}
				h2();
				break;
			case 5:
				Scanner s4 = new Scanner(System.in);
				System.out.println("1. Por nome\n2. Por codigo");
				String aux4 = s4.nextLine();
				Resposta r4 = new Resposta();
				if (aux4.equals("1")) {
					System.out.println("Nome: ");
					String nome4 = s4.nextLine();
					System.out.println("Quantidade: ");
					r4.setValue(s4.nextLine());
					Vitrine.add(nome4, r4.getIntValue());
				} else if (aux4.equals("2")) {
					System.out.println("Código: ");
					Codigo codigo = new Codigo(s4.nextLine());
					System.out.println("Quantidade: ");
					r4.setValue(s4.nextLine());
					Vitrine.add(codigo, r4.getIntValue());
				} else {
					System.out.println("Inválido!");
				}
				h2();
				break;
			default:
				Scanner scan = new Scanner(System.in);
				System.out.println("Nome: ");
				Vitrine.removerTudo(scan.nextLine());
				h2();
			}
		} else {
			System.out.println("Insira resposta válida");
			h2();
		}
	}

	public static void h3() {
		Scanner sc = new Scanner(System.in);
		Resposta r = new Resposta();
		System.out.println("Valor: ");
		r.setValue(sc.nextLine());
		if (r.getDoubleValue() > 0) {
			Autenticador.getUsuario().getCarteira().depositar(r.getDoubleValue());
			;
		} else {
			System.out.println("Resposta Invalida");
			h3();
		}
	}

	public static void h4() {
		Scanner sc = new Scanner(System.in);
		Resposta r = new Resposta();
		System.out.println("Valor: ");
		r.setValue(sc.nextLine());
		if (r.getDoubleValue() >0) {
			Autenticador.getUsuario().getCarteira().sacar(r.getDoubleValue());
		} else {
			System.out.println("Resposta Invalida");
			h3();
		}
	}

	

}
