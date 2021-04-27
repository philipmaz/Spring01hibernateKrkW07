package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrkw07.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw07.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw07.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Author;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;


    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao=publisherDao;
        this.authorDao=authorDao;
    }

    @GetMapping("/create")
    @ResponseBody
    public String create(){
        final Book b= new Book()
                .setTitle("w pustyni i w puszczy")
                .setDescription("klasyczna ksiazka")
                .setRating(9);

        bookDao.create(b);
        return b.toString();
    }


    @GetMapping("/create/{title}/{description}/{rating}")
    @ResponseBody
    public String createWithPublisher(@PathVariable String title,
                                      @PathVariable String description,
                                      @PathVariable int rating){


        final Book b= new Book()
                .setTitle(title)
                .setDescription(description)
                .setRating(rating);

        bookDao.create(b);
        return b.toString();
    }

//    @GetMapping("/createWithP")
//    @ResponseBody
//    public String createWithPublisher(){
//        Publisher p= publisherDao.readById();
//
//        publisherDao.create(p);
//
//
//        Book b = new Book().setTitle("Thinking in Java")
//                .setPublisher(p)
//                .setDescription("super java mordko")
//                .setRating(10);
//        bookDao.create(b);
//        return b.toString();
//    }

    @GetMapping("/createWithP/{title}/{description}/{rating}/{p_id}")
    @ResponseBody
    public String createWithPublisher(@PathVariable String title,
                         @PathVariable String description,
                         @PathVariable int rating,
                         @PathVariable long p_id){

        Publisher p= publisherDao.readById(p_id);

        final Book b= new Book()
                .setTitle(title)
                .setDescription(description)
                .setRating(rating)
                .setPublisher(p);

        bookDao.create(b);
        return b.toString();
    }

    @GetMapping("/createWithPandA/{title}/{description}/{rating}/{p_id}/{a1_id}/{a2_id}")
    @ResponseBody
    public String createWithPublisherAndAuthors(@PathVariable String title,
                                      @PathVariable String description,
                                      @PathVariable int rating,
                                      @PathVariable long p_id,
                                                @PathVariable long a1_id,
                                                @PathVariable long a2_id){

        Publisher p= publisherDao.readById(p_id);
        List<Author> a_list=new ArrayList<>();
        a_list.add(authorDao.readById(a1_id));
        a_list.add(authorDao.readById(a2_id));

        final Book b= new Book()
                .setTitle(title)
                .setDescription(description)
                .setRating(rating)
                .setPublisher(p)
                .setAuthorList(a_list);

        bookDao.create(b);
        return b.toString();
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public String read(@PathVariable long id){
        return bookDao.readById(id).toString();
    }

    @GetMapping("/readall")
    @ResponseBody
    public String readAll(){

        final String html = bookDao.readAllWithAuthors()
                .stream()
                .map(Book::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;

    }

    @GetMapping("/readByRating/{min_rating}")
    @ResponseBody
    public String readByRating(@PathVariable Integer min_rating){

        if(min_rating==null){
            min_rating = 6;
        }

        final String html = bookDao.readByRatingGTE(min_rating)
                .stream()
                .map(Book::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }


    @GetMapping("/update/{id}/{title}/{description}/{rating}")
    @ResponseBody
    public String update(@PathVariable long id,
                         @PathVariable String title,
                         @PathVariable String description,
                         @PathVariable int rating) {
        Book b = bookDao.readById(id);
        b.setTitle(title);
        b.setDescription(description);
        b.setRating(rating);

        bookDao.update(b);

        return b.toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        Book b = bookDao.readById(id);
        bookDao.delete(b);

        return "Usunięto: "+b;
    }

}
