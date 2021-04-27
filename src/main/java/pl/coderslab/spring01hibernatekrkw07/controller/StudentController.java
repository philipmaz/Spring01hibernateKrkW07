package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw07.dao.PersonDao;
import pl.coderslab.spring01hibernatekrkw07.dao.StudentDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Person;
import pl.coderslab.spring01hibernatekrkw07.model.Student;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentDao studentDao;

    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

//    @GetMapping("/addform")
//    public String addForm(){
//        return "person/addform";
//    }
//
//
//    @PostMapping("/addform")
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


    @GetMapping("/studentformbind")
    public String addForm(Model m){
        m.addAttribute("student", new Student());
        return "student/studentformbind";
    }


    @PostMapping("/studentformbind")
    @ResponseBody
    public String addFormPost(@ModelAttribute Student student){
        return student.toString();
    }


    @ModelAttribute("countryItems")
    public List<String> countryItems() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "Python", "C", "C#", ".Net");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Swimming", "Hiking", "Running", "Reading Books");
    }

}
