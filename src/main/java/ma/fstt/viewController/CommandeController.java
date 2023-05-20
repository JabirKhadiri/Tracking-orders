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
        import ma.fstt.Controller.CommandDAO;
        import ma.fstt.model.Commande;
        import ma.fstt.trackingl.HelloApplication;
        import java.io.IOException;
        import java.net.URL;
        import java.sql.SQLException;
        import java.util.ResourceBundle;

public class CommandeController implements Initializable {

    private static boolean executeopenajouter3 = true;
    private static Long ID3;
    private static String dateDebut;
    private static String dateFin;
    private static Long Client;
    @FXML
    private TextField search3;
    @FXML
    private TextField date_debut;
    @FXML
    private TextField date_fin;
    @FXML
    private TextField etat;
    @FXML
    private TextField client;
    @FXML
    private TextField id3;
    @FXML
    private TextField date_debut2;
    @FXML
    private TextField etat2;
    @FXML
    private TextField client2;
    @FXML
    private TableView<Commande> mytable3 ;
    @FXML
    private TableColumn<Commande ,Long> col_id3 ;
    @FXML
    private TableColumn <Commande ,String> col_etat ;
    @FXML
    private TableColumn <Commande ,String> col_debut ;
    @FXML
    private TableColumn <Commande ,String> col_fin ;
    @FXML
    private TableColumn <Commande ,Long> col_client ;
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
            if(!date_debut.getText().isEmpty() || !etat.getText().isEmpty() || !client.getText().isEmpty()){
                CommandDAO commandDAO = new CommandDAO();

                Commande com = new Commande(0l, date_debut.getText(),"", etat.getText(), Long.parseLong(client.getText()));

                commandDAO.save(com);

                UpdateTable();
                close(event);
            }}
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    private void onUpdateButton(Event e) throws SQLException {
        executeopenajouter3 = false;
        if(!date_debut2.getText().isEmpty() || !etat2.getText().isEmpty() || !client2.getText().isEmpty() || !date_fin.getText().isEmpty()){
            CommandDAO commandDAO = new CommandDAO();
            Commande com = new Commande();
            com.setDate_debut(date_debut2.getText());
            com.setDate_livraison(date_fin.getText());
            com.setEtat(etat2.getText());
            com.setClient(Long.parseLong(client2.getText()));
            com.setId_commande(ID3);

            commandDAO.update(com);
            close(e);
        }
    }
    @FXML
    public void clickTable(Event e) throws IOException {
        executeopenajouter3 = false;
        Commande com = (Commande) mytable3.getSelectionModel().getSelectedItem();
        dateDebut = com.getDate_debut();
        dateFin = com.getDate_livraison();
        ID3=com.getId_commande();
        Client= com.getClient();
        openUpdate(e);
    }
    @FXML
    public void openSupprimer(Event e) throws IOException {
        executeopenajouter3 = false;
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SupprimerCommande.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 288);
        newStage.setScene(scene);
        newStage.show();
    }
    @FXML
    public void openUpdate(Event e) throws IOException {
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateCommande.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 447);
        newStage.setScene(scene);
        newStage.show();
    }
    @FXML
    public void onDeleteButton(Event e) throws SQLException {
        executeopenajouter3 = false;
        if(!id3.getText().isEmpty()){
            CommandDAO commandDAO = new CommandDAO();
            Commande com = new Commande();
            com.setId_commande(Long.parseLong(id3.getText()));
            commandDAO.delete(com);
            close(e);
        }
    }
    @FXML
    public void openajouter() throws IOException {
        executeopenajouter3 = false;
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AjouterCommande.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 370);
        newStage.setScene(scene);
        newStage.show();
    }
    public void close(Event e) {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void clear2(){
        if (!date_debut2.getText().isEmpty() && !client2.getText().isEmpty() && !etat2.getText().isEmpty() && !date_fin.getText().isEmpty()) {
            date_debut2.setText("");
            client2.setText("");
            etat2.setText("");
            date_fin.setText("");
        }
    }
    @FXML
    public void clear(){
        if (!date_debut.getText().isEmpty() && !client.getText().isEmpty() && !etat.getText().isEmpty()) {
            date_debut.setText("");
            client.setText("");
            etat.setText("");
        }
    }
    @FXML
    public void clear3(){
        if (!id3.getText().isEmpty()) {
            id3.setText("");
        }
    }


    public void refresh(){
        executeopenajouter3 = true;
        UpdateTable();
    }
    @FXML
    private void UpdateTable(){
        if(executeopenajouter3) {
            col_id3.setCellValueFactory(new PropertyValueFactory<Commande, Long>("id_commande"));
            col_etat.setCellValueFactory(new PropertyValueFactory<Commande, String>("etat"));
            col_debut.setCellValueFactory(new PropertyValueFactory<Commande, String>("date_debut"));
            col_fin.setCellValueFactory(new PropertyValueFactory<Commande, String>("date_livraison"));
            col_client.setCellValueFactory(new PropertyValueFactory<Commande, Long>("client"));
            mytable3.setItems(this.getDataCommandes());
        }
    }
    @FXML
    private void UpdateTable2(){
        if (!search3.getText().isEmpty()){
            executeopenajouter3 = false;
            col_id3.setCellValueFactory(new PropertyValueFactory<Commande, Long>("id_commande"));
            col_debut.setCellValueFactory(new PropertyValueFactory<Commande, String>("date_debut"));
            col_fin.setCellValueFactory(new PropertyValueFactory<Commande, String>("date_livraison"));
            col_etat.setCellValueFactory(new PropertyValueFactory<Commande, String>("etat"));
            col_client.setCellValueFactory(new PropertyValueFactory<Commande, Long>("client"));
            mytable3.setItems(this.getLikeCommandes());
            search3.setText("");
        }}
    @FXML
    public void UpdateTable3(Commande com){
            executeopenajouter3 = false;

            col_id3.setCellValueFactory(new PropertyValueFactory<Commande, Long>("id_commande"));
            col_debut.setCellValueFactory(new PropertyValueFactory<Commande, String>("date_debut"));
            col_fin.setCellValueFactory(new PropertyValueFactory<Commande, String>("date_livraison"));
            col_etat.setCellValueFactory(new PropertyValueFactory<Commande, String>("etat"));
            col_client.setCellValueFactory(new PropertyValueFactory<Commande, Long>("client"));
            mytable3.setItems(this.getLikeCommandes2(com));
        }
    @FXML
    public static ObservableList<Commande> getDataCommandes(){
        CommandDAO commandDAO = null;

        ObservableList<Commande> listfx = FXCollections.observableArrayList();

        try {
            commandDAO = new CommandDAO();
            for (Commande ettemp : commandDAO.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx;
    }
    @FXML
    public ObservableList<Commande> getLikeCommandes(){

        CommandDAO commandDAO = null;
        Commande com = new Commande();
        com.setId_commande(Long.parseLong(search3.getText()));
        ObservableList<Commande> listfx = FXCollections.observableArrayList();

        try {
            commandDAO = new CommandDAO();
            for (Commande ettemp : commandDAO.getLike(com))
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listfx;
    }
    @FXML
    public ObservableList<Commande> getLikeCommandes2( Commande com ){

        CommandDAO commandDAO = null;
        ObservableList<Commande> listfx = FXCollections.observableArrayList();

        try {
            commandDAO = new CommandDAO();
            for (Commande ettemp : commandDAO.getLike(com))
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
