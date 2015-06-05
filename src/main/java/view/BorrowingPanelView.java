package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BorrowingPanelModel;
import controller.BorrowingPanelController;

public class BorrowingPanelView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6100013237167283019L;

	private JTextField bookNumberTextField;
	private JTextField readerNumberTextField;

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

		BorrowingPanelModel model = new BorrowingPanelModel(this);
		BorrowingPanelController controller = new BorrowingPanelController(
				model, this);
		controller.control();
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public JButton getReturnBookButton() {
		return btnPrzyjmijZwrot;
	}

	public JButton getBorrowBookButton() {
		return btnWypozycz;
	}

	public String getBookIdField() {
		return bookNumberTextField.getText();
	}

	public void setBookIdField(String text) {
		this.bookNumberTextField.setText(text);
	}

	public String getReaderIdTextField() {
		return readerNumberTextField.getText();
	}

	public void setReaderIdTextField(String text) {
		this.readerNumberTextField.setText(text);
	}

}
