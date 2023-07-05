package com.example.awstest.model;

public class MMTData {
    private int memberno;
    private String title;
    private int dmnumber;
    private int documentid;
    private String marketingcontact;
    private String ref;

    public int getMemberno() {
        return memberno;
    }

    public void setMemberno(int memberno) {
        this.memberno = memberno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDmnumber() {
        return dmnumber;
    }

    public void setDmnumber(int dmno) {
        this.dmnumber = dmno;
    }

    public int getDocumentid() {
        return documentid;
    }

    public void setDocumentid(int docid) {
        this.documentid = docid;
    }

    public String getMarketingcontact() {
        return marketingcontact;
    }

    public void setMarketingcontact(String contact) {
        this.marketingcontact = contact;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String toString() {
        return "MMTData [memberno="
                + memberno +
                ", title=" + title +
                ", dmnumber=" + dmnumber +
                ", documentid=" + documentid
                +",marketingcontact=" + marketingcontact +
                ", ref=" +
                "]";
    }
}