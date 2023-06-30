package edu.datascientest.library_project.type_ouvrage;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class TypeOuvrage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_type", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOuvrage that = (TypeOuvrage) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType());
    }

    @Override
    public String toString() {
        return "TypeOuvrage{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
