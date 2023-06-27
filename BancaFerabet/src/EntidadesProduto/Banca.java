package EntidadesProduto;


import java.util.List;

import EntidadesJogos.Jogo;

public class Banca {
	
	private List<Produto>produtos;
	private List<Jogo>jogos;

	public Banca(List<Produto> produtos) {
		super();
		this.produtos = produtos;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	

	}
	
	
	
	
	

