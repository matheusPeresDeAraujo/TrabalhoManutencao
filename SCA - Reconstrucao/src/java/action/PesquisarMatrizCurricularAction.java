
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

public class PesquisarMatrizCurricularAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        try {
            String acao = request.getParameter("acao");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
        
            request.setAttribute("cursos", Curso.obterCursos());
            request.setAttribute("acao", acao);
            
            if (!acao.equals("prepararOperacao")) {
                int codCurso = Integer.parseInt(request.getParameter("optCurso"));
                List<Disciplina> disciplinas = Disciplina.obterDisciplinas();
                List<Disciplina> disciplinaExcluir = new ArrayList<Disciplina>();
                
                for (Disciplina disciplina : disciplinas) {
                    if (disciplina.getCurso().getCodCurso() != codCurso) {
                        disciplinaExcluir.add(disciplina);
                    }
                }
                
                disciplinas.removeAll(disciplinaExcluir);
                
                request.setAttribute("disciplinas", disciplinas);
                request.setAttribute("codCurso", codCurso);
            }

            RequestDispatcher janela = request.getRequestDispatcher("/pesquisarMatrizCurricular.jsp");
        
            janela.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(PesquisarMatrizCurricularAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisarMatrizCurricularAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarMatrizCurricularAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
