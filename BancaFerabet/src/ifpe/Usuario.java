package ifpe;

public abstract class Usuario {
	protected String nome;
	protected String login;
	protected String senha;
	protected Carteira carteira;
	public Usuario(String nome,String login, String senha, Carteira carteira) {
		this.carteira = carteira;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Carteira getCarteira() {
		return carteira;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
