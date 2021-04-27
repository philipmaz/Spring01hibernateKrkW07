package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw07.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Author;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/af")
public class AuthorFormController {
    private AuthorDao authorDao;

    public AuthorFormController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/readall")
    @ResponseBody
    public String readall(){
        final String html = authorDao.readAll()
                .stream()
                .map(Author::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }

    @GetMapping("/addauthor")
    public String addAuthorForm(Model m){
        m.addAttribute("author", new Author());
        return "author/authorform";
    }

    @PostMapping("/addauthor")
    public String addAuthorForm(@ModelAttribute Author author){
        authorDao.create(author);
        return "redirect:readall";
    }

    @GetMapping("/{id}/edit")
    public String editAuthor(Model m, @PathVariable long id){
        m.addAttribute("author", authorDao.readById(id));
        return "author/authorform";
    }

    @PostMapping("/{id}/edit")
    public String editAuthor(@ModelAttribute Author author){
        authorDao.update(author);
        return "redirect:../readall";
    }

    @GetMapping("/{id}/delete")
    public String deleteAuthor(Model m, @PathVariable long id){
        m.addAttribute("author", authorDao.readById(id));
        return "author/authorform";
    }

    @PostMapping("/{id}/delete")
    public String deleteAuthor(@ModelAttribute Author author){
        authorDao.delete(author);
        return "redirect:../readall";
    }

}
