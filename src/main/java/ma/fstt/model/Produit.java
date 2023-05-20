package ma.fstt.model;

public class Produit {
    private long id_prod;
    private String Nom_prod;
    private String description;
    private double prix;

    public Produit() {
    }
    public Produit(long id_prod, String nom_prod, String description, Double prix) {
        this.id_prod = id_prod;
        Nom_prod = nom_prod;
        this.description = description;
        this.prix = prix;
    }

    public long getId_prod() {
        return id_prod;
    }

    public void setId_prod(long id_prod) {
        this.id_prod = id_prod;
    }

    public String getNom_prod() {
        return Nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        Nom_prod = nom_prod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id_prod=" + id_prod +
                ", Nom_prod='" + Nom_prod + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}
