package view;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoggingWindowView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1433114895703338520L;

	private JTextField loginTextField_1;
	private JPasswordField passwordTextField;

	private JButton btnZaloguj;

	private JLabel errorLabel;
	public LoggingWindowView() {

		this.setTitle("Logowanie");
		this.setSize(300, 200);
		this.setLocation(10, 10);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50,50,100,};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel label = new JLabel("Login");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		getContentPane().add(label, gbc_label);
		
		loginTextField_1 = new JTextField();
		loginTextField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		getContentPane().add(loginTextField_1, gbc_textField_1);
		
		JLabel label_1 = new JLabel("Haslo");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		getContentPane().add(label_1, gbc_label_1);
		
		passwordTextField = new JPasswordField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		getContentPane().add(passwordTextField, gbc_textField);
		passwordTextField.setColumns(10);
		
		btnZaloguj = new JButton("Zaloguj");
		GridBagConstraints gbc_btnZaloguj = new GridBagConstraints();
		gbc_btnZaloguj.gridx = 2;
		gbc_btnZaloguj.gridy = 4;
		getContentPane().add(btnZaloguj, gbc_btnZaloguj);
		
		errorLabel = new JLabel("");
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.gridwidth = 3;
		gbc_errorLabel.anchor = GridBagConstraints.EAST;
		gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_errorLabel.gridx = 0;
		gbc_errorLabel.gridy = 5;
		getContentPane().add(errorLabel, gbc_errorLabel);
	}
	public String getLoginTextField_1() {
		return loginTextField_1.getText();
	}
	public void setLoginTextField_1(String loginTextField_1) {
		this.loginTextField_1.setText(loginTextField_1);
	}
	
	public char[] getPasswordTextField_1() {
		return passwordTextField.getPassword();
	}
	public void setPasswordTextField_1(String passwordTextField) {
		this.passwordTextField.setText(passwordTextField);
	}
	
	public JButton getBtnZaloguj() {
		return btnZaloguj;
	}
	
	public void setErrorLabel(String error) {
		this.errorLabel.setForeground (Color.red);
		this.errorLabel.setText(error);
	}

}
