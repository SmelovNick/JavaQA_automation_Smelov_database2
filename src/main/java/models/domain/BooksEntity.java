package models.domain;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "Books")
public class BooksEntity {

    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Title")
    private String title;

}
