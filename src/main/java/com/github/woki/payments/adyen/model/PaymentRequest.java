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

import com.github.woki.payments.adyen.support.ToStringStyle;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class PaymentRequest implements Serializable {
    private Amount additionalAmount;
    private Map<String, String> additionalData = new HashMap<>();
    private Amount amount;
    private Address billingAddress;
    private BrowserInfo browserInfo;
    private Integer captureDelayHours;
    private Date dateOfBirth;
    private ForexQuote dccQuote;
    private Address deliveryAddress;
    private String deliveryDate;
    private String deviceFingerprint;
    private Long fraudOffset;
    private Installments installments;
    private Integer mcc;
    private String merchantAccount;
    private String merchantOrderReference;
    private Map<String, String> metadata = new HashMap<>();
    private String orderReference;
    private Recurring recurring;
    private String recurringProcessingModel;
    private String reference;
    private String selectedBrand;
    private String selectedRecurringDetailReference;
    private String sessionId;
    private String shopperEmail;
    private String shopperIP;
    private ShopperInteraction shopperInteraction;
    private String shopperLocale;
    private Name shopperName;
    private String shopperReference;
    private String shopperStatement;
    private String socialSecurityNumber;
    private String store;
    private String telephoneNumber;
    private String totalsGroup;
    private BankAccount bankAccount;
    private Card card;
    private String entityType;
    private ThreeDSecureData mpiData;
    private String nationality;
    private String md;
    private String paResponse;

    public void addAdditionalDataEntry(String key, String value) {
        if (StringUtils.isNotBlank(key)) {
            additionalData.put(key, value);
        }
    }

    // allowed values for the recurringProcessingModel field
    public enum ProcessingModel {
        SUBSCRIPTION( "Subscription"),
        CARDONFILE("CardOnFile");

        private final String modelName;

        ProcessingModel(String s) {
            modelName = s;
        }

        public String toString() {
            return this.modelName;
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("additionalAmount", additionalAmount)
                .append("additionalData", additionalData)
                .append("amount", amount)
                .append("bankAccount", bankAccount)
                .append("billingAddress", billingAddress)
                .append("browserInfo", browserInfo)
                .append("captureDelayHours", captureDelayHours)
                .append("card", card)
                .append("dateOfBirth", dateOfBirth)
                .append("dccQuote", dccQuote)
                .append("deliveryAddress", deliveryAddress)
                .append("deliveryDate", deliveryDate)
                .append("deviceFingerprint", deviceFingerprint)
                .append("fraudOffset", fraudOffset)
                .append("installments", installments)
                .append("mcc", mcc).append("md", md)
                .append("merchantAccount", merchantAccount)
                .append("merchantOrderReference", merchantOrderReference)
                .append("mpiData", mpiData)
                .append("orderReference", orderReference)
                .append("paResponse", paResponse)
                .append("recurring", recurring)
                .append("recurringProcessingModel", recurringProcessingModel)
                .append("reference", reference)
                .append("selectedBrand", selectedBrand)
                .append("selectedRecurringDetailReference", selectedRecurringDetailReference)
                .append("sessionId", sessionId)
                .append("shopperEmail", shopperEmail)
                .append("shopperIP", shopperIP)
                .append("shopperInteraction", shopperInteraction)
                .append("shopperLocale", shopperLocale)
                .append("shopperName", shopperName)
                .append("shopperReference", shopperReference)
                .append("shopperStatement", shopperStatement)
                .append("socialSecurityNumber", socialSecurityNumber)
                .append("telephoneNumber", telephoneNumber)
                .append("metadata", metadata)
                .append("store", store)
                .append("totalsGroup", totalsGroup)
                .append("entityType", entityType)
                .append("nationality", nationality).toString();
    }
}
