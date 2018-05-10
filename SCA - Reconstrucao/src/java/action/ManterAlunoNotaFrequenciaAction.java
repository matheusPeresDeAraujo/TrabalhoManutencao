
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
import model.Avaliacao;
import model.AvaliacaoId;
public class ManterAlunoNotaFrequenciaAction implements Action{

    Avaliacao avaliacao;
    
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
            Logger.getLogger(ManterAlunoNotaFrequenciaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {

            int codTurma = Integer.parseInt(request.getParameter("codTurma"));
            int matricula = Integer.parseInt(request.getParameter("matricula"));
            
            AvaliacaoId avaliacaoId = new AvaliacaoId(matricula, codTurma);
            
            avaliacao = Avaliacao.obterAvaliacao(avaliacaoId);
            request.setAttribute("avaliacao", avaliacao);
            
            
            
            RequestDispatcher view = request.getRequestDispatcher("/manterAlunoNotaFrequencia.jsp");
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
         int codTurma = Integer.parseInt(request.getParameter("txtCodTurma"));
        int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
        float nota1 = 0;
        float nota2 = 0;
        int numFaltas = 0;
        float notaProvaFinal = 0;
        if(!request.getParameter("txtNota1").equals("")){
            nota1 = Float.parseFloat(request.getParameter("txtNota1"));
        }
        
        if(!request.getParameter("txtNota2").equals("")){
            nota2 = Float.parseFloat(request.getParameter("txtNota2"));
        }
        
        if(!request.getParameter("txtNumFaltas").equals("")){
            numFaltas = Integer.parseInt(request.getParameter("txtNumFaltas"));
        }
        
        if(!request.getParameter("txtNotaProvaFinal").equals("")){
            numFaltas = Integer.parseInt(request.getParameter("txtNumFaltas"));
        }
        
        if(!request.getParameter("txtNotaProvaFinal").equals("")){
            notaProvaFinal = Float.parseFloat(request.getParameter("txtNotaProvaFinal"));
        }
        
        try {
            avaliacao.setNota1(nota1);
            avaliacao.setNota2(nota2);
            avaliacao.setNumFaltas(numFaltas);
            avaliacao.setNotaProvaFinal(notaProvaFinal);
            avaliacao.alterar();
            RequestDispatcher view = request.getRequestDispatcher("ManterNotaFrequenciaController?acao=prepararOperacao&codTurma="+codTurma);
            view.forward(request, response);

        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    } 
}
