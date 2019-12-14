package Model;

public class Quizs {
	private int idQuiz, numF;
	private String nomQ ;

	public Quizs(int idQuiz, String nomQ, int numF) {
		setNumF(numF);
		setIdQuiz(idQuiz);
		setNomQ(nomQ);
		
	}


	public int getIdQuiz() {
		return idQuiz;
	}

	public void setIdQuiz(int idQuiz) {
		this.idQuiz = idQuiz;
	}

	public int getNumF() {
		return numF;
	}

	public void setNumF(int numF) {
		this.numF = numF;
	}

	public String getNomQ() {
		return nomQ;
	}

	public void setNomQ(String nomQ) {
		this.nomQ = nomQ;
	}
}
