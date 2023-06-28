package apresentacao;

public class Resposta {
	String value;
	public Resposta() {
		
	}
	public Resposta(String value) {
		this.value = value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getIntValue() {
		try {
			return Integer.parseInt(value);
		}catch(Exception e) {
			return -1;
		}
	}
	public double getDoubleValue() {
		try {
			return Double.parseDouble(value);
		}catch(Exception e) {
			return -1;
		}
	}
}
