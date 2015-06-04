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

public class BookSearchPanelView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField searchTextField2;
	private JList list;
	private JButton searchButton;
	private JTable searchBookResultTable;

	public BookSearchPanelView() {
		GridBagLayout gbl_bookSearchPanel = new GridBagLayout();
		gbl_bookSearchPanel.columnWidths = new int[] { 240, 440 };
		gbl_bookSearchPanel.rowHeights = new int[] { 20, 30, 30, 30, 300 };
		gbl_bookSearchPanel.columnWeights = new double[] {Double.MIN_VALUE };
		gbl_bookSearchPanel.rowWeights = new double[] { Double.MIN_VALUE };
		this.setLayout(gbl_bookSearchPanel);

		JLabel lblNewLabel = new JLabel("Wpisz slowo lub fraze");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		this.add(lblNewLabel, gbc_lblNewLabel);

		searchTextField2 = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		this.add(searchTextField2, gbc_textField);
		searchTextField2.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Pole do wyszukiwania");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);

		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		this.add(list, gbc_list);

		searchButton = new JButton("Szukaj");
		GridBagConstraints gbc_btnWypozycz = new GridBagConstraints();
		gbc_btnWypozycz.insets = new Insets(0, 0, 5, 5);
		gbc_btnWypozycz.gridx = 0;
		gbc_btnWypozycz.gridy = 3;
		this.add(searchButton, gbc_btnWypozycz);

		searchBookResultTable = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 4;
		this.add(searchBookResultTable, gbc_table);

	}

}
