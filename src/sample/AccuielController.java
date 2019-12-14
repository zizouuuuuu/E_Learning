package sample;
import Model.*;
import Model.Quizs;
import dateBase.*;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.util.Callback;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;
import java.lang.String;

public class AccuielController implements Initializable {

    @FXML
    private Pane profil, admin, prof, formationIns, app, allStudents, quiz, courQ, etud, formationApp, sondage, resultat, creeSondage;
    @FXML
    private PieChart statistics;
    @FXML
    private Parent avatar1;
    @FXML
    private TextField t1, t2, t3, t4, t5, t6, gra, special, nve, sec, nomFormation, titreCour, addQuiz;
    @FXML
    private Button modify, confirme, disco, ressourceInst, ajouterFormInst, supprimerFormInst, afficherTout, tle, ajouterEtudiant, supprimerEtudiant, supprimerCour, openFile, addFile, ajouterQuiz, supprimerQuiz;
    @FXML
    private Label id, nom, prenom, grade, spec, niv, section, numF, id_quiz, id_form;
    @FXML
    private Button modifierQuiz, retourF, confirmerQ, validerQ;
    @FXML
    private TextField ques1, rep1, ch1q1, ch2q1, ch3q1, ch4q1;
    @FXML
    private TextField ques2, rep2, ch1q2, ch2q2, ch3q2, ch4q2;
    @FXML
    private TextField ques3, rep3, ch1q3, ch2q3, ch3q3, ch4q3;
    @FXML
    private TextField ques4, rep4, ch1q4, ch2q4, ch3q4, ch4q4;
    @FXML
    private Button afficherFormApp, ouvrirCourApp, repondreQuizApp, frmApp;
    @FXML
    private CheckBox ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11, ch12, ch13, ch14, ch15, ch16;
    @FXML
    private Label note, sur20, nbPart;
    @FXML
    private TextField noteT;
    @FXML
    private ListView listFormation, listCours, listQuiz, listCoursQ, listCoursApp, listeFormApp, listQuizApp;
    @FXML
    private TableView<Cour> tableCours;
    @FXML
    private TableView<AllApprenant> tableAllStu, tableStuFor;
    @FXML
    private TableColumn<Cour, String> c1, c2;
    @FXML
    private TableColumn<AllApprenant, String> nomC, preC, specC, mat, nomC1, prenomC1, specC1, mat1;
    @FXML
    private TextField titreSnd,choix1,choix2,choix3,choix4;
    @FXML
    private CheckBox  choixBox1, choixBox3, choixBox2, choixBox4;
    @FXML
    private TextArea contenuSondage, contenuRsltSnd;
    @FXML
    private TableView<listTwoPar> tableSondages;
    @FXML
    private TableColumn<listTwoPar, String> titreSondage, createurSondage;

    private ArrayList<String> suivi = new ArrayList<>();
    @FXML private Button supprimerSondage, mtSondage, confirmerSnd, creerSnd;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setText(String.valueOf(Connecter.getIdConnected()));
        nom.setText(Connecter.getNameConnected());
        prenom.setText(Connecter.getLastNameConnected());

/*
        if(Integer.parseInt(l5.getText()) == 1 ) {
            admin.toFront();

        }*/

        if (Integer.parseInt(id.getText()) > 1 && Integer.parseInt(id.getText()) < 1000) {
            prof.toFront();
            formationIns.toFront();
            allStudents.toBack();

        }

        if (Integer.parseInt(id.getText()) > 1000 && Integer.parseInt(id.getText()) < 1000000) {
            etud.toFront();
            formationApp.toFront();
        }

        nomC.setCellValueFactory(new PropertyValueFactory<>("nom"));
        preC.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        specC.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        mat.setCellValueFactory(new PropertyValueFactory<>("matricule"));

        nomC1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomC1.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        specC1.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        mat1.setCellValueFactory(new PropertyValueFactory<>("matricule"));

        titreSondage.setCellValueFactory(new PropertyValueFactory<>("titre"));
        createurSondage.setCellValueFactory(new PropertyValueFactory<>("createur"));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void afficheProfil() {
        profil.toFront();
        if (Integer.parseInt(id.getText()) == 1) {
            ArrayList<Administrateur> ad = ProfilAdminDB.display();

            t1.setText(String.valueOf(ad.get(0).getId()));
            t2.setText(ad.get(0).getNom());
            t3.setText(ad.get(0).getPrenom());
            t4.setText("ad.get(0).getDate()");
            t5.setText(ad.get(0).getAdresse());
            t6.setText(ad.get(0).getPassword());

            grade.setVisible(false);
            gra.setVisible(false);
            spec.setVisible(false);
            special.setVisible(false);
            niv.setVisible(false);
            nve.setVisible(false);
            section.setVisible(false);
            sec.setVisible(false);

        }

        if (Integer.parseInt(id.getText()) > 1 && Integer.parseInt(id.getText()) < 1000) {

            ArrayList<Instructeur> ad = ProfilInstructorDB.display(Integer.parseInt(id.getText()));

            t1.setText(String.valueOf(ad.get(0).getId()));
            t2.setText(ad.get(0).getNom());
            t3.setText(ad.get(0).getPrenom());
            t4.setText("ad.get(0).getDate()");
            t5.setText(ad.get(0).getAdresse());
            t6.setText(ad.get(0).getPassword());
            gra.setText(ad.get(0).getGrade());
            special.setText(ad.get(0).getSpec());
            niv.setVisible(false);
            nve.setVisible(false);
            section.setVisible(false);
            sec.setVisible(false);

        }
        if (Integer.parseInt(id.getText()) > 1000 && Integer.parseInt(id.getText()) < 1000000) {
            ArrayList<Apprenant> ad = ProfilApprenantDB.display(Integer.parseInt(id.getText()));
            t1.setText(String.valueOf(ad.get(0).getMatricule()));
            t2.setText(ad.get(0).getNom());
            t3.setText(ad.get(0).getPrenom());
            t4.setText("ad.get(0).getDate()");
            t5.setText(ad.get(0).getAdresse());
            t6.setText(ad.get(0).getPassword());
            special.setText(ad.get(0).getSpec());
            grade.setVisible(false);
            gra.setVisible(false);
            nve.setText(String.valueOf(ad.get(0).getNiv()));
            sec.setText(String.valueOf(ad.get(0).getSection()));

        }
    }

    @FXML
    void modifierProfil() {

        t2.setDisable(false);
        t3.setDisable(false);
        t4.setDisable(false);
        t5.setDisable(false);
        t6.setDisable(false);
        confirme.setDisable(false);

        if (Integer.parseInt(id.getText()) > 1 && Integer.parseInt(id.getText()) < 100) {
            t1.setDisable(false);
            gra.setDisable(false);
            special.setDisable(false);
        }

        if (Integer.parseInt(id.getText()) > 100 && Integer.parseInt(id.getText()) < 1000) {
            t1.setVisible(false);
            nve.setDisable(false);
            special.setDisable(false);
            sec.setDisable(false);
        }

    }

    @FXML
    void confirmeModification() {
        if (Integer.parseInt(id.getText()) == 1)
            ProfilAdminDB.modify(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), "t4.getDate()", t5.getText(), t6.getText());

        else if (Integer.parseInt(id.getText()) > 1 && Integer.parseInt(id.getText()) < 2000) {
            ProfilInstructorDB.modify(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), "t4.getDate()", t5.getText(), t6.getText(), gra.getText(), special.getText());
            grade.setDisable(true);
            gra.setDisable(true);
            spec.setDisable(true);
            special.setDisable(true);
        } else {
            ProfilApprenantDB.modify(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), "t4.getDate()", t5.getText(), 0, t6.getText(), special.getText(), nve.getText(), sec.getText());
            ;
            spec.setDisable(true);
            special.setDisable(true);
            niv.setDisable(true);
            nve.setDisable(true);
            sec.setDisable(true);
            section.setDisable(true);
        }

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Informaton Dialog");
        a.setHeaderText("Look, an information Dialog");
        a.setContentText("Modification réussite");
        a.showAndWait();

        t2.setDisable(true);
        t3.setDisable(true);
        t4.setDisable(true);
        t5.setDisable(true);
        t6.setDisable(true);
        confirme.setDisable(true);
    }

    @FXML
    public void disconnect(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
            s.setScene(scene);
            s.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void RessourceInst(ActionEvent event) {
        formationIns.toFront();
        ArrayList<String> frm = Formations.afficherFormation(Integer.parseInt(id.getText()));
        ajouterFormInst.setDisable(false);
        supprimerFormInst.setDisable(false);
        afficherTout.setDisable(false);
        listFormation.getItems().clear();
        listCours.getItems().clear();
        listQuiz.getItems().clear();
        tableStuFor.getItems().clear();

        listFormation.getItems().addAll(frm);

    }

    @FXML
    public void setAjouterFormInst(ActionEvent event) {
        if (nomFormation.getText().isEmpty() == false) {
            listFormation.getItems().add(nomFormation.getText());
            Formations.ajouterFormation(nomFormation.getText(), Integer.parseInt(id.getText()));
            nomFormation.clear();
        }
    }

    @FXML
    public void setSupprimerFormInst(ActionEvent event) {
        Object item = listFormation.getSelectionModel().getSelectedItem();

        listFormation.getItems().remove(item);
        String s = (String) item;
        Formations.supprimerFormation(Formations.getNumF(s));
        listCours.getItems().clear();
        tableStuFor.getItems().clear();
        listQuiz.getItems().clear();
    }

    @FXML
    public void AfficherTout(ActionEvent event) {
        tableStuFor.getItems().clear();
        listCours.getItems().clear();
        listCours.getItems().clear();


        openFile.setDisable(false);
        addFile.setDisable(false);
        supprimerCour.setDisable(false);

        tle.setDisable(false);
        ajouterEtudiant.setDisable(false);
        supprimerEtudiant.setDisable(false);

        ajouterQuiz.setDisable(false);
        modifierQuiz.setDisable(false);
        supprimerQuiz.setDisable(false);

        Object item = listFormation.getSelectionModel().getSelectedItem();
        String s = (String) item;
        id_form.setText(String.valueOf(Formations.getNumF(s)));

        ArrayList<String> cour = Cours.afficherCours(Integer.parseInt(id_form.getText()));

        for (int i = 0; i < cour.size(); i++) {
            listCours.getItems().add(cour.get(i));
        }

        ArrayList<AllApprenant> alp = Accee.getApprenant(Formations.getNumF(s));
        for (int i = 0; i < alp.size(); i++) tableStuFor.getItems().add(alp.get(i));


        ArrayList<String> q = Quiz.getQuiz(Integer.parseInt(id_form.getText()));
        for (int j = 0; j < q.size(); j++) {
            listQuiz.getItems().add(q.get(j));
        }

    }

    @FXML
    public void setAllStudents(ActionEvent event) {

        allStudents.toFront();
        tableAllStu.getItems().clear();
        ArrayList<AllApprenant> app = AllLearners.diplayAll();
        for (int i = 0; i < app.size(); i++)
            tableAllStu.getItems().add(app.get(i));

    }

    @FXML
    public void setAjouterEtudiant(ActionEvent event) {
        Object o = tableAllStu.getSelectionModel().getSelectedItem();

        if (o != null) {
            tableAllStu.getItems().remove(o);
            AllApprenant a = (AllApprenant) o;
            allStudents.toBack();
            if (Accee.setAccee(a.getMatricule(), Integer.parseInt(id_form.getText()))) {
                tableStuFor.getItems().add(a);
            }
            ;

        }
    }

    @FXML
    public void setSupprimerApp(ActionEvent event) {

        Object o = tableStuFor.getSelectionModel().getSelectedItem();
        if (o != null) {
            AllApprenant item = (AllApprenant) o;
            tableStuFor.getItems().remove(o);
            Accee.supprimerApprenant(item.getMatricule());
            System.out.println("Suppression dans la table");

        }


    }

    ////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void ajouterCour(ActionEvent event) {
        if (titreCour.getText().isEmpty() == false) {
            FileChooser fc = new FileChooser();
            fc.setTitle("Open text file");
            fc.setInitialDirectory(new File(System.getProperty("user.home")));
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files ", "*.pdf"),
                    new FileChooser.ExtensionFilter("All Files ", "*.*")
            );
            File f = fc.showOpenDialog(stage);

            if (f != null) System.out.println("Choosen file " + f);
            Object o = listFormation.getSelectionModel().getSelectedItem();
            String s = (String) o;
            Cours.creerCour(titreCour.getText(), f.toString(), Integer.parseInt(id_form.getText()));
            listCours.getItems().add(titreCour.getText());
            titreCour.clear();
        }

    }

    @FXML
    public void setSupprimerCour(ActionEvent event) {

        Object o = listCours.getSelectionModel().getSelectedItem();
        if (o != null) {
            String item = (String) o;
            Cours.supprimerCour(item);
            listCours.getItems().remove(o);
            System.out.println("Cour supprimer");
        }

    }
    ///////////////////////////////////////////////

    private Stage stage;

    public void init(Stage stage) {
        this.stage = stage;

    }

    @FXML
    public void ouvrirCour(ActionEvent event) {
        try {
            Object item = listCours.getSelectionModel().getSelectedItem();
            String s = (String) item;

            String path = Cours.getPath(s);
            File f = new File(path);
            Desktop.getDesktop().open(f);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void setAjouterQuiz() {
        Object o = listFormation.getSelectionModel().getSelectedItem();
        if (o != null) {
            String s = (String) o;
            if (addQuiz.getText().isEmpty() == false) {
                listQuiz.getItems().add(addQuiz.getText());
                Quiz.ajouterQuiz(addQuiz.getText(), Integer.parseInt(id_form.getText()));
                confirmerQ.setText("Confirmer");
                id_quiz.setText(String.valueOf(Quiz.getIdQuiz(addQuiz.getText())));
                prof.setDisable(true);
                quiz.toFront();

            }
        }
    }

    boolean choixIn(String rep, String c1, String c2, String c3, String c4) {
        boolean b = false;
        if (rep.equals(c1)) return true;
        if (rep.equals(c2)) return true;
        if (rep.equals(c3)) return true;
        if (rep.equals(c4)) return true;
        return b;
    }

    @FXML
    public void confirmeQuiz(ActionEvent event) {
        if (Integer.parseInt(id.getText()) > 1 && Integer.parseInt(id.getText()) < 1000) {
            if (ques1.getText().isEmpty() == false && ques2.getText().isEmpty() == false && ques3.getText().isEmpty() == false && ques4.getText().isEmpty() == false && rep1.getText().isEmpty() == false && rep2.getText().isEmpty() == false && rep3.getText().isEmpty() == false && rep4.getText().isEmpty() == false && ch1q1.getText().isEmpty() == false && ch1q2.getText().isEmpty() == false && ch1q3.getText().isEmpty() == false && ch1q4.getText().isEmpty() == false && ch2q1.getText().isEmpty() == false && ch2q2.getText().isEmpty() == false && ch2q3.getText().isEmpty() == false && ch2q4.getText().isEmpty() == false && ch3q1.getText().isEmpty() == false && ch3q2.getText().isEmpty() == false && ch3q3.getText().isEmpty() == false && ch3q4.getText().isEmpty() == false && ch4q1.getText().isEmpty() == false && ch4q2.getText().isEmpty() == false && ch4q3.getText().isEmpty() == false && ch4q4.getText().isEmpty() == false) {
                if (choixIn(rep1.getText(), ch1q1.getText(), ch2q1.getText(), ch3q1.getText(), ch4q1.getText()) && choixIn(rep2.getText(), ch1q2.getText(), ch2q2.getText(), ch3q2.getText(), ch4q2.getText()) && choixIn(rep3.getText(), ch1q3.getText(), ch2q3.getText(), ch3q3.getText(), ch4q3.getText()) && choixIn(rep4.getText(), ch1q4.getText(), ch2q4.getText(), ch3q4.getText(), ch4q4.getText())) {
                    Question.setQuestion(Integer.parseInt(id_quiz.getText()), ques1.getText(), rep1.getText(), ch1q1.getText(), ch2q1.getText(), ch3q1.getText(), ch4q1.getText());
                    Question.setQuestion(Integer.parseInt(id_quiz.getText()), ques2.getText(), rep2.getText(), ch1q2.getText(), ch2q2.getText(), ch3q2.getText(), ch4q2.getText());
                    Question.setQuestion(Integer.parseInt(id_quiz.getText()), ques3.getText(), rep3.getText(), ch1q3.getText(), ch2q3.getText(), ch3q3.getText(), ch4q3.getText());
                    Question.setQuestion(Integer.parseInt(id_quiz.getText()), ques4.getText(), rep4.getText(), ch1q4.getText(), ch2q4.getText(), ch3q4.getText(), ch4q4.getText());
                    System.out.println("Quiz cree");
                    retourF.setDisable(false);
                } else {
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Informaton Dialog");
                    a.setHeaderText("Look, an information Dialog");
                    a.setContentText("La reponse n'existe pas dans les choix");
                    a.showAndWait();
                }

            } else {
                Alert b = new Alert(Alert.AlertType.INFORMATION);
                b.setTitle("Informaton Dialog");
                b.setHeaderText("Look, an information Dialog");
                b.setContentText("Remplissez tous les champs");
                b.showAndWait();
            }
        }

        if (Integer.parseInt(id.getText()) > 1000 && Integer.parseInt(id.getText()) < 1000000) {
            int n=0;
            if(ch1.isSelected() && rep1.getText().equals(ch1q1.getText())) n+=5;
            if(ch2.isSelected() && rep1.getText().equals(ch2q1.getText())) n+=5;
            if(ch3.isSelected() && rep1.getText().equals(ch3q1.getText())) n+=5;
            if(ch4.isSelected() && rep1.getText().equals(ch4q1.getText())) n+=5;
            if(ch5.isSelected() && rep2.getText().equals(ch1q2.getText())) n+=5;
            if(ch6.isSelected() && rep2.getText().equals(ch2q2.getText())) n+=5;
            if(ch7.isSelected() && rep2.getText().equals(ch3q2.getText())) n+=5;
            if(ch8.isSelected() && rep2.getText().equals(ch4q2.getText())) n+=5;
            if(ch9.isSelected() && rep3.getText().equals(ch1q3.getText())) n+=5;
            if(ch10.isSelected() && rep3.getText().equals(ch2q3.getText())) n+=5;
            if(ch11.isSelected() && rep3.getText().equals(ch3q3.getText())) n+=5;
            if(ch12.isSelected() && rep3.getText().equals(ch4q3.getText())) n+=5;
            if(ch13.isSelected() && rep4.getText().equals(ch1q4.getText())) n+=5;
            if(ch14.isSelected() && rep4.getText().equals(ch2q4.getText())) n+=5;
            if(ch15.isSelected() && rep4.getText().equals(ch3q4.getText())) n+=5;
            if(ch16.isSelected() && rep4.getText().equals(ch4q4.getText())) n+=5;
            System.out.println(n);
            noteT.setText(String.valueOf(n));
            note.setVisible(true);
            noteT.setVisible(true);
            sur20.setVisible(true);

            Quiz.setReponseApp(Integer.parseInt(id_quiz.getText()), Integer.parseInt(id.getText()),n);
            retourF.setDisable(false);


        }

    }

    @FXML
    private void handleBox1(ActionEvent event) {
        if (ch1.isSelected()) {
            ch2.setSelected(false);
            ch3.setSelected(false);
            ch4.setSelected(false);
        }
    }

    @FXML
    private void handleBox2(ActionEvent event) {
        if (ch2.isSelected()) {
            ch1.setSelected(false);
            ch3.setSelected(false);
            ch4.setSelected(false);
        }
    }

    @FXML
    private void handleBox3(ActionEvent event) {
        if (ch3.isSelected()) {
            ch2.setSelected(false);
            ch1.setSelected(false);
            ch4.setSelected(false);
        }
    }

    @FXML
    private void handleBox4(ActionEvent event) {
        if (ch4.isSelected()) {
            ch2.setSelected(false);
            ch3.setSelected(false);
            ch1.setSelected(false);
        }
    }

    @FXML
    private void handleBox5(ActionEvent event) {
        if (ch5.isSelected()) {
            ch6.setSelected(false);
            ch7.setSelected(false);
            ch8.setSelected(false);
        }
    }

    @FXML
    private void handleBox6(ActionEvent event) {
        if (ch6.isSelected()) {
            ch5.setSelected(false);
            ch7.setSelected(false);
            ch8.setSelected(false);
        }
    }

    @FXML
    private void handleBox7(ActionEvent event) {
        if (ch7.isSelected()) {
            ch5.setSelected(false);
            ch6.setSelected(false);
            ch8.setSelected(false);
        }
    }

    @FXML
    private void handleBox8(ActionEvent event) {
        if (ch8.isSelected()) {
            ch5.setSelected(false);
            ch6.setSelected(false);
            ch7.setSelected(false);
        }
    }



    @FXML private void handleBox9(ActionEvent event) {
        if (ch9.isSelected()) {
            ch10.setSelected(false);
            ch11.setSelected(false);
            ch12.setSelected(false);
        }
    }
    @FXML private void handleBox10(ActionEvent event) {
        if (ch10.isSelected()) {
            ch9.setSelected(false);
            ch11.setSelected(false);
            ch12.setSelected(false);
        }
    }
    @FXML private void handleBox11(ActionEvent event) {
        if (ch11.isSelected()) {
            ch9.setSelected(false);
            ch10.setSelected(false);
            ch12.setSelected(false);
        }
    }
    @FXML private void handleBox12(ActionEvent event){
        if(ch12.isSelected()){
            ch9.setSelected(false); ch10.setSelected(false); ch11.setSelected(false);
        }
    }

    @FXML private void handleBox13(ActionEvent event) {
        if (ch13.isSelected()) {
            ch14.setSelected(false);
            ch15.setSelected(false);
            ch16.setSelected(false);
        }
    }
    @FXML private void handleBox14(ActionEvent event) {
        if (ch14.isSelected()) {
            ch13.setSelected(false);
            ch15.setSelected(false);
            ch16.setSelected(false);
        }
    }
    @FXML private void handleBox15(ActionEvent event) {
        if (ch15.isSelected()) {
            ch13.setSelected(false);
            ch14.setSelected(false);
            ch16.setSelected(false);
        }
    }
    @FXML private void handleBox16(ActionEvent event){
        if(ch16.isSelected()){
            ch13.setSelected(false); ch14.setSelected(false); ch15.setSelected(false);
        }
    }



    @FXML void retourToForm(ActionEvent event){
        prof.setDisable(false);
        prof.toFront();
        formationIns.toFront();
    }

    @FXML public void setSupprimerQuiz(ActionEvent event){
        Object o = listQuiz.getSelectionModel().getSelectedItem();
        if(o != null){
            String s1 = (String)o;
            id_quiz.setText(String.valueOf(Quiz.getIdQuiz(s1)));
            Quiz.supprimerQuiz(Integer.parseInt(id_quiz.getText()));
            listQuiz.getItems().remove(o);
            System.out.println("Suppression quiz table");

        }
    }

    @FXML public void setModifierQuiz(ActionEvent event){
        Object o = listQuiz.getSelectionModel().getSelectedItem();
        if(o != null){
                    prof.setDisable(true);
                    retourF.setDisable(false);
                String s = (String)o;
                id_quiz.setText(String.valueOf(Quiz.getIdQuiz(s)));

                ArrayList<Questions> q = Question.getQestQuiz(Integer.parseInt(id_quiz.getText()));
                quiz.toFront();
                ques1.setText(q.get(0).getQ());
                rep1.setText(q.get(0).getR());
                ch1q1.setText(q.get(0).getC1());
                ch2q1.setText(q.get(0).getC2());
                ch3q1.setText(q.get(0).getC3());
                ch4q1.setText(q.get(0).getC4());
            ques2.setText(q.get(1).getQ());
            rep2.setText(q.get(1).getR());
            ch1q2.setText(q.get(1).getC1());
            ch2q2.setText(q.get(1).getC2());
            ch3q2.setText(q.get(1).getC3());
            ch4q2.setText(q.get(1).getC4());
                                ques3.setText(q.get(2).getQ());
                                rep3.setText(q.get(2).getR());
                                ch1q3.setText(q.get(2).getC1());
                                ch2q3.setText(q.get(2).getC2());
                                ch3q3.setText(q.get(2).getC3());
                                ch4q3.setText(q.get(2).getC4());
                                    ques4.setText(q.get(3).getQ());
                                    rep4.setText(q.get(3).getR());
                                    ch1q4.setText(q.get(3).getC1());
                                    ch2q4.setText(q.get(3).getC2());
                                    ch3q4.setText(q.get(3).getC3());
                                    ch4q4.setText(q.get(3).getC4());
        }

    }

    @FXML public void setFrmApp(ActionEvent event){
        formationApp.toFront();
        listeFormApp.getItems().clear();
        listCoursApp.getItems().clear();
        listQuizApp.getItems().clear();
        ArrayList<String> f = Accee.getFrmAccee(Integer.parseInt(id.getText()));
        listeFormApp.getItems().addAll(f);
        afficherFormApp.setDisable(false);

    }

    @FXML public void setAfficherFormApp(ActionEvent event){
        Object o = listeFormApp.getSelectionModel().getSelectedItem();
        if(o != null){
            listCoursApp.getItems().clear();
            listQuizApp.getItems().clear();
            String s = (String)o;
            id_form.setText(String.valueOf(Formations.getNumF(s)));
            System.out.println(s+" " +id_form.getText());
            ArrayList<String> c = Cours.afficherCours(Integer.parseInt(id_form.getText()));
            for(int i=0; i<c.size(); i++){
                listCoursApp.getItems().add(c.get(i));
            }
            ouvrirCourApp.setDisable(false);

            ArrayList<String> q = Quiz.getQuiz(Integer.parseInt(id_form.getText()));
            for(int i=0; i<q.size(); i++){
                listQuizApp.getItems().add(q.get(i));
            }
            repondreQuizApp.setDisable(false);
        }

    }

    @FXML public void setOuvrirCourApp(ActionEvent event){
        try {
            Object o = listCoursApp.getSelectionModel().getSelectedItem();
            if (o != null) {
                String s = (String) o;
                String path = Cours.getPath(s);
                File f = new File(path);
                Desktop.getDesktop().open(f);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());

        }

    }

    @FXML public void setRepondreQuizApp(ActionEvent event){
        Object o = listQuizApp.getSelectionModel().getSelectedItem();
        if(o != null){
            String s = (String)o;
            id_quiz.setText(String.valueOf(Quiz.getIdQuiz(s)));
            quiz.toFront();
            courQ.toFront();
            confirmerQ.setText("Valider");
            ArrayList<Questions> q = Question.getQestQuiz(Integer.parseInt(id_quiz.getText()));
            ques1.setText(q.get(0).getQ()); ques1.setEditable(false);
            rep1.setText(q.get(0).getR());  rep1.setVisible(false);
            ch1q1.setText(q.get(0).getC1()); ch1q1.setEditable(false);
            ch2q1.setText(q.get(0).getC2());   ch2q1.setEditable(false);
            ch3q1.setText(q.get(0).getC3());   ch3q1.setEditable(false);
            ch4q1.setText(q.get(0).getC4());   ch4q1.setEditable(false);
            ques2.setText(q.get(1).getQ());  ques2.setEditable(false);
            rep2.setText(q.get(1).getR());   rep2.setVisible(false);
            ch1q2.setText(q.get(1).getC1());  ch1q2.setEditable(false);
            ch2q2.setText(q.get(1).getC2());  ch2q2.setEditable(false);
            ch3q2.setText(q.get(1).getC3());  ch3q2.setEditable(false);
            ch4q2.setText(q.get(1).getC4());  ch4q2.setEditable(false);
            ques3.setText(q.get(2).getQ());   ques3.setEditable(false);
            rep3.setText(q.get(2).getR());   rep3.setVisible(false);
            ch1q3.setText(q.get(2).getC1());  ch1q3.setEditable(false);
            ch2q3.setText(q.get(2).getC2());   ch2q3.setEditable(false);
            ch3q3.setText(q.get(2).getC3()); ch3q3.setEditable(false);
            ch4q3.setText(q.get(2).getC4());   ch4q3.setEditable(false);
            ques4.setText(q.get(3).getQ());  ques4.setEditable(false);
            rep4.setText(q.get(3).getR());   rep4.setVisible(false);
            ch1q4.setText(q.get(3).getC1());  ch1q4.setEditable(false);
            ch2q4.setText(q.get(3).getC2());   ch2q4.setEditable(false);
            ch3q4.setText(q.get(3).getC3()); ch3q4.setEditable(false);
            ch4q4.setText(q.get(3).getC4());   ch4q4.setEditable(false);

            ch1.setVisible(true);
            ch2.setVisible(true);
            ch3.setVisible(true);
            ch4.setVisible(true);
            ch5.setVisible(true);
            ch6.setVisible(true);
            ch7.setVisible(true);
            ch8.setVisible(true);
            ch9.setVisible(true);
            ch10.setVisible(true);
            ch11.setVisible(true);
            ch12.setVisible(true);
            ch13.setVisible(true);
            ch14.setVisible(true);
            ch15.setVisible(true);
            ch16.setVisible(true);

            ArrayList<String> c = Cours.afficherCours(Integer.parseInt(id_form.getText()));
            listCoursQ.getItems().clear();
            for(int i=0;i<c.size(); i++){
                listCoursQ.getItems().add(c.get(i));
            }

        }
    }



    @FXML public void ouvrirCourQ(ActionEvent event){
        try {
            Object o = listCoursQ.getSelectionModel().getSelectedItem();
            if (o != null) {
                String s = (String) o;
                String path = Cours.getPath(s);
              File f = new File(path);
              Desktop.getDesktop().open(f);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());

        }
    }

    @FXML public void sondage(ActionEvent event){
        sondage.toFront();
        creeSondage.setVisible(false);
        resultat.setVisible(false);
        ArrayList<listTwoPar> s = SondageBD.afficherSondage();

        for(int i=0; i<s.size(); i++)
            tableSondages.getItems().add(s.get(i));

    }

    @FXML public void creeSnd(){
        titreSnd.setEditable(true);
        contenuSondage.setEditable(true);
        choix1.setEditable(true);choix2.setEditable(true);choix3.setEditable(true);choix4.setEditable(true);
        choixBox1.setVisible(false);choixBox2.setVisible(false);choixBox3.setVisible(false);choixBox4.setVisible(false);
        creeSondage.setVisible(true);
        creerSnd.setVisible(true);
    }

    @FXML public void setCreeSondage(){
        if (titreSnd.getText().isEmpty()==false && contenuSondage.getText().isEmpty()==false && choix1.getText().isEmpty()== false && choix2.getText().isEmpty()== false && choix3.getText().isEmpty()== false && choix4.getText().isEmpty() == false) {

            SondageBD.creerSondage(titreSnd.getText(), contenuSondage.getText(), choix1.getText(), choix2.getText(), choix3.getText(), choix4.getText(), Integer.parseInt(id.getText()), nom.getText());
            titreSnd.clear();
            contenuSondage.clear();
            choix1.clear(); choix2.clear(); choix3.clear(); choix4.clear();
            tableSondages.getItems().clear();
            ArrayList<listTwoPar> s = SondageBD.afficherSondage();

            for(int i=0; i<s.size(); i++)
                tableSondages.getItems().add(s.get(i));
        }

        creerSnd.setVisible(false);
        creeSondage.setVisible(false);
    }

    @FXML public void participerSondage(){
        Object o = tableSondages.getSelectionModel().getSelectedItem();
        if(o != null){
            confirmerSnd.setVisible(true);
            creeSondage.setVisible(true);
            titreSnd.clear();
            contenuSondage.clear();
            choix1.clear();choix2.clear();choix3.clear();choix4.clear();
            listTwoPar l = (listTwoPar)o;
            ArrayList<Sondage> sd = SondageBD.consulterSondage(l.getTitre());
            System.out.println(l.getTitre());
            sondage.setVisible(true);
            titreSnd.setEditable(false);
            contenuSondage.setEditable(false);
            choix1.setEditable(false);choix2.setEditable(false);choix3.setEditable(false);choix4.setEditable(false);

            titreSnd.setText(sd.get(0).getTitre());
            contenuSondage.setText(sd.get(0).getContenu());
            choix1.setText(sd.get(0).getChoix1());choix2.setText(sd.get(0).getChoix2());choix3.setText(sd.get(0).getChoix3());choix4.setText(sd.get(0).getChoix4());
            choixBox1.setVisible(true);choixBox2.setVisible(true);choixBox3.setVisible(true);choixBox4.setVisible(true);
        }

    }

    @FXML public void box1(){
        if(choixBox1.isSelected()){
            choixBox2.setSelected(false);
            choixBox3.setSelected(false);
            choixBox4.setSelected(false);
        }
    }

    @FXML public void box2(){
        if(choixBox2.isSelected()){
            choixBox1.setSelected(false);
            choixBox3.setSelected(false);
            choixBox4.setSelected(false);
        }
    }@FXML public void box3(){
        if(choixBox3.isSelected()){
            choixBox2.setSelected(false);
            choixBox1.setSelected(false);
            choixBox4.setSelected(false);
        }
    }@FXML public void box4(){
        if(choixBox4.isSelected()){
            choixBox2.setSelected(false);
            choixBox3.setSelected(false);
            choixBox1.setSelected(false);
        }
    }

    @FXML public void confirmeParticipation(){
        String s = titreSnd.getText();
        if(choixBox1.isSelected()) SondageBD.participer1(s);
        if(choixBox2.isSelected()) SondageBD.participer2(s);
        if(choixBox3.isSelected()) SondageBD.participer3(s);
        if(choixBox4.isSelected()) SondageBD.participer4(s);
        titreSnd.clear();
        contenuSondage.clear();
        choix1.clear();choix2.clear();choix3.clear();choix4.clear();

        choixBox1.setVisible(false);choixBox2.setVisible(false);choixBox3.setVisible(false);choixBox4.setVisible(false);
        creeSondage.setVisible(false);
        confirmerSnd.setVisible(false);
        choixBox1.setSelected(false);choixBox2.setSelected(false);choixBox3.setSelected(false);choixBox4.setSelected(false);
    }

    @FXML public int MesSondages() {
        resultat.toBack();
        resultat.setVisible(false);
        creerSnd.setVisible(false);
        System.out.println(mtSondage.getText());
        if (mtSondage.getText().equals("Mes Sondages")) {
            ArrayList<listTwoPar> s = SondageBD.getMesSondages(Integer.parseInt(id.getText()));
            tableSondages.getItems().clear();
            for (int i = 0; i < s.size(); i++)
                tableSondages.getItems().add(s.get(i));

            supprimerSondage.setVisible(true);
            mtSondage.setText("Tous les Sondages");
            System.out.println("Voici vos Sondages");
            return 1;
        }
        else {
            ArrayList<listTwoPar> s = SondageBD.afficherSondage();
            tableSondages.getItems().clear();
            for (int i = 0; i < s.size(); i++)
                tableSondages.getItems().add(s.get(i));

            supprimerSondage.setVisible(false);
            mtSondage.setText("Mes Sondages");
            System.out.println("Vois tous les sondages");
            return 1;
        }


    }

    @FXML public void SupprimerSondage(){
        Object o = tableSondages.getSelectionModel().getSelectedItem();
        if(o != null){
            listTwoPar s = (listTwoPar) o;
            tableSondages.getItems().remove(o);
            SondageBD.supprimerSondage(s.getTitre());

            System.out.println("Suppppp");
        }
    }

    @FXML public void afficherSondage(){
        Object o = tableSondages.getSelectionModel().getSelectedItem();
        if(o != null){
            listTwoPar s = (listTwoPar) o;
            ArrayList<Sondage> l = SondageBD.consulterSondage(s.getTitre());

            ObservableList<PieChart.Data> pieChertData = FXCollections.observableArrayList(new PieChart.Data(l.get(0).getChoix1(),l.get(0).getNb1()),
                     new PieChart.Data(l.get(0).getChoix2(),l.get(0).getNb2()),
                     new PieChart.Data(l.get(0).getChoix3(),l.get(0).getNb3()),
                     new PieChart.Data(l.get(0).getChoix4(),l.get(0).getNb4()));

            statistics.setData(pieChertData);
            contenuRsltSnd.setText(l.get(0).getContenu());
            nbPart.setText(String.valueOf(l.get(0).getNbPart()));
            resultat.setVisible(true);
            creeSondage.setVisible(false);
            resultat.toFront();
        }
    }
}