package pl.coderslab.spring01hibernatekrkw07.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw07.entity.Person;
import pl.coderslab.spring01hibernatekrkw07.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Student e){
        em.persist(e);
    }

    public void update(Student e){
        em.merge(e);
    }

    public Student readById(long id){
        return em.find(Student.class, id); }

    public void delete(Student e){
        em.remove(em.contains(e) ? e : em.merge(e));
    }

    public List<Student> readAll(){
        Query q = em.createQuery("SELECT e FROM Student e");
        return q.getResultList();
    }
}

