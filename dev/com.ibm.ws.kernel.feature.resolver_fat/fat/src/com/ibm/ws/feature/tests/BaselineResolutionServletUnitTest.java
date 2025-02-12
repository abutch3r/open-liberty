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
package com.ibm.ws.feature.tests;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.ibm.ws.feature.tests.util.RepositoryUtil;
import com.ibm.ws.kernel.feature.internal.util.VerifyData;
import com.ibm.ws.kernel.feature.internal.util.VerifyData.VerifyCase;

/**
 * Baseline public singleton resolution.
 */
@RunWith(Parameterized.class)
public class BaselineResolutionServletUnitTest extends BaselineResolutionUnitTest {
    /** Control parameter: Used to disable this unit test. */
    public static final boolean IS_ENABLED = BaselineResolutionEnablement.enableServlet;

    // Not currently used:
    //
    // BeforeClass is invoked after data() is invoked.
    //
    // But 'data' requires the locations and repository,
    // which were being setup in 'setupClass'.
    //
    // The setup steps have been moved to 'data()', and
    // have been set run at most once.

    @BeforeClass
    public static void setupClass() throws Exception {
        // doSetupClass(getServerName());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        doTearDownClass(BaselineResolutionServletUnitTest.class);
    }

    public static final String DATA_FILE_PATH_OL = "publish/verify/servlet_expected.xml";
    public static final String DATA_FILE_PATH_WL = "publish/verify/servlet_expected_WL.xml";

    public static File getDataFile_OL() {
        return new File(DATA_FILE_PATH_OL);
    }

    public static File getDataFile_WL() {
        return new File(DATA_FILE_PATH_WL);
    }

    // To use change the name of parameterized tests, you say:
    //
    // @Parameters(name="namestring")
    //
    // namestring is a string, which can have the following special placeholders:
    //
    //   {index} - the index of this set of arguments. The default namestring is {index}.
    //   {0} - the first parameter value from this invocation of the test.
    //   {1} - the second parameter value
    //   and so on
    // @Parameterized.Parameters(name = "{0}")

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws Exception {
        doSetupClass(); // 'data()' is invoked before the '@BeforeClass' method.

        if (!IS_ENABLED) {
            return nullCases("servlet baseline");
        }

        VerifyData verifyData = readData(getDataFile_OL());

        // WAS liberty adds and modifies the Open liberty cases.
        if (RepositoryUtil.isWASLiberty()) {
            int initialCount = verifyData.getCases().size();
            VerifyData verifyData_WL = readData(getDataFile_WL());
            verifyData = verifyData.add(verifyData_WL);
            int finalCount = verifyData.getCases().size();
            System.out.println("Case adjustment [ " + (finalCount - initialCount) + " ]");
        }

        CaseSelector servletSelector = new CaseSelector() {
            @Override
            public boolean accept(VerifyCase aCase) {
                String feature0 = aCase.input.roots.get(0);
                String feature1 = aCase.input.roots.get(1);
                
                if (feature0.equals("servlet-3.0")) {
                    if (feature1.endsWith(".el") || feature1.endsWith(".expressionLanguage")) {
                        System.out.println("Skipping [ " + feature0 + " ] [ " + feature1 + " ]:" +
                                           " Expression language changes between OL and WL and versionless");
                        return false;
                    }
                }
                return true;
            }
        };

        return asCases(verifyData, servletSelector);
    }

    public BaselineResolutionServletUnitTest(String name, VerifyCase testCase) throws Exception {
        super(name, testCase);
    }

    @Before
    public void setupTest() throws Exception {
        doSetupResolver();
    }

    @After
    public void tearDownTest() throws Exception {
        doClearResolver();
    }

    @Override
    public List<String> detectFeatureErrors(List<String> rootFeatures) {
        return detectPairErrors(rootFeatures);
    }

    @Test
    public void baseline_servletTest() throws Exception {
        if (!IS_ENABLED) {
            nullResult();
            return;
        }
        doTestResolve();
    }
}
