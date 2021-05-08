package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw07.dao.PersonDao;
import pl.coderslab.spring01hibernatekrkw07.dao.PersonDetailsDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Author;
import pl.coderslab.spring01hibernatekrkw07.entity.Person;
import pl.coderslab.spring01hibernatekrkw07.entity.PersonDetails;

import java.util.stream.Collectors;


@Controller
@RequestMapping("/details")
public class PersonDetailsController {
    private PersonDetailsDao personDetailsDao;

    public PersonDetailsController(PersonDetailsDao personDetailsDao) {
        this.personDetailsDao = personDetailsDao;
    }

//    @GetMapping("/adddetails")
//    public String addForm(){
//        return "person/adddetails";
//    }
//
//
//    @PostMapping("/adddeta")
//    @ResponseBody
//    public String addFormPost(@RequestParam String login,
//                              @RequestParam String email,
//                              @RequestParam String password){
//        Person person= new Person()
//                .setLogin(login)
//                .setEmail(email)
//                .setPassword(password);
//
//        personDao.create(person);
//        return person.toString();
//    }

    @GetMapping("/readall")
    @ResponseBody
    public String readall(){
        final String html = personDetailsDao.readAll()
                .stream()
                .map(PersonDetails::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }


    @GetMapping("/add")
    public String addForm(Model m){
        m.addAttribute("persondetails", new PersonDetails());
        return "person/adddetails";
    }


    @PostMapping("/add")
    public String addFormPost(@ModelAttribute PersonDetails personDetails){
        personDetailsDao.create(personDetails);
        return "redirect:readall";
    }


}
