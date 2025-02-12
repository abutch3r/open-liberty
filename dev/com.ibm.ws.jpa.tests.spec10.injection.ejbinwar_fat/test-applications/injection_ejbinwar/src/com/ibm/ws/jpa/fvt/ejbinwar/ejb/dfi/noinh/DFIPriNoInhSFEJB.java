/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation and others.
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

package com.ibm.ws.jpa.fvt.ejbinwar.ejb.dfi.noinh;

import javax.ejb.Local;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;

import com.ibm.ws.testtooling.vehicle.ejb.BMTEJBTestVehicle;

@Stateful(name = "DFIPriNoInhSFEJB")
@Local(DFIPriNoInhSFEJBLocal.class)
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class DFIPriNoInhSFEJB extends BMTEJBTestVehicle {
    /*
     * JPA Resource Injection with No Override by Deployment Descriptor
     */

    // Container Managed Persistence Context

    // This EntityManager should refer to the COMMON_JTA in the Web App module
    @SuppressWarnings("unused")
    @PersistenceContext(unitName = "COMMON_JTA", type = PersistenceContextType.TRANSACTION)
    private EntityManager em_cmts_common_ejb;

    // This EntityManager should refer to the EJB_JTA in the Web App module
    @SuppressWarnings("unused")
    @PersistenceContext(unitName = "EJB_JTA", type = PersistenceContextType.TRANSACTION)
    private EntityManager em_cmts_ejb_ejb;

    // This EntityManager should refer to the COMMON_JTA in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceContext(unitName = "../lib/jpapulib.jar#COMMON_JTA", type = PersistenceContextType.TRANSACTION)
    private EntityManager em_cmts_common_earlib;

    // This EntityManager should refer to the JPALIB_JTA in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceContext(unitName = "JPALIB_JTA", type = PersistenceContextType.TRANSACTION)
    private EntityManager em_cmts_jpalib_earlib;

    // Application Managed Persistence Unit, JTA-Transaction

    // This EntityManager should refer to the COMMON_JTA in the Web App module
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "COMMON_JTA")
    private EntityManagerFactory emf_amjta_common_ejb;

    // This EntityManager should refer to the EJB_JTA in the Web App module
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "EJB_JTA")
    private EntityManagerFactory emf_amjta_ejb_ejb;

    // This EntityManager should refer to the COMMON_JTA in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "../lib/jpapulib.jar#COMMON_JTA")
    private EntityManagerFactory emf_amjta_common_earlib;

    // This EntityManager should refer to the JPALIB_JTA in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "JPALIB_JTA")
    private EntityManagerFactory emf_amjta_jpalib_earlib;

    // Application Managed Persistence Unit, RL-Transaction

    // This EntityManager should refer to the COMMON_RL in the Web App module
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "COMMON_RL")
    private EntityManagerFactory emf_amrl_common_ejb;

    // This EntityManager should refer to the EJB_RL in the Web App module
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "EJB_RL")
    private EntityManagerFactory emf_amrl_ejb_ejb;

    // This EntityManager should refer to the COMMON_RL in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "../lib/jpapulib.jar#COMMON_RL")
    private EntityManagerFactory emf_amrl_common_earlib;

    // This EntityManager should refer to the JPALIB_RL in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "JPALIB_RL")
    private EntityManagerFactory emf_amrl_jpalib_earlib;

    /*
     * JPA Resource Injection with Override by Deployment Descriptor
     *
     * Overridden injection points will refer to a OVRD_<pu name> which contains both the <appmodule>A and B entities.
     */

    // Container Managed Persistence Context

    // This EntityManager should refer to the COMMON_JTA in the Web App module
    @SuppressWarnings("unused")
    @PersistenceContext(unitName = "COMMON_JTA", type = PersistenceContextType.TRANSACTION,
                        name = "jpa/DFIPriNoInhTestEJB/ovdem_cmts_common_ejb")
    private EntityManager ovdem_cmts_common_ejb;

    // This EntityManager should refer to the EJB_JTA in the Web App module
    @SuppressWarnings("unused")
    @PersistenceContext(unitName = "EJB_JTA", type = PersistenceContextType.TRANSACTION,
                        name = "jpa/DFIPriNoInhTestEJB/ovdem_cmts_ejb_ejb")
    private EntityManager ovdem_cmts_ejb_ejb;

    // This EntityManager should refer to the COMMON_JTA in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceContext(unitName = "../lib/jpapulib.jar#COMMON_JTA", type = PersistenceContextType.TRANSACTION,
                        name = "jpa/DFIPriNoInhTestEJB/ovdem_cmts_common_earlib")
    private EntityManager ovdem_cmts_common_earlib;

    // This EntityManager should refer to the JPALIB_JTA in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceContext(unitName = "JPALIB_JTA", type = PersistenceContextType.TRANSACTION,
                        name = "jpa/DFIPriNoInhTestEJB/ovdem_cmts_jpalib_earlib")
    private EntityManager ovdem_cmts_jpalib_earlib;

    // Application Managed Persistence Unit, JTA-Transaction

    // This EntityManager should refer to the COMMON_JTA in the Web App module
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "COMMON_JTA", name = "jpa/DFIPriNoInhTestEJB/ovdemf_amjta_common_ejb")
    private EntityManagerFactory ovdemf_amjta_common_ejb;

    // This EntityManager should refer to the EJB_JTA in the Web App module
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "EJB_JTA", name = "jpa/DFIPriNoInhTestEJB/ovdemf_amjta_ejb_ejb")
    private EntityManagerFactory ovdemf_amjta_ejb_ejb;

    // This EntityManager should refer to the COMMON_JTA in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "../lib/jpapulib.jar#COMMON_JTA", name = "jpa/DFIPriNoInhTestEJB/ovdemf_amjta_common_earlib")
    private EntityManagerFactory ovdemf_amjta_common_earlib;

    // This EntityManager should refer to the JPALIB_JTA in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "JPALIB_JTA", name = "jpa/DFIPriNoInhTestEJB/ovdemf_amjta_jpalib_earlib")
    private EntityManagerFactory ovdemf_amjta_jpalib_earlib;

    // Application Managed Persistence Unit, RL-Transaction

    // This EntityManager should refer to the COMMON_RL in the Web App module
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "COMMON_RL", name = "jpa/DFIPriNoInhTestEJB/ovdemf_amrl_common_ejb")
    private EntityManagerFactory ovdemf_amrl_common_ejb;

    // This EntityManager should refer to the EJB_RL in the Web App module
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "EJB_RL", name = "jpa/DFIPriNoInhTestEJB/ovdemf_amrl_ejb_ejb")
    private EntityManagerFactory ovdemf_amrl_ejb_ejb;

    // This EntityManager should refer to the COMMON_RL in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "../lib/jpapulib.jar#COMMON_RL", name = "jpa/DFIPriNoInhTestEJB/ovdemf_amrl_common_earlib")
    private EntityManagerFactory ovdemf_amrl_common_earlib;

    // This EntityManager should refer to the JPALIB_RL in the jar in the Application's Library directory
    @SuppressWarnings("unused")
    @PersistenceUnit(unitName = "JPALIB_RL", name = "jpa/DFIPriNoInhTestEJB/ovdemf_amrl_jpalib_earlib")
    private EntityManagerFactory ovdemf_amrl_jpalib_earlib;

    @Override
    @Remove
    public void release() {

    }
}
