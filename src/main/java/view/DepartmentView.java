package view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DepartmentView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1600378463027083846L;
	private JTextField nameDepartmentTextField;
	private Component btnDodaj_3;
	private JButton btnUsun_3;
	private JTextField numberDepartmentTextField;
	private String rights = "r";

	public DepartmentView(String string) {
		this.setRights(string);
		GridBagLayout gbl_departmentPanel = new GridBagLayout();
		gbl_departmentPanel.columnWidths = new int[]{300,300,50,50};
		gbl_departmentPanel.rowHeights = new int[]{30,30,30,300};
		gbl_departmentPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_departmentPanel.rowWeights = new double[]{Double.MIN_VALUE};
		this.setLayout(gbl_departmentPanel);
		
		JLabel lblNumer_2 = new JLabel("Numer");
		GridBagConstraints gbc_lblNumer_2 = new GridBagConstraints();
		gbc_lblNumer_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumer_2.gridx = 0;
		gbc_lblNumer_2.gridy = 0;
		this.add(lblNumer_2, gbc_lblNumer_2);
		
		numberDepartmentTextField = new JTextField();
		GridBagConstraints gbc_numberDepartmentTextField = new GridBagConstraints();
		gbc_numberDepartmentTextField.gridwidth = 4;
		gbc_numberDepartmentTextField.insets = new Insets(0, 0, 5, 0);
		gbc_numberDepartmentTextField.fill = GridBagConstraints.BOTH;
		gbc_numberDepartmentTextField.gridx = 1;
		gbc_numberDepartmentTextField.gridy = 0;
		this.add(numberDepartmentTextField, gbc_numberDepartmentTextField);
		numberDepartmentTextField.setColumns(10);
		
		JLabel lblNazwa = new JLabel("Nazwa");
		GridBagConstraints gbc_lblNazwa = new GridBagConstraints();
		gbc_lblNazwa.insets = new Insets(0, 0, 5, 5);
		gbc_lblNazwa.gridx = 0;
		gbc_lblNazwa.gridy = 1;
		this.add(lblNazwa, gbc_lblNazwa);
		
		nameDepartmentTextField = new JTextField();
		GridBagConstraints gbc_nameDepartmentTextField = new GridBagConstraints();
		gbc_nameDepartmentTextField.gridwidth = 4;
		gbc_nameDepartmentTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameDepartmentTextField.fill = GridBagConstraints.BOTH;
		gbc_nameDepartmentTextField.gridx = 1;
		gbc_nameDepartmentTextField.gridy = 1;
		this.add(nameDepartmentTextField, gbc_nameDepartmentTextField);
		nameDepartmentTextField.setColumns(10);
		
		btnDodaj_3 = new JButton("Dodaj");
		GridBagConstraints gbc_btnDodaj_3 = new GridBagConstraints();
		gbc_btnDodaj_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj_3.gridx = 2;
		gbc_btnDodaj_3.gridy = 2;
		this.add(btnDodaj_3, gbc_btnDodaj_3);
		
		btnUsun_3 = new JButton("Usun");
		GridBagConstraints gbc_btnUsun_3 = new GridBagConstraints();
		gbc_btnUsun_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnUsun_3.gridx = 3;
		gbc_btnUsun_3.gridy = 2;
		this.add(btnUsun_3, gbc_btnUsun_3);
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

}
