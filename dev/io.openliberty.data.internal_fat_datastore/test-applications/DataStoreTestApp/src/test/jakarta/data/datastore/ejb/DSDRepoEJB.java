/*******************************************************************************
 * Copyright (c) 2024 IBM Corporation and others.
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
package test.jakarta.data.datastore.ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import jakarta.data.repository.By;
import jakarta.data.repository.Find;
import jakarta.data.repository.Repository;
import jakarta.data.repository.Save;

/**
 * A repository in an EJB module that uses a DataSourceDefinition that is defined
 * in a WAR module (same application) in the java:app namespace.
 */
@Repository(dataStore = "java:app/jdbc/DataSourceDef")
public interface DSDRepoEJB {

    @Find
    Optional<DSDEntityEJB> get(@By("id") int id);

    Connection getConnection();

    default String getUser() throws SQLException {
        return getConnection().getMetaData().getUserName().toLowerCase();
    }

    @Save
    void put(DSDEntityEJB e);
}