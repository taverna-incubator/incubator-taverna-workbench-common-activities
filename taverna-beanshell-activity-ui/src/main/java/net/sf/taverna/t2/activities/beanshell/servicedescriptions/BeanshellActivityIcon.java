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
package net.sf.taverna.t2.activities.beanshell.servicedescriptions;

import java.net.URI;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import net.sf.taverna.t2.workbench.activityicons.ActivityIconSPI;

/**
 *
 * @author Alex Nenadic
 * @author David Withers
 */
public class BeanshellActivityIcon implements ActivityIconSPI {

	private static Icon icon = null;

	@Override
	public int canProvideIconScore(URI activityType) {
		if (BeanshellTemplateService.ACTIVITY_TYPE.equals(activityType))
			return DEFAULT_ICON + 1;
		else
			return NO_ICON;
	}

	@Override
	public Icon getIcon(URI activityType) {
		return getBeanshellIcon();
	}

	public static Icon getBeanshellIcon() {
		if (icon == null) {
			icon = new ImageIcon(BeanshellActivityIcon.class.getResource("/beanshell.png"));
		}
		return icon;
	}
}
