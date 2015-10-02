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
package com.github.woki.payments.adyen.model;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("unused")
public final class ThreeDSecureDataBuilder {
    private ThreeDSecureDataBuilder() {
        // builder
    }

    public static ICavv authenticationResponse(String response) {
        return new Builder(response);
    }

    public interface ICavv {
        IDirResponse cavv(String cavv, String algorithm);
    }

    public interface IDirResponse {
        IEci directoryResponse(String response);
    }

    public interface IEci {
        IXid eci(String eci);
    }

    public interface IXid {
        IBuilder xid(String xid);
    }

    public interface IBuilder {
        ThreeDSecureData build();
    }

    private static final class Builder implements IBuilder, ICavv, IDirResponse, IEci, IXid {
        private ThreeDSecureData data;

        Builder(String authenticationResponse) {
            data = new ThreeDSecureData();
            data.setAuthenticationResponse(authenticationResponse);
        }

        @Override
        public ThreeDSecureData build() {
            return data;
        }

        @Override
        public IDirResponse cavv(String cavv, String algorithm) {
            data.setCavv(cavv);
            data.setCavvAlgorithm(algorithm);
            return this;
        }

        @Override
        public IEci directoryResponse(String response) {
            data.setDirectoryResponse(response);
            return this;
        }

        @Override
        public IXid eci(String eci) {
            data.setEci(eci);
            return this;
        }

        @Override
        public IBuilder xid(String xid) {
            data.setXid(xid);
            return this;
        }
    }
}
