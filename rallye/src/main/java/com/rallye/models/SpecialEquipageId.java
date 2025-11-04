package com.rallye.models;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SpecialEquipageId implements Serializable {

    private Integer equipageId;
    private Integer specialeId;

    public SpecialEquipageId() {}

    public SpecialEquipageId(Integer equipageId, Integer specialeId) {
        this.equipageId = equipageId;
        this.specialeId = specialeId;
    }

    public Integer getEquipageId() { return equipageId; }
    public void setEquipageId(Integer equipageId) { this.equipageId = equipageId; }

    public Integer getSpecialeId() { return specialeId; }
    public void setSpecialeId(Integer specialeId) { this.specialeId = specialeId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialEquipageId)) return false;
        SpecialEquipageId that = (SpecialEquipageId) o;
        return Objects.equals(equipageId, that.equipageId)
            && Objects.equals(specialeId, that.specialeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipageId, specialeId);
    }
}
