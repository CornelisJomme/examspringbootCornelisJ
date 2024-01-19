package fr.CornelisJ.exam.entity;

import fr.CornelisJ.exam.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;

    private String email;

    private String password;

    private String roles;

    private String slug;




    @Override
    public String getField() {
        return email;
    }
}