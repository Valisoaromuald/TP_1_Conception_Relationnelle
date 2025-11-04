package com.rallye.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private Integer idCategorie;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "categorie")
    private List<Equipage> equipages;

    // Getters et setters
    public Integer getIdCategorie() { return idCategorie; }
    public void setIdCategorie(Integer idCategorie) { this.idCategorie = idCategorie; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public List<Equipage> getEquipages() { return equipages; }
    public void setEquipages(List<Equipage> equipages) { this.equipages = equipages; }
}
