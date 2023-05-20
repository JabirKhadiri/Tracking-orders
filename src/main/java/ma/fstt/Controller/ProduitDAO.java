package ma.fstt.Controller;

import ma.fstt.model.Produit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO extends BaseDAO<Produit> {
    public ProduitDAO() throws SQLException {

        super();
    }
    @Override
    public void save(Produit object) throws SQLException {

        String request = "insert into produit (Nom_prod , description, Prix) values (? , ? , ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getNom_prod());
        this.preparedStatement.setString(2 , object.getDescription());
        this.preparedStatement.setDouble(3 , object.getPrix());

        this.preparedStatement.execute();
    }

    @Override
    public void update(Produit object) throws SQLException {
        String request = "UPDATE produit SET Nom_prod = ?, description = ?, Prix = ? WHERE id_prod = ?";

        this.preparedStatement = this.connection.prepareStatement(request);

        this.preparedStatement.setString(1 , object.getNom_prod());
        this.preparedStatement.setString(2 , object.getDescription());
        this.preparedStatement.setDouble(3, object.getPrix());
        this.preparedStatement.setLong(4,object.getId_prod());

        this.preparedStatement.execute();
    }

    @Override
    public void delete(Produit object) throws SQLException {
        String request = "DELETE FROM produit WHERE id_prod = ?";

        this.preparedStatement = this.connection.prepareStatement(request);
        this.preparedStatement.setLong(1,object.getId_prod());
        this.preparedStatement.execute();
    }

    @Override
    public List<Produit> getAll()  throws SQLException {

        List<Produit> mylist2 = new ArrayList<Produit>();

        String request = "select * from produit ";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            mylist2.add(new Produit(this.resultSet.getLong(1) ,
                    this.resultSet.getString(2) , this.resultSet.getString(3), this.resultSet.getDouble(4)));

        }

        return mylist2;
}
    @Override
    public List<Produit> getLike(Produit object)  throws SQLException {

        List<Produit> mylist2 = new ArrayList<Produit>();

        String request = "select * from produit where id_prod = "+object.getId_prod()+"";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

        while ( this.resultSet.next()){
            mylist2.add(new Produit(this.resultSet.getLong(1) ,
                    this.resultSet.getString(2) , this.resultSet.getString(3), this.resultSet.getDouble(4)));
        }
        return mylist2;
    }

    @Override
    public Produit getOne(Long id) throws SQLException {
        return null;
    }
}
