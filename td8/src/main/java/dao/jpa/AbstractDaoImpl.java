package dao.jpa;

import dao.AbstractDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

public class AbstractDaoImpl<T> implements AbstractDao<T> {

    /** Entity Manager used to talk with the database.
     * On s'est permis un petit écart avec cet autowired... */
    @PersistenceContext(name = "BanquePU")
    private EntityManager em;

    private Class<T> domainClass;

    public AbstractDaoImpl(Class<T> entityClass) {
        this.domainClass = entityClass;
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#create(T)
     */
    @Override
    public void create(T entity) {
        em.persist(entity);
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#edit(T)
     */
    @Override
    public void edit(T entity) {
        em.merge(entity);
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#remove(T)
     */
    @Override
    public void remove(T entity) {
        em.remove(em.merge(entity));
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#find(java.lang.Object)
     */
    @Override
    public T find(Object id) {
        return em.find(domainClass, id);
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#findAll()
     */
    @Override
    public List<T> findAll() {
        return em.createQuery("Select e from "+domainClass.getName()+" e").getResultList();
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#count()
     */
    @Override
    public int count() {
        return ((Long)em.createQuery("Select count (distinct e) from "+domainClass.getName()+" e").getSingleResult()).intValue();
    }

}