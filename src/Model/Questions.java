package Model;

public class Questions {
    private int id_Qest, id_Quiz;
    private String q,r,c1,c2,c3,c4;

    public Questions(int id_Qest, String q, String r, String c1, String c2, String c3, String c4, int id_Quiz){
        this.id_Qest = id_Qest;
        this.q = q;
        this.r = r;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.id_Quiz = id_Quiz;
    }

    public int getId_Qest() {
        return id_Qest;
    }

    public void setId_Qest(int id_Qest) {
        this.id_Qest = id_Qest;
    }

    public int getId_Quiz() {
        return id_Quiz;
    }

    public void setId_Quiz(int id_Quiz) {
        this.id_Quiz = id_Quiz;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }


    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }
    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }
    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }
}
