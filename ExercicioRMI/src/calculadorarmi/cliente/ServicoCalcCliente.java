package calculadorarmi.cliente;

import java.rmi.ConnectException;
import java.rmi.ConnectIOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import apresentacao.Tela;
import calculadorarmi.ServicoCalc;
import calculadorarmi.User;
import calculadorarmi.excecao.DivisaoInvalidaException;

public class ServicoCalcCliente {
	public static void main(String[] args) {
		//String nomeObjeto = "SevicoCalculadoraOnline";
		String ip = null, nomeServidor = null;
		
		boolean passou = false;

		Registry registry = null;
		ServicoCalc servCalc = null;

		try {

			do {
				ip = JOptionPane.showInputDialog("informar o IP do servidor: ");
				ip = (ip == null || ip.equals("")) ? "localhost" : ip;
				
				nomeServidor = JOptionPane.showInputDialog("informar o Nome do servidor: ");
				nomeServidor = (nomeServidor == null || nomeServidor.equals("")) ? "SevicoCalculadoraOnline" : nomeServidor;
				try {
					registry = LocateRegistry.getRegistry(ip,4000);
					servCalc = (ServicoCalc) registry.lookup("SevicoCalculadoraOnline");
					
					passou = true;
				} catch (ConnectIOException | UnknownHostException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Não foi possível conectar. Verifique o IP do Servidor.");
					passou = false;
				} catch (NotBoundException e) {
					JOptionPane.showMessageDialog(null, "Não foi possível conectar. Verifique o NOME do Servidor.");
					passou = false;
				} catch (ConnectException e) {
					JOptionPane.showMessageDialog(null, "Servidor Não Encontrado. :(");
					passou = false;
				}
			}while(!passou);	
			//ServicoCalc servCalc = (ServicoCalc) registry.lookup(nomeObjeto);

			String login = JOptionPane.showInputDialog("informar seu login: ");
			User usuario = new User(login);
			servCalc.conectar(usuario);
			Tela tela = new Tela(servCalc);

			//servCalc.desconectar(usuario);
		} catch(RemoteException e) {
			e.printStackTrace();
		}
	}

}
