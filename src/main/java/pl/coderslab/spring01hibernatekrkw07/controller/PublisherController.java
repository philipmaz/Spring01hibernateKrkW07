package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrkw07.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Author;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/create")
    @ResponseBody
    public String create(){
        final Publisher p= new Publisher().setName("SuperPublisher");

        publisherDao.create(p);
        return p.toString();
    }

    @GetMapping("/create/{name}")
    @ResponseBody
    public String create(@PathVariable String name){
        Publisher p = new Publisher().setName(name);

        publisherDao.create(p);
        return p.toString();
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public String read(@PathVariable long id){
        return publisherDao.readById(id).toString();
    }

    @GetMapping("/update/{id}/{name}")
    @ResponseBody
    public String update(@PathVariable long id,
                         @PathVariable String name) {
        Publisher p = publisherDao.readById(id);
        p.setName(name);

        publisherDao.update(p);
        return p.toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        Publisher p = publisherDao.readById(id);
        publisherDao.delete(p);

        return "Usunięto: "+p;
    }

}
