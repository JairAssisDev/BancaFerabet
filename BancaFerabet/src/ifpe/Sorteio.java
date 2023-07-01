package ifpe;
import java.security.SecureRandom;
public class Sorteio {
	private SecureRandom random;
	public Sorteio() {
		random = new SecureRandom();
	}
	public int pegarNumero(int min, int max) {
		return random.nextInt(min,max);
	}
	public double pegarDinheiro(double min,double max) {
		return random.nextDouble(min,max);
	}
}
