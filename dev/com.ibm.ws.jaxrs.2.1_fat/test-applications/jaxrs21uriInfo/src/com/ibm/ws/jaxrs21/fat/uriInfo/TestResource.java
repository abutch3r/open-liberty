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
package com.ibm.ws.jaxrs21.fat.uriInfo;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("test")
public class TestResource {

    @Context
    HttpServletRequest request;

    @Context
    UriInfo uriInfo;

    @Inject
    TestClient testClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        String content = "uriInfo.baseUri: " + uriInfo.getBaseUriBuilder().build() + ", ";

        if (testClient == null) {
            // workaround for missing CDI integration
            testClient = new TestClient();
            testClient.initClient();
            content += testClient.invokeRequest();
            testClient.closeClient();
        } else {
            // normal path
            content += testClient.invokeRequest();
        }

        return content + ", uriInfo.baseUri 2nd time: " + uriInfo.getBaseUriBuilder().build();
    }

    @GET
    @Path("client")
    public String clientRequest() {
        return "";
    }
}
