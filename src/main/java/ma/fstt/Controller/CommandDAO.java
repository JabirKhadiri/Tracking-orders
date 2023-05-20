package ma.fstt.Controller;

import ma.fstt.model.Commande;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandDAO extends BaseDAO<Commande> {
    public CommandDAO() throws SQLException {

        super();
    }
    @Override
    public void save(Commande object) throws SQLException {

        String request = "insert into commande ( date_debut , date_livr, etat, client) values ( ? , ?, ?, ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        //
        this.preparedStatement.setString(1 , object.getDate_debut());
        this.preparedStatement.setString(2 , object.getDate_livraison());
        this.preparedStatement.setString(3 , object.getEtat());
        this.preparedStatement.setLong(4,  object.getClient());

        this.preparedStatement.execute();
    }

    @Override
    public void update(Commande object) throws SQLException {
        String request = "UPDATE commande SET date_debut = ?, date_livr = ?, etat = ?, client = ? WHERE id_commande = ?";

        this.preparedStatement = this.connection.prepareStatement(request);

        this.preparedStatement.setString(1 , object.getDate_debut());
        this.preparedStatement.setString(2, object.getDate_livraison());
        this.preparedStatement.setString(3 , object.getEtat());
        this.preparedStatement.setLong(4, object.getClient());
        this.preparedStatement.setLong(5,object.getId_commande());

        this.preparedStatement.execute();
    }

    @Override
    public void delete(Commande object) throws SQLException {
        String request = "DELETE FROM commande WHERE id_commande = ?";

        this.preparedStatement = this.connection.prepareStatement(request);
        this.preparedStatement.setLong(1,object.getId_commande());
        this.preparedStatement.execute();
    }

    @Override
    public List<Commande> getAll()  throws SQLException {

        List<Commande> mylist3 = new ArrayList<Commande>();

        String request = "select * from commande ";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

        while ( this.resultSet.next()){
            mylist3.add(new Commande(this.resultSet.getLong(1), this.resultSet.getString(2),
                    this.resultSet.getString(3), this.resultSet.getString(4), this.resultSet.getLong(5)));
        }
        return mylist3;
    }
    @Override
    public List<Commande> getLike(Commande object)  throws SQLException {

        List<Commande> mylist3 = new ArrayList<Commande>();

        String request = "select * from commande where id_commande = "+object.getId_commande()+"";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

        while ( this.resultSet.next()){
            mylist3.add(new Commande(this.resultSet.getLong(1), this.resultSet.getString(2) , this.resultSet.getString(3), this.resultSet.getString(4),this.resultSet.getLong(5)));
        }
        return mylist3;
    }
    @Override
    public Commande getOne(Long id) throws SQLException {
        return null;
    }

}
