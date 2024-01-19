package fr.CornelisJ.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.CornelisJ.exam.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Department implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String code;

    private String slug;

    @OneToMany(mappedBy = "department")
    private List<City> cities;

    @ManyToOne
    private Region region;


    @Override
    public String getField() {
        return name;
    }
}