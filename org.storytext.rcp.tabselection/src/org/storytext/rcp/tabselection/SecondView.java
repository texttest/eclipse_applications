package org.storytext.rcp.tabselection;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.part.ViewPart;

public class SecondView extends ViewPart {

	public static final String ID = "org.storytext.rcp.tabselection.view2";

	public void init(String name) {
		setPartName(name);	
	}

	@Override
	public void createPartControl(Composite parent) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText("The Second View Button");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Pressed in the second view!");
			}
		});
		

	}

	@Override
	public void setFocus() {

	}

}
