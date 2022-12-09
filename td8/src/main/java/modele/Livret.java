package modele;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Livret extends Compte {
    private double tauxInteret;

    public Livret() {
    }

    public Livret(long id,Client titulaire, double solde, Date date, double taux){
        super(id,titulaire, solde, date);
        tauxInteret = taux;
    }
}
