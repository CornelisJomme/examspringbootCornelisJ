package fr.CornelisJ.exam.entity;

import fr.CornelisJ.exam.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Model implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String slug;

    @ManyToOne
    private Brand brand;


    @Override
    public String getField() {
        return name;
    }
}