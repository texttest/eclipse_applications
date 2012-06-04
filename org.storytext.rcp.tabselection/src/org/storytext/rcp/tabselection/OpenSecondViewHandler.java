package org.storytext.rcp.tabselection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

public class OpenSecondViewHandler extends AbstractHandler implements IHandler {
	private static int count;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow wWindow = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage wPage = wWindow.getActivePage();
		try {
			wPage.showView(SecondView.ID, String.valueOf(count++),
					IWorkbenchPage.VIEW_ACTIVATE);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}

}
