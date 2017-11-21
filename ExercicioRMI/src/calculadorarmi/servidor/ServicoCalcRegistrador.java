package calculadorarmi.servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import calculadorarmi.ServicoCalc;
import calculadorarmi.servidor.ServicoCalcImpl;

public class ServicoCalcRegistrador {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			ServicoCalc servidorCalc = new ServicoCalcImpl();
			ServicoCalc stub = (ServicoCalc) UnicastRemoteObject.exportObject(servidorCalc,4000);
			Registry registry = LocateRegistry.createRegistry(4000);
			registry.rebind("SevicoCalculadoraOnline", stub);
			System.out.println("Serviço de Calculadora registrado com sucesso");
		} catch(Exception e) {
			System.out.println("Erro ao registrar Serviço de Calculadora");
			e.printStackTrace();
		}
	}
}
