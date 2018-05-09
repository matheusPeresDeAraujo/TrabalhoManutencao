package model;

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
@Table(name = "aluno")
public class Aluno implements java.io.Serializable {

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
    private String rg;
    private String cpf;
    private String email;
    private Integer anoIngresso;
    private Integer semestreIngresso;
    private String status;
    private Integer posicaoVestibular;
    private Set<Avaliacao> avaliacaos = new HashSet<Avaliacao>(0);

    public Aluno() {
    }

    public Aluno(int matricula) {
        this.matricula = matricula;
    }

    public Aluno(int matricula, Curso curso, String nome, Date dtNascimento, String endLogradouro, Integer endNumero, String endComplemento, String endBairro, String endCep, String endCidade, String endEstado, String rg, String cpf, String email, Integer anoIngresso, Integer semestreIngresso, String status, Integer posicaoVestibular, Set<Avaliacao> avaliacaos) {
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
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.anoIngresso = anoIngresso;
        this.semestreIngresso = semestreIngresso;
        this.status = status;
        this.posicaoVestibular = posicaoVestibular;
        this.avaliacaos = avaliacaos;
    }
    
    public Aluno(int matricula, String nome, Date dtNascimento, String endLogradouro, Integer endNumero, String endComplemento, String endBairro, String endCep, String endCidade, String endEstado, String rg, String cpf, String email, Integer anoIngresso, Integer semestreIngresso, String status, Integer posicaoVestibular, Curso curso) {
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
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.anoIngresso = anoIngresso;
        this.semestreIngresso = semestreIngresso;
        this.status = status;
        this.posicaoVestibular = posicaoVestibular;
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
    @JoinColumn(name = "codCurso")
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

    @Column(name = "endBairro", length = 35)
    public String getEndBairro() {
        return this.endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    @Column(name = "endCEP", length = 15)
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

    @Column(name = "endEstado", length = 45)
    public String getEndEstado() {
        return this.endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

    @Column(name = "rg", length = 15)
    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Column(name = "cpf", length = 20)
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "email", length = 45)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "anoIngresso")
    public Integer getAnoIngresso() {
        return this.anoIngresso;
    }

    public void setAnoIngresso(Integer anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    @Column(name = "semestreIngresso")
    public Integer getSemestreIngresso() {
        return this.semestreIngresso;
    }

    public void setSemestreIngresso(Integer semestreIngresso) {
        this.semestreIngresso = semestreIngresso;
    }

    @Column(name = "status", length = 25)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "posicaoVestibular")
    public Integer getPosicaoVestibular() {
        return this.posicaoVestibular;
    }

    public void setPosicaoVestibular(Integer posicaoVestibular) {
        this.posicaoVestibular = posicaoVestibular;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "aluno")
    public Set<Avaliacao> getAvaliacaos() {
        return this.avaliacaos;
    }

    public void setAvaliacaos(Set<Avaliacao> avaliacaos) {
        this.avaliacaos = avaliacaos;
    }
//
//    public static List<Aluno> obterAlunos() throws ClassNotFoundException, SQLException {
//        return AlunoDao.obterAlunos();
//    }
//    public static List<Aluno> obterAlunosPorNome(String nome) throws ClassNotFoundException, SQLException {
//        return AlunoDao.obterAlunosPorNome(nome);
//    }
//    public static Aluno obterAluno(int matricula) throws ClassNotFoundException, SQLException {
//        return AlunoDao.obterAluno(matricula);
//    }
//    public void gravar() throws SQLException, ClassNotFoundException {
//        AlunoDao.gravarAluno(this);
//    }
//    public void editar() throws SQLException, ClassNotFoundException {
//        AlunoDao.editarAluno(this);
//    }
//    public void excluir() throws SQLException, ClassNotFoundException {
//        AlunoDao.excluirAluno(this);
//    }
}
