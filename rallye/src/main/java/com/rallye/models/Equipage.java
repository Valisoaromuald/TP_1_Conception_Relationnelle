package com.rallye.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipage")
public class Equipage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipage")
    private Integer idEquipage;

    @ManyToOne
    @JoinColumn(name = "id_categorie", nullable = false)
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "pilote", nullable = false)
    private Participant pilote;

    @ManyToOne
    @JoinColumn(name = "copilote", nullable = false)
    private Participant copilote;

    @OneToMany(mappedBy = "equipage",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SpecialeEquipage> specialEquipages;

    // Getters et setters
    public Integer getIdEquipage() { return idEquipage; }
    public void setIdEquipage(Integer idEquipage) { this.idEquipage = idEquipage; }
    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }
    public Participant getilote() { return pilote; }
    public void setPilote(Participant pilote) { this.pilote = pilote; }
    public Participant getCopilote() { return copilote; }
    public void setCopilote(Participant copilote) { this.copilote = copilote; }
}
