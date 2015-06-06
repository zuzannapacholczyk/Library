package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.BooksPanelModel;
import controller.BooksPanelController;

public class BooksPanelView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1684637705068628631L;
	private JButton btnDodaj;
	private JButton btnUsun_1;
	private JTable authorBookResultTable;
	private JButton btnDodajAutora_1;
	private JComboBox<String> listDepartments;
	private JTextField issuerBooksTextField;
	private JTextField yearBooksTextField;
	private JTextField titleBooksTextField;
	private JTextField copyIdBooksTextField;
	private JTextField bookIdBooksTextField;
	private String rights = "r";
	private JButton btnDodajEgzemplarz;
	private JButton btnWyczysc;
	public BooksPanelView(String string) {
		this.setRights(string);
		GridBagLayout gbl_booksPanel = new GridBagLayout();
		gbl_booksPanel.columnWidths = new int[]{200,200, 50, 50,50,50,50};
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
		gbc_bookIdBooksTextField.gridwidth = 5;
		gbc_bookIdBooksTextField.insets = new Insets(0, 0, 5, 5);
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
		gbc_copyIdBooksTextField.gridwidth = 5;
		gbc_copyIdBooksTextField.insets = new Insets(0, 0, 5, 5);
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
		gbc_titleBooksTextField.gridwidth = 5;
		gbc_titleBooksTextField.insets = new Insets(0, 0, 5, 5);
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
		gbc_yearBooksTextField.gridwidth = 5;
		gbc_yearBooksTextField.insets = new Insets(0, 0, 5, 5);
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
		gbc_issuerBooksTextField.gridwidth = 5;
		gbc_issuerBooksTextField.insets = new Insets(0, 0, 5, 5);
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
		
		listDepartments = new JComboBox<String>();
		GridBagConstraints gbc_listDepartments = new GridBagConstraints();
		gbc_listDepartments.insets = new Insets(0, 0, 5, 5);
		gbc_listDepartments.fill = GridBagConstraints.BOTH;
		gbc_listDepartments.gridx = 1;
		gbc_listDepartments.gridy = 5;
		this.add(listDepartments, gbc_listDepartments);
		
		btnDodajAutora_1 = new JButton("Dodaj autora");
		GridBagConstraints gbc_btnDodajAutora_1 = new GridBagConstraints();
		gbc_btnDodajAutora_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodajAutora_1.gridx = 1;
		gbc_btnDodajAutora_1.gridy = 6;
		this.add(btnDodajAutora_1, gbc_btnDodajAutora_1);
		
		btnDodaj = new JButton("Dodaj ksiazke");
		GridBagConstraints gbc_btnDodaj_1 = new GridBagConstraints();
		gbc_btnDodaj_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj_1.gridx = 2;
		gbc_btnDodaj_1.gridy = 6;
		this.add(btnDodaj, gbc_btnDodaj_1);
		
		btnDodajEgzemplarz = new JButton("Dodaj egzemplarz");
		GridBagConstraints gbc_btnDodajEgzemplarz = new GridBagConstraints();
		gbc_btnDodajEgzemplarz.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodajEgzemplarz.gridx = 3;
		gbc_btnDodajEgzemplarz.gridy = 6;
		this.add(btnDodajEgzemplarz, gbc_btnDodajEgzemplarz);
		
		btnUsun_1 = new JButton("Usun");
		GridBagConstraints gbc_btnUsun_1 = new GridBagConstraints();
		gbc_btnUsun_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnUsun_1.gridx = 4;
		gbc_btnUsun_1.gridy = 6;
		this.add(btnUsun_1, gbc_btnUsun_1);
		gbc_btnDodajAutora_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodajAutora_1.gridx = 5;
		gbc_btnDodajAutora_1.gridy = 6;
		
		btnWyczysc = new JButton("Wyczysc");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 5;
		gbc_button.gridy = 6;
		add(btnWyczysc, gbc_button);
		
		authorBookResultTable = new JTable();
		JScrollPane scrollPane = new JScrollPane(authorBookResultTable);
		GridBagConstraints gbc_authorsBookTable = new GridBagConstraints();
		gbc_authorsBookTable.gridwidth = 5;
		gbc_authorsBookTable.insets = new Insets(0, 0, 0, 5);
		gbc_authorsBookTable.fill = GridBagConstraints.BOTH;
		gbc_authorsBookTable.gridx = 0;
		gbc_authorsBookTable.gridy = 7;
		this.add(scrollPane, gbc_authorsBookTable);
		
		BooksPanelModel model = new BooksPanelModel(this);
		BooksPanelController controller = new BooksPanelController(model, this);
		controller.control();
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	
	public JButton getAddButton() {
		return this.btnDodaj;
	}
	
	public JButton getAddCopyButton() {
		return this.btnDodajEgzemplarz;
	}
	
	public JButton getRemoveButton() {
		return this.btnUsun_1;
	}
	
	public JButton getCleanButton() {
		return this.btnWyczysc;
	}
	
	public JButton getAddAuthorButton() {
		return this.btnDodajAutora_1;
	}
	
	public JTable getAuthorResultTable() {
		return this.authorBookResultTable;
	}
	
	public String getSelectedDepartment() {
		return (String) this.listDepartments.getSelectedItem();
	}
	
	public JComboBox<String> getListDepartments() {
		return this.listDepartments;
	}
	
	public String getCopyIdTextField() {
		return copyIdBooksTextField.getText();
	}
	
	public void setCopyIdTextField(String text) {
		this.copyIdBooksTextField.setText(text);
	}
	
	public String getBookIdTextField() {
		return bookIdBooksTextField.getText();
	}
	
	public void setBookIdTextField(String text) {
		this.bookIdBooksTextField.setText(text);
	}
	
	public String getIssuerTexField() {
		return issuerBooksTextField.getText();
	}
	
	public void setIssuerTextField(String text) {
		this.issuerBooksTextField.setText(text);
	}
	
	public String getYearTextField() {
		return yearBooksTextField.getText();
	}
	
	public void setYearTextField(String text) {
		this.yearBooksTextField.setText(text);
	}
	
	public String getTitleTextField() {
		return titleBooksTextField.getText();
	}
	
	public void setTitleTextField(String text) {
		this.titleBooksTextField.setText(text);
	}
}
