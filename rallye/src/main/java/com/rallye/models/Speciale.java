package com.rallye.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "speciale") // ⚠️ ton SQL crée "Speciales", donc il faut le même nom ici
public class Speciale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_speciale")
    private Integer idSpeciale;

    @Column(name = "distance", nullable = false, precision = 10, scale = 2)
    private BigDecimal distance;

    @Column(name = "nom_special", nullable = false)
    private String nomSpecial;

    @ManyToOne
    @JoinColumn(name = "id_rallye", nullable = false)
    private Rallye rallye;

    @OneToMany(mappedBy = "speciale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SpecialeEquipage> specialEquipages;

    // --- Getters et Setters ---
    public Integer getIdSpeciale() {
        return idSpeciale;
    }

    public void setIdSpeciale(Integer idSpeciale) {
        this.idSpeciale = idSpeciale;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public String getNomSpecial() {
        return nomSpecial;
    }

    public void setNomSpecial(String nomSpecial) {
        this.nomSpecial = nomSpecial;
    }

    public Rallye getRallye() {
        return rallye;
    }

    public void setRallye(Rallye rallye) {
        this.rallye = rallye;
    }

    public List<SpecialeEquipage> getSpecialEquipages() {
        return specialEquipages;
    }

    public void setSpecialEquipages(List<SpecialeEquipage> specialEquipages) {
        this.specialEquipages = specialEquipages;
    }
}
