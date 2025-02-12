/*******************************************************************************
 * Copyright (c) 2015 IBM Corporation and others.
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
package com.ibm.ws.jaxws.wsat.components;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

/**
 *
 */
public interface WSATInterceptorService {
    public AbstractPhaseInterceptor<Message> getCoorContextOutInterceptor();

    public AbstractPhaseInterceptor<SoapMessage> getCoorContextInInterceptor();

    public AbstractPhaseInterceptor<Message> getSSLServerInterceptor();
}
