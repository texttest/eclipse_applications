package org.storytext.rcp.jobs;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.storytext.rcp.jobs.commands.JobAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IWorkbenchAction exitAction;
	private JobAction jobsAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);
		jobsAction = new JobAction(window.getShell(), "Job1");
		//register(jobsAction);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenu = new MenuManager("&File",
				IWorkbenchActionConstants.M_FILE);
		MenuManager jobsMenu = new MenuManager("&Jobs", "jobsMenu");
		menuBar.add(fileMenu);
		menuBar.add(jobsMenu);
		fileMenu.add(exitAction);
		jobsMenu.add(jobsAction);

	}

}
