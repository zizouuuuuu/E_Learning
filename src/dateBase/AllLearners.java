
package dateBase;

import Model.Apprenant;
import sample.AllApprenant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllLearners extends BD {

    public static ArrayList<AllApprenant> diplayAll(){
        ArrayList<AllApprenant> app = new ArrayList<>();
        try(
                Connection com = connect();

                PreparedStatement pr = connect().prepareStatement("select matricule,nom,prenom,specialite from apprenant");
                ){
            ResultSet r = pr.executeQuery();
                while(r.next()) app.add(new AllApprenant(r.getInt("matricule"),r.getString("nom"), r.getString("prenom"), r.getString("specialite")));
            return app;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static int getMatricule(String nom, String prenom){

        try(
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("Select matricule from apprenant where nom=? and prenom=?");
                ){
            pr.setString(1,nom);
            pr.setString(2,prenom);
            ResultSet r = pr.executeQuery();

            if(r.next()) return r.getInt("matricule");


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

}
