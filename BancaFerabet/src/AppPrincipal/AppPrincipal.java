package AppPrincipal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import EntidadesProduto.Banca;
import EntidadesProduto.Bebida;
import EntidadesProduto.Doce;
import EntidadesProduto.Produto;
import EntidadesProduto.Revista;

public class AppPrincipal {

	private static Scanner input = new Scanner(System.in);
	private static List<Produto>produtos = new ArrayList<Produto>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Produto produto1 = new Bebida("pitu", 10.50, 10, "alcoólico");
		Produto produto2 = new Doce("bombom", 33.3, 10, "nestle");
		Produto produto3 = new Revista("veja", 20.20, 10, 4);

		
		
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		
		Banca banca = new Banca(produtos);
		
		
		
		menu();
		
		
		
	}
	private static void menu() {
		System.out.println("-------------------------------------------------------");
		System.out.println("---------------Sistema de Banca FeraBet----------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("*************************MENU**************************");
		System.out.println("-------------------------------------------------------");
		System.out.println("|             Opção 1 - Sistema de Cadastrar          |");
		System.out.println("|             Opção 2 - Listar Itens                  |");
		System.out.println("|             Opção 3 - Comprar Itens                 |");
		System.out.println("|             Opção 4 - Remover Itens do Cadastro     |");
		System.out.println("|             Opção 0 - Sair do Programa              |");
		String opcao = input.next();
		if(opcao.equals("1")) {
			cadastroDeProdutos();
		}
		if(opcao.equals("2")) {
			System.out.println("|     Opção 1 - listar bebida            |");
			System.out.println("|     Opção 2 - listar Doce              |");
			System.out.println("|     Opção 3 - listar Revista           |");
			System.out.println("|     Opção 4 - listar tudo              |");
			System.out.println("|     Opção 0 - Voltar                   |");
			System.out.println("Digite a Opção desejada");
			String x = input.next();
			input.nextLine();
			if(x.equals("0")) {
				menu();
			}else if(x.equals("1")) {
				listaProdutos(x);
			}else if(x.equals("2")) {
				listaProdutos(x);
			}else if(x.equals("3")) {
				listaProdutos(x);
			}else if(x.equals("4")) {
				listaProdutos(x);
			}else if(x.equals("0")) {
				menu();
			}
			else {
				
				System.out.println("opção invalida!!");
				menu();
			
			}
		}	
		if(opcao.equals("3")) {
			compra();
		}
		if(opcao.equals("4")) {
			removerDoCadastro();
		}
		if(opcao.equals("0")) {
			System.out.println("-------------------------------------------------------");
			System.out.println("---------------Sistema de Banca FeraBet----------------");
			System.out.println("-------------------------------------------------------");
			System.out.println("**********************Volte sempre*********************");
			System.out.println("-------------------------------------------------------");
			System.exit(0);
		}
		else {
			System.out.println("opção invalida!!");
			menu();
		}
	}
	private static void cadastroDeProdutos(){
		System.out.println("------------------------------------------------------");
		System.out.println("------------------Sistema de Cadastro-----------------");
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma operação que deseja realizar *****");
		System.out.println("------------------------------------------------------");
		System.out.println("|     Opção 1 - Cadastrar bebida            |");
		System.out.println("|     Opção 2 - Cadastrar Doce              |");
		System.out.println("|     Opção 3 - Cadastrar Revista           |");
		System.out.println("|     Opção 0 - Voltar para o menu          |");
		String opcao = input.next();
		
		System.out.println(opcao);
		switch (opcao) {
		case "1":
			
			cadastraBebida();
			
			break;
		case "2":
			
			cadastraDoce();
			
			break;
		case "3":
			cadastraRevista();
			break;
		case "0":
			menu();
			break;
		default:
			
			menu();
			break;
		}
	
		
	
	}
	private static void cadastraBebida() {
	    System.out.println("Digite o nome do produto: ");
	    String nome = input.next();
	    System.out.println("Digite o valor do produto: ");
	    String valorStr = input.next();
	    double valor = Double.parseDouble(valorStr);
	    System.out.println("Digite o tipo da bebida");
	    String tipo = input.next();
	    System.out.println("Digite a quantidade que será colocada no estoque");
	    int quantidade = input.nextInt();

	    Produto produto = new Bebida(nome, valor, quantidade, tipo);
	    produtos.add(produto);
	    System.out.println("Cadastro realizado com sucesso!");
	    System.out.println("------------------------------------------------------");
	    System.out.println("-----------Deseja cadastrar outra Bebida?-------------");
	    System.out.println("------------------------------------------------------");
	    System.out.println("Digite 1 para sim e 2 para não e voltar para página de cadastro");
	    String opcao1 = input.next();
	    if (opcao1.equals("1")) {
	        cadastraBebida();
	        System.out.println("--------------------Obrigado!!!-------------------");
	    } else {
	        System.out.println("__________________________________________________");
	    }
	}


	private static void cadastraDoce() {
	    System.out.println("Digite o nome do produto: ");
	    String nome = input.next();
	    System.out.println("Digite o valor do produto: ");
	    String valorStr = input.next();
	    double valor = Double.parseDouble(valorStr);
	    input.nextLine(); // Limpa o buffer do scanner
	    System.out.println("Digite o nome da marca");
	    String marca = input.nextLine();
	    System.out.println("Digite a quantidade que será colocada no estoque");
	    int quantidade = input.nextInt();

	    Produto produto = new Doce(nome, valor, quantidade, marca);
	    produtos.add(produto);
	    System.out.println("Cadastro realizado com sucesso!");
	    System.out.println("------------------------------------------------------");
	    System.out.println("-----------Deseja cadastrar outro Doce?------------");
	    System.out.println("Digite 1 para sim e 2 para não e voltar para página de cadastro");
	    String opcao1 = input.next();
	    if (opcao1.equals("1")) {
	        cadastraDoce();
	        System.out.println("--------------------Obrigado!!!-------------------");
	    } else {
	        System.out.println("__________________________________________________");
	    }
	}


	private static void cadastraRevista() {
	    System.out.println("Digite o nome do produto: ");
	    String nome = input.next();
	    System.out.println("Digite o valor do produto: ");
	    String valorStr = input.next();
	    double valor = Double.parseDouble(valorStr);
	    input.nextLine(); // Limpa o buffer do scanner
	    System.out.println("Digite o número da edição");
	    int numeroEdicao = input.nextInt();
	    System.out.println("Digite a quantidade que será colocada no estoque");
	    int quantidade = input.nextInt();

	    Produto produto = new Revista(nome, valor, quantidade, numeroEdicao);
	    produtos.add(produto);
	    System.out.println("Cadastro realizado com sucesso!");
	    System.out.println("------------------------------------------------------");
	    System.out.println("-----------Deseja cadastrar outra Revista?------------");
	    System.out.println("Digite 1 para sim e 2 para não e voltar para página de cadastro");
	    String opcao1 = input.next();
	    if (opcao1.equals("1")) {
	        cadastraRevista();
	        System.out.println("--------------------Obrigado!!!-------------------");
	    } else {
	        System.out.println("__________________________________________________");
	    }
	}

	private static void listaProdutos(String opcao) {
		
		for (Produto produtos: produtos) {
			switch (opcao) {
			case "1":
				if(produtos instanceof Bebida) {
					produtos.imprimirInformacoes();
			
				}
				break;
			case "2":
				if(produtos instanceof Doce) {
					produtos.imprimirInformacoes();
				}
				
				break;
			case "3":
				if(produtos instanceof Revista) {
					produtos.imprimirInformacoes();
				}
				
				break;
			case "4":
				produtos.imprimirInformacoes();;
				
				break;
			}
		}
		//volta para o menu
		menu();
		
	}
	private static void compra() {
	    System.out.println("----------Sistema de Compra----------");
	    System.out.println("Produtos disponíveis para compra:");

	    for (int i = 0; i < produtos.size(); i++) {
	        Produto produto = produtos.get(i);
	        System.out.println((i + 1) + ". " + produto.getNome() + " - R$" + produto.getValor());
	    }

	    List<Produto> carrinho = new ArrayList<>();
	    double valorTotal = 0;

	    while (true) {
	        System.out.println("Digite o número do produto que deseja comprar (0 para encerrar):");
	        
	        String opcaoStr = input.next();
	        int opcao = Integer.parseInt(opcaoStr);
	        if (opcao == 0) {
	            break;
	        }

	        if (opcao < 1 || opcao > produtos.size()) {
	            System.out.println("Opção inválida. Tente novamente.");
	            continue;
	        }

	        Produto produtoSelecionado = produtos.get(opcao - 1);

	        System.out.println("Produto selecionado: " + produtoSelecionado.getNome());
	        System.out.println("Quantidade disponível: " + produtoSelecionado.getQuantidade());

	        System.out.println("Digite a quantidade desejada:");
	        int quantidadeDesejada = input.nextInt();

	        if (quantidadeDesejada <= 0) {
	            System.out.println("Quantidade inválida. Tente novamente.");
	            continue;
	        }

	        if (quantidadeDesejada > produtoSelecionado.getQuantidade()) {
	            System.out.println("Quantidade indisponível. Tente novamente.");
	            continue;
	        }

	        produtoSelecionado.setQuantidade(produtoSelecionado.getQuantidade() - quantidadeDesejada);
	        carrinho.add(produtoSelecionado);
	        valorTotal += produtoSelecionado.getValor() * quantidadeDesejada;

	        System.out.println("Produto adicionado ao carrinho.");

	        System.out.println("Deseja continuar comprando? (S/N)");
	        String opcaoContinuar = input.next();

	        if (opcaoContinuar.equalsIgnoreCase("N")) {
	            break;
	        }
	    }
	    DecimalFormat decimalFormat = new DecimalFormat("#.00");
	    String valorTotalFormatado = decimalFormat.format(valorTotal);

	    System.out.println("Valor total da compra: R$" + valorTotalFormatado);
	    System.out.println("Obrigado pela compra!");
	    menu();
	}
	private static void removerDoCadastro() {
	    System.out.println("-----------Remover Itens do Cadastro-----------");
	    System.out.println("Produtos cadastrados:");

	    for (int i = 0; i < produtos.size(); i++) {
	        Produto produto = produtos.get(i);
	        System.out.println((i + 1) + ". " + produto.getNome());
	    }

	    System.out.println("Digite o número do produto que deseja remover (0 para cancelar):");
	    int opcao = input.nextInt();

	    if (opcao == 0) {
	        return;
	    }

	    if (opcao < 1 || opcao > produtos.size()) {
	        System.out.println("Opção inválida. Tente novamente.");
	        return;
	    }

	    Produto produtoRemovido = produtos.remove(opcao - 1);
	    System.out.println("Produto removido: " + produtoRemovido.getNome());
	    System.out.println("Produto removido do cadastro.");

	    //volta para o menu
	    menu();
	}


}
