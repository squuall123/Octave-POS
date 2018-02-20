public class Produit {
    public int id;
    public String nom;
    public int quantity;
    public float prix;

    public Produit(int id, String nom, int quantity, float prix) {
        this.id = id;
        this.nom = nom;
        this.quantity = quantity;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
