package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ReaderPanelController;
import model.ReaderPanelModel;

public class ReaderPanelView extends JPanel{
	private static final long serialVersionUID = 7457095234650451444L;
	private JTextField idTextField;
	private JTextField addressTextField;
	private JTextField emailTextField;
	private JTextField nameUserTextField;
	private JTextField surnameUserTextField;

	private JButton btnDodaj_2;
	private JButton btnUsun_2;
	private JButton btnZmien;
	private JButton btnClear;
	private String rights = "r";

	public ReaderPanelView(String string) {
		this.setRights(string);
		GridBagLayout gbl_userAccountPanel = new GridBagLayout();
		gbl_userAccountPanel.columnWidths = new int[]{300,400};
		gbl_userAccountPanel.rowHeights = new int[]{30,30,30,30,30,30,30, 210};
		gbl_userAccountPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_userAccountPanel.rowWeights = new double[]{Double.MIN_VALUE};
		this.setLayout(gbl_userAccountPanel);
		
		JLabel lblLogin = new JLabel("Id");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 1;
		this.add(lblLogin, gbc_lblLogin);
		
		idTextField = new JTextField();
		GridBagConstraints gbc_idTextField = new GridBagConstraints();
		gbc_idTextField.gridwidth = 4;
		gbc_idTextField.insets = new Insets(0, 0, 5, 0);
		gbc_idTextField.fill = GridBagConstraints.BOTH;
		gbc_idTextField.gridx = 1;
		gbc_idTextField.gridy = 1;
		this.add(idTextField, gbc_idTextField);
		idTextField.setColumns(10);
		
		JLabel lblImie_2 = new JLabel("Imie");
		GridBagConstraints gbc_lblImie_2 = new GridBagConstraints();
		gbc_lblImie_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblImie_2.gridx = 0;
		gbc_lblImie_2.gridy = 2;
		this.add(lblImie_2, gbc_lblImie_2);
		
		nameUserTextField = new JTextField();
		GridBagConstraints gbc_nameUserTextField = new GridBagConstraints();
		gbc_nameUserTextField.gridwidth = 4;
		gbc_nameUserTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameUserTextField.fill = GridBagConstraints.BOTH;
		gbc_nameUserTextField.gridx = 1;
		gbc_nameUserTextField.gridy = 2;
		this.add(nameUserTextField, gbc_nameUserTextField);
		nameUserTextField.setColumns(10);
		
		JLabel lblNazwisko_2 = new JLabel("Nazwisko");
		GridBagConstraints gbc_lblNazwisko_2 = new GridBagConstraints();
		gbc_lblNazwisko_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNazwisko_2.gridx = 0;
		gbc_lblNazwisko_2.gridy = 3;
		this.add(lblNazwisko_2, gbc_lblNazwisko_2);
		
		surnameUserTextField = new JTextField();
		GridBagConstraints gbc_surnameUserTextField = new GridBagConstraints();
		gbc_surnameUserTextField.gridwidth = 4;
		gbc_surnameUserTextField.insets = new Insets(0, 0, 5, 0);
		gbc_surnameUserTextField.fill = GridBagConstraints.BOTH;
		gbc_surnameUserTextField.gridx = 1;
		gbc_surnameUserTextField.gridy = 3;
		this.add(surnameUserTextField, gbc_surnameUserTextField);
		surnameUserTextField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Adres");
		GridBagConstraints gbc_Address = new GridBagConstraints();
		gbc_Address.insets = new Insets(0, 0, 5, 5);
		gbc_Address.gridx = 0;
		gbc_Address.gridy = 4;
		this.add(lblAddress, gbc_Address);
		
		addressTextField = new JTextField();
		GridBagConstraints gbc_loginUserTextField = new GridBagConstraints();
		gbc_loginUserTextField.gridwidth = 4;
		gbc_loginUserTextField.insets = new Insets(0, 0, 5, 0);
		gbc_loginUserTextField.fill = GridBagConstraints.BOTH;
		gbc_loginUserTextField.gridx = 1;
		gbc_loginUserTextField.gridy = 4;
		this.add(addressTextField, gbc_loginUserTextField);
		addressTextField.setColumns(10);
		
		JLabel emailLbl = new JLabel("Email");
		GridBagConstraints gbc_lblHaslo = new GridBagConstraints();
		gbc_lblHaslo.insets = new Insets(0, 0, 5, 5);
		gbc_lblHaslo.gridx = 0;
		gbc_lblHaslo.gridy = 5;
		this.add(emailLbl, gbc_lblHaslo);
		
		emailTextField = new JTextField();
		GridBagConstraints gbc_passwordUserTextField = new GridBagConstraints();
		gbc_passwordUserTextField.gridwidth = 4;
		gbc_passwordUserTextField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordUserTextField.fill = GridBagConstraints.BOTH;
		gbc_passwordUserTextField.gridx = 1;
		gbc_passwordUserTextField.gridy = 5;
		this.add(emailTextField, gbc_passwordUserTextField);
		emailTextField.setColumns(10);
		
		btnClear = new JButton("Wyczysc");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnClear.gridx = 1;
		gbc_btnClear.gridy = 6;
		this.add(btnClear, gbc_btnClear);
		
		btnDodaj_2 = new JButton("Dodaj");
		GridBagConstraints gbc_btnDodaj_2 = new GridBagConstraints();
		gbc_btnDodaj_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj_2.gridx = 2;
		gbc_btnDodaj_2.gridy = 6;
		this.add(btnDodaj_2, gbc_btnDodaj_2);
		
		btnUsun_2 = new JButton("Usun");
		GridBagConstraints gbc_btnUsun_2 = new GridBagConstraints();
		gbc_btnUsun_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnUsun_2.gridx = 3;
		gbc_btnUsun_2.gridy = 6;
		this.add(btnUsun_2, gbc_btnUsun_2);
		
		btnZmien = new JButton("Zmien");
		GridBagConstraints gbc_btnZmien = new GridBagConstraints();
		gbc_btnZmien.insets = new Insets(0, 0, 5, 0);
		gbc_btnZmien.gridx = 4;
		gbc_btnZmien.gridy = 6;
		this.add(btnZmien, gbc_btnZmien);
		
		ReaderPanelModel model = new ReaderPanelModel(this);
		ReaderPanelController controller = new  ReaderPanelController(model, this);
		controller.control();

	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}
	
	public JButton getDeleteButton() {
		return btnUsun_2;
	}
	
	public JButton getChangeButton() {
		return btnZmien;
	}
	
	public JButton getAddButton() {
		return btnDodaj_2;
	}
	
	public String getNameTextField() {
		return nameUserTextField.getText();
	}
	
	public void setNameTextField(String name) {
		this.nameUserTextField.setText(name);
	}
	
	public String getSurnameTextField() {
		return surnameUserTextField.getText();
	}
	
	public void setSurnameTextField(String surname) {
		this.surnameUserTextField.setText(surname);
	}

	public JButton getClearButton() {
		return btnClear;
	}

	public String getAddress() {
		return addressTextField.getText();
	}

	public void setAddress(String address) {
		this.addressTextField.setText( address);
	}

	public String getIdTextField() {
		return idTextField.getText();
	}

	public void setIdTextField(String idTextField) {
		this.idTextField.setText(idTextField);
	}

	public String getEmailTextField() {
		return emailTextField.getText();
	}

	public void setEmailTextField(String emailTextField) {
		this.emailTextField.setText(emailTextField);
	}

}
