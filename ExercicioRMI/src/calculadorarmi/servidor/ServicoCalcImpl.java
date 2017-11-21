package calculadorarmi.servidor;

import java.rmi.RemoteException;
import java.util.Vector;

import calculadorarmi.ServicoCalc;
import calculadorarmi.User;
import calculadorarmi.excecao.DivisaoInvalidaException;

public class ServicoCalcImpl implements ServicoCalc {
	private Vector<User> conectados;
	
	public ServicoCalcImpl() {
		this.conectados = new Vector<User>();
	}
	
	public double somar(double num1, double num2) throws RemoteException {
		return num1 + num2;
	}

	public double subtrair(double num1, double num2) throws RemoteException {
		return num1 - num2;
	}

	public double multiplicar(double num1, double num2) throws RemoteException {
		return num1 * num2;
	}

	public double dividir(double num1, double num2) throws DivisaoInvalidaException, RemoteException {
		if (num2 == 0)
			throw new DivisaoInvalidaException("Não é possível divisão por zero.");
		return num1 / num2;
	}

	public void conectar(User u) throws RemoteException {
		this.conectados.add(u);
	}

	public void desconectar(User u) throws RemoteException {
		this.conectados.remove(u);
	}
}
