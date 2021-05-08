package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrkw07.entity.Author;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ValidationController {
    Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    @ResponseBody
    public String validate(){
        String html="";

        Book b = new Book();

        Set<ConstraintViolation<Book>> validationResults=validator.validate(b);

        if(validationResults.isEmpty()){
            html="Walidacja zakonczona sukcesem. Brak bledow.";
        } else{
            html=validationResults.stream()
                    .map(cv-> cv.getPropertyPath() + " : " + cv.getMessage())
                    .collect(Collectors.joining("</div><div>","<div>","</div>"));
        }


        return html;
    }

    @GetMapping("/valid")
    @ResponseBody
    public String valid(){
        String html="";

        Book b = new Book()
                .setPublisher(new Publisher())
                .setRating(5)
                .setPages(555);

        b.getAuthorList().add(new Author());

        Set<ConstraintViolation<Book>> validationResults=validator.validate(b);

        if(validationResults.isEmpty()){
            html="Walidacja zakonczona sukcesem. Brak bledow.";
        } else{
            html=validationResults.stream()
                    .map(cv-> cv.getPropertyPath() + " : " + cv.getMessage())
                    .collect(Collectors.joining("</div><div>","<div>","</div>"));
        }


        return html;
    }

    @GetMapping("/enc") @ResponseBody public String encoding(){
        return "ąęćółńżź"; }
}
