
package action;

import controller.Action;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Disciplina;

public class VisualizarEmentaDisciplinaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int codDisciplina = Integer.parseInt(request.getParameter("codDisciplina"));
            request.setAttribute("disciplina", Disciplina.obterDisciplina(codDisciplina));
            RequestDispatcher janela = request.getRequestDispatcher("/visualizarEmentaDisciplina.jsp");
        
            janela.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(VisualizarEmentaDisciplinaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisualizarEmentaDisciplinaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VisualizarEmentaDisciplinaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
}
