/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.saml.profile.query.processor;

import org.opensaml.saml1.core.AuthorizationDecisionQuery;
import org.opensaml.saml2.core.AssertionIDRequest;
import org.opensaml.saml2.core.RequestAbstractType;
import org.opensaml.saml2.core.impl.AttributeQueryImpl;
import org.opensaml.saml2.core.impl.AuthnQueryImpl;
import org.opensaml.saml2.core.impl.SubjectQueryImpl;


public class SAMLProcessorFactory {
    /**
     * factory method to select relevant processor
     *
     * @param request
     * @return SAMLQueryProcessor
     */
    public static SAMLQueryProcessor getProcessor(RequestAbstractType request) {

        SAMLQueryProcessor samlQueryProcessor = null;

        if (request instanceof AssertionIDRequest) {

            samlQueryProcessor = new SAMLIDRequestProcessor();

        } else if (request instanceof SubjectQueryImpl) {

            samlQueryProcessor = new SAMLSubjectQueryProcessor();


        } else if (request instanceof AttributeQueryImpl) {

            samlQueryProcessor = new SAMLAttributeQueryProcessor();


        } else if (request instanceof AuthnQueryImpl) {

            samlQueryProcessor = new SAMLAuthnQueryProcessor();


        } else if (request instanceof AuthorizationDecisionQuery) {
        /* deprecated after SAML 2.0 */
            samlQueryProcessor = new SAMLAuthzDecisionProcessor();

        }

        return samlQueryProcessor;

    }


}
