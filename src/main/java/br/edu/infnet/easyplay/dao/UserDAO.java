package br.edu.infnet.easyplay.DAO;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.edu.infnet.easyplay.model.User;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager em;
    // private EntityManagerFactory emf = Persistence.createEntityManagerFactory("EasyPlayDB");

    public void persistUser(User user) {
        System.out.println(user.getId());
        em.persist(user);
        // EntityManager em = emf.createEntityManager();

        // em.getTransaction();
        // em.persist(new User(Long.toString(((timestamp - Instant.now().toEpochMilli()) << 12)*-1), username, email, senha));
        // em.getTransaction().commit();
        // em.close();
        // emf.close();
    }
}
