
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
import model.Professor;

public class PesquisarProfessorAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            
            String nomeProfessor = request.getParameter("busca");
            if(nomeProfessor == null || nomeProfessor.equals("")){
                 request.setAttribute("professores", Professor.obterProfessores());
            }else{
                 request.setAttribute("professores", Professor.obterProfessoresPorNome(nomeProfessor));
            }

            RequestDispatcher view = 
                    request.getRequestDispatcher("PesquisarProfessor.jsp");
            view.forward(request, response);
        } catch (ServletException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PesquisarProfessorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
