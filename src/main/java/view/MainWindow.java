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

public class MainWindow {

	  public static void main(String[] args) {
		   
		   JFrame mainFrame = new JFrame("A JFrame");
		   mainFrame.setSize(701, 501);
		   mainFrame.setLocation(10,10);
		   mainFrame.getContentPane().add(BorderLayout.CENTER, BorderLayout.NORTH);
		   
		   JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		   mainFrame.getContentPane().add(tabbedPane, BorderLayout.SOUTH);
		   
		   JPanel bookSearchPanel = new JPanel();
		   tabbedPane.addTab("Wyszukaj książkę", null, bookSearchPanel, null);
		   
		   JPanel borrowingPanel = new JPanel();
		   tabbedPane.addTab("Wypożycz książkę", null, borrowingPanel, null);
		   
		   JPanel punishmentPanel = new JPanel();
		   tabbedPane.addTab("Rozlicz kary", null, punishmentPanel, null);
		   
		   JPanel bookCollectionPanel = new JPanel();
		   tabbedPane.addTab("Zarządzaj księgozbiorem", null, bookCollectionPanel, null);
		   mainFrame.setVisible(true);
		   
		   JPanel userAccountPanel = new JPanel();
		   tabbedPane.addTab("Konta użytkownika", null, userAccountPanel, null);
		   
		   JPanel topPanel = new JPanel();
		   mainFrame.getContentPane().add(topPanel, BorderLayout.NORTH);
		   
		   JTextPane textPane = new JTextPane();
		   topPanel.add(textPane);
		   
		   JButton loggingButton = new JButton("Zaloguj");
		   topPanel.add(loggingButton);
		   mainFrame.setVisible(true);
		   
		 }
}
