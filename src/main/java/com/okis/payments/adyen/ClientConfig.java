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
package com.okis.payments.adyen;

import static org.boon.Boon.toJson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
public class ClientConfig implements Serializable {
    private int connectionTimeout;
    private int socketTimeout;
    private Map<APService, String> services = new HashMap<>();
    private String username, password, proxyUser;

    public ClientConfig() {
        // noop ctor
    }

    /**
     * connectionTimeout (em milissegundos) refere-se ao parametro http.connection.timeout (httpclient). O valor 0 (default) siginifica que nao ha timeout (blocking).
     *
     * @return the connection timeout
     */
    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    /**
     * readTimeout (em milissegundos) refere-se ao parametro http.socket.timeout (httpcliet). O valor 0 (default) siginifica que nao ha timeout (blocking).
     *
     * @return the read timeout
     */
    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    /**
     * @return the services
     */
    public Map<APService, String> getServices() {
        return services;
    }

    /**
     * @param services the services to set
     */
    public void setServices(Map<APService, String> services) {
        this.services = services;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getProxyUser() {
        return proxyUser;
    }

    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    @Override
    public String toString() {
        return toJson(this);
    }
}
