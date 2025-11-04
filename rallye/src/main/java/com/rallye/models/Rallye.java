package com.rallye.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rallye")
public class Rallye {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rallye")
    private Integer idRallye;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "date_realisation", nullable = false)
    private LocalDate dateRealisation;

    @OneToMany(mappedBy = "rallye")
    private List<Speciale> speciales;

    // Getters et setters
    public Integer getIdRallye() { return idRallye; }
    public void setIdRallye(Integer idRallye) { this.idRallye = idRallye; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public LocalDate getDateRealisation() { return dateRealisation; }
    public void setDateRealisation(LocalDate dateRealisation) { this.dateRealisation = dateRealisation; }
}
