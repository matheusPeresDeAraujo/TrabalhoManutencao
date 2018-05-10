package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Avaliacao;

public class ConsultarNotaFrequenciaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String acao = request.getParameter("acao");
        try {

            int matricula = Integer.parseInt(request.getParameter("matricula"));
            if (acao.equals("prepararOperacao")) {
                List<Avaliacao> avaliacoes = Avaliacao.obterAvaliacoesPorAluno(matricula);
                request.setAttribute("avaliacoes", avaliacoes);
            } else {
                if (acao.equals("confirmarOperacao")) {
                    String pesqisa = request.getParameter("pesquisa");
                    if (pesqisa.equals("Todas")) {
                        List<Avaliacao> avaliacoes = Avaliacao.obterAvaliacoesPorAluno(matricula);
                        request.setAttribute("avaliacoes", avaliacoes);
                    } else {
                        int ano = Integer.parseInt(request.getParameter("ano"));
                        int semestre = Integer.parseInt(request.getParameter("semestre"));
                        List<Avaliacao> avaliacoes = Avaliacao.obterAvaliacoesPorAnoSemestre(ano, semestre, matricula);
                        request.setAttribute("avaliacoes", avaliacoes);
                    }
                }
            }


            Aluno aluno = Aluno.obterAluno(matricula);
            request.setAttribute("aluno", aluno);

            RequestDispatcher janela = request.getRequestDispatcher("/consultarNotaFrequencia.jsp");
            janela.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ConsultarNotaFrequenciaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConsultarNotaFrequenciaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarNotaFrequenciaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
