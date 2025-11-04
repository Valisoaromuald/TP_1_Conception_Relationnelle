package com.rallye.models;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "speciale_equipage")
public class SpecialeEquipage {

    @EmbeddedId
    private SpecialEquipageId id;

    @ManyToOne
    @MapsId("equipageId")  // correspond au champ de la clé composite
    @JoinColumn(name = "id_equipage", nullable = false)
    private Equipage equipage;

    @ManyToOne
    @MapsId("specialeId")  // correspond au champ de la clé composite
    @JoinColumn(name = "id_speciale", nullable = false)
    private Speciale speciale;

    @Column(name = "duree", nullable = false)
    private LocalTime duree;

    public SpecialeEquipage() {}

    public SpecialeEquipage(Equipage equipage, Speciale speciale, LocalTime duree) {
        this.equipage = equipage;
        this.speciale = speciale;
        this.duree = duree;
        this.id = new SpecialEquipageId(equipage.getIdEquipage(), speciale.getIdSpeciale());
    }

    public SpecialEquipageId getId() { return id; }
    public void setId(SpecialEquipageId id) { this.id = id; }

    public Equipage getEquipage() { return equipage; }
    public void setEquipage(Equipage equipage) { this.equipage = equipage; }

    public Speciale getSpeciale() { return speciale; }
    public void setSpeciale(Speciale speciale) { this.speciale = speciale; }

    public LocalTime getDuree() { return duree; }
    public void setDuree(LocalTime duree) { this.duree = duree; }
}
