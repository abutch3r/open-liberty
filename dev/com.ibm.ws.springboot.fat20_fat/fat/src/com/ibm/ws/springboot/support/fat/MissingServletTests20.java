/*******************************************************************************
 * Copyright (c) 2018,2023 IBM Corporation and others.
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
package com.ibm.ws.springboot.support.fat;

import static componenttest.custom.junit.runner.Mode.TestMode.FULL;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;

import componenttest.custom.junit.runner.FATRunner;
import componenttest.custom.junit.runner.Mode;

@RunWith(FATRunner.class)
@Mode(FULL)
public class MissingServletTests20 extends AbstractSpringTests {
    @Override
    public boolean expectApplicationSuccess() {
        return false;
    }

    @Test
    public void testMissingServletFor20() throws Exception {
        assertNotNull("No error message CWWKC0279E was found for missing servlet feature ",
                      server.waitForStringInLog("CWWKC0254E"));
        stopServer(true, "CWWKC0254E", "CWWKZ0002E");
    }

    @Override
    public Set<String> getFeatures() {
        return new HashSet<>(Arrays.asList("springBoot-2.0"));
    }

    @Override
    public String getApplication() {
        return SPRING_BOOT_20_APP_BASE;
    }

}
