
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
import model.Disciplina;
import model.Turma;

public class PesquisarDisciplinaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int filtro = Integer.parseInt(request.getParameter("filtro"));
            request.setAttribute("cursos", Curso.obterCursos());

            if( filtro==1){
                int curso = Integer.parseInt(request.getParameter("curso"));
                String nomeDisciplina = request.getParameter("disciplina");
                if((curso == 0 ) && (nomeDisciplina==null || nomeDisciplina.equals("")) ){
                 request.setAttribute("disciplinas", Disciplina.obterDisciplinas());
                }else{
                     if(curso!=0 && !nomeDisciplina.equals("")){
                         request.setAttribute("disciplinas", Disciplina.obterDisciplinasPorCursoENome(curso,nomeDisciplina));
                         request.setAttribute("cursoFiltro", curso);
                         request.setAttribute("nomeFiltro", nomeDisciplina);
                     }else if(curso!=0){
                         request.setAttribute("disciplinas", Disciplina.obterDisciplinasPorCurso(curso));
                         request.setAttribute("cursoFiltro", curso);
                     }else if(!nomeDisciplina.equals("")){
                         request.setAttribute("disciplinas", Disciplina.obterDisciplinasPorNome(nomeDisciplina));
                         request.setAttribute("nomeFiltro", nomeDisciplina);
                     }
                }
            }else{
                request.setAttribute("disciplinas", Disciplina.obterDisciplinas());
            }
            
            RequestDispatcher view = 
                    request.getRequestDispatcher("PesquisarDisciplina.jsp");
            view.forward(request, response);
        } catch (ServletException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PesquisarDisciplinaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
