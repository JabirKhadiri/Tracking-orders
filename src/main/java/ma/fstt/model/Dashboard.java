package ma.fstt.model;

public class Dashboard {
    private Long id_commande;
    private Long id_livreur;
    private Long id_produit;
    public Dashboard() {
    }
    public Dashboard(Long id_commande, Long id_livreur, Long id_produit) {
        this.id_commande = id_commande;
        this.id_livreur = id_livreur;
        this.id_produit = id_produit;
    }

    public Long getId_commande() {
        return id_commande;
    }

    public void setId_commande(Long id_commande) {
        this.id_commande = id_commande;
    }

    public Long getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(Long id_livreur) {
        this.id_livreur = id_livreur;
    }

    public Long getId_produit() {
        return id_produit;
    }

    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }
}
