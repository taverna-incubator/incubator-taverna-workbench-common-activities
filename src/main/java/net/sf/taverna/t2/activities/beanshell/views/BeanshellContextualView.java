/*******************************************************************************
 * Copyright (C) 2007 The University of Manchester
 *
 *  Modifications to the initial code base are copyright of their
 *  respective authors, or their employers as appropriate.
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 ******************************************************************************/
package net.sf.taverna.t2.activities.beanshell.views;

import java.awt.Frame;

import javax.swing.Action;

import uk.org.taverna.scufl2.api.activity.Activity;

import net.sf.taverna.t2.activities.beanshell.BeanshellActivity;
import net.sf.taverna.t2.activities.beanshell.BeanshellActivityConfigurationBean;
import net.sf.taverna.t2.activities.beanshell.actions.BeanshellActivityConfigurationAction;
import net.sf.taverna.t2.workbench.activityicons.ActivityIconManager;
import net.sf.taverna.t2.workbench.configuration.colour.ColourManager;
import net.sf.taverna.t2.workbench.edits.EditManager;
import net.sf.taverna.t2.workbench.file.FileManager;
import net.sf.taverna.t2.workbench.ui.actions.activity.HTMLBasedActivityContextualView;

/**
 * A simple non editable HTML table view over a {@link BeanshellActivity}.
 * Clicking on the configure button shows the editable
 * {@link BeanshellConfigView}
 *
 * @author Ian Dunlop
 * @author Stuart Owen
 *
 */
@SuppressWarnings("serial")
public class BeanshellContextualView extends
		HTMLBasedActivityContextualView<BeanshellActivityConfigurationBean> {

	private EditManager editManager;
	private FileManager fileManager;
	private final ActivityIconManager activityIconManager;

	public BeanshellContextualView(Activity activity, EditManager editManager, FileManager fileManager,
			ActivityIconManager activityIconManager, ColourManager colourManager) {
		super(activity, colourManager);
		this.editManager = editManager;
		this.fileManager = fileManager;
		this.activityIconManager = activityIconManager;
		init();
	}

	private void init() {
	}

	@Override
	protected String getRawTableRowsHtml() {
		String html = "";
		html = html
		+ "<tr><th>Input Port Name</th>"
			+	"<th>Depth</th>"
		+"</tr>";
		for (ActivityInputPortDefinitionBean bean : getConfigBean()
				.getInputPortDefinitions()) {
			html = html + "<tr><td>" + bean.getName() + "</td><td>"
					+ bean.getDepth() + "</td></tr>";
		}
		html = html
				+ "<tr><th>Output Port Name</th>"
					+	"<th>Depth</th>"
				+"</tr>";
		for (ActivityOutputPortDefinitionBean bean : getConfigBean()
				.getOutputPortDefinitions()) {
			html = html + "<tr><td>" + bean.getName() + "</td><td>"
					+ bean.getDepth() + "</td>"
//							+ "<td>" + bean.getGranularDepth()
//					+ "</td>"
					+ "</tr>";
		}
		return html;
	}

	@Override
	public String getViewTitle() {
		return "Beanshell service";
	}

	@Override
	public Action getConfigureAction(Frame owner) {
		return new BeanshellActivityConfigurationAction(
				getActivity(), owner, editManager, fileManager, activityIconManager);
	}

	@Override
	public int getPreferredPosition() {
		return 100;
	}

}
