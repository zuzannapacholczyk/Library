package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DepartmentPanelView;
import model.DepartmentPanelModel;

public class DepartmentPanelController {

	private DepartmentPanelModel model;
	private DepartmentPanelView view;
	private ActionListener departmentRemoveListener;
	private ActionListener departmentAddListener;

	public DepartmentPanelController(DepartmentPanelModel model,
			DepartmentPanelView departmentPanelView) {
		this.model = model;
		this.view = departmentPanelView;
	}

	public void control() {
		departmentRemoveListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.removeDepartment();

			}

		};
		view.getRemoveButton().addActionListener(departmentRemoveListener);
		
		departmentAddListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				model.addDepartment();

			}

		};
		view.getAddButton().addActionListener(departmentAddListener);
		
	}

}
