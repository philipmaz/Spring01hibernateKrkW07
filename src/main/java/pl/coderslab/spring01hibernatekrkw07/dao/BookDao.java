package pl.coderslab.spring01hibernatekrkw07.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Book e){
        em.persist(e);
    }

    public void update(Book e){
        em.merge(e);
    }

    public Book readById(long id){
        return em.find(Book.class, id);

    }

    public void delete(Book e){
        em.remove(em.contains(e) ? e : em.merge(e));
    }

    public List<Book> readAll(){
        Query q = em.createQuery("SELECT e FROM Book e");
        return q.getResultList();
    }

    public List<Book> readByRatingGTE(int minimalRating){
        Query q = em.createQuery("SELECT e FROM Book e LEFT JOIN FETCH e.authorList WHERE e.rating >= :minRating");
        q.setParameter("minRating", minimalRating);
        return q.getResultList();
    }
    public List<Book> readByIdWithAuthors(long id) {
//        SELECT b FROM Book b JOIN FETCH b.authors
        Query q = em.createQuery("SELECT e FROM Book e LEFT JOIN FETCH e.authorList WHERE e.id=:id");
        return q.getResultList();
    }

    public List<Book> readAllWithAuthors() {
//        SELECT b FROM Book b JOIN FETCH b.authors
        Query q = em.createQuery("SELECT DISTINCT e FROM Book e LEFT JOIN FETCH e.authorList");
        return q.getResultList();
    }
}
