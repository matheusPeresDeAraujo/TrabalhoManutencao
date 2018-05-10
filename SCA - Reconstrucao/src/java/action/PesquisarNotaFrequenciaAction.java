
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
import model.Professor;
import model.Turma;

public class PesquisarNotaFrequenciaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        String acao = request.getParameter("acao");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            request.setAttribute("professores", Professor.obterProfessores());
            request.setAttribute("acao", acao);

            if (!acao.equals("prepararOperacao")) {
                int matricula = Integer.parseInt(request.getParameter("optProfessor"));
                List<Turma> turmas = Turma.obterTurmas();
                List<Turma> turmaExcluir = new ArrayList<Turma>();

                for (Turma turma : turmas) {
                    if (turma.getProfessor().getMatricula() != matricula) {
                        turmaExcluir.add(turma);
                    }
                }

                turmas.removeAll(turmaExcluir);

                request.setAttribute("turmas", turmas);
                request.setAttribute("matricula", matricula);
            }

            RequestDispatcher janela = request.getRequestDispatcher("/PesquisarNotaFrequencia.jsp");
        
            janela.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(PesquisarNotaFrequenciaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisarNotaFrequenciaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarNotaFrequenciaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
