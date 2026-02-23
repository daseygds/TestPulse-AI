package org.testngmetadatalibs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionModel {
    @JsonProperty("session_id")
    private String session_id;

    @JsonProperty("session_name")
    private String session_name;

    public SessionModel(String session_id, String session_name) {
        this.session_id = session_id;
        this.session_name = session_name;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }
}
