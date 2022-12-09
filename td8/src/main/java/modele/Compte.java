package modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
    @Id
    @Getter
    private long id;
    @ManyToOne
    @Setter
    @Getter
    private Client titulaire;
    @Setter
    @Getter
    private double solde;
    @Temporal(value=TemporalType.DATE)
    @Setter
    @Getter
    private Date dateOuverture;

    public Compte(Client titulaire, double solde, Date dateOuverture) {
        this.titulaire = titulaire;
        this.solde = solde;
        this.dateOuverture = dateOuverture;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", solde=" + solde +
                ", dateOuverture=" + dateOuverture +
                '}';
    }
}
