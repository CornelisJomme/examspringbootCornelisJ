package fr.CornelisJ.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.CornelisJ.exam.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class City implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String siren;

    private String name;

    private String code;

    private int population;

    private String slug;

    @ManyToOne
    private Department department; // BDD => department_id



    @Override
    public String getField() {
        return name;
    }
}