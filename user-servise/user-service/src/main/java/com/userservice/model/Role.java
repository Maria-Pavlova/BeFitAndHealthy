package com.userservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;


public enum Role {
    USER, ADMIN, TRAINER, NUTRITIONIST;

    @JsonCreator
    public  static Role fromString(String value){
        return Role.valueOf(value.toUpperCase());
    }
}
