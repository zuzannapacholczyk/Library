package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserAccountView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7457095234650451444L;
	private JTextField loginUserTextField;
	private JTextField passwordUserTextField;
	private JTextField nameUserTextField;
	private JTextField surnameUserTextField;
	private JList<String> listRights;
	private JButton btnDodaj_2;
	private JButton btnUsun_2;
	private JButton btnZmien;
	private String rights = "r";

	public UserAccountView(String string) {
		this.setRights(string);
		GridBagLayout gbl_userAccountPanel = new GridBagLayout();
		gbl_userAccountPanel.columnWidths = new int[]{300,400};
		gbl_userAccountPanel.rowHeights = new int[]{30,30,30,30,30,30,30, 210};
		gbl_userAccountPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_userAccountPanel.rowWeights = new double[]{Double.MIN_VALUE};
		this.setLayout(gbl_userAccountPanel);
		
		JLabel lblLogin = new JLabel("Login");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 1;
		this.add(lblLogin, gbc_lblLogin);
		
		loginUserTextField = new JTextField();
		GridBagConstraints gbc_loginUserTextField = new GridBagConstraints();
		gbc_loginUserTextField.gridwidth = 4;
		gbc_loginUserTextField.insets = new Insets(0, 0, 5, 0);
		gbc_loginUserTextField.fill = GridBagConstraints.BOTH;
		gbc_loginUserTextField.gridx = 1;
		gbc_loginUserTextField.gridy = 1;
		this.add(loginUserTextField, gbc_loginUserTextField);
		loginUserTextField.setColumns(10);
		
		JLabel lblHaslo = new JLabel("Haslo");
		GridBagConstraints gbc_lblHaslo = new GridBagConstraints();
		gbc_lblHaslo.insets = new Insets(0, 0, 5, 5);
		gbc_lblHaslo.gridx = 0;
		gbc_lblHaslo.gridy = 2;
		this.add(lblHaslo, gbc_lblHaslo);
		
		passwordUserTextField = new JTextField();
		GridBagConstraints gbc_passwordUserTextField = new GridBagConstraints();
		gbc_passwordUserTextField.gridwidth = 4;
		gbc_passwordUserTextField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordUserTextField.fill = GridBagConstraints.BOTH;
		gbc_passwordUserTextField.gridx = 1;
		gbc_passwordUserTextField.gridy = 2;
		this.add(passwordUserTextField, gbc_passwordUserTextField);
		passwordUserTextField.setColumns(10);
		
		JLabel lblImie_2 = new JLabel("Imie");
		GridBagConstraints gbc_lblImie_2 = new GridBagConstraints();
		gbc_lblImie_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblImie_2.gridx = 0;
		gbc_lblImie_2.gridy = 3;
		this.add(lblImie_2, gbc_lblImie_2);
		
		nameUserTextField = new JTextField();
		GridBagConstraints gbc_nameUserTextField = new GridBagConstraints();
		gbc_nameUserTextField.gridwidth = 4;
		gbc_nameUserTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameUserTextField.fill = GridBagConstraints.BOTH;
		gbc_nameUserTextField.gridx = 1;
		gbc_nameUserTextField.gridy = 3;
		this.add(nameUserTextField, gbc_nameUserTextField);
		nameUserTextField.setColumns(10);
		
		JLabel lblNazwisko_2 = new JLabel("Nazwisko");
		GridBagConstraints gbc_lblNazwisko_2 = new GridBagConstraints();
		gbc_lblNazwisko_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNazwisko_2.gridx = 0;
		gbc_lblNazwisko_2.gridy = 4;
		this.add(lblNazwisko_2, gbc_lblNazwisko_2);
		
		surnameUserTextField = new JTextField();
		GridBagConstraints gbc_surnameUserTextField = new GridBagConstraints();
		gbc_surnameUserTextField.gridwidth = 4;
		gbc_surnameUserTextField.insets = new Insets(0, 0, 5, 0);
		gbc_surnameUserTextField.fill = GridBagConstraints.BOTH;
		gbc_surnameUserTextField.gridx = 1;
		gbc_surnameUserTextField.gridy = 4;
		this.add(surnameUserTextField, gbc_surnameUserTextField);
		surnameUserTextField.setColumns(10);
		
		JLabel lblPrawaUzytkownika = new JLabel("Prawa uzytkownika");
		GridBagConstraints gbc_lblPrawaUzytkownika = new GridBagConstraints();
		gbc_lblPrawaUzytkownika.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrawaUzytkownika.gridx = 0;
		gbc_lblPrawaUzytkownika.gridy = 5;
		this.add(lblPrawaUzytkownika, gbc_lblPrawaUzytkownika);
		
		listRights = new JList<String>();
		GridBagConstraints gbc_listRights = new GridBagConstraints();
		gbc_listRights.gridwidth = 4;
		gbc_listRights.insets = new Insets(0, 0, 5, 0);
		gbc_listRights.fill = GridBagConstraints.BOTH;
		gbc_listRights.gridx = 1;
		gbc_listRights.gridy = 5;
		this.add(listRights, gbc_listRights);
		
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

	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}
}
