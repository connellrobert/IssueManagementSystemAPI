package dev.connellrobert.ims.model;

public enum UserRole {
    BASIC_USER(false),
    ADMIN(true),
    MAINTAINER(true),
    AUDITOR(false);

    private final boolean writePermissions;

    private UserRole(boolean canWrite){
        writePermissions = canWrite;
    }

    public boolean canWrite(){
        return writePermissions;
    }
}
