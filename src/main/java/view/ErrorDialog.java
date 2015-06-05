package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog {

	public void showError(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, "Blad",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void showSuccess(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, "Blad",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
