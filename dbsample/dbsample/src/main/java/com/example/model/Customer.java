package com.example.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Customer {


    @CsvBindByPosition(position=1)
    private String id;


    @CsvBindByPosition(position=2)
    private String nom;


    @CsvBindByPosition(position=4)
    private String anneeNaissance;


    @CsvBindByPosition(position=3)
    private String adresse;

    public Customer() {
        super();
    }

    public Customer(String id, String nom, String anneeNaissance, String adresse) {
        super();
        this.id = id;
        this.nom = nom;
        this.anneeNaissance = anneeNaissance;
        this.adresse = adresse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(String anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", anneeNaissance='" + anneeNaissance + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
