package ifpe;

public enum RoletaEnum {
	VERMELHO(0),PRETO(1),BRANCO(14);
	public int valor;
	private RoletaEnum(int valor) {
		this.valor = valor;
	}
}
