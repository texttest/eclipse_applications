package org.storytext.rcp.tabselection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class ShowInView2Handler extends AbstractHandler implements IHandler {
	private static int count = 1;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart wPart = HandlerUtil.getActivePart(event);
		SecondView view = (SecondView) wPart;
		view.init("Showing " + String.valueOf(count++));
		return null;
	}

}
