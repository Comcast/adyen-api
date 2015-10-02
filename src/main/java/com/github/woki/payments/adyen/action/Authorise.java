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
package com.github.woki.payments.adyen.action;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import com.github.woki.payments.adyen.APService;
import com.github.woki.payments.adyen.ClientConfig;
import com.github.woki.payments.adyen.error.APSAccessException;
import com.github.woki.payments.adyen.error.APSConfigurationException;
import com.github.woki.payments.adyen.model.PaymentRequest;
import com.github.woki.payments.adyen.model.PaymentResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public final class Authorise {
    private Authorise() {
        // utility
    }

    private static final Logger LOG = LoggerFactory.getLogger(Authorise.class);

    private static Request createRequest(ClientConfig config, PaymentRequest request, boolean secure) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("config: {}, request: {}, secure: {}", config, request, secure);
        }
        Request retval;
        String url;
        // create a Post
        try {
            url = secure ? config.getServices().get(APService.AUTHORISATION_3D) : config.getServices().get(APService.AUTHORISATION);
        } catch (Exception e) {
            LOG.error("authorisation: missing parameter: url");
            throw new APSConfigurationException("authorisation: missing parameter: url");
        }
        if (StringUtils.isNotBlank(url)) {
            retval = ActionUtil.createPost(url, config.getConnectionTimeout(), config.getSocketTimeout(), config.getProxyUser(), request);
        } else {
            LOG.error("authorisation: missing parameter: url");
            throw new APSConfigurationException("authorisation: missing parameter: url");
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("retval: {}", retval);
        }
        return retval;
    }

    public static PaymentResponse execute(@NotNull ClientConfig config, @NotNull PaymentRequest request, boolean secure) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("config: {}, request: {}, secure: {}", config, request, secure);
        }
        PaymentResponse retval;
        // create the request
        Request req = createRequest(config, request, secure);
        // create an Executor
        Executor exec = Executor.newInstance();
        // add auth
        exec.auth(config.getUsername(), config.getPassword());
        // execute and handle
        try {
            retval = exec.execute(req).handleResponse(new ResponseHandler<PaymentResponse>() {
                public PaymentResponse handleResponse(HttpResponse response) throws IOException {
                    PaymentResponse payres = ActionUtil.handlePaymentResponse(response);
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("payres: {}", payres);
                    }
                    return payres;
                }
            });
        } catch (Exception e) {
            LOG.error("authorisation", e);
            throw new APSAccessException("authorization", e);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("retval: {}", retval);
        }
        return retval;
    }
}
