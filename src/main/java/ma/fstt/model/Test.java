package ma.fstt.model;

import ma.fstt.Controller.CommandDAO;
import ma.fstt.Controller.LivreurDAO;

import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) {

// trait bloc try catch
        try {


            CommandDAO commandDAO = new CommandDAO();
          //  Livreur liv = new Livreur(0l , "liv3" , "200000000");

            //livreurDAO.save(liv);

            //Livreur liv2 = new Livreur(0l , "liv2" , "100000000");


           // livreurDAO.save(liv2);


          List<Commande> livlist =  commandDAO.getAll();

            for (Commande com :livlist) {

                System.out.println(com.toString());

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
