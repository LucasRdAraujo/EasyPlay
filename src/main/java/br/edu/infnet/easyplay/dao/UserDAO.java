package br.edu.infnet.easyplay.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.infnet.easyplay.model.User;

@Stateless
public class UserDAO {

    @PersistenceContext
    private EntityManager em;
    
    public void persistUser(User user) {
        em.persist(user);
    }
}

