package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrkw07.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/create")
    @ResponseBody
    public String create(){
        final Author a= new Author()
                .setFirstName("George")
                .setLastName("Orwell");

        authorDao.create(a);
        return a.toString();
    }

    @GetMapping("/create/{firstName}/{lastName}")
    @ResponseBody
    public String create(@PathVariable String firstName,
                         @PathVariable String lastName){
        final Author a= new Author()
                .setFirstName(firstName)
                .setLastName(lastName);

        authorDao.create(a);
        return a.toString();
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public String read(@PathVariable long id){
        return authorDao.readById(id).toString();
    }

    @GetMapping("/update/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String update(@PathVariable long id,
                         @PathVariable String firstName,
                         @PathVariable String lastName) {
        Author a= authorDao.readById(id);
        a.setFirstName(firstName);
        a.setLastName(lastName);

        authorDao.update(a);
        return a.toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        Author a = authorDao.readById(id);
        authorDao.delete(a);

        return "Usunięto: "+a;
    }

}
