package models.domain;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "BookAuthors")
public class BookAuthorsEntity {

    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "AuthorId")
    private int authorId;

    @Column(name = "BookId")
    private int bookId;

}
