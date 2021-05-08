package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw07.dao.PersonDao;
import pl.coderslab.spring01hibernatekrkw07.dao.PersonDetailsDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Person;
import pl.coderslab.spring01hibernatekrkw07.entity.PersonDetails;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/person")
public class PersonController {
    private PersonDao personDao;
    private PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/addform")
    public String addForm(){
        return "person/addform";
    }


    @PostMapping("/addform")
    @ResponseBody
    public String addFormPost(@RequestParam String login,
                              @RequestParam String email,
                              @RequestParam String password,
                              @RequestParam long details_id){
        Person person= new Person()
                .setLogin(login)
                .setEmail(email)
                .setPassword(password);

        person.setPersonDetails(personDetailsDao.readById(details_id));

        personDao.create(person);
        return person.toString();
    }


    @GetMapping("/readall")
    @ResponseBody
    public String readall(){
        final String html = personDao.readAll()
                .stream()
                .map(Person::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }


    @GetMapping("/addformbind")
    public String addForm(Model m){
        m.addAttribute("person", new Person());
        return "person/addformbind";
    }


    @PostMapping("/addformbind")
    public String addFormPost(@ModelAttribute Person person){
        personDao.create(person);
        return "redirect:readall";
    }

    @ModelAttribute("personDetails")
    public List<PersonDetails> publishers(){
        return personDetailsDao.readAll();
    }


}
