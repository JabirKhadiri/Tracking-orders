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
        import ma.fstt.Controller.ProduitDAO;
        import ma.fstt.model.Produit;
        import ma.fstt.trackingl.HelloApplication;
        import java.io.IOException;
        import java.net.URL;
        import java.sql.SQLException;
        import java.util.ResourceBundle;

public class ProduitController implements Initializable {

    private static boolean executeopenajouter2 = true;
    private static Long ID2;
    private static String Nom2;
    private static Double Prix;
    private static String Description;
    @FXML
    private TextField search2;
    @FXML
    private TextField nom_prod;
    @FXML
    private TextField prix;
    @FXML
    private TextField desc;
    @FXML
    private TextField id2;
    @FXML
    private TextField nom_prod2;
    @FXML
    private TextField prix2;
    @FXML
    private TextField desc2;
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
            if(!prix.getText().isEmpty() || !desc.getText().isEmpty() || !nom_prod.getText().isEmpty()){
                ProduitDAO produitDAO = new ProduitDAO();

                Produit pro = new Produit(0l, nom_prod.getText(), desc.getText(), Double.parseDouble(prix.getText()));

                produitDAO.save(pro);

                UpdateTable();
                close(event);
            }}
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    private void onUpdateButton(Event e) throws SQLException {
        executeopenajouter2 = false;
        if(!nom_prod2.getText().isEmpty() || !prix2.getText().isEmpty() || !desc2.getText().isEmpty()){
            ProduitDAO produitDAO = new ProduitDAO();
            Produit pro = new Produit();
            pro.setNom_prod(nom_prod2.getText());
            pro.setDescription(desc2.getText());
            pro.setPrix(Double.parseDouble(prix2.getText()));
            pro.setId_prod(ID2);

            produitDAO.update(pro);
            close(e);
        }
    }
    @FXML
    public void clickTable(Event e) throws IOException {
        executeopenajouter2 = false;
        Produit pro = (Produit) mytable2.getSelectionModel().getSelectedItem();
        Nom2 = pro.getNom_prod();
        Prix = pro.getPrix();
        ID2=pro.getId_prod();
        Description = pro.getDescription();
        openUpdate(e);
    }
    @FXML
    public void openSupprimer(Event e) throws IOException {
        executeopenajouter2 = false;
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SupprimerProduit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 288);
        newStage.setScene(scene);
        newStage.show();
    }
    @FXML
    public void openUpdate(Event e) throws IOException {
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateProduit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 379);
        newStage.setScene(scene);
        newStage.show();
    }
    @FXML
    public void onDeleteButton(Event e) throws SQLException {
        executeopenajouter2 = false;
        if(!id2.getText().isEmpty()){
            ProduitDAO produitDAO = new ProduitDAO();
            Produit pro = new Produit();
            pro.setId_prod(Long.parseLong(id2.getText()));
            produitDAO.delete(pro);
            close(e);
        }
    }
    @FXML
    public void openajouter() throws IOException {
        executeopenajouter2 = false;
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AjouterProduit.fxml"));
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
    public void clear(){
        if (!nom_prod2.getText().isEmpty() && !prix2.getText().isEmpty() && !desc2.getText().isEmpty()) {
            nom_prod2.setText("");
            prix2.setText("");
            desc2.setText("");
        }
    }
    @FXML
    public void clear2(){
        if (!nom_prod.getText().isEmpty() && !prix.getText().isEmpty() && !desc.getText().isEmpty()) {
            nom_prod.setText("");
            prix.setText("");
            desc.setText("");
        }
    }
    @FXML
    public void clear3(){
        if (!id2.getText().isEmpty()) {
            id2.setText("");
        }
    }


    public void refresh(){
        executeopenajouter2 = true;
        UpdateTable();
    }
    @FXML
    private void UpdateTable(){
        if(executeopenajouter2) {
            col_id2.setCellValueFactory(new PropertyValueFactory<Produit, Long>("id_prod"));
            col_nom2.setCellValueFactory(new PropertyValueFactory<Produit, String>("Nom_prod"));
            col_prix.setCellValueFactory(new PropertyValueFactory<Produit, Double>("Prix"));
            col_desc.setCellValueFactory(new PropertyValueFactory<Produit, String>("description"));
            mytable2.setItems(this.getDataProduits());
        }
    }
    @FXML
    private void UpdateTable2(){
        if (!search2.getText().isEmpty()){
            executeopenajouter2 = false;
            col_id2.setCellValueFactory(new PropertyValueFactory<Produit, Long>("id_prod"));
            col_nom2.setCellValueFactory(new PropertyValueFactory<Produit, String>("Nom_prod"));
            col_prix.setCellValueFactory(new PropertyValueFactory<Produit, Double>("Prix"));
            col_desc.setCellValueFactory(new PropertyValueFactory<Produit, String>("description"));

            mytable2.setItems(this.getLikeDataProduits());
            search2.setText("");
        }}
    @FXML
    public static ObservableList<Produit> getDataProduits(){
        ProduitDAO produitDAO = null;

        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            produitDAO = new ProduitDAO();
            for (Produit ettemp : produitDAO.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx;
    }
    @FXML
    public ObservableList<Produit> getLikeDataProduits(){

        ProduitDAO produitDAO = null;
        Produit pro = new Produit();
        pro.setId_prod(Long.parseLong(search2.getText()));
        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            produitDAO = new ProduitDAO();
            for (Produit ettemp : produitDAO.getLike(pro))
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