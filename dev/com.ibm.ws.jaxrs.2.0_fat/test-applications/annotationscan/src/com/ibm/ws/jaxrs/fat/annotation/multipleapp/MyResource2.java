/*******************************************************************************
 * Copyright (c) 2019 IBM Corporation and others.
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
package com.ibm.ws.jaxrs.fat.annotation.multipleapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/resource2")
public class MyResource2 {

    @GET
    public String get() {
        return "Hello world 2!";
    }

    @GET
    @Path("subresource")
    public String getSubresource() {
        return "Hello world 2 subresource!";
    }
}
