package model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements java.io.Serializable {

    private int codCurso;
    private Professor professor;
    private String nome;
    private Integer cargaHoraria;
    private String tipoCurso;
    private Integer totalPeriodos;
    private Set<Professor> professors = new HashSet<Professor>(0);
    private Set<Disciplina> disciplinas = new HashSet<Disciplina>(0);
    private Set<Aluno> alunos = new HashSet<Aluno>(0);

    public Curso() {
    }

    public Curso(int codCurso) {
        this.codCurso = codCurso;
    }

    public Curso(int codCurso, Professor professor, String nome, Integer cargaHoraria, String tipoCurso, Integer totalPeriodos, Set<Professor> professors, Set<Disciplina> disciplinas, Set<Aluno> alunos) {
        this.codCurso = codCurso;
        this.professor = professor;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.tipoCurso = tipoCurso;
        this.totalPeriodos = totalPeriodos;
        this.professors = professors;
        this.disciplinas = disciplinas;
        this.alunos = alunos;
    }
    
    public Curso(int codCurso, String nome, Integer cargaHoraria, String tipoCurso, Integer totalPeriodos, Professor professor){
        this.codCurso = codCurso;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.tipoCurso = tipoCurso;
        this.totalPeriodos = totalPeriodos;
        this.professor = professor;
    }

    @Id
    @Column(name = "codCurso", unique = true, nullable = false)
    public int getCodCurso() {
        return this.codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professorCoordenador")
    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Column(name = "nome", length = 45)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "cargaHoraria")
    public Integer getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Column(name = "tipoCurso", length = 45)
    public String getTipoCurso() {
        return this.tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    @Column(name = "totalPeriodos")
    public Integer getTotalPeriodos() {
        return this.totalPeriodos;
    }

    public void setTotalPeriodos(Integer totalPeriodos) {
        this.totalPeriodos = totalPeriodos;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curso")
    public Set<Professor> getProfessors() {
        return this.professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curso")
    public Set<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curso")
    public Set<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }
    
//    public void gravar() throws SQLException, ClassNotFoundException{
//        CursoDAO.gravarCurso(this);
//    }
//    
//    public void editar() throws SQLException, ClassNotFoundException{
//        CursoDAO.editarCurso(this);
//    }
//    
//    public void excluir() throws SQLException, ClassNotFoundException{
//        CursoDAO.excluirCurso(this);
//    }
//    
//    public static List<Curso> obterCursos() throws ClassNotFoundException, SQLException{
//        return CursoDAO.obterCursos();
//    }
//    
//    public static Curso obterCurso(int codCurso) throws ClassNotFoundException, SQLException{
//        return CursoDAO.obterCurso(codCurso);
//    }
}
