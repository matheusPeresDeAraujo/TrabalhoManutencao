package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AvaliacaoId  implements java.io.Serializable {


     private int matriculaAluno;
     private int codTurma;

    public AvaliacaoId() {
    }

    public AvaliacaoId(int matriculaAluno, int codTurma) {
       this.matriculaAluno = matriculaAluno;
       this.codTurma = codTurma;
    }
   

    @Column(name="matriculaAluno", nullable=false)
    public int getMatriculaAluno() {
        return this.matriculaAluno;
    }
    
    public void setMatriculaAluno(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    @Column(name="codTurma", nullable=false)
    public int getCodTurma() {
        return this.codTurma;
    }
    
    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AvaliacaoId) ) return false;
		 AvaliacaoId castOther = ( AvaliacaoId ) other; 
         
		 return (this.getMatriculaAluno()==castOther.getMatriculaAluno())
 && (this.getCodTurma()==castOther.getCodTurma());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getMatriculaAluno();
         result = 37 * result + this.getCodTurma();
         return result;
   }   


}


