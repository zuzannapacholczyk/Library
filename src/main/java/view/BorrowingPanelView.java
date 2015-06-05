package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BorrowingPanelView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6100013237167283019L;
	private JTextField nameTextField;
	private JTextField bookNumberTextField;
	private JTextField readerNumberTextField;
	private JTextField titleTextField;
	private JTextField surnameTextField;
	private JTextField authorTextField;
	private JButton btnWypozycz;
	private JButton btnPrzyjmijZwrot;
	
	private String rights = "r";

	public BorrowingPanelView(String string) {
		this.setRights(string);
		GridBagLayout gbl_borrowingPanel = new GridBagLayout();
		gbl_borrowingPanel.columnWidths = new int[] { 150, 200, 150, 200 };
		gbl_borrowingPanel.rowHeights = new int[] { 50, 30, 30, 30, 30, 250 };
		gbl_borrowingPanel.columnWeights = new double[] { 1.0 };
		gbl_borrowingPanel.rowWeights = new double[] { 1.0 };
		this.setLayout(gbl_borrowingPanel);
		

		JLabel lblCzytelnik = new JLabel("CZYTELNIK");
		GridBagConstraints gbc_lblCzytelnik = new GridBagConstraints();
		gbc_lblCzytelnik.insets = new Insets(0, 0, 5, 5);
		gbc_lblCzytelnik.gridx = 1;
		gbc_lblCzytelnik.gridy = 0;
		this.add(lblCzytelnik, gbc_lblCzytelnik);

		JLabel lblKsiazka = new JLabel("KSIAZKA");
		GridBagConstraints gbc_lblKsiazka = new GridBagConstraints();
		gbc_lblKsiazka.insets = new Insets(0, 0, 5, 0);
		gbc_lblKsiazka.gridx = 3;
		gbc_lblKsiazka.gridy = 0;
		this.add(lblKsiazka, gbc_lblKsiazka);

		JLabel lblNewLabel_2 = new JLabel("Numer");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		readerNumberTextField = new JTextField();
		GridBagConstraints gbc_readerNumberTextField = new GridBagConstraints();
		gbc_readerNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_readerNumberTextField.fill = GridBagConstraints.BOTH;
		gbc_readerNumberTextField.gridx = 1;
		gbc_readerNumberTextField.gridy = 1;
		this.add(readerNumberTextField, gbc_readerNumberTextField);
		readerNumberTextField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Numer");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 1;
		this.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		bookNumberTextField = new JTextField();
		GridBagConstraints gbc_bookNumberTextField = new GridBagConstraints();
		gbc_bookNumberTextField.insets = new Insets(0, 0, 5, 0);
		gbc_bookNumberTextField.fill = GridBagConstraints.BOTH;
		gbc_bookNumberTextField.gridx = 3;
		gbc_bookNumberTextField.gridy = 1;
		this.add(bookNumberTextField, gbc_bookNumberTextField);
		bookNumberTextField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Imie");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		this.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		nameTextField = new JTextField();
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nameTextField.fill = GridBagConstraints.BOTH;
		gbc_nameTextField.gridx = 1;
		gbc_nameTextField.gridy = 2;
		this.add(nameTextField, gbc_nameTextField);
		nameTextField.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Tytul");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 2;
		this.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		titleTextField = new JTextField();
		GridBagConstraints gbc_titleTextField = new GridBagConstraints();
		gbc_titleTextField.insets = new Insets(0, 0, 5, 0);
		gbc_titleTextField.fill = GridBagConstraints.BOTH;
		gbc_titleTextField.gridx = 3;
		gbc_titleTextField.gridy = 2;
		this.add(titleTextField, gbc_titleTextField);
		titleTextField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Nazwisko");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		this.add(lblNewLabel_4, gbc_lblNewLabel_4);

		surnameTextField = new JTextField();
		GridBagConstraints gbc_surnameTextField = new GridBagConstraints();
		gbc_surnameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_surnameTextField.fill = GridBagConstraints.BOTH;
		gbc_surnameTextField.gridx = 1;
		gbc_surnameTextField.gridy = 3;
		this.add(surnameTextField, gbc_surnameTextField);
		surnameTextField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Autor");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 3;
		this.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		authorTextField = new JTextField();
		GridBagConstraints gbc_authorNumberTextField = new GridBagConstraints();
		gbc_authorNumberTextField.insets = new Insets(0, 0, 5, 0);
		gbc_authorNumberTextField.fill = GridBagConstraints.BOTH;
		gbc_authorNumberTextField.gridx = 3;
		gbc_authorNumberTextField.gridy = 3;
		this.add(authorTextField, gbc_authorNumberTextField);
		authorTextField.setColumns(10);

		btnWypozycz = new JButton("Wypozycz");
		GridBagConstraints gbc_butnWypozycz = new GridBagConstraints();
		gbc_butnWypozycz.insets = new Insets(0, 0, 5, 5);
		gbc_butnWypozycz.gridx = 2;
		gbc_butnWypozycz.gridy = 4;
		this.add(btnWypozycz, gbc_butnWypozycz);

		btnPrzyjmijZwrot = new JButton("Przyjmij zwrot");
		GridBagConstraints gbc_btnPrzyjmijZwrot = new GridBagConstraints();
		gbc_btnPrzyjmijZwrot.insets = new Insets(0, 0, 5, 0);
		gbc_btnPrzyjmijZwrot.gridx = 3;
		gbc_btnPrzyjmijZwrot.gridy = 4;
		this.add(btnPrzyjmijZwrot, gbc_btnPrzyjmijZwrot);
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

}
