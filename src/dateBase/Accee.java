package dateBase;

import sample.AllApprenant;

import java.sql.*;
import java.util.ArrayList;

public class Accee extends BD {

    public static boolean setAccee(int matricule, int numF) {
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("insert into accee(matricule, numF) values(?,?)");
        ) {
            pr.setInt(1, matricule);
            pr.setInt(2, numF);
            pr.execute();
            System.out.println("Apprenant est autorisé dans la formation");
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;


    }

    public static ArrayList<AllApprenant> getApprenant(int numF) {
        ArrayList<AllApprenant> alp = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select matricule,nom,prenom,specialite from apprenant where matricule in (select matricule from accee where numF=?)");
        ) {
            pr.setInt(1, numF);
            ResultSet r = pr.executeQuery();
            while (r.next()) {
                alp.add(new AllApprenant(r.getInt("matricule"), r.getString("nom"), r.getString("prenom"), r.getString("specialite")));
            }
            return alp;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public static void supprimerApprenant(int matricule) {
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("delete from accee where matricule=?");
        ) {
            pr.setInt(1, matricule);
            pr.execute();

            System.out.println("Suppression apprenant effectué");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<String> getFrmAccee(int matricule) {
        ArrayList<String> f = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select nomF from formation where numF in(select numF from accee where matricule=?)");
        ) {

            pr.setInt(1, matricule);
            ResultSet r = pr.executeQuery();
            while (r.next()) {
                f.add(r.getString("nomF"));
            }
            return f;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}