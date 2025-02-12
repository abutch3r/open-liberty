/*******************************************************************************
 * Copyright (c) 2014, 2020 IBM Corporation and others.
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
package com.ibm.ws.jaxrs20.client.ComplexClientTest.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.ibm.ws.jaxrs20.client.ComplexClientTest.client.MyReader;
import com.ibm.ws.jaxrs20.client.ComplexClientTest.client.MyWriter;

/**
 *
 */
public class TestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> list = new HashSet<Class<?>>();
        list.add(ComplexResource.class);
        list.add(MyResource.class);
        list.add(MyReader.class);
        list.add(MyWriter.class);
        list.add(NotProtected.class);
        return list;
    }

}
