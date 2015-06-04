package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3172688540921699213L;
	private static JFrame mainFrame;
	private static JLabel welcomeTextLabel;
	private static JButton loggingButton;
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public MainWindow() {

		mainFrame = new JFrame("Biblioteka");
		mainFrame.setSize(701, 501);
		mainFrame.setLocation(10, 10);
		//mainFrame.getContentPane().add(BorderLayout.CENTER);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel bookSearchPanel = new BookSearchPanelView();
		tabbedPane.addTab("Wyszukaj ksiazke", null, bookSearchPanel, null);
		
		JPanel borrowingPanel = new JPanel();
		tabbedPane.addTab("Wypozycz ksiazke", null, borrowingPanel, null);
		

		JPanel punishmentPanel = new JPanel();
		tabbedPane.addTab("Rozlicz kary", null, punishmentPanel, null);
		

		JPanel authorsPanel = new JPanel();
		tabbedPane.addTab("Autorzy", null, authorsPanel,
				null);	
		
		JPanel booksPanel = new JPanel();
		tabbedPane.addTab("Ksiegozbior", null, booksPanel,
				null);	
		
		
		JPanel departmentPanel = new JPanel();
		tabbedPane.addTab("Dzialy", null, departmentPanel,
				null);	
		

		JPanel userAccountPanel = new JPanel();
		tabbedPane.addTab("Konta uzytkownikow", null, userAccountPanel, null);

		JPanel topPanel = new JPanel();
		mainFrame.getContentPane().add(topPanel, BorderLayout.NORTH);

		welcomeTextLabel = new JLabel("Welcome");
		topPanel.add(welcomeTextLabel);
		loggingButton = new JButton("Zaloguj");
		topPanel.add(loggingButton);
		mainFrame.setVisible(true);

	}
}
