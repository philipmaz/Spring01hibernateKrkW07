package pl.coderslab.spring01hibernatekrkw07.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=5)
    private String title;
    @Range(min=1, max=10)
    private int rating;
    @Size(min=1, max=600)
    private String description;
    @NotNull
    @ManyToOne
    private Publisher publisher;
    @NotNull
    @Size(min=1)
    @ManyToMany
    private List<Author> authorList=new ArrayList<>();
    @Min(1)
    private int pages;

    //gettery i settery


    public List<Author> getAuthorList() {
        return authorList;
    }

    public Book setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
        return this;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Book setPublisher(Publisher publisher) {
        this.publisher = publisher;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Book setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                ", authorList=" + authorList +
                '}';
    }
}
