
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

public class PesquisarCursoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("cursos", Curso.obterCursos());
            RequestDispatcher view = 
                    request.getRequestDispatcher("PesquisarCurso.jsp");
            view.forward(request, response);
        } catch (ServletException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PesquisarCursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
