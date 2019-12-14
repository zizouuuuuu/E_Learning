package dateBase;

import Model.Quizs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Quiz extends BD {

    public static ArrayList<String> getQuiz(int numF){
        ArrayList<String> q = new ArrayList<>();

        try(
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select nomQ from Quiz where numF=?");
                ){
            pr.setInt(1,numF);

            ResultSet r = pr.executeQuery();

            while(r.next()){
                q.add(r.getString("nomQ"));
            }
            return q;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return null;

    }


    public static int getIdQuiz(String q){
        try(
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select idQuiz from Quiz where nomQ=?");
        ){
        pr.setString(1,q);
        ResultSet r = pr.executeQuery();
        if(r.next()){
            System.out.println("IdQuiz retourné");
            return r.getInt("idQuiz");
        }

        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public static void ajouterQuiz(String nomQ,int numF){
        try(
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("insert into Quiz(nomQ,numF)values (?,?)");
                ){
            pr.setString(1,nomQ);
            pr.setInt(2,numF);
            pr.execute();
            System.out.println("Ajout du quiz effectué");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void supprimerQuiz(int idQuiz){
        try(
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("delete from Question where idQuiz=?");
                PreparedStatement pr = con.prepareStatement("delete from Quiz where idQuiz=?");
        ){
            p.setInt(1,idQuiz);
            p.execute();

            pr.setInt(1,idQuiz);
            pr.execute();
            System.out.println("Suppression du quiz et ses questions effectué");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void setReponseApp(int idQuiz, int matricule, int note){
        try(
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("insert into suivi(idQuiz,matricule,note) values(?,?,?)");
        ){
            pr.setInt(1,idQuiz);
            pr.setInt(2,matricule);
            pr.setInt(3,note);
            pr.execute();
            System.out.println("Insertion de la note de l'étudiant faite");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

	
	
}
