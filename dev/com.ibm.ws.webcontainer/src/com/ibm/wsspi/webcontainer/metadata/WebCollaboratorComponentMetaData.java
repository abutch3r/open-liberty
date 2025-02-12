/*******************************************************************************
 * Copyright (c) 1997, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.wsspi.webcontainer.metadata;

import com.ibm.ws.runtime.metadata.ComponentMetaData;

/**
 * 
 * 
 * 
 * A ComponentMetaData a object associated with a ModuleMetaDta object and
 * used when calling preInvoke on collaborators when a specific ComponentMetaData
 * object is inappropriate.
 * 
 * @ibm-private-in-use
 *
 */
 public interface WebCollaboratorComponentMetaData extends ComponentMetaData
 {
 }


