package com.okwallet.framework;

public enum ServiceStatus {

    STARTED("Started"),
    STARTING("Starting"),
    STOPED("Stoped"),
    STOPING("Stoping"),
    UNKNOWN("Unknown");

    private String desc;
    ServiceStatus(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
