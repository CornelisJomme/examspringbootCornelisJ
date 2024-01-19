package fr.CornelisJ.exam.entity;

import fr.CornelisJ.exam.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Listing implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private int  producedYear;

    private Long mileage;

    private Long price;

    private Date createdAt;

    private String image;

    private String slug;

    @ManyToOne
    private User user;

    @ManyToOne
    private Model model;


    @Override
    public String getField() {
        return title;
    }
}