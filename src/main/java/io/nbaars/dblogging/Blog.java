package io.nbaars.dblogging;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author;
    private String title;
    private String contents;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date publishDate;

    protected Blog() {
    }

    Blog(String author, String title, String contents) {
        this.author = author;
        this.title = title;
        this.contents = contents;
    }
}
