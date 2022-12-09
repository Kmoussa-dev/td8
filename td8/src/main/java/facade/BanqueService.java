package facade;

import dao.ClientDao;
import dao.CompteDao;
import dao.LivretDao;
import lombok.AllArgsConstructor;
import modele.Client;
import modele.Compte;
import modele.Livret;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class BanqueService {

    ClientDao clientDao;
    CompteDao compteDao;
    LivretDao livretDao;

    EntityManager em;

    public BanqueService(ClientDao clientDao, CompteDao compteDao, LivretDao livretDao,EntityManagerFactory emf) {
        this.clientDao = clientDao;
        this.compteDao = compteDao;
        this.livretDao = livretDao;
        em=emf.createEntityManager();
    }

    @Transactional
    public void virement(long id1, long id2, double montant) {
        Compte c1=compteDao.find(id1);
        Compte c2=compteDao.find(id2);
        c1.setSolde(c1.getSolde()-montant);
        c2.setSolde(c2.getSolde()+montant);
    }

    public Iterable<Client> getAllClients() {
        return clientDao.findAll();
    }

    public Client getClient(long id) {
        return clientDao.find(id);
    }

    public Iterable<Livret> getAllLivrets() {
        return livretDao.findAll();
    }


    public Iterable<? extends Compte> getAllComptes() {
        return compteDao.findAll();
    }

    public Iterable<? extends Compte> getComptesOfClient(long id) {
        Client c=clientDao.find(id);
        return c.getComptes();
    }

    @Transactional
    public void saveClients(Client[] clients) {
        for (Client c : clients) {
            clientDao.create(c);
        }
    }
    @Transactional
    public void deleteClient(long id) {
        clientDao.remove(clientDao.find(id));
    }
}
