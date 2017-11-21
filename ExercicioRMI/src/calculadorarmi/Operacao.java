package calculadorarmi;

public class Operacao {
	private double param1;
	private double param2;
	private char op;
	private double resultado;

	public Operacao(double param1, double param2, char op, double resultado) {
		super();
		this.param1 = param1;
		this.param2 = param2;
		this.op = op;
		this.resultado = resultado;
	}

	public double getParam1() {
		return param1;
	}

	public void setParam1(double param1) {
		this.param1 = param1;
	}

	public double getParam2() {
		return param2;
	}

	public void setParam2(double param2) {
		this.param2 = param2;
	}

	public char getOp() {
		return op;
	}

	public void setOp(char op) {
		this.op = op;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

}
