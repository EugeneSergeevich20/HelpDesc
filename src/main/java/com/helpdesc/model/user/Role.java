package com.helpdesc.model.user;

public enum Role {
    ROLE_CLIENT("Клиент"),
    ROLE_MASTER("Мастер"),
    ROLE_ADMIN("Админ");
    private final String displayValue;

    private Role(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return displayValue;
    }
}
