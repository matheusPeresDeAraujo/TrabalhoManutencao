package model;

import dao.AvaliacaoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacao")
public class Avaliacao implements java.io.Serializable {

    private AvaliacaoId id;
    private Aluno aluno;
    private Turma turma;
    private Float nota1;
    private Float nota2;
    private Integer numFaltas;
    private Float notaProvaFinal;

    public Avaliacao() {
    }

    public Avaliacao(AvaliacaoId id, Aluno aluno, Turma turma) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
    }

    public Avaliacao(AvaliacaoId id, Aluno aluno, Turma turma, Float nota1, Float nota2, Integer numFaltas, Float notaProvaFinal) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.numFaltas = numFaltas;
        this.notaProvaFinal = notaProvaFinal;
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "matriculaAluno", column =
        @Column(name = "matriculaAluno", nullable = false)),
        @AttributeOverride(name = "codTurma", column =
        @Column(name = "codTurma", nullable = false))})
    public AvaliacaoId getId() {
        return this.id;
    }

    public void setId(AvaliacaoId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matriculaAluno", nullable = false, insertable = false, updatable = false)
    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codTurma", nullable = false, insertable = false, updatable = false)
    public Turma getTurma() {
        return this.turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Column(name = "nota1", precision = 12, scale = 0)
    public Float getNota1() {
        return this.nota1;
    }

    public void setNota1(Float nota1) {
        this.nota1 = nota1;
    }

    @Column(name = "nota2", precision = 12, scale = 0)
    public Float getNota2() {
        return this.nota2;
    }

    public void setNota2(Float nota2) {
        this.nota2 = nota2;
    }

    @Column(name = "numFaltas")
    public Integer getNumFaltas() {
        return this.numFaltas;
    }

    public void setNumFaltas(Integer numFaltas) {
        this.numFaltas = numFaltas;
    }

    @Column(name = "notaProvaFinal", precision = 12, scale = 0)
    public Float getNotaProvaFinal() {
        return this.notaProvaFinal;
    }

    public void setNotaProvaFinal(Float notaProvaFinal) {
        this.notaProvaFinal = notaProvaFinal;
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AvaliacaoDao.excluirAvaliacao(this);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        AvaliacaoDao.gravarAvaliacao(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AvaliacaoDao.editarAvaliacao(this);
    }
    
    public static List<Avaliacao> obterAvaliacoesPorAluno(int matricula) throws SQLException, ClassNotFoundException {
        return AvaliacaoDao.obterAvaliacoesPorAluno(matricula);
    }
    
    public static List<Avaliacao> obterAvaliacoesPorTurma(int codTurma) throws SQLException, ClassNotFoundException {
        return AvaliacaoDao.obterAvaliacoesPorTurma(codTurma);
    }
    
    public static Avaliacao obterAvaliacao(AvaliacaoId avaliacaoId) throws SQLException, ClassNotFoundException {
        return AvaliacaoDao.obterAvaliacao(avaliacaoId);
    }
    
    public static List<Avaliacao> obterAvaliacoesPorAnoSemestre(int ano, int semestre, int matricula) throws SQLException, ClassNotFoundException {
        List<Avaliacao> avaliacoes = AvaliacaoDao.obterAvaliacoesPorAluno(matricula);
        List<Avaliacao> avaliacoesParaEnvio = new ArrayList<Avaliacao>();
        
        for(Avaliacao a: avaliacoes){
            if(a.getTurma().getAno() == ano && a.getTurma().getSemestre() == semestre){
                avaliacoesParaEnvio.add(a);
            }
        }
        
        return avaliacoesParaEnvio;
        
    }

    
}
