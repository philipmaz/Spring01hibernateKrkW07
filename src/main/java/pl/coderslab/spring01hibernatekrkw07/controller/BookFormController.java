package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw07.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw07.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw07.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Author;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bf")
public class BookFormController {
    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;


    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/readall")
    @ResponseBody
    public String readAll(){
//        List<Book> local=bookDao.readAllWithAuthors();

        final String html = bookDao.readAllWithAuthors()
                .stream()
                .map(Book::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }

    @GetMapping("/addform")
    public String addForm(Model m){
        m.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/addform")
    public String addForm(@ModelAttribute @Valid Book book, BindingResult violations){
        if(violations.hasErrors()){
            return "book/form";
        }
        bookDao.create(book);
        return "redirect:readall";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable long id, Model m){
        m.addAttribute("book", bookDao.readByIdWithAuthors(id));

        return "book/form";
    }

    @PostMapping("/{id}/edit")
    public String editBook(@ModelAttribute @Valid Book book, BindingResult violations){
        if(violations.hasErrors()){
            return "book/form";
        }
        bookDao.update(book);
        return "redirect:../readall";
    }


    @GetMapping("/{id}/delete")
    public String deleteBook(@PathVariable long id, Model m){
        m.addAttribute("book", bookDao.readByIdWithAuthors(id));

        return "book/formdelete";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@ModelAttribute Book book){
        bookDao.delete(book);
        return "redirect:../readall";
    }

//    @GetMapping("/{id}/delete/ensure")
//    public String deleteBookEnsure(@PathVariable long id,@ModelAttribute Book book, Model m){
//        m.addAttribute("id_todelete", id);
//        return "book/ensure";
//    }
//
//    @GetMapping("/{id}/delete/final")
//    public String deleteBookFinal(@PathVariable long id){
//        bookDao.delete(bookDao.readById(id));
//        return "redirect:bf/readall";
//    }




    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
        return publisherDao.readAll();
    }
    @ModelAttribute("authorList")
    public List<Author> authorList(){
        return authorDao.readAll();
    }



}
