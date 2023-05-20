package ma.fstt.model;

public class Commande {
    private Long id_commande;
    private String date_debut;
    private String date_livraison;
    private String etat;
    private Long client;

    public Commande() {
    }
    public Commande(Long id_commande, String date_debut, String date_livraison, String etat, Long client) {
        this.id_commande = id_commande;
        this.date_debut = date_debut;
        this.date_livraison = date_livraison;
        this.etat = etat;
        this.client = client;
    }

    public Long getId_commande() {
        return id_commande;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_livraison() {
        return date_livraison;
    }

    public String getEtat() {
        return etat;
    }

    public Long getClient() {
        return client;
    }

    public void setId_commande(Long id_commande) {
        this.id_commande = id_commande;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_livraison(String date_livraison) {
        this.date_livraison = date_livraison;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id_commande=" + id_commande +
                ", date_debut='" + date_debut + '\'' +
                ", date_livraison='" + date_livraison + '\'' +
                ", etat='" + etat + '\'' +
                ", client=" + client +
                '}';
    }
}
