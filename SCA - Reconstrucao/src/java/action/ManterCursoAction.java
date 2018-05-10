
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.Professor;

public class ManterCursoAction implements Action{

    private Curso curso;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        try {
                String acao = request.getParameter("acao");
                if (acao.equals("prepararOperacao")) {
                    prepararOperacao(request, response);
                }
                if (acao.equals("confirmarOperacao")) {
                    confirmarOperacao(request, response);
                }
        } catch (ServletException ex) {
            Logger.getLogger(ManterCursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("professores", Professor.obterProfessores());
            if (!operacao.equals("incluir")) {
                int codCurso = Integer.parseInt(request.getParameter("codCurso"));
                curso = Curso.obterCurso(codCurso);
                request.setAttribute("curso", curso);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterCurso.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            int codCurso = Integer.parseInt(request.getParameter("codCurso"));
            String nome = request.getParameter("nomeCurso");
            int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
            String tipoCurso = request.getParameter("tipoCurso");
            int totalPeriodos = Integer.parseInt(request.getParameter("totalPeriodos"));
            int matriculaProfessor = Integer.parseInt(request.getParameter("professorCoordenador"));
            Professor professor;
            if(matriculaProfessor != 0){
                professor = Professor.obterProfessor(matriculaProfessor);
            } else {
                professor = null;
            }
            if (operacao.equals("incluir")) {
                curso = new Curso(codCurso, nome, cargaHoraria, tipoCurso, totalPeriodos, professor);
                curso.gravar();
            } else if (operacao.equals("editar")) {
                curso.setNome(nome);
                curso.setCargaHoraria(cargaHoraria);
                curso.setTipoCurso(tipoCurso);
                curso.setTotalPeriodos(totalPeriodos);
                curso.setProfessor(Professor.obterProfessor(matriculaProfessor));
                curso.editar();
            } else if (operacao.equals("excluir")) {
                curso.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarCursoController");
            view.forward(request, response);

        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
    
}
