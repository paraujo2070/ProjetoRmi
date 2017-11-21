package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import calculadorarmi.ServicoCalc;
import calculadorarmi.User;
import calculadorarmi.excecao.DadosInsuficientesException;
import calculadorarmi.excecao.DivisaoInvalidaException;

public class Tela extends JFrame {	
	private ServicoCalc servCalc;
	
	private JMenuBar menuBar;
	private JMenu menuSair;
	
	private JTextField txtCampo;
	
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnSum;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;
	private JButton btnChangeSignal;
	private JButton btnVirgula;
	private JButton btnIgual;
	private JButton btnApagar;
	
	public Tela(ServicoCalc servCalc) {
		this.servCalc = servCalc;
		TelaPrincipal();
		this.show();
		//this.initApp();
	}
	
/*	private void initApp() {
		String nomeObjeto = "SevicoCalculadoraOnline";
		String ip = JOptionPane.showInputDialog("informar o IP do servidor: ");
		ip = (ip == null || ip.equals("")) ? "localhost" : ip;

		try {
			Registry registry = LocateRegistry.getRegistry(ip,4000);
			servCalc = (ServicoCalc) registry.lookup(nomeObjeto);
			String login = JOptionPane.showInputDialog("informar seu login: ");
			User usuario = new User(login);
			servCalc.conectar(usuario);
			
			
			servCalc.desconectar(usuario);
		} catch(RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}*/
	
	private void TelaPrincipal() {
		//setExtendedState(MAXIMIZED_BOTH);
		this.setSize(270, 430);
		this.setLocation(460, 130);
		this.setResizable(false);
		setTitle("Calculadora - Cliente");
		formulario();
		this.txtCampo = this.campo(5, 0, 255, 50);
		this.btn1 = buttons("1", 5, 250, 60, 60);
		this.btn2 = buttons("2", 70, 250, 60, 60);
		this.btn3 = buttons("3", 135, 250, 60, 60);
		this.btn4 = buttons("4", 5, 185, 60, 60);
		this.btn5 = buttons("5", 70, 185, 60, 60);
		this.btn6 = buttons("6", 135, 185, 60, 60);
		this.btn7 = buttons("7", 5, 120, 60, 60);
		this.btn8 = buttons("8", 70, 120, 60, 60);
		this.btn9 = buttons("9", 135, 120, 60, 60);
		this.btnSum = buttons("+", 200, 250, 60, 60);
		this.btnSub = buttons("-", 200, 185, 60, 60);
		this.btnMul = buttons("*", 200, 120, 60, 60);
		this.btnDiv = buttons("/", 200, 55, 60, 60);
		this.btn0 = buttons("0", 70, 315, 60, 60);
		this.btnChangeSignal = buttons("+-", 5, 315, 60, 60);
		this.btnVirgula = buttons(",", 135, 315, 60, 60);
		this.btnIgual = buttons("=", 200, 315, 60, 60);
		this.btnApagar = buttons("C", 5, 55, 60, 60);
		
		this.buttonsActions();
		
		this.add(txtCampo);
		this.add(btn0);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		this.add(btn7);
		this.add(btn8);
		this.add(btn9);
		this.add(btnSum);
		this.add(btnSub);
		this.add(btnMul);
		this.add(btnDiv);
		this.add(btnChangeSignal);
		this.add(btnVirgula);
		this.add(btnIgual);
		this.add(btnApagar);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	protected void formulario() {
		setLayout(null);
		menuBar = menuBar();
		
		setJMenuBar(menuBar);		
	}
	
	private JMenuBar menuBar() {
		menuBar = new JMenuBar();
		menuSair = menuSair();
		menuBar.add(menuSair);
		
		return menuBar;
	}

	private JMenu menuSair() {
		JMenu menu = new JMenu("Sair");
		
		menu.add(menuItemSair());
		
		return menu;
	}
	
	private JMenuItem menuItemSair() {
		JMenuItem menuItem = new JMenuItem("Sair");
		
		menuItem.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						actionSair();
					}
				});
		
		return menuItem;
	}
	
	private void actionSair() {
		System.exit(1);
	}
	
	protected JTextField campo(int x, int y, int width, int height) {
		JTextField txtField = new JTextField();
		txtField.setBounds(x, y, width, height);
		return txtField;
	}

	protected JButton buttons(String texto, int x, int y, int width, int height) {
		JButton btn = new JButton(texto);
		btn.setBounds(x, y, width, height);
		
		return btn;
	}
	
	private void buttonsActions() {
		this.btn1.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+"1");
					}
				});
		this.btn2.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+"2");
					}
				});
		this.btn3.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+"3");
					}
				});
		this.btn4.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+"4");
					}
				});
		this.btn5.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+"5");
					}
				});
		this.btn6.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+"6");
					}
				});
		this.btn7.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+"7");
					}
				});
		this.btn8.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+"8");
					}
				});
		this.btn9.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+"9");
					}
				});
		this.btnSum.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+" + ");
					}
				});
		this.btnSub.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+" - ");
					}
				});
		this.btnMul.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+" * ");
					}
				});
		this.btnDiv.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+" / ");
					}
				});
		this.btn0.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+"0");
					}
				});
		this.btnChangeSignal.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//txtCampo.setText("2");
					}
				});
		this.btnVirgula.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(txtCampo.getText()+",");
					}
				});
		this.btnIgual.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//calcs = txtCampo.getText().split(" ");
						double result;
						try {
							result = calculadora(txtCampo.getText().split(" "));
							txtCampo.setText(String.valueOf(result));
						} catch (DadosInsuficientesException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Verifique o campo e tente novamente");
						} catch (ConnectException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "O servidor calculadora está Offline. Tente mais tarde!");
							System.exit(1);
						}
					}
				});
		this.btnApagar.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txtCampo.setText(null);
					}
				});
	}
	
	private double calculadora(String[] calcs) throws DadosInsuficientesException, ConnectException {
		if (calcs.equals("") || calcs == null)
			throw new DadosInsuficientesException("Verifique o campo e tente novamente");
		double num1 = Double.parseDouble(calcs[0]);
		double num2 = Double.parseDouble(calcs[2]);
		char sinal = calcs[1].charAt(0);
		double result = 0.0;
		
		try {
			switch(sinal) {
			case '+': result = servCalc.somar(num1, num2); break;
			case '-': result = servCalc.subtrair(num1, num2); break;
			case '*': result = servCalc.multiplicar(num1, num2); break;
			case '/': result = servCalc.dividir(num1, num2); break;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "O servidor calculadora está Offline. Tente mais tarde!");
			System.exit(1);
		} catch (DivisaoInvalidaException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return result;
	}
}