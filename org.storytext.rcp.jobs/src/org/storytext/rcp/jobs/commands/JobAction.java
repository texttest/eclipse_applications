package org.storytext.rcp.jobs.commands;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class JobAction extends Action implements IJobChangeListener {

	Shell parent;
	String[] tasks = { "first", "second", "third" };

	public JobAction(Shell parent, String label) {
		this.parent = parent;
		setText(label);
	}

	@Override
	public void run() {
		Job job = new Job("Job 1") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				int nrTasks = tasks.length;
				for (int i = 0; i < nrTasks; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					monitor.subTask("Executing the " + tasks[i] + " task");
					monitor.worked(30);
					monitor.setTaskName("Task " + String.valueOf(i + 1)
							+ " of " + nrTasks);
					System.out.println("Executing the " + tasks[i] + " task");
				}
				monitor.worked(40);

				return Status.OK_STATUS;
			}

		};
		job.addJobChangeListener(this);
		job.setUser(true);
		job.schedule();
		// return null;
	}

	@Override
	public void aboutToRun(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void awake(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void done(IJobChangeEvent event) {
		if (event.getResult().isOK()) {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					MessageDialog.openInformation(parent, "Info",
							"The job is done");

				}
			});
		} else {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					MessageDialog.openInformation(parent, "Info",
							"The job has failed");

				}
			});
		}

	}

	@Override
	public void running(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scheduled(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sleeping(IJobChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
