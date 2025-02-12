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
package io.openliberty.data.internal.persistence.metadata;

import com.ibm.websphere.csi.J2EEName;
import com.ibm.websphere.ras.annotation.Trivial;
import com.ibm.ws.runtime.metadata.ApplicationMetaData;
import com.ibm.ws.runtime.metadata.ComponentMetaData;
import com.ibm.ws.runtime.metadata.MetaDataImpl;
import com.ibm.ws.runtime.metadata.ModuleMetaData;

/**
 * Dummy ModuleMetaData for a module or application.
 * This metadata is used to allow the creation of a ComponentMetaData
 * for an application artifact, such as when the repository is defined
 * in a library of the application rather than a web or ejb component.
 */
@Trivial
public class DataModuleMetaData extends MetaDataImpl implements ModuleMetaData {
    private final ApplicationMetaData appMetadata;
    private final J2EEName jeeName;

    public DataModuleMetaData(J2EEName jeeName, ApplicationMetaData appMetadata) {
        super(0);

        this.appMetadata = appMetadata;
        this.jeeName = jeeName;
    }

    @Override
    public ApplicationMetaData getApplicationMetaData() {
        return appMetadata;
    }

    @Override
    public ComponentMetaData[] getComponentMetaDatas() {
        return null;
    }

    @Override
    @Trivial
    public J2EEName getJ2EEName() {
        return jeeName;
    }

    @Override
    public String getName() {
        return jeeName.toString();
    }
}