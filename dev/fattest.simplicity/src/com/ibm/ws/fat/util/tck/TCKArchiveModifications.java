/*******************************************************************************
 * Copyright (c) 2018, 2024 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.ibm.ws.fat.util.tck;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jboss.arquillian.container.test.spi.client.deployment.ApplicationArchiveProcessor;
import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveAppender;
import org.jboss.arquillian.core.spi.LoadableExtension.ExtensionBuilder;

public enum TCKArchiveModifications implements ArchiveModification {

    //With the exception of TEST_LOGGER these are uesd to work around bugs in upstream TCK.
    //Modifications to the TCK archives should only be made as a last resort.
    HAMCREST {
        @Override
        public void applyModification(ExtensionBuilder extensionBuilder) {
            LOG.log(Level.INFO, "WLP: Adding Extension com.ibm.ws.fat.util.tck.HamcrestArchiveProcessor");
            extensionBuilder.service(ApplicationArchiveProcessor.class, HamcrestArchiveProcessor.class);
        }
    },
    HAMCREST21 {
        @Override
        public void applyModification(ExtensionBuilder extensionBuilder) {
            LOG.log(Level.INFO, "WLP: Adding Extension com.ibm.ws.fat.util.tck.Hamcrest21ArchiveProcessor");
            extensionBuilder.service(ApplicationArchiveProcessor.class, Hamcrest21ArchiveProcessor.class);
        }
    },
    JETTY {
        @Override
        public void applyModification(ExtensionBuilder extensionBuilder) {
            LOG.log(Level.INFO, "WLP: Adding Extension com.ibm.ws.fat.util.tck.JettyArchivesProcessor");
            extensionBuilder.service(ApplicationArchiveProcessor.class, JettyArchivesProcessor.class);
        }
    },
    ORG_JSON {
        @Override
        public void applyModification(ExtensionBuilder extensionBuilder) {
            LOG.log(Level.INFO, "WLP: Adding Extension com.ibm.ws.fat.util.tck.OrgJsonArchiveProcessor");
            extensionBuilder.service(ApplicationArchiveProcessor.class, OrgJsonArchiveProcessor.class);
        }
    },
    TEST_LOGGER {
        @Override
        public void applyModification(ExtensionBuilder extensionBuilder) {
            LOG.log(Level.INFO, "WLP: Adding Extension com.ibm.ws.fat.util.tck.TestLoggingObserverArchiveProcessor");
            extensionBuilder.service(ApplicationArchiveProcessor.class, TestLoggingObserverArchiveProcessor.class);
        }
    },
    SLF4J {
        @Override
        public void applyModification(ExtensionBuilder extensionBuilder) {
            LOG.log(Level.INFO, "WLP: Adding Extension com.ibm.ws.fat.util.tck.Slf4JArchiveAppender");
            extensionBuilder.service(AuxiliaryArchiveAppender.class, Slf4JArchiveAppender.class);
        }
    },
    WIREMOCK {
        @Override
        public void applyModification(ExtensionBuilder extensionBuilder) {
            LOG.log(Level.INFO, "WLP: Adding Extension com.ibm.ws.fat.util.tck.WiremockArchiveProcessor");
            extensionBuilder.service(ApplicationArchiveProcessor.class, WiremockArchiveProcessor.class);
        }
    },
    TELEMETRY_PORTING {
        @Override
        public void applyModification(ExtensionBuilder extensionBuilder) {
            LOG.log(Level.INFO, "WLP: Adding Extension com.ibm.ws.fat.util.tck.TelemetryPortingArchiveProcessor");
            extensionBuilder.service(ApplicationArchiveProcessor.class, TelemetryPortingArchiveProcessor.class);
        }
    };

    private static final Logger LOG = Logger.getLogger(TCKArchiveModifications.class.getName());
}
