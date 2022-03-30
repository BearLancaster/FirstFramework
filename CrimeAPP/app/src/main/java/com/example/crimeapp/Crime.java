package com.example.crimeapp;

import java.util.UUID;

public class Crime {
    private UUID mid;
    private String mtitle;
    public Crime(){
        mid=UUID.randomUUID();
    }

    public UUID getMid() {
        return mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }
}
