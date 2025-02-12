/*******************************************************************************
 * Copyright (c) 2022 IBM Corporation and others.
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
package com.ibm.ws.jpa.olgh16685.model;

import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CriteriaCarOLGH16685.class)
public class CriteriaCarOLGH16685_ {
    public static volatile SingularAttribute<CriteriaCarOLGH16685, String> id;
    public static volatile SingularAttribute<CriteriaCarOLGH16685, Integer> version;
    public static volatile MapAttribute<CriteriaCarOLGH16685, String, String> origin;
}
