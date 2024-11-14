package com.propiconnect.inmoshare.user.domain.model.enums;

public enum UserType {
    FREE(1), PRO(2), ENTERPRISE(3);

    private final int id;

    UserType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
