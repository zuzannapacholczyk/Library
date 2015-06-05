package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BooksView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1684637705068628631L;
	private JButton btnDodaj_1;
	private JButton btnUsun_1;
	private JTable authorBookResultTable;
	private JButton btnDodajAutora_1;
	private JList<String> listDepartments;
	private JTextField issuerBooksTextField;
	private JTextField yearBooksTextField;
	private JTextField titleBooksTextField;
	private JTextField copyIdBooksTextField;
	private JTextField bookIdBooksTextField;
	private String rights = "r";
	public BooksView(String string) {
		this.setRights(string);
		GridBagLayout gbl_booksPanel = new GridBagLayout();
		gbl_booksPanel.columnWidths = new int[]{200,300,50,50,50};
		gbl_booksPanel.rowHeights = new int[]{30,30,30,30,30, 30, 30,190};
		gbl_booksPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_booksPanel.rowWeights = new double[]{Double.MIN_VALUE};
		this.setLayout(gbl_booksPanel);
		
		JLabel lblNumerKsiazki = new JLabel("Numer ksiazki");
		GridBagConstraints gbc_lblNumerKsiazki = new GridBagConstraints();
		gbc_lblNumerKsiazki.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumerKsiazki.gridx = 0;
		gbc_lblNumerKsiazki.gridy = 0;
		this.add(lblNumerKsiazki, gbc_lblNumerKsiazki);
		
		bookIdBooksTextField = new JTextField();
		GridBagConstraints gbc_bookIdBooksTextField = new GridBagConstraints();
		gbc_bookIdBooksTextField.gridwidth = 4;
		gbc_bookIdBooksTextField.insets = new Insets(0, 0, 5, 0);
		gbc_bookIdBooksTextField.fill = GridBagConstraints.BOTH;
		gbc_bookIdBooksTextField.gridx = 1;
		gbc_bookIdBooksTextField.gridy = 0;
		this.add(bookIdBooksTextField, gbc_bookIdBooksTextField);
		bookIdBooksTextField.setColumns(10);
		
		JLabel lblNumerEgzemplarza = new JLabel("Numer egzemplarza");
		GridBagConstraints gbc_lblNumerEgzemplarza = new GridBagConstraints();
		gbc_lblNumerEgzemplarza.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumerEgzemplarza.gridx = 0;
		gbc_lblNumerEgzemplarza.gridy = 1;
		this.add(lblNumerEgzemplarza, gbc_lblNumerEgzemplarza);
		
		copyIdBooksTextField = new JTextField();
		GridBagConstraints gbc_copyIdBooksTextField = new GridBagConstraints();
		gbc_copyIdBooksTextField.gridwidth = 4;
		gbc_copyIdBooksTextField.insets = new Insets(0, 0, 5, 0);
		gbc_copyIdBooksTextField.fill = GridBagConstraints.BOTH;
		gbc_copyIdBooksTextField.gridx = 1;
		gbc_copyIdBooksTextField.gridy = 1;
		this.add(copyIdBooksTextField, gbc_copyIdBooksTextField);
		copyIdBooksTextField.setColumns(10);
		
		JLabel lblTytul = new JLabel("Tytul");
		GridBagConstraints gbc_lblTytul = new GridBagConstraints();
		gbc_lblTytul.insets = new Insets(0, 0, 5, 5);
		gbc_lblTytul.gridx = 0;
		gbc_lblTytul.gridy = 2;
		this.add(lblTytul, gbc_lblTytul);
		
		titleBooksTextField = new JTextField();
		GridBagConstraints gbc_titleBooksTextField = new GridBagConstraints();
		gbc_titleBooksTextField.gridwidth = 4;
		gbc_titleBooksTextField.insets = new Insets(0, 0, 5, 0);
		gbc_titleBooksTextField.fill = GridBagConstraints.BOTH;
		gbc_titleBooksTextField.gridx = 1;
		gbc_titleBooksTextField.gridy = 2;
		this.add(titleBooksTextField, gbc_titleBooksTextField);
		titleBooksTextField.setColumns(10);
		
		JLabel lblRokWydania = new JLabel("Rok wydania");
		GridBagConstraints gbc_lblRokWydania = new GridBagConstraints();
		gbc_lblRokWydania.insets = new Insets(0, 0, 5, 5);
		gbc_lblRokWydania.gridx = 0;
		gbc_lblRokWydania.gridy = 3;
		this.add(lblRokWydania, gbc_lblRokWydania);
		
		yearBooksTextField = new JTextField();
		GridBagConstraints gbc_yearBooksTextField = new GridBagConstraints();
		gbc_yearBooksTextField.gridwidth = 4;
		gbc_yearBooksTextField.insets = new Insets(0, 0, 5, 0);
		gbc_yearBooksTextField.fill = GridBagConstraints.BOTH;
		gbc_yearBooksTextField.gridx = 1;
		gbc_yearBooksTextField.gridy = 3;
		this.add(yearBooksTextField, gbc_yearBooksTextField);
		yearBooksTextField.setColumns(10);
		
		JLabel lblWydawnictwo = new JLabel("Wydawnictwo");
		GridBagConstraints gbc_lblWydawnictwo = new GridBagConstraints();
		gbc_lblWydawnictwo.insets = new Insets(0, 0, 5, 5);
		gbc_lblWydawnictwo.gridx = 0;
		gbc_lblWydawnictwo.gridy = 4;
		this.add(lblWydawnictwo, gbc_lblWydawnictwo);
		
		issuerBooksTextField = new JTextField();
		GridBagConstraints gbc_issuerBooksTextField = new GridBagConstraints();
		gbc_issuerBooksTextField.gridwidth = 4;
		gbc_issuerBooksTextField.insets = new Insets(0, 0, 5, 0);
		gbc_issuerBooksTextField.fill = GridBagConstraints.BOTH;
		gbc_issuerBooksTextField.gridx = 1;
		gbc_issuerBooksTextField.gridy = 4;
		this.add(issuerBooksTextField, gbc_issuerBooksTextField);
		issuerBooksTextField.setColumns(10);
		
		JLabel lblDzial = new JLabel("Dzial");
		GridBagConstraints gbc_lblDzial = new GridBagConstraints();
		gbc_lblDzial.insets = new Insets(0, 0, 5, 5);
		gbc_lblDzial.gridx = 0;
		gbc_lblDzial.gridy = 5;
		this.add(lblDzial, gbc_lblDzial);
		
		listDepartments = new JList<String>();
		GridBagConstraints gbc_listDepartments = new GridBagConstraints();
		gbc_listDepartments.insets = new Insets(0, 0, 5, 0);
		gbc_listDepartments.fill = GridBagConstraints.BOTH;
		gbc_listDepartments.gridx = 1;
		gbc_listDepartments.gridy = 7;
		this.add(listDepartments, gbc_listDepartments);
		
		btnDodajAutora_1 = new JButton("Dodaj autora");
		GridBagConstraints gbc_btnDodajAutora_1 = new GridBagConstraints();
		gbc_btnDodajAutora_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodajAutora_1.gridx = 2;
		gbc_btnDodajAutora_1.gridy = 6;
		this.add(btnDodajAutora_1, gbc_btnDodajAutora_1);
		
		btnDodaj_1 = new JButton("Dodaj");
		GridBagConstraints gbc_btnDodaj_1 = new GridBagConstraints();
		gbc_btnDodaj_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj_1.gridx = 3;
		gbc_btnDodaj_1.gridy = 6;
		this.add(btnDodaj_1, gbc_btnDodaj_1);
		
		btnUsun_1 = new JButton("Usun");
		GridBagConstraints gbc_btnUsun_1 = new GridBagConstraints();
		gbc_btnUsun_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnUsun_1.gridx = 4;
		gbc_btnUsun_1.gridy = 6;
		this.add(btnUsun_1, gbc_btnUsun_1);
		
		authorBookResultTable = new JTable();
		GridBagConstraints gbc_authorsBookTable = new GridBagConstraints();
		gbc_authorsBookTable.gridwidth = 5;
		gbc_authorsBookTable.insets = new Insets(0, 0, 0, 5);
		gbc_authorsBookTable.fill = GridBagConstraints.BOTH;
		gbc_authorsBookTable.gridx = 0;
		gbc_authorsBookTable.gridy = 7;
		this.add(authorBookResultTable, gbc_authorsBookTable);
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
}
