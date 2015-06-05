package view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AuthorsView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4366533306285564495L;
	private JButton btnUsun;
	private JTable searchAuthorResultTable;
	private Component btnDodaj;
	private Component btnZnajdz;
	private JTextField surnameAuthorTextField;
	private JTextField nameAuthorTextField;
	private JTextField numberAuthorTextField;
	private String rights = "r";
	
	public AuthorsView(String string) {
		this.setRights(string);
		GridBagLayout gbl_authorsPanel = new GridBagLayout();
		gbl_authorsPanel.columnWidths = new int[]{350,200,50,50,50};
		gbl_authorsPanel.rowHeights = new int[]{30,30,30,30, 280};
		gbl_authorsPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_authorsPanel.rowWeights = new double[]{Double.MIN_VALUE};
		this.setLayout(gbl_authorsPanel);
		
		JLabel lblNumer_1 = new JLabel("Numer");
		GridBagConstraints gbc_lblNumer_1 = new GridBagConstraints();
		gbc_lblNumer_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumer_1.gridx = 0;
		gbc_lblNumer_1.gridy = 0;
		this.add(lblNumer_1, gbc_lblNumer_1);
		
		numberAuthorTextField = new JTextField();
		GridBagConstraints gbc_numberAuthorTextField = new GridBagConstraints();
		gbc_numberAuthorTextField.gridwidth = 4;
		gbc_numberAuthorTextField.insets = new Insets(0, 0, 5, 0);
		gbc_numberAuthorTextField.fill = GridBagConstraints.BOTH;
		gbc_numberAuthorTextField.gridx = 1;
		gbc_numberAuthorTextField.gridy = 0;
		this.add(numberAuthorTextField, gbc_numberAuthorTextField);
		numberAuthorTextField.setColumns(10);
		
		JLabel lblImie_1 = new JLabel("Imie");
		GridBagConstraints gbc_lblImie_1 = new GridBagConstraints();
		gbc_lblImie_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblImie_1.gridx = 0;
		gbc_lblImie_1.gridy = 1;
		this.add(lblImie_1, gbc_lblImie_1);
		
		nameAuthorTextField = new JTextField();
		GridBagConstraints gbc_nameAuthorTextField = new GridBagConstraints();
		gbc_nameAuthorTextField.gridwidth = 4;
		gbc_nameAuthorTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameAuthorTextField.fill = GridBagConstraints.BOTH;
		gbc_nameAuthorTextField.gridx = 1;
		gbc_nameAuthorTextField.gridy = 1;
		this.add(nameAuthorTextField, gbc_nameAuthorTextField);
		nameAuthorTextField.setColumns(10);
		
		JLabel lblNazwisko_1 = new JLabel("Nazwisko");
		GridBagConstraints gbc_lblNazwisko_1 = new GridBagConstraints();
		gbc_lblNazwisko_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNazwisko_1.gridx = 0;
		gbc_lblNazwisko_1.gridy = 2;
		this.add(lblNazwisko_1, gbc_lblNazwisko_1);
		
		surnameAuthorTextField = new JTextField();
		GridBagConstraints gbc_surnameAuthorTextField = new GridBagConstraints();
		gbc_surnameAuthorTextField.gridwidth = 4;
		gbc_surnameAuthorTextField.insets = new Insets(0, 0, 5, 0);
		gbc_surnameAuthorTextField.fill = GridBagConstraints.BOTH;
		gbc_surnameAuthorTextField.gridx = 1;
		gbc_surnameAuthorTextField.gridy = 2;
		this.add(surnameAuthorTextField, gbc_surnameAuthorTextField);
		surnameAuthorTextField.setColumns(10);
		
		btnZnajdz = new JButton("Znajdz");
		GridBagConstraints gbc_btnZnajdz = new GridBagConstraints();
		gbc_btnZnajdz.insets = new Insets(0, 0, 5, 5);
		gbc_btnZnajdz.gridx = 2;
		gbc_btnZnajdz.gridy = 3;
		this.add(btnZnajdz, gbc_btnZnajdz);
		
		btnDodaj = new JButton("Dodaj");
		GridBagConstraints gbc_btnDodaj = new GridBagConstraints();
		gbc_btnDodaj.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj.gridx = 3;
		gbc_btnDodaj.gridy = 3;
		this.add(btnDodaj, gbc_btnDodaj);
		
		btnUsun = new JButton("Usun");
		GridBagConstraints gbc_btnUsun = new GridBagConstraints();
		gbc_btnUsun.insets = new Insets(0, 0, 5, 0);
		gbc_btnUsun.gridx = 4;
		gbc_btnUsun.gridy = 3;
		this.add(btnUsun, gbc_btnUsun);	
		
		searchAuthorResultTable = new JTable();
		GridBagConstraints gbc_tableAuthor = new GridBagConstraints();
		gbc_tableAuthor.gridwidth = 5;
		gbc_tableAuthor.insets = new Insets(0, 0, 0, 5);
		gbc_tableAuthor.fill = GridBagConstraints.BOTH;
		gbc_tableAuthor.gridx = 0;
		gbc_tableAuthor.gridy = 4;
		this.add(searchAuthorResultTable, gbc_tableAuthor);
		
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}
}
