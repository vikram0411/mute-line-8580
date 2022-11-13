package com.masai.model;

public class AdharCard {

    private String adharNo;
    private String fingerprints;
    private String irisScan;
    
    public String getAdharNo() {
        return adharNo;
    }

    public void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }

    public String getFingerprints() {
        return fingerprints;
    }

    public void setFingerprints(String fingerprints) {
        this.fingerprints = fingerprints;
    }

    public String getIrisScan() {
        return irisScan;
    }
    public void setIrisScan(String irisScan) {
        this.irisScan = irisScan;
    }
    public AdharCard(String adharNo, String fingerprints, String irisScan) {
        this.adharNo = adharNo;
        this.fingerprints = fingerprints;
        this.irisScan = irisScan;
    }

    public AdharCard() {
    }

    @Override
    public String toString() {
        return "AdharCard{" +
                "adharNo='" + adharNo + '\'' +
                ", fingerprints='" + fingerprints + '\'' +
                ", irisScan='" + irisScan + '\'' +
                '}';
    }
}
