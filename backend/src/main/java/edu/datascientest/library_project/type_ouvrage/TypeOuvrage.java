package edu.datascientest.library_project.type_ouvrage;

import edu.datascientest.library_project.ouvrage.Ouvrage;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="type_ouvrage")
public class TypeOuvrage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String type;
    @OneToMany(mappedBy="typeOuvrage")
    @JsonManagedReference(value="ouvrage-typeouvrage")
    private List<Ouvrage> ouvrages;

    public TypeOuvrage() {
        this.ouvrages = new ArrayList<>();
    }

    public TypeOuvrage(Integer id, String type) {
        this.id = id;
        this.type = type;
        this.ouvrages = new ArrayList<>();
    }

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

    public TypeOuvrage(Integer id, String type, List<Ouvrage> ouvrages) {
        this.id = id;
        this.type = type;
        this.ouvrages = ouvrages;
    }

    @Override
    public String toString() {
        return "TypeOuvrage{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", ouvrages=" + ouvrages +
                '}';
    }


}
