package ifpe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vitrine {
	public static Map<Produto,Integer> estoque = new HashMap<Produto,Integer>();
	
	public static Produto consultar(String nome) {
		Set<Produto> produtos = estoque.keySet();
		for(Produto produto : produtos) {
			if(produto.getNome().equalsIgnoreCase(nome)) {
				return produto;
			}
		}
		return null;
	}
	
	public static Produto consultar(Codigo codigo) {
		Set<Produto> produtos = estoque.keySet();
		for(Produto produto : produtos) {
			if(produto.getCodigo().getValor().equals(codigo.getValor())) {
				return produto;
			}
		}
		return null;
	}
	
	
	private static void adicionar(Produto produto, int qtd) {
		if(produto != null ) {
			estoque.put(produto,estoque.get(produto)+qtd);
		}
	}
	private static void removeAll(Produto produto) {
		if(produto != null) {
			estoque.remove(produto);
		}
	}
	private static boolean remover(Produto produto, int qtd) {
		if(produto != null) {
			int q = estoque.get(produto);
			if(q >= qtd) {
				estoque.put(produto,q-qtd);
				return true;
			}
		}
		return false;
	}
	
	public static void add(String nome, int qtd) {
		adicionar(consultar(nome),qtd);
	}
	public static void add(Codigo codigo, int qtd) {
		adicionar(consultar(codigo),qtd);
	}
	
	
	public static void removerTudo(String nome) {
		removeAll(consultar(nome));
	}
	public static void removerTudo(Codigo codigo) {
		removeAll(consultar(codigo));
	}
	
	
	public static boolean rem(String nome, int qtd) {
		return remover(consultar(nome),qtd);
	}
	public static boolean rem(Codigo codigo, int qtd) {
		return remover(consultar(codigo),qtd);
	}
	public static void criar(String nome, double preco, String descricao,int op) {
		if(consultar(nome) == null) {
			switch (op) {
			case 1:
				estoque.put(new Droga(nome,preco,descricao),0);
				break;
			case 2:
				estoque.put(new Camisa(nome,preco,descricao),0);
				break;
			case 3:
				estoque.put(new Livro(nome, preco, descricao),0);
				break;
			}
		}
	}
	public static String apresentarProduto(String nome) {
		return "Dados do Produto:\n" + consultar(nome).apresentarProduto();
	}
	public static String apresentarProduto(Codigo codigo) {
		return "Dados do Produto:\n" + consultar(codigo).apresentarProduto();
	}
	public static String mostrarVitrine() {
		StringBuilder s = new StringBuilder();
		for(Produto produto : estoque.keySet()) {
			s.append("=".repeat(20)+"\n" + produto.getCodigo().getValor()+"\n"+produto.apresentarProduto()+"\n"
					+"Quantidade: " + estoque.get(produto)+"=".repeat(20)+"\n");
		}
		return s.toString();
	}
}