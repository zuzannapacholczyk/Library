package model;

import database.DepartmentOperations;
import view.DepartmentPanelView;
import view.ErrorDialog;

public class DepartmentPanelModel {

	private DepartmentPanelView view;

	public DepartmentPanelModel(DepartmentPanelView departmentPanelView) {
		this.view = departmentPanelView;
	}

	public void removeDepartment() {
		int id = Integer.parseInt(view.getIdTextField());
		DepartmentOperations departmentOperations = new DepartmentOperations();
		if (view.getIdTextField().length() == 0) {
			String name = view.getNameTextField();
			if (name.length() == 0) {
				ErrorDialog error = new ErrorDialog();
				error.showError("Podaj niezbedne informacje");
			} else {
				if (departmentOperations.deleteDepartmentByName(name,
						view.getRights())) {
					ErrorDialog error = new ErrorDialog();
					error.showSuccess("Dzial usuniety");
				} else {
					ErrorDialog error = new ErrorDialog();
					error.showError("Nie mozna usunac");
				}
			}
		}

		if (departmentOperations.deleteDepartmentById(id, view.getRights())) {
			ErrorDialog error = new ErrorDialog();
			error.showSuccess("Dzial usuniety");
		} else {
			ErrorDialog error = new ErrorDialog();
			error.showError("Nie mozna usunac");
		}
	}

	public void addDepartment() {
		DepartmentOperations departmentOperations = new DepartmentOperations();
		String name = view.getNameTextField();
		if (name.length() == 0) {
			ErrorDialog error = new ErrorDialog();
			error.showError("Podaj niezbedne informacje");
		} else {
			if (departmentOperations.addDepartment(name, view.getRights())) {
				ErrorDialog error = new ErrorDialog();
				error.showSuccess("Dzial dodany");
			} else {
				ErrorDialog error = new ErrorDialog();
				error.showError("Nie mozna dodac");
			}
		}
	}

}
