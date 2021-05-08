package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw07.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pf")
public class PublisherFormController {
    PublisherDao publisherDao;

    public PublisherFormController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/readall")
    @ResponseBody
    public String readall(){
        final String html = publisherDao.readAll()
                .stream()
                .map(Publisher::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }

    @GetMapping("/addpublisher")
    public String addPublisher(Model m){
        Publisher publisher= new Publisher();
        m.addAttribute("publisher", publisher);
        return "publisher/publisherform";
    }

    @PostMapping("/addpublisher")
    public String addPublisher(@ModelAttribute @Valid Publisher publisher, BindingResult violations){
        if(violations.hasErrors()){
            return "publisher/publisherform";
        }
        publisherDao.create(publisher);

        return "redirect:readall";
    }

    @GetMapping("/{id}/edit")
    public String editPublisher(Model m, @PathVariable long id){
        m.addAttribute("publisher", publisherDao.readById(id));
        return "publisher/editpublisherform";
    }

    @PostMapping("/{id}/edit")
    public String editPublisher(@ModelAttribute @Valid Publisher publisher, BindingResult violations){
        if(violations.hasErrors()){
            return "publisher/publisherform";
        }
        publisherDao.update(publisher);
        return "redirect:../readall";
    }

    @GetMapping("/{id}/delete")
    public String deletePublisher(Model m, @PathVariable long id){
        m.addAttribute("publisher", publisherDao.readById(id));
        return "publisher/deletepublisherform";
    }

    @PostMapping("/{id}/delete")
    public String deletePublisher(@ModelAttribute @Valid Publisher publisher, BindingResult violations){
        if(violations.hasErrors()){
            return "publisher/publisherform";
        }
        publisherDao.delete(publisher);
        return "redirect:../readall";
    }
}
