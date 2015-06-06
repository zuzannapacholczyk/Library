package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3172688540921699213L;
	private JLabel welcomeTextLabel;
	private JButton loggingButton;
	private JTabbedPane tabbedPane;

	public MainWindow(String rights) {

		this.setTitle("Biblioteka");
		this.setSize(801, 501);
		this.setLocation(10, 10);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		if (rights.equals("a"))
			createTabsForAdmin();
		else if (rights.equals("l"))
			createTabsForLibrarian();
		else createTabsForReader();

		JPanel topPanel = new JPanel();
		this.getContentPane().add(topPanel, BorderLayout.NORTH);

		welcomeTextLabel = new JLabel("Welcome");
		topPanel.add(welcomeTextLabel);
		loggingButton = new JButton("Wyloguj");
		topPanel.add(loggingButton);
		this.setVisible(true);
	}

	private void createTabsForReader() {
		BookSearchPanelView bookSearchPanel = new BookSearchPanelView("r");
		tabbedPane.addTab("Wyszukaj ksiazke", null, bookSearchPanel, null);

	}

	private void createTabsForAdmin() {
		BookSearchPanelView bookSearchPanel = new BookSearchPanelView("a");
		tabbedPane.addTab("Wyszukaj ksiazke", null, bookSearchPanel, null);

		BorrowingPanelView borrowingPanel = new BorrowingPanelView("a");
		tabbedPane.addTab("Wypozycz ksiazke", null, borrowingPanel, null);

		PunishmentView punishmentPanel = new PunishmentView("a");
		tabbedPane.addTab("Rozlicz kary", null, punishmentPanel, null);

		AuthorsPanelView authorsPanel = new AuthorsPanelView("a");
		tabbedPane.addTab("Autorzy", null, authorsPanel, null);

		BooksPanelView booksPanel = new BooksPanelView("a");
		tabbedPane.addTab("Ksiegozbior", null, booksPanel, null);

		DepartmentPanelView departmentPanel = new DepartmentPanelView("a");
		tabbedPane.addTab("Dzialy", null, departmentPanel, null);

		UserAccountView userAccountPanel = new UserAccountView("a");
		tabbedPane.addTab("Konta uzytkownikow", null, userAccountPanel, null);

	}

	private void createTabsForLibrarian() {
		BookSearchPanelView bookSearchPanel = new BookSearchPanelView("l");
		tabbedPane.addTab("Wyszukaj ksiazke", null, bookSearchPanel, null);

		BorrowingPanelView borrowingPanel = new BorrowingPanelView("l");
		tabbedPane.addTab("Wypozycz ksiazke", null, borrowingPanel, null);

		PunishmentView punishmentPanel = new PunishmentView("l");
		tabbedPane.addTab("Rozlicz kary", null, punishmentPanel, null);

		AuthorsPanelView authorsPanel = new AuthorsPanelView("l");
		tabbedPane.addTab("Autorzy", null, authorsPanel, null);

		BooksPanelView booksPanel = new BooksPanelView("l");
		tabbedPane.addTab("Ksiegozbior", null, booksPanel, null);

		DepartmentPanelView departmentPanel = new DepartmentPanelView("l");
		tabbedPane.addTab("Dzialy", null, departmentPanel, null);

	}

	public JTabbedPane getTabbedPane() {
		return this.tabbedPane;
	}

	public void setWelcomeTextLabel(String text) {
		this.welcomeTextLabel.setText("Witaj " + text);
	}

	public JButton getLoggingButton() {
		return this.loggingButton;
	}
}
