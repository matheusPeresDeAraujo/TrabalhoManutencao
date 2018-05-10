
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.Disciplina;
import model.Professor;
import model.Turma;
import util.ConverteData;
import util.Estados;

public class ManterTurmaAction implements Action{

    Turma turma;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("confirmarOperacao")) {
                confirmarOperacao(request, response);
            } else if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        } catch (ServletException ex) {
            Logger.getLogger(ManterTurmaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("cursos", Curso.obterCursos());
            request.setAttribute("professores", Professor.obterProfessores());
            request.setAttribute("disciplinas", Disciplina.obterDisciplinas());
            if (!operacao.equals("Incluir")) {
                int codTurma = Integer.parseInt(request.getParameter("codTurma"));
                turma = Turma.obterTurma(codTurma);
                request.setAttribute("turma", turma);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterTurma.jsp");
            view.forward(request, response);

        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        int codDisciplina = Integer.parseInt(request.getParameter("optDisciplina"));
        int numVagas = Integer.parseInt(request.getParameter("txtVagas"));
        int matricula = Integer.parseInt(request.getParameter("optProfessor"));
        String numSala = request.getParameter("txtSala");
        int ano = Integer.parseInt(request.getParameter("txtAno"));
        int semestre = Integer.parseInt(request.getParameter("optSemestre"));

        try {
            Disciplina disciplina = null;
            if (codDisciplina != 0) {
                disciplina = Disciplina.obterDisciplina(codDisciplina);
            }
            Professor professor = null;
            if (matricula != 0) {
                professor = Professor.obterProfessor(matricula);
            }
            if (operacao.equals("Incluir")) {
                turma = new Turma(professor, disciplina, semestre, ano, numVagas, numSala, null, null);
                turma.gravar();
            } else if (operacao.equals("Editar")) {
                turma.setDisciplina(disciplina);
                turma.setNumVagas(numVagas);
                turma.setProfessor(professor);
                turma.setNumSala(numSala);
                turma.setAno(ano);
                turma.setSemestre(semestre);
                turma.alterar();
            } else if (operacao.equals("Excluir")) {
                turma.excluir();
            }

            RequestDispatcher view = request.getRequestDispatcher("PesquisarTurmaController");
            view.forward(request, response);
        } catch (SQLException e) {
            //  throw new ServletException(e);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            //  throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }
}
