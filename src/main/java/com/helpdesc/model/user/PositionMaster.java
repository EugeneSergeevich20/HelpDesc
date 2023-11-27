package com.helpdesc.model.user;

public enum PositionMaster {

    ENGINEER("Инженер");
    private final String displayValue;

    private PositionMaster(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return displayValue;
    }
}
