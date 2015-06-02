package view;

import java.awt.BorderLayout;
import java.awt.Composite;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class MainWindow {
	private static JTextField textField;
	private static JTable searchBookResultTable;

	  /**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   
		   JFrame mainFrame = new JFrame("A JFrame");
		   mainFrame.setSize(701, 501);
		   mainFrame.setLocation(10,10);
		   mainFrame.getContentPane().add(BorderLayout.CENTER, BorderLayout.NORTH);
		   
		   JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		   mainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		   
		   JPanel bookSearchPanel = new JPanel();
		   tabbedPane.addTab("Wyszukaj ksiazke", null, bookSearchPanel, null);
		   GridBagLayout gbl_bookSearchPanel = new GridBagLayout();
		   gbl_bookSearchPanel.columnWidths = new int[]{240, 440, 0};
		   gbl_bookSearchPanel.rowHeights = new int[]{40, 50, 50, 50, 250};
		   gbl_bookSearchPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		   gbl_bookSearchPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		   bookSearchPanel.setLayout(gbl_bookSearchPanel);
		   
		   JLabel lblNewLabel = new JLabel("Wpisz slowo lub fraze");
		   GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		   gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		   gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		   gbc_lblNewLabel.gridx = 0;
		   gbc_lblNewLabel.gridy = 1;
		   bookSearchPanel.add(lblNewLabel, gbc_lblNewLabel);
		   
		   JTextField textField = new JTextField();
		   GridBagConstraints gbc_textField = new GridBagConstraints();
		   gbc_textField.insets = new Insets(0, 0, 5, 0);
		   gbc_textField.fill = GridBagConstraints.BOTH;
		   gbc_textField.gridx = 1;
		   gbc_textField.gridy = 1;
		   bookSearchPanel.add(textField, gbc_textField);
		   textField.setColumns(10);
		   
		   JLabel lblNewLabel_1 = new JLabel("Pole do wyszukiwania");
		   GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		   gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		   gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		   gbc_lblNewLabel_1.gridx = 0;
		   gbc_lblNewLabel_1.gridy = 2;
		   bookSearchPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		   
		   @SuppressWarnings("rawtypes")
		JList list = new JList();
		   GridBagConstraints gbc_list = new GridBagConstraints();
		   gbc_list.insets = new Insets(0, 0, 5, 0);
		   gbc_list.fill = GridBagConstraints.BOTH;
		   gbc_list.gridx = 1;
		   gbc_list.gridy = 2;
		   bookSearchPanel.add(list, gbc_list);
		   
		   JButton searchButton = new JButton("Szukaj");
		   GridBagConstraints gbc_button = new GridBagConstraints();
		   gbc_button.insets = new Insets(0, 0, 5, 5);
		   gbc_button.gridx = 0;
		   gbc_button.gridy = 3;
		   bookSearchPanel.add(searchButton, gbc_button);
		   
		   searchBookResultTable = new JTable();
		   GridBagConstraints gbc_table = new GridBagConstraints();
		   gbc_table.gridwidth = 2;
		   gbc_table.insets = new Insets(0, 0, 0, 5);
		   gbc_table.fill = GridBagConstraints.BOTH;
		   gbc_table.gridx = 0;
		   gbc_table.gridy = 4;
		   bookSearchPanel.add(searchBookResultTable, gbc_table);

		   JPanel borrowingPanel = new JPanel();
		   tabbedPane.addTab("Wypozycz ksiazke", null, borrowingPanel, null);
		   GridBagLayout gbl_borrowingPanel = new GridBagLayout();
		   gbl_borrowingPanel.columnWidths = new int[]{150, 200, 150, 200};
		   gbl_borrowingPanel.rowHeights = new int[]{70, 50, 50, 50, 250};
		   gbl_borrowingPanel.columnWeights = new double[]{Double.MIN_VALUE};
		   gbl_borrowingPanel.rowWeights = new double[]{Double.MIN_VALUE};
		   borrowingPanel.setLayout(gbl_borrowingPanel);
		   
		   JLabel lblNewLabel_2 = new JLabel("New label");
		   GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		   gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		   gbc_lblNewLabel_2.gridx = 0;
		   gbc_lblNewLabel_2.gridy = 1;
		   borrowingPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		   
		   JLabel lblNewLabel_5 = new JLabel("New label");
		   GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		   gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		   gbc_lblNewLabel_5.gridx = 2;
		   gbc_lblNewLabel_5.gridy = 1;
		   borrowingPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		   
		   JLabel lblNewLabel_3 = new JLabel("New label");
		   GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		   gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		   gbc_lblNewLabel_3.gridx = 0;
		   gbc_lblNewLabel_3.gridy = 2;
		   borrowingPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		   
		   JLabel lblNewLabel_6 = new JLabel("New label");
		   GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		   gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		   gbc_lblNewLabel_6.gridx = 2;
		   gbc_lblNewLabel_6.gridy = 2;
		   borrowingPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		   
		   JLabel lblNewLabel_4 = new JLabel("New label");
		   GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		   gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		   gbc_lblNewLabel_4.gridx = 0;
		   gbc_lblNewLabel_4.gridy = 3;
		   borrowingPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		   
		   JLabel lblNewLabel_7 = new JLabel("New label");
		   GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		   gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		   gbc_lblNewLabel_7.gridx = 2;
		   gbc_lblNewLabel_7.gridy = 3;
		   borrowingPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		   
		   JPanel punishmentPanel = new JPanel();
		   tabbedPane.addTab("Rozlicz kary", null, punishmentPanel, null);
		   
		   JPanel bookCollectionPanel = new JPanel();
		   tabbedPane.addTab("Zarzadzaj ksiegozbiorem", null, bookCollectionPanel, null);
		   mainFrame.setVisible(true);
		   
		   JPanel userAccountPanel = new JPanel();
		   tabbedPane.addTab("Konta uzytkownika", null, userAccountPanel, null);
		   
		   JPanel topPanel = new JPanel();
		   mainFrame.getContentPane().add(topPanel, BorderLayout.NORTH);
		   
		   JLabel welcomeTextLabel = new JLabel("Welcome");
		   topPanel.add(welcomeTextLabel);
		   JButton loggingButton = new JButton("Zaloguj");
		   topPanel.add(loggingButton);
		   mainFrame.setVisible(true);
		   
		 }
}
