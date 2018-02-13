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
package com.github.woki.payments.adyen.support;

import com.github.woki.payments.adyen.action.Options;
import com.github.woki.payments.adyen.model.ModificationRequest;
import com.github.woki.payments.adyen.model.PaymentRequest;
import com.github.woki.payments.adyen.model.RecurringDisableRequest;
import com.github.woki.payments.adyen.model.RecurringListDetailsRequest;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public enum APService {
    AUTHORISATION("/pal/servlet/Payment/v30/authorise"),
    AUTHORISATION_3D("/pal/servlet/Payment/v30/authorise3d"),
    CAPTURE("/pal/servlet/Payment/v30/capture"),
    REFUND("/pal/servlet/Payment/v30/refund"),
    CANCEL("/pal/servlet/Payment/v30/cancel"),
    CANCEL_OR_REFUND("/pal/servlet/Payment/v30/cancelOrRefund"),
    RECURRING_DISABLE("/pal/servlet/Recurring/v30/disable"),
    RECURRING_LIST_DETAILS("/pal/servlet/Recurring/v30/listRecurringDetails")
    ;

    final String path;

    APService(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static <ReqType> APService from(final ReqType request, final Options opts) {
        if (request instanceof PaymentRequest) {
            if (opts != null && opts.has("threeds")) {
                return AUTHORISATION_3D;
            }
            return AUTHORISATION;
        }
        if (request instanceof ModificationRequest) {
            if ("capture".equals(opts.getValue("action"))) {
                return CAPTURE;
            }
            if ("refund".equals(opts.getValue("action"))) {
                return REFUND;
            }
            if ("cancel".equals(opts.getValue("action"))) {
                return CANCEL;
            }
            if ("cancelOrRefund".equals(opts.getValue("action"))) {
                return CANCEL_OR_REFUND;
            }
        }
        if (request instanceof RecurringDisableRequest) {
            return RECURRING_DISABLE;
        }
        if (request instanceof RecurringListDetailsRequest) {
            return RECURRING_LIST_DETAILS;
        }
        return null;
    }
}
