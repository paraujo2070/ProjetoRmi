package calculadorarmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import calculadorarmi.excecao.DivisaoInvalidaException;
import calculadorarmi.User;

public interface ServicoCalc extends Remote {
	public double somar(double num1, double num2) throws RemoteException;
	public double subtrair(double num1, double num2) throws RemoteException;
	public double multiplicar(double num1, double num2) throws RemoteException;
	public double dividir(double num1, double num2) throws DivisaoInvalidaException, RemoteException;
	public void conectar(User u) throws RemoteException;
	public void desconectar(User u) throws RemoteException;
}