package ma.fstt.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ma.fstt.trackingl.HelloApplication;


public class HomeController {
    @FXML
    private Button produits;
    @FXML
    private Button commandes;
    @FXML
    private Button livreurs;
    @FXML
    private Button Add;
    @FXML
    public void openLivreur(Event e)
    {
        try {
            Node node = (Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Livreur.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 738, 407);
            stage.setTitle("Tracking");
            stage.setScene(scene);
            stage.show();

        } catch (Exception ex) {
            System.out.println("y"+ex.getMessage());
        }
    }
    @FXML
    public void openProduit(Event e)
    {
        try {
            Node node = (Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Produit.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 850, 407);
            stage.setTitle("Tracking");
            stage.setScene(scene);
            stage.show();

        } catch (Exception ex) {
            System.out.println("y"+ex.getMessage());
        }
    }
    public void openCommande(Event e)
    {
        try {
            Node node = (Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Commande.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 850, 407);
            stage.setTitle("Tracking");
            stage.setScene(scene);
            stage.show();

        } catch (Exception ex) {
            System.out.println("y"+ex.getMessage());
        }
    }
    public void openDashboard(Event e)
    {
        try {
            Node node = (Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 986, 407);
            stage.setTitle("Tracking");
            stage.setScene(scene);
            stage.show();

        } catch (Exception ex) {
            System.out.println("y"+ex.getMessage());
        }
    }

}
