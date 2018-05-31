import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankAccount {



	JFrame thisGUI;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JMenuBar menuBar;
	JMenuBar moreMenu;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JTextField userText;
	double balance = 500.0;
	double wValue = 0.0;
	double dValue = 0.0;
	String uName;
	String aNumber;
	
	
	
	public static void main(String[] args) {
		new BankAccount();
	
		}


	public BankAccount(){

		thisGUI = new JFrame();
		thisGUI.setTitle("My ATM");
		thisGUI.setSize(400, 400);
		thisGUI.setResizable(false);
		thisGUI.setLocationRelativeTo(null);
		thisGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ListenForLogin lForLogin = new ListenForLogin();
		ListenForWithdraw lForWithdraw = new ListenForWithdraw();
		ListenForDeposit lForDeposit = new ListenForDeposit();
		ListenForLogout lForLogout = new ListenForLogout();
		ListenForAbout lForAbout = new ListenForAbout();
		ListenForProcess lForProcess = new ListenForProcess();


		
		JPanel panel = new JPanel();
		panel.setLayout(null);
	
		
		label1 = new JLabel();
		label1.setText("Clinton's ATM");
		label1.setOpaque(true);
		label1.setBackground(Color.CYAN);
		label1.setBounds(0,0,398,50);
		label1.setFont(new Font(label1.getName(), Font.PLAIN, 25));
		panel.add(label1);
		
		label2 = new JLabel();  
		label2.setBounds(30,95,398,15);
		panel.add(label2);

		label3 = new JLabel(); 
		label3.setBounds(30,115,398,15);
		panel.add(label3);
		
		label4 = new JLabel();
		label4.setText("Balance: " + balance);
		label4.setOpaque(true);
		label4.setBounds(230,95,398,15);
		label4.setVisible(false);
		panel.add(label4);
		
		
		button1  = new JButton("Login");
		button1.setBounds(133, 55, 135, 30);
		button1.setVisible(true);
		button1.addActionListener(lForLogin);
		panel.add(button1);
		
		button3  = new JButton("Logout");
		button3.setBounds(133, 55, 135, 30);
		button3.setVisible(false);
		button3.addActionListener(lForLogout);
		panel.add(button3);
		
		button4  = new JButton("Withdraw");
		button4.setBounds(30, 240, 135, 50);
		button4.setVisible(false);
		button4.addActionListener(lForWithdraw);
		panel.add(button4);
		
		
		button5  = new JButton("Deposit");
		button5.setBounds(230, 240, 135, 50);
		button5.setVisible(false);
		button5.addActionListener(lForDeposit);
		panel.add(button5);
		
	
		userText = new JTextField(20);
		userText.setBounds(0,35, 250, 30);
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu transactionMenu = new JMenu("Transaction");
		JMenuItem depositMenuItem = new JMenuItem("Deposit");
		depositMenuItem.addActionListener(lForDeposit);
		transactionMenu.add(depositMenuItem);
		//menuBar.setVisible(false);
		transactionMenu.addSeparator();
		
		JMenuItem withdrawMenuItem = new JMenuItem("Withdraw");
		withdrawMenuItem.addActionListener(lForWithdraw);
		transactionMenu.add(withdrawMenuItem);
		
		JMenu moreMenu = new JMenu("More");
		JMenuItem aboutMenuItem = new JMenuItem("About");
		moreMenu.add(aboutMenuItem);
		aboutMenuItem.addActionListener(lForAbout);
		//moreMenu.setVisible(false);
		moreMenu.addSeparator();
		
		JMenuItem processMenuItem = new JMenuItem("Process");
		processMenuItem.addActionListener(lForProcess);
		moreMenu.add(processMenuItem); 
		
		
		
		menuBar.add(transactionMenu);
		menuBar.add(moreMenu);
		thisGUI.add(menuBar); 
		thisGUI.setJMenuBar(menuBar);
		
		
		
		thisGUI.add(panel);
		thisGUI.setVisible(true);

	}
	
	//Add Action Listeners Here
	private class ListenForLogin implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String uName = (String)JOptionPane.showInputDialog(
                    thisGUI,
                    "Please enter your username:", "Verification",  JOptionPane.PLAIN_MESSAGE);
			label2.setText("Username: " + uName); 
			String aNumber = (String)JOptionPane.showInputDialog(
                    thisGUI,
                    "Please enter your account number:", "Verification",  JOptionPane.PLAIN_MESSAGE);
			label3.setText("Account number: " + aNumber); 
			label2.setVisible(true);
			label3.setVisible(true);
			button3.setVisible(true);
			button4.setVisible(true);
			button5.setVisible(true); 
			label4.setVisible(true);
			button1.setVisible(false);
			//moreMenu.setVisible(true);
			//menuBar.setVisible(true);

		}
	}
	private class ListenForLogout implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	
			label2.setVisible(false);
			label3.setVisible(false);
			button3.setVisible(true);
			button4.setVisible(false);
			button5.setVisible(false); 
			label4.setVisible(false);
			button1.setVisible(true);
		}

	
	}
	private class ListenForWithdraw implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String withdraw = (String)JOptionPane.showInputDialog(
                    thisGUI,
                    "How much would you like to withdraw?", "Withdraw",  JOptionPane.PLAIN_MESSAGE);
			double withdraw2 = Double.parseDouble(withdraw);
			wValue = (balance - withdraw2);
			balance = wValue;
			String wFinalValue = Double.toString(wValue);
			label4.setText("Balance: " + wFinalValue);
			
		}
}
	private class ListenForDeposit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String deposit = (String)JOptionPane.showInputDialog(
                    thisGUI,
                    "How much would you like to deposit?", "Deposit",  JOptionPane.PLAIN_MESSAGE);
			double deposit2 = Double.parseDouble(deposit);
			dValue = (balance + deposit2);
			balance = dValue;
			String dFinalValue = Double.toString(dValue);
			label4.setText("Balance: " + dFinalValue);
		}
}
	private class ListenForAbout implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(thisGUI,
				    "This GUI was created by Dustin Voigt and Itaty Marquez.");
		}

	
	}	
	private class ListenForProcess implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(thisGUI,
				    "This program was created using java in Eclipse. It took 8 days to create.");
		}

	}
}





