package com.github.woki.payments.adyen.model;

import static io.advantageous.boon.json.JsonFactory.toJson;

import java.io.Serializable;

@SuppressWarnings("serial, unused")
public class Recurring implements Serializable {
    private ContractType contract;
    private String recurringDetailName;

    public Recurring() {
        // noop ctor
    }

    public Recurring(ContractType contract, String recurringDetailName) {
        this.contract = contract;
        this.recurringDetailName = recurringDetailName;
    }

    public ContractType getContract() {
        return contract;
    }

    public void setContract(ContractType contract) {
        this.contract = contract;
    }

    public String getRecurringDetailName() {
        return recurringDetailName;
    }

    public void setRecurringDetailName(String recurringDetailName) {
        this.recurringDetailName = recurringDetailName;
    }

    @Override
    public String toString() {
        return toJson(this);
    }
}
