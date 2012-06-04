package org.storytext.rcp.uiforms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	public static final String ID = "org.storytext.rcp.uiforms.view";

	public void createPartControl(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		final ScrolledForm form = toolkit.createScrolledForm(parent);
		TableWrapLayout layout = new TableWrapLayout();
		form.getBody().setLayout(layout);

		Section section = new Section(form.getBody(), Section.TWISTIE | ExpandableComposite.CLIENT_INDENT);
		section.setText("ExpandableComposite - TWISTIE style");
		Label label = toolkit.createLabel(section, "Content", SWT.WRAP);
		section.setClient(label);
		TableWrapData td = new TableWrapData();
		td.colspan = 1;
		section.setLayoutData(td);

		ExpandableComposite composite = toolkit.createExpandableComposite(
				form.getBody(), ExpandableComposite.TREE_NODE
						| ExpandableComposite.CLIENT_INDENT);
		composite.setText("ExpandableComposite - TREE_NODE style");
		String text = "Content, Content,";
		Label label2 = toolkit.createLabel(composite, text, SWT.WRAP);
		composite.setClient(label2);
		td = new TableWrapData();
		td.colspan = 1;
		composite.setLayoutData(td);
		composite.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}