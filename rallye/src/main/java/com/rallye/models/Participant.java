package com.rallye.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participant")
    private Integer idParticipant;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenoms")
    private String prenoms;

    @OneToMany(mappedBy = "copilote")
    private List<Equipage> equipagesAsParticipant1;

    @OneToMany(mappedBy = "pilote")
    private List<Equipage> equipagesAsParticipant2;

    // Getters et setters
    public Integer getIdParticipant() { return idParticipant; }
    public void setIdParticipant(Integer idParticipant) { this.idParticipant = idParticipant; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenoms() { return prenoms; }
    public void setPrenoms(String prenoms) { this.prenoms = prenoms; }
}
