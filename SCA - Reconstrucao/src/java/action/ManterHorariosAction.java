
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
import model.Curso;
import model.Horario;
import model.Turma;
import util.ConverteData;
import util.Estados;
import util.Horarios;

public class ManterHorariosAction implements Action{

    private Set<Horario> horarios = new HashSet<Horario>(0);
    
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
            Logger.getLogger(ManterHorariosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            int codTurma = Integer.parseInt(request.getParameter("codTurma"));
            Turma turma = Turma.obterTurma(codTurma);
            request.setAttribute("turma", turma);

            List<Enum> horas = new ArrayList<Enum>();
            horas.addAll(Arrays.asList(Horarios.values()));
            request.setAttribute("horas", horas);

            RequestDispatcher view = request.getRequestDispatcher("/manterHorarios.jsp");
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
        String horarioSerial = request.getParameter("horarioSerial");
        int codTurma = Integer.parseInt(request.getParameter("txtCodTurma"));
        List<String> diaHora = Arrays.asList(horarioSerial.split(","));

        Set<Horario> horarios = new HashSet<Horario>();


        try {
            List<Horario> horariosAnt = Horario.obterHorariosPorTurma(codTurma);
                    
            for(Horario h: horariosAnt){
                h.excluir();
            }

            Turma turma = new Turma();
            turma.setCodTurma(codTurma);

            for (String e : diaHora) {
                if (!e.equals("")) {
                    Horario horario;
                    String vetDiaHora[] = e.split("-");
                    int dia = Integer.parseInt(vetDiaHora[0]);
                    String hora = vetDiaHora[1];
                    horario = new Horario(turma, dia, hora);
                    horarios.add(horario);
                }
            }
            
            for(Horario h: horarios){
                h.gravar();
            }
            
            RequestDispatcher view = request.getRequestDispatcher("PesquisarTurmaController");
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
