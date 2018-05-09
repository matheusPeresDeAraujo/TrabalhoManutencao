package model;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario implements java.io.Serializable {

    private Integer codHorario;
    private Turma turma;
    private Integer diaSemana;
    private String horarioInicio;

    public Horario() {
    }

    public Horario(Turma turma) {
        this.turma = turma;
    }

    public Horario(Turma turma, Integer diaSemana, String horarioInicio) {
        this.turma = turma;
        this.diaSemana = diaSemana;
        this.horarioInicio = horarioInicio;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "codHorario", unique = true, nullable = false)
    public Integer getCodHorario() {
        return this.codHorario;
    }

    public void setCodHorario(Integer codHorario) {
        this.codHorario = codHorario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codTurma")
    public Turma getTurma() {
        return this.turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Column(name = "diaSemana")
    public Integer getDiaSemana() {
        return this.diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    @Column(name = "horarioInicio", length = 15)
    public String getHorarioInicio() {
        return this.horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }
//    
//    public void excluir() throws SQLException, ClassNotFoundException{
//        this.setTurma(null);
//        HorarioDAO.excluirHorario(this);
//    }
//    
//    public void gravar() throws SQLException, ClassNotFoundException{
//        HorarioDAO.gravarHorario(this);
//    }
//    
//    public void alterar() throws SQLException, ClassNotFoundException{
//        HorarioDAO.editarHorario(this);
//    }
//    
//    public static List<Horario> obterHorariosPorTurma(int codTurma) throws SQLException, ClassNotFoundException{
//        return HorarioDAO.obterHorariosPorTurma(codTurma);
//    }
}
