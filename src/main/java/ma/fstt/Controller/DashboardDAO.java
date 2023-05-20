package ma.fstt.Controller;

import ma.fstt.model.Dashboard;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DashboardDAO extends BaseDAO<Dashboard> {
    public DashboardDAO() throws SQLException {

        super();
    }
    @Override
    public void save(Dashboard object) throws SQLException {

        String request = "insert into dashboard ( id_commande , id_Liv, id_prod) values ( ? , ?, ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        //
        this.preparedStatement.setLong(1 , object.getId_commande());
        this.preparedStatement.setLong(2 , object.getId_livreur());
        this.preparedStatement.setLong(3 , object.getId_produit());

        this.preparedStatement.execute();
    }

    @Override
    public void update(Dashboard object) throws SQLException {
        String request = "UPDATE dashboard SET id_livr = ?, id_prod = ? WHERE id_commande = ?";

        this.preparedStatement = this.connection.prepareStatement(request);

        this.preparedStatement.setLong(1, object.getId_livreur());
        this.preparedStatement.setLong(2 , object.getId_produit());
        this.preparedStatement.setLong(3,object.getId_commande());

        this.preparedStatement.execute();
    }

    @Override
    public void delete(Dashboard object) throws SQLException {
        String request = "DELETE FROM dashboard WHERE id_commande = ?";

        this.preparedStatement = this.connection.prepareStatement(request);
        this.preparedStatement.setLong(1,object.getId_commande());
        this.preparedStatement.execute();
    }

    @Override
    public List<Dashboard> getAll()  throws SQLException {

        List<Dashboard> mylist4 = new ArrayList<Dashboard>();

        String request = "select * from dashboard ";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

        while ( this.resultSet.next()){
            mylist4.add(new Dashboard(this.resultSet.getLong(1), this.resultSet.getLong(2),this.resultSet.getLong(3)));
        }
        return mylist4;
    }
    @Override
    public List<Dashboard> getLike(Dashboard object)  throws SQLException {

        List<Dashboard> mylist4 = new ArrayList<Dashboard>();

        String request = "select * from dashboard where id_commande = "+object.getId_commande()+"";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

        while ( this.resultSet.next()){
            mylist4.add(new Dashboard(this.resultSet.getLong(1), this.resultSet.getLong(2),this.resultSet.getLong(3)));
        }
        return mylist4;
    }
    @Override
    public Dashboard getOne(Long id) throws SQLException {
        return null;
    }
}
