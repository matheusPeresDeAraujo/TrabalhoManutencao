package model;

import dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "professor")
public class Professor implements java.io.Serializable {

    private int matricula;
    private Curso curso;
    private String nome;
    private Date dtNascimento;
    private String endLogradouro;
    private Integer endNumero;
    private String endComplemento;
    private String endBairro;
    private String endCep;
    private String endCidade;
    private String endEstado;
    private String email;
    private Date dtIngresso;
    private String titulacao;
    private Set<Curso> cursos = new HashSet<Curso>(0);
    private Set<Turma> turmas = new HashSet<Turma>(0);

    public Professor() {
    }

    public Professor(int matricula) {
        this.matricula = matricula;
    }

    public Professor(int matricula, Curso curso, String nome, Date dtNascimento, String endLogradouro, Integer endNumero, String endComplemento, String endBairro, String endCep, String endCidade, String endEstado, String email, Date dtIngresso, String titulacao, Set<Curso> cursos, Set<Turma> turmas) {
        this.matricula = matricula;
        this.curso = curso;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.endLogradouro = endLogradouro;
        this.endNumero = endNumero;
        this.endComplemento = endComplemento;
        this.endBairro = endBairro;
        this.endCep = endCep;
        this.endCidade = endCidade;
        this.endEstado = endEstado;
        this.email = email;
        this.dtIngresso = dtIngresso;
        this.titulacao = titulacao;
        this.cursos = cursos;
        this.turmas = turmas;
    }
    
    public Professor(int matricula, String nome, Date dtNascimento,
                String endLogradouro, Integer endNumero, String endComplemento, String endBairro, String endCep, String endCidade, String endEstado, String email,
                Date dtIngresso, String titulacao, Curso curso){
        this.matricula = matricula;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.endLogradouro = endLogradouro;
        this.endNumero = endNumero;
        this.endComplemento = endComplemento;
        this.endBairro = endBairro;
        this.endCep = endCep;
        this.endCep = endCidade;
        this.endEstado = endEstado;
        this.email = email;
        this.dtIngresso = dtIngresso;
        this.titulacao = titulacao;
        this.curso = curso;
    }
    

    @Id
    @Column(name = "matricula", unique = true, nullable = false)
    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cursoAtuacao")
    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Column(name = "nome", length = 80)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dtNascimento", length = 10)
    public Date getDtNascimento() {
        return this.dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Column(name = "endLogradouro", length = 60)
    public String getEndLogradouro() {
        return this.endLogradouro;
    }

    public void setEndLogradouro(String endLogradouro) {
        this.endLogradouro = endLogradouro;
    }

    @Column(name = "endNumero")
    public Integer getEndNumero() {
        return this.endNumero;
    }

    public void setEndNumero(Integer endNumero) {
        this.endNumero = endNumero;
    }

    @Column(name = "endComplemento", length = 10)
    public String getEndComplemento() {
        return this.endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    @Column(name = "endBairro", length = 45)
    public String getEndBairro() {
        return this.endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    @Column(name = "endCEP", length = 20)
    public String getEndCep() {
        return this.endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    @Column(name = "endCidade", length = 45)
    public String getEndCidade() {
        return this.endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    @Column(name = "endEstado", length = 25)
    public String getEndEstado() {
        return this.endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

    @Column(name = "email", length = 45)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dtIngresso", length = 10)
    public Date getDtIngresso() {
        return this.dtIngresso;
    }

    public void setDtIngresso(Date dtIngresso) {
        this.dtIngresso = dtIngresso;
    }

    @Column(name = "titulacao", length = 45)
    public String getTitulacao() {
        return this.titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "professor")
    public Set<Curso> getCursos() {
        return this.cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
    public Set<Turma> getTurmas() {
        return this.turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException{
        ProfessorDAO.gravarProfessor(this);
    }
    
    public void editar() throws SQLException, ClassNotFoundException{
        ProfessorDAO.editarProfessor(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        ProfessorDAO.excluirProfessor(this);
    }
    
    public static Professor obterProfessor(int matricula) throws ClassNotFoundException, SQLException{
        return ProfessorDAO.obterProfessor(matricula);
    }
    
    public static List<Professor> obterProfessores() throws ClassNotFoundException, SQLException{
        return ProfessorDAO.obterProfessores();
    }
    
    public static List<Professor> obterProfessoresPorNome(String nomeProfessor) throws ClassNotFoundException, SQLException{
        return ProfessorDAO.obterProfessoresPorNome(nomeProfessor);
    }
}
