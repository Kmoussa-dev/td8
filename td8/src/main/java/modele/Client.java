package modele;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Client {
    @Id
    private long id;
    private String nom;
    private String prenom;
    private String adresse;
    @OneToMany(mappedBy="titulaire",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Builder.Default
    private Collection<Compte> comptes = new ArrayList<>();




    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", comptes=" + comptes +
                '}';
    }

    public void addCompte(Compte c){
        comptes.add(c);
        c.setTitulaire(this);
    }
}
