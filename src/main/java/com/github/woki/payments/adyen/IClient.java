/*
 * Copyright 2015 Willian Oki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.github.woki.payments.adyen;

import com.github.woki.payments.adyen.error.APSAccessException;
import com.github.woki.payments.adyen.model.*;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public interface IClient {
    /**
     * @return the {@link ClientConfig}
     */
    ClientConfig getClientConfig();
    /**
     * @param request the request
     *
     * @return the response
     *
     * @throws APSAccessException on communication error
     */
    PaymentResponse authorise(final PaymentRequest request);
    /**
     * @param request the request
     *
     * @return the response
     *
     * @throws APSAccessException on communication error
     */
    PaymentResponse authorise3ds(final PaymentRequest request);
    /**
     * @param request the request
     *
     * @return the response
     *
     * @throws APSAccessException on communication error
     */
    PaymentResponse verifyBin(final PaymentRequest request);
    /**
     * @param request the request
     *
     * @return the response
     *
     * @throws APSAccessException on communication error
     */
    ModificationResponse capture(final ModificationRequest request);
    /**
     * @param request the request
     *
     * @return the response
     *
     * @throws APSAccessException on communication error
     */
    ModificationResponse cancel(final ModificationRequest request);
    /**
     * @param request the request
     *
     * @return the response
     *
     * @throws APSAccessException on communication error
     */
    ModificationResponse refund(final ModificationRequest request);
    /**
     * @param request the request
     *
     * @return the response
     *
     * @throws APSAccessException on communication error
     */
    ModificationResponse cancelOrRefund(final ModificationRequest request);
    /**
     * @param request the request
     *
     * @return the response
     *
     * @throws APSAccessException on communication error
     */
    RecurringDisableResponse recurringDisable(final RecurringDisableRequest request);
    /**
     * @param request the request
     *
     * @return the response
     *
     * @throws APSAccessException on communication error
     */
    RecurringListDetailsResponse recurringListDetails(final RecurringListDetailsRequest request);
}
