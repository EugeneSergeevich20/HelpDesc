package com.helpdesc.model;

public enum Status {

    STATUS_NEW("Новая"),
    STATUS_PROCESS("В процессе"),
    STATUS_COMPLETED("Выполнено");

    private final String displayValue;

    private Status(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return displayValue;
    }

}
