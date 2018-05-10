
package action;

import controller.Action;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class PesquisarProfessorPorCursoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        String acao = request.getParameter("acao");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            request.setAttribute("cursos", Curso.obterCursos());
            request.setAttribute("acao", acao);
            
            if (!acao.equals("prepararOperacao")) {
                int codCurso = Integer.parseInt(request.getParameter("optCurso"));
                List<Professor> professores = Professor.obterProfessores();
                List<Professor> professoresExcluir = new ArrayList<Professor>();
                
                for (Professor professor : professores) {
                    if (professor.getCurso().getCodCurso() != codCurso) {
                        professoresExcluir.add(professor);
                    }
                }
                
                professores.removeAll(professoresExcluir);
                
                request.setAttribute("professores", professores);
                request.setAttribute("codCurso", codCurso);
            }

            RequestDispatcher janela = request.getRequestDispatcher("/PesquisarProfessorPorCurso.jsp");
            janela.forward(request, response);
        }   catch (ServletException ex) {
            Logger.getLogger(PesquisarProfessorPorCursoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisarProfessorPorCursoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarProfessorPorCursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
