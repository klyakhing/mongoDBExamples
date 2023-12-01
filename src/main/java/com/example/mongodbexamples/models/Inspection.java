package com.example.mongodbexamples.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document(collection="inspections")
public class Inspection {

    @BsonProperty("id")
    private String id;

    private Long certificate_number;

    private String business_name;

    @BsonProperty("date")
    private Date date;

    private String result;

    private String sector;

    private Address address;

    public Inspection() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCertificate_number() {
        return certificate_number;
    }

    public void setCertificate_number(Long certificate_number) {
        this.certificate_number = certificate_number;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Inspection{" +
                "id='" + id + '\'' +
                ", certificate_number=" + certificate_number +
                ", business_name='" + business_name + '\'' +
                ", date=" + date +
                ", result='" + result + '\'' +
                ", sector='" + sector + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inspection that = (Inspection) o;
        return id.equals(that.id) && Objects.equals(certificate_number, that.certificate_number) && Objects.equals(business_name, that.business_name) && Objects.equals(date, that.date) && Objects.equals(result, that.result) && Objects.equals(sector, that.sector) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, certificate_number, business_name, date, result, sector, address);
    }
}
