package org.storytext.rcp.gef.basic;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.part.FileInPlaceEditorInput;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(400, 300));
		configurer.setShowCoolBar(false);
		configurer.setShowStatusLine(false);
		configurer.setTitle("RCP GEF Draw2d Application");
	}
	
	@Override
	public void postWindowCreate() {
		try {
			/**
			 * Open a digraph editor on a file. The file does not exist, but
			 * since our editor does not read or write any data we are ok.
			 */
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path("/project/file.graph1")); //$NON-NLS-1$
			getWindowConfigurer().getWindow().getActivePage().openEditor(
					new FileInPlaceEditorInput(file),
					"org.storytext.rcp.gef.basic.graph1"); //$NON-NLS-1$
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		super.postWindowCreate();
	}

}
