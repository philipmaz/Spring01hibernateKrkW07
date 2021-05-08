package pl.coderslab.spring01hibernatekrkw07.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw07.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    private EntityManager em;

    public void create(PersonDetails e){
        em.persist(e);
    }

    public void update(PersonDetails e){
        em.merge(e);
    }

    public PersonDetails readById(long id){
        return em.find(PersonDetails.class, id);
    }
    public void delete(PersonDetails e){
        em.remove(em.contains(e) ? e : em.merge(e));
    }

    public List<PersonDetails> readAll(){
        Query q = em.createQuery("SELECT e FROM PersonDetails e");
        return q.getResultList();
    }
}

