package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.PunishmentPanelModel;
import controller.PunishmentPanelController;

public class PunishmentView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5381523845873691737L;
	private JTextField surnamePunishTextField;
	private JButton btnZnajdzKary;
	private JTable searchPunishmentResultTable;
	private JButton btnOplacWszystkie;
	private JTextField namePunishTextField;
	private JTextField readerNumberPunishTextField;
	private String rights = "r";
	private JButton btnClean;

	public PunishmentView(String string) {
		this.setRights(string);
		GridBagLayout gbl_punishmentPanel = new GridBagLayout();
		gbl_punishmentPanel.columnWidths = new int[] { 350, 350 };
		gbl_punishmentPanel.rowHeights = new int[] { 30, 30, 30, 30, 250, 30 };
		gbl_punishmentPanel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_punishmentPanel.rowWeights = new double[] { Double.MIN_VALUE };
		this.setLayout(gbl_punishmentPanel);

		JLabel lblNumer = new JLabel("Numer");
		GridBagConstraints gbc_lblNumer = new GridBagConstraints();
		gbc_lblNumer.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumer.gridx = 0;
		gbc_lblNumer.gridy = 0;
		this.add(lblNumer, gbc_lblNumer);

		readerNumberPunishTextField = new JTextField();
		GridBagConstraints gbc_readerNumberPunishTextField = new GridBagConstraints();
		gbc_readerNumberPunishTextField.insets = new Insets(0, 0, 5, 0);
		gbc_readerNumberPunishTextField.fill = GridBagConstraints.BOTH;
		gbc_readerNumberPunishTextField.gridx = 1;
		gbc_readerNumberPunishTextField.gridy = 0;
		this.add(readerNumberPunishTextField, gbc_readerNumberPunishTextField);
		readerNumberPunishTextField.setColumns(10);
		
		JLabel lblImie = new JLabel("Imie");
		GridBagConstraints gbc_lblImie = new GridBagConstraints();
		gbc_lblImie.insets = new Insets(0, 0, 5, 5);
		gbc_lblImie.gridx = 0;
		gbc_lblImie.gridy = 1;
		this.add(lblImie, gbc_lblImie);
		
		namePunishTextField = new JTextField();
		GridBagConstraints gbc_namePunishTextField = new GridBagConstraints();
		gbc_namePunishTextField.insets = new Insets(0, 0, 5, 0);
		gbc_namePunishTextField.fill = GridBagConstraints.BOTH;
		gbc_namePunishTextField.gridx = 1;
		gbc_namePunishTextField.gridy = 1;
		this.add(namePunishTextField, gbc_namePunishTextField);
		namePunishTextField.setColumns(10);

		JLabel lblNazwisko = new JLabel("Nazwisko");
		GridBagConstraints gbc_lblNazwisko = new GridBagConstraints();
		gbc_lblNazwisko.insets = new Insets(0, 0, 5, 5);
		gbc_lblNazwisko.gridx = 0;
		gbc_lblNazwisko.gridy = 2;
		this.add(lblNazwisko, gbc_lblNazwisko);
		
		surnamePunishTextField = new JTextField();
		GridBagConstraints gbc_surnamePunishTextField = new GridBagConstraints();
		gbc_surnamePunishTextField.insets = new Insets(0, 0, 5, 0);
		gbc_surnamePunishTextField.fill = GridBagConstraints.BOTH;
		gbc_surnamePunishTextField.gridx = 1;
		gbc_surnamePunishTextField.gridy = 2;
		this.add(surnamePunishTextField, gbc_surnamePunishTextField);
		surnamePunishTextField.setColumns(10);
		
		btnZnajdzKary = new JButton("Znajdz kary");
		GridBagConstraints gbc_btnZnajdzKary = new GridBagConstraints();
		gbc_btnZnajdzKary.insets = new Insets(0, 0, 5, 0);
		gbc_btnZnajdzKary.gridx = 1;
		gbc_btnZnajdzKary.gridy = 3;
		this.add(btnZnajdzKary, gbc_btnZnajdzKary);
		
		searchPunishmentResultTable = new JTable();
		JScrollPane scrollPane = new JScrollPane(searchPunishmentResultTable);
		GridBagConstraints gbc_tablePunishment = new GridBagConstraints();
		gbc_tablePunishment.gridwidth = 2;
		gbc_tablePunishment.insets = new Insets(0, 0, 0, 5);
		gbc_tablePunishment.fill = GridBagConstraints.BOTH;
		gbc_tablePunishment.gridx = 0;
		gbc_tablePunishment.gridy = 4;
		this.add(scrollPane, gbc_tablePunishment);
		
		btnOplacWszystkie = new JButton("Oplac wszystkie");
		GridBagConstraints gbc_btnOplacWszystkie = new GridBagConstraints();
		gbc_btnOplacWszystkie.gridx = 1;
		gbc_btnOplacWszystkie.gridy = 5;
		this.add(btnOplacWszystkie, gbc_btnOplacWszystkie);
		
		btnClean = new JButton("Wyczysc");
		GridBagConstraints gbc_btnClean = new GridBagConstraints();
		gbc_btnOplacWszystkie.gridx = 0;
		gbc_btnOplacWszystkie.gridy = 5;
		this.add(btnClean, gbc_btnClean);
		
		PunishmentPanelModel model = new PunishmentPanelModel(this);
		PunishmentPanelController controller = new PunishmentPanelController(model, this);
		controller.control();
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}
	
	public JButton getButtonPayForAll() {
		return btnOplacWszystkie;
	}
	
	public JTable getResultTable() {
		return searchPunishmentResultTable;
	}
	
	public String getSurnameTextField() {
		return surnamePunishTextField.getText();
	}
	
	public void setSurnameTextField(String text) {
		this.surnamePunishTextField.setText(text);
	}
	
	public String getNameTextField() {
		return namePunishTextField.getText();
	}
	
	public void setNameTextField(String text) {
		this.namePunishTextField.setText(text);
	}
	
	public String getIdTextField() {
		return readerNumberPunishTextField.getText();
	}
	
	public void setIdTextField(String text) {
		this.readerNumberPunishTextField.setText(text);
	}
	
	public JButton getButtonFindPunishment() {
		return btnZnajdzKary;
	}
	
	public JButton getButtonClean() {
		return btnClean;
	}

}
