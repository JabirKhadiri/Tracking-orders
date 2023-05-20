
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

        import ma.fstt.Controller.DashboardDAO;
        import ma.fstt.model.Commande;
        import ma.fstt.model.Dashboard;
        import ma.fstt.model.Livreur;
        import ma.fstt.model.Produit;
        import ma.fstt.trackingl.HelloApplication;
        import java.io.IOException;
        import java.net.URL;
        import java.sql.SQLException;
        import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    private static boolean executeopenajouter4 = true;
    @FXML
    private TextField search4;
    @FXML
    private TextField id_Com;
    @FXML
    private TextField id_Prod;
    @FXML
    private TextField id_Liv;
    @FXML
    private TextField id4;
    @FXML
    private TableView<Dashboard> mytable4 ;
    @FXML
    private TableColumn<Dashboard ,Long> col_idLiv ;
    @FXML
    private TableColumn <Dashboard ,Long> col_idCom ;
    @FXML
    private TableColumn <Dashboard ,Long> col_idProd ;
    @FXML
    private Button livreurs;
    @FXML
    private Button commandes;
    @FXML
    private Button dashboard;
    @FXML
    private Button produits;
    @FXML
    private TableView<Produit> mytable2 ;
    @FXML
    private TableColumn<Produit ,Long> col_id2 ;
    @FXML
    private TableColumn <Produit ,String> col_nom2 ;
    @FXML
    private TableColumn <Produit ,Double> col_prix ;
    @FXML
    private TableColumn <Produit ,String> col_desc ;
    @FXML
    private TableView<Livreur> mytable ;
    @FXML
    private TableColumn<Livreur ,Long> col_id ;
    @FXML
    private TableColumn <Livreur ,String> col_nom ;
    @FXML
    private TableColumn <Livreur ,String> col_tele ;
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

    /*@FXML
    private void onSaveButtonClick(ActionEvent event)  {
        try {
            // accees a la bdd
            if(!id_Com.getText().isEmpty() && !id_Prod.getText().isEmpty() && !id_Liv.getText().isEmpty()){
                DashboardDAO dashboardDAO = new DashboardDAO();

                Dashboard dash = new Dashboard( Long.parseLong(id_Com.getText()), Long.parseLong(id_Liv.getText()), Long.parseLong(id_Prod.getText()));

                dashboardDAO.save(dash);

                UpdateTable();
                close(event);
            }}
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }*/
    /*@FXML
    private void onUpdateButton(Event e) throws SQLException {
        executeopenajouter4 = false;
        if(!id_Liv2.getText().isEmpty() || !id_Prod2.getText().isEmpty()){
            DashboardDAO dashboardDAO = new DashboardDAO();
            Dashboard dash = new Dashboard();
            dash.setId_livreur(date_debut2.getText());
            dash.setDate_livraison(date_fin.getText());
            dash.setEtat(etat2.getText());
            dash.setClient(Long.parseLong(client2.getText()));
            dash.setId_commande(ID3);

            commandDAO.update(com);
            close(e);
        }
    }*/
  @FXML
    public void clickTable(Event e) throws IOException {
        executeopenajouter4 = false;
        Dashboard dash = (Dashboard) mytable4.getSelectionModel().getSelectedItem();
        Commande com = new Commande();
        com.setId_commande(dash.getId_commande());
        CommandeController commandeController = new CommandeController();
        commandeController.UpdateTable3(com);
    }
    /*@FXML
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
    }*/
    /*@FXML
    public void openajouter() throws IOException {
        executeopenajouter4 = false;
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AjouterInDashborad.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 370);
        newStage.setScene(scene);
        newStage.show();
    }*/
    public void close(Event e) {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
   /* @FXML
    public void clear2(){
        if (!date_debut2.getText().isEmpty() && !client2.getText().isEmpty() && !etat2.getText().isEmpty() && !date_fin.getText().isEmpty()) {
            date_debut2.setText("");
            client2.setText("");
            etat2.setText("");
            date_fin.setText("");
        }
    }*/
    @FXML
    public void clear(){
        if (!id_Prod.getText().isEmpty() || !id_Liv.getText().isEmpty() || !id_Com.getText().isEmpty()) {
            id_Prod.setText("");
            id_Liv.setText("");
            id_Com.setText("");
        }
    }
    /*@FXML
    public void clear3(){
        if (!id3.getText().isEmpty()) {
            id3.setText("");
        }
    }*/


    public void refresh(){
        executeopenajouter4 = true;
        UpdateTable();
    }
    @FXML
    private void UpdateTable(){
        if(executeopenajouter4) {
            col_idCom.setCellValueFactory(new PropertyValueFactory<Dashboard, Long>("id_commande"));
            col_idLiv.setCellValueFactory(new PropertyValueFactory<Dashboard, Long>("id_livreur"));
            col_idProd.setCellValueFactory(new PropertyValueFactory<Dashboard, Long>("id_produit"));
            mytable4.setItems(this.getDataDashboard());
        }
    }
    @FXML
    private void UpdateTable2(){
        if (!search4.getText().isEmpty()){
            executeopenajouter4 = false;
            col_idCom.setCellValueFactory(new PropertyValueFactory<Dashboard, Long>("id_commande"));
            col_idLiv.setCellValueFactory(new PropertyValueFactory<Dashboard, Long>("id_livreur"));
            col_idProd.setCellValueFactory(new PropertyValueFactory<Dashboard, Long>("id_produit"));
            mytable4.setItems(this.getLike());
            search4.setText("");
        }}
    @FXML
    public static ObservableList<Dashboard> getDataDashboard(){
        DashboardDAO dashboardDAO = null;

        ObservableList<Dashboard> listfx = FXCollections.observableArrayList();

        try {
            dashboardDAO = new DashboardDAO();
            for (Dashboard ettemp : dashboardDAO.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx;
    }
    @FXML
    public ObservableList<Dashboard> getLike(){

        DashboardDAO dashboardDAO = null;
        Dashboard dash = new Dashboard();
        dash.setId_commande(Long.parseLong(search4.getText()));
        ObservableList<Dashboard> listfx = FXCollections.observableArrayList();

        try {
            dashboardDAO = new DashboardDAO();
            for (Dashboard ettemp : dashboardDAO.getLike(dash))
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
        } else if (e.getSource() == dashboard) {
            homeController.openDashboard(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();

    }

}
