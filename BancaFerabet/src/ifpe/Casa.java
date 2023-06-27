package ifpe;

public class Casa {
	public static String nome = "FeraBet";
	public static double apostaMaxima;
	public static double apostaMinima;
	public static Carteira carteira;
	
	public static double getApostaMaxima() {
		return apostaMaxima;
	}
	public static String getApostaMaximaFormatada() {
		return String.format("R$%,.2f",apostaMaxima);
	}
	
	public static void setApostaMaxima(double apostaMaxima) {
		Casa.apostaMaxima = apostaMaxima;
	}

	public static double getApostaMinima() {
		return apostaMinima;
	}
	public static String getApostaMinimaFormatada() {
		return String.format("R$%,.2f",apostaMinima);
	}
	public static void setApostaMinima(double apostaMinima) {
		Casa.apostaMinima = apostaMinima;
	}

	public static Carteira getCarteira() {
		return carteira;
	}

	public static void setCarteira(Carteira carteira) {
		Casa.carteira = carteira;
	}

	public static Roleta getRoleta() {
		return roleta;
	}

	public static void setRoleta(Roleta roleta) {
		Casa.roleta = roleta;
	}
	
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Casa.nome = nome;
	}

	static Roleta roleta;
}
