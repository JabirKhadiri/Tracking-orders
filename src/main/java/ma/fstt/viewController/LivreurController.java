package ma.fstt.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ma.fstt.model.Livreur;
import ma.fstt.Controller.LivreurDAO;
import ma.fstt.trackingl.HelloApplication;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LivreurController implements Initializable {

    private static boolean executeopenajouter = true;
    private static Long ID;
    private static String Nom;
    private static String telephone;
    @FXML
    private TextField search;
    @FXML
    private TextField nom2;
    @FXML
    private TextField tele2;
    @FXML
    private TextField id;
    @FXML
    private TextField nom ;
    @FXML
    private TextField tele ;
    @FXML
    private TableView<Livreur> mytable ;
    @FXML
    private TableColumn<Livreur ,Long> col_id ;

    @FXML
    private TableColumn <Livreur ,String> col_nom ;

    @FXML
    private TableColumn <Livreur ,String> col_tele ;
    @FXML
    private Button livreurs;
    @FXML
    private Button commandes;
    @FXML
    private Button dashboard;
    @FXML
    private Button produits;

    @FXML
    private void onSaveButtonClick(ActionEvent event)  {
        try {
        // accees a la bdd
        if(!tele.getText().isEmpty() || !nom.getText().isEmpty()){
                LivreurDAO livreurDAO = new LivreurDAO();

                Livreur liv = new Livreur(0l, nom.getText(), tele.getText());

                livreurDAO.save(liv);

                UpdateTable();
            close(event);
            }}
        catch (SQLException e) {
                throw new RuntimeException(e);
        }

    }
    @FXML
    private void onUpdateButton(Event e) throws SQLException {
        executeopenajouter = false;
       if(!nom2.getText().isEmpty() || !tele2.getText().isEmpty()){
            LivreurDAO livreurDAO = new LivreurDAO();
            Livreur liv = new Livreur();
            liv.setNom(nom2.getText());
            liv.setTelephone(tele2.getText());
            liv.setId_livreur(ID);

            livreurDAO.update(liv);
            close(e);
       }
    }
    @FXML
    public void clickTable(Event e) throws IOException {
        executeopenajouter = false;
        Livreur liv = (Livreur) mytable.getSelectionModel().getSelectedItem();
        Nom = liv.getNom();
        telephone = liv.getTelephone();
        ID=liv.getId_livreur();
        openUpdate(e);
    }
    @FXML
    public void openSupprimer(Event e) throws IOException {
        executeopenajouter = false;
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SupprimerLivreur.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 288);
        newStage.setScene(scene);
        newStage.show();

    }
    @FXML
    public void openUpdate(Event e) throws IOException {
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateLivreur.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 337);
        newStage.setScene(scene);
        newStage.show();

    }
    @FXML
    public void onDeleteButton(Event e) throws SQLException {
        executeopenajouter = false;
        if(!id.getText().isEmpty()){
            LivreurDAO livreurDAO = new LivreurDAO();
            Livreur liv = new Livreur();
            liv.setId_livreur(Long.parseLong(id.getText()));
            livreurDAO.delete(liv);
            close(e);
        }
    }
    @FXML
    public void openajouter() throws IOException {
            executeopenajouter = false;
            Stage newStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AjouterLivreur.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 300, 337);
            newStage.setScene(scene);
            newStage.show();
    }
    public void close(Event e) {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void clear(){
        if (!tele2.getText().isEmpty() && !nom2.getText().isEmpty()) {
            tele2.setText("");
            nom2.setText("");
        }
    }
    @FXML
    public void clear2(){
        if (!tele.getText().isEmpty() && !nom.getText().isEmpty()) {
            tele.setText("");
            nom.setText("");
        }
    }
    @FXML
    public void clear3(){
        if (!id.getText().isEmpty()) {
            id.setText("");
        }
    }


    public void refresh(){
        executeopenajouter = true;
        UpdateTable();
    }
    @FXML
    private void UpdateTable(){
        if(executeopenajouter) {
            col_id.setCellValueFactory(new PropertyValueFactory<Livreur, Long>("id_livreur"));
            col_nom.setCellValueFactory(new PropertyValueFactory<Livreur, String>("nom"));
            col_tele.setCellValueFactory(new PropertyValueFactory<Livreur, String>("telephone"));

            mytable.setItems(this.getDataLivreurs());
        }
    }
    @FXML
    private void UpdateTable2(){
        if (!search.getText().isEmpty()){
            executeopenajouter = false;
            col_id.setCellValueFactory(new PropertyValueFactory<Livreur, Long>("id_livreur"));
            col_nom.setCellValueFactory(new PropertyValueFactory<Livreur, String>("nom"));
            col_tele.setCellValueFactory(new PropertyValueFactory<Livreur, String>("telephone"));

            mytable.setItems(this.getLikeDataLivreurs());
            search.setText("");
        }}
    @FXML
    public static ObservableList<Livreur> getDataLivreurs(){
            LivreurDAO livreurDAO = null;

            ObservableList<Livreur> listfx = FXCollections.observableArrayList();

            try {
                livreurDAO = new LivreurDAO();
                for (Livreur ettemp : livreurDAO.getAll())
                    listfx.add(ettemp);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return listfx;
        }
    @FXML
    public ObservableList<Livreur> getLikeDataLivreurs(){

            LivreurDAO livreurDAO = null;
            Livreur liv = new Livreur();
            liv.setId_livreur(Long.parseLong(search.getText()));
            ObservableList<Livreur> listfx = FXCollections.observableArrayList();

            try {
                livreurDAO = new LivreurDAO();
                for (Livreur ettemp : livreurDAO.getLike(liv))
                    listfx.add(ettemp);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return listfx;

    }
    public void changepage(Event e){
        HomeController homeController = new HomeController();
        if(e.getSource() == livreurs){
        homeController.openLivreur(e);
        } else if (e.getSource() == produits) {
            homeController.openProduit(e);
        }else if (e.getSource() == commandes) {
            homeController.openCommande(e);
        }else if (e.getSource() == dashboard) {
            homeController.openDashboard(e);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();

    }

}