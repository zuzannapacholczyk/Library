package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog {

	public void showError(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, "Komunikat",
				JOptionPane.ERROR_MESSAGE);
	}
}
