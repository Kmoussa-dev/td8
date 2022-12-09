package dao.jpa;

import dao.CompteDao;
import modele.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CompteDaoImpl extends AbstractDaoImpl<Compte> implements CompteDao {

    public CompteDaoImpl() {
        this(Compte.class);
    }
    public CompteDaoImpl(Class<Compte> entityClass) {
        super(entityClass);
    }
}
