package AppPrincipal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import EntidadesProduto.Banca;
import EntidadesProduto.Bebida;
import EntidadesProduto.Doce;
import EntidadesProduto.Estoque;
import EntidadesProduto.Produto;
import EntidadesProduto.Revista;

public class Appteste {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Produto>produtos = new ArrayList<Produto>();
		Produto produto1 = new Bebida("pitu", 10.50, 10, "alcoólico");
		Produto produto2 = new Doce("bombom", 33.3, 10, "nestle");
		Produto produto3 = new Revista("veja", 20.20, 10, 4);

		Estoque estoque = new Estoque(produtos);
		
		estoque.getProdutos().add(produto1);
		estoque.getProdutos().add(produto2);
		estoque.getProdutos().add(produto3);
		
		
		Banca banca = new Banca("fera Bet", estoque);
		
		System.out.println("-------------------------------------------------------");
		System.out.println("---------------Sistema de Banca FeraBet----------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("*************************MENU**************************");
		System.out.println("-------------------------------------------------------");
		System.out.println("|        Opção 1 - Sistema de Compra e Cadastrar      |");
		System.out.println("|        Opção 2 - Sistema de jogos                   |");
		System.out.println("|        Opção 0 - Sair do Programa                   |");
		String opcao = input.next();
		if(opcao.equals("1")) {
			banca.getEstoque().menu();
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
			
			}
		}
		
	}
}
