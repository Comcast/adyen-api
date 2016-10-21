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

import com.github.woki.payments.adyen.PublicApi;
import com.github.woki.payments.adyen.ToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
@PublicApi
public class Card implements Serializable {
    private int expiryMonth;
    private int expiryYear;
    private String holderName;
    private String number;
    private String cvc;
    private Date generationTime;

    @PublicApi
    public Card() {
    }

    @PublicApi
    public int getExpiryMonth() {
        return expiryMonth;
    }

    @PublicApi
    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    @PublicApi
    public int getExpiryYear() {
        return expiryYear;
    }

    @PublicApi
    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    @PublicApi
    public String getHolderName() {
        return holderName;
    }

    @PublicApi
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    @PublicApi
    public String getNumber() {
        return number;
    }

    @PublicApi
    public void setNumber(String number) {
        this.number = number;
    }

    @PublicApi
    public String getCvc() {
        return cvc;
    }

    @PublicApi
    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    @PublicApi
    public Date getGenerationTime() {
        return generationTime;
    }

    @PublicApi
    public void setGenerationTime(Date generationTime) {
        this.generationTime = generationTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("expiryMonth", expiryMonth).append("expiryYear", expiryYear).append("holderName", holderName)
                .append("cardNumber", number).append("cvc", cvc).toString();
    }
}
