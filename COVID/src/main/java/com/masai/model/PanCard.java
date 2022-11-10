package com.masai.model;

public class PanCard {

    private String panNo;

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public PanCard(String panNo) {
        this.panNo = panNo;
    }

    public PanCard() {
    }

    @Override
    public String toString() {
        return "PanCard{" +
                "panNo='" + panNo + '\'' +
                '}';
    }
}
