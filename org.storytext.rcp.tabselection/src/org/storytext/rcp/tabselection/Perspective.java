package org.storytext.rcp.tabselection;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);

		IFolderLayout folder1 = layout.createFolder("First views",
				IPageLayout.TOP, 0.5f, editorArea);
		folder1.addPlaceholder(FirstView.ID + ":*");
		folder1.addView(FirstView.ID);
		IFolderLayout folder2 = layout.createFolder("Second views",
				IPageLayout.BOTTOM, 0.5f, editorArea);
		folder2.addPlaceholder(SecondView.ID + ":*");
		folder2.addView(SecondView.ID);
	}

}
