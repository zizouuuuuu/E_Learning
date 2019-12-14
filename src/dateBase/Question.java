package dateBase;

import Model.Questions;

import java.sql.*;
import java.util.ArrayList;

public class Question extends BD {
    public static void setQuestion(int idQuiz,String q,String r,String c1,String c2,String c3,String c4){
    try (
            Connection con = connect();
        PreparedStatement pr = con.prepareStatement("insert into Question (question,reponse,choix1,choix2,choix3,choix4,idQuiz)values (?,?,?,?,?,?,?)");
    ){

        pr.setString(1,q);
        pr.setString(2,r);
        pr.setString(3,c1);
        pr.setString(4,c2);
        pr.setString(5,c3);
        pr.setString(6,c4);
        pr.setInt(7,idQuiz);
        pr.execute();
        System.out.println("Insertion question faite");

    }catch (SQLException e){
     System.out.println(e.getMessage());
    }
    }

    public static ArrayList<Questions> getQestQuiz(int idQuiz) {
        ArrayList<Questions> q = new ArrayList<>();
        try (
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("select idQst,question,reponse,choix1,choix2,choix3,choix4 from Question where idQuiz=?");
        ) {
            pr.setInt(1, idQuiz);
            System.out.println(idQuiz);
            ResultSet r = pr.executeQuery();
            while (r.next()) {
                q.add(new Questions(r.getInt("idQst"), r.getString("question"), r.getString("reponse"), r.getString("choix1"), r.getString("choix2"), r.getString("choix3"), r.getString("choix4"), idQuiz));

            }
            System.out.println("Selection faite");
            return q;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
