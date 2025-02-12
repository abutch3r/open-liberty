/*******************************************************************************
 * Copyright (c) 2019, 2021 IBM Corporation and others.
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

package com.ibm.ws.jpa.fvt.injection.ejb.dmi.inh;

import javax.persistence.EntityManager;

import com.ibm.ws.testtooling.vehicle.ejb.BMTEJBTestVehicle;

public abstract class DMIInhCommonEJBEXSuperclass extends BMTEJBTestVehicle {
    /*
     * JPA Resource Injection with No Override by Deployment Descriptor
     */

    // Container Managed Persistence Context

    protected EntityManager em_cmex_common_ejb;
    protected EntityManager em_cmex_ejb_ejb;
    protected EntityManager em_cmex_common_earlib;
    protected EntityManager em_cmex_jpalib_earlib;

    /*
     * JPA Resource Injection with Override by Deployment Descriptor
     *
     * Overridden injection points will refer to a OVRD_<pu name> which contains both the <appmodule>A and B entities.
     */

    // Container Managed Persistence Context

    protected EntityManager ovdem_cmex_common_ejb;
    protected EntityManager ovdem_cmex_ejb_ejb;
    protected EntityManager ovdem_cmex_common_earlib;
    protected EntityManager ovdem_cmex_jpalib_earlib;
}
