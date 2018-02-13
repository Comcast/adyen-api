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
package com.github.woki.payments.adyen.simulator.web.controller;

import com.github.woki.payments.adyen.model.PaymentRequest;
import com.github.woki.payments.adyen.model.PaymentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@RestController
public class PaymentController {
    @RequestMapping(value = {"/pal/servlet/Payment/v30/authorise", "/pal/servlet/Payment/v30/authorise3d"}, method = RequestMethod.POST)
    public ResponseEntity<PaymentResponse> authorize(@RequestBody PaymentRequest request) {
        PaymentResponse res = new PaymentResponse();
        if ("gimme_500".equals(request.getReference())) {
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if ("gimme_400".equals(request.getReference())) {
            res.setStatus(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        if ("gimme_422".equals(request.getReference())) {
            res.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
            return new ResponseEntity<>(res, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if ("gimme_401".equals(request.getReference())) {
            res.setStatus(HttpStatus.UNAUTHORIZED.value());
            return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
        }
        if ("gimme_403".equals(request.getReference())) {
            res.setStatus(HttpStatus.FORBIDDEN.value());
            return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
        }
        if ("gimme_404".equals(request.getReference())) {
            res.setStatus(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        if ("gimme_200".equals(request.getReference())) {
            res.setStatus(HttpStatus.OK.value());
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        res.setStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
        return new ResponseEntity<>(res, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }
}
