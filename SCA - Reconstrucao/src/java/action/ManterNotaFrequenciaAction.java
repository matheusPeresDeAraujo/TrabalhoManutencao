
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Avaliacao;
import model.AvaliacaoId;
import model.Curso;
import model.Horario;
import model.Turma;
import util.ConverteData;
import util.Estados;
import util.Horarios;

public class ManterNotaFrequenciaAction implements Action{

    private Turma turma;
    List<Avaliacao> avaliacoes;
    List<AvaliacaoId> avaliacaoIds;
    
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
            Logger.getLogger(ManterNotaFrequenciaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {

            int codTurma = Integer.parseInt(request.getParameter("codTurma"));
            request.setAttribute("turma", Turma.obterTurma(codTurma));

            avaliacoes = Avaliacao.obterAvaliacoesPorTurma(codTurma);
            request.setAttribute("avaliacoes", avaliacoes);

            RequestDispatcher view = request.getRequestDispatcher("/manterNotaFrequencia.jsp");
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

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
        String nome = request.getParameter("txtNomeCurso");
        int cargaHoraria = Integer.parseInt(request.getParameter("txtCargaHoraria"));
        String tipoCurso = request.getParameter("optTipoCurso");
        int totalPeriodos = Integer.parseInt(request.getParameter("txtTotalPeriodos"));
        int coordenador = Integer.parseInt(request.getParameter("optCoordenador"));

       
    }
}
