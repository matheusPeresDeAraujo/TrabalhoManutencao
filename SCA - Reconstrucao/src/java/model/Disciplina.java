package model;
import dao.DisciplinaDao;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina implements java.io.Serializable {

    private int codDisciplina;
    private Curso curso;
    private String nome;
    private String ementa;
    private Integer periodo;
    private Integer qtdeCreditos;
    private Set<Turma> turmas = new HashSet<Turma>(0);
    private Set<Disciplina> disciplinasForCodDisciplinaPreRequisito = new HashSet<Disciplina>(0);
    private Set<Disciplina> disciplinasForCodDisciplinaPreRequisitada = new HashSet<Disciplina>(0);

    public Disciplina() {
    }

    public Disciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public Disciplina(int codDisciplina, Curso curso, String nome, String ementa, Integer periodo, Integer qtdeCreditos, Set<Turma> turmas, Set<Disciplina> disciplinasForCodDisciplinaPreRequisito, Set<Disciplina> disciplinasForCodDisciplinaPreRequisitada) {
        this.codDisciplina = codDisciplina;
        this.curso = curso;
        this.nome = nome;
        this.ementa = ementa;
        this.periodo = periodo;
        this.qtdeCreditos = qtdeCreditos;
        this.turmas = turmas;
        this.disciplinasForCodDisciplinaPreRequisito = disciplinasForCodDisciplinaPreRequisito;
        this.disciplinasForCodDisciplinaPreRequisitada = disciplinasForCodDisciplinaPreRequisitada;
    }
    
    public Disciplina(int codDisciplina, String nomeDisciplina,String ementa,Integer periodo,Integer qtdCreditos,Curso curso,Set<Disciplina> preRequisitos){
        this.codDisciplina = codDisciplina;
        this.nome = nomeDisciplina;
        this.ementa = ementa;
        this.periodo = periodo;
        this.qtdeCreditos = qtdCreditos;
        this.curso = curso;
        this.disciplinasForCodDisciplinaPreRequisito = preRequisitos;
    }

    @Id
    @Column(name = "codDisciplina", unique = true, nullable = false)
    public int getCodDisciplina() {
        return this.codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codCurso")
    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Column(name = "nome", length = 45)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "ementa", length = 65535)
    public String getEmenta() {
        return this.ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    @Column(name = "periodo")
    public Integer getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    @Column(name = "qtdeCreditos")
    public Integer getQtdeCreditos() {
        return this.qtdeCreditos;
    }

    public void setQtdeCreditos(Integer qtdeCreditos) {
        this.qtdeCreditos = qtdeCreditos;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "disciplina")
    public Set<Turma> getTurmas() {
        return this.turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "prerequisito", catalog = "sca", joinColumns = {
        @JoinColumn(name = "codDisciplinaPreRequisitada", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "codDisciplinaPreRequisito", nullable = false, updatable = false)})
    public Set<Disciplina> getDisciplinasForCodDisciplinaPreRequisito() {
        return this.disciplinasForCodDisciplinaPreRequisito;
    }

    public void setDisciplinasForCodDisciplinaPreRequisito(Set<Disciplina> disciplinasForCodDisciplinaPreRequisito) {
        this.disciplinasForCodDisciplinaPreRequisito = disciplinasForCodDisciplinaPreRequisito;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "prerequisito", catalog = "sca", joinColumns = {
        @JoinColumn(name = "codDisciplinaPreRequisito", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "codDisciplinaPreRequisitada", nullable = false, updatable = false)})
    public Set<Disciplina> getDisciplinasForCodDisciplinaPreRequisitada() {
        return this.disciplinasForCodDisciplinaPreRequisitada;
    }

    public void setDisciplinasForCodDisciplinaPreRequisitada(Set<Disciplina> disciplinasForCodDisciplinaPreRequisitada) {
        this.disciplinasForCodDisciplinaPreRequisitada = disciplinasForCodDisciplinaPreRequisitada;
    }
    
    public static List<Disciplina> obterDisciplinas() throws ClassNotFoundException, SQLException{
        return DisciplinaDao.obterDisciplinas();
    }
      
    public static List<Disciplina> obterDisciplinasPorNome(String nome) throws ClassNotFoundException, SQLException{
       return DisciplinaDao.obterDisciplinasPorNome(nome);
    }
    
    public static List<Disciplina> obterDisciplinasPorCursoENome(int codCurso, String nome) throws ClassNotFoundException, SQLException{
       return DisciplinaDao.obterDisciplinasPorCursoENome(codCurso,nome);
    }
    
    public static List<Disciplina> obterDisciplinasPorCurso(int codCurso) throws ClassNotFoundException, SQLException{
       return DisciplinaDao.obterDisciplinasPorCurso(codCurso);
    }
    
    public static Disciplina obterDisciplina(int codDisciplina) throws ClassNotFoundException, SQLException{
        return DisciplinaDao.obterDisciplina(codDisciplina);
    }
    
    public void gravar() throws SQLException, ClassNotFoundException{
        DisciplinaDao.gravarDisciplina(this);
    }
    
    public void editar() throws SQLException, ClassNotFoundException{
        DisciplinaDao.editarDisciplina(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        DisciplinaDao.excluirDisciplina(this);
    }
}
