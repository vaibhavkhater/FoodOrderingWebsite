package com.dev.models;

public class Privilege {
    long privilegeId;
    String privilegeName;

    public long getPrivilageId() {
        return privilegeId;
    }

    public void setPrivilageId(long privilageId) {
        this.privilegeId = privilageId;
    }

    public String getPrivilageName() {
        return privilegeName;
    }

    public void setPrivilageName(String privilageName) {
        this.privilegeName = privilageName;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "privilegeId=" + privilegeId +
                ", privilegeName='" + privilegeName + '\'' +
                '}';
    }
}
