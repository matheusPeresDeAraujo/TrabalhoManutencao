
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.Disciplina;

public class ManterDisciplinaAction implements Action{

    private List<Disciplina> disciplinas;
    private Disciplina disciplina;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        
        try {
            
            String acao = request.getParameter("acao");
            if(acao.equals("prepararOperacao")){
               prepararOperacao(request,response);
            }
            if(acao.equals("confirmarOperacao")){
                confirmarOperacao(request,response);
            }   
        } catch (ServletException ex) {
            Logger.getLogger(ManterDisciplinaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String operacao = request.getParameter("operacao");
            int codDisciplina = Integer.parseInt(request.getParameter("codDisciplina"));
            int periodo = Integer.parseInt(request.getParameter("periodo"));
            int codCurso = Integer.parseInt(request.getParameter("curso"));
            String nomeDisciplina = request.getParameter("nomeDisciplina");
            int qtdCreditos = Integer.parseInt(request.getParameter("qtdCreditos"));
            String ementa = request.getParameter("ementa");
            Set<Disciplina> preRequisitos = new HashSet<Disciplina>();
            List<String> elements = Arrays.asList(request.getParameter("preRequisitosSerialized").split(","));  
            
            for(String elemento: elements){
                if(!elemento.equals("")){
                    preRequisitos.add(Disciplina.obterDisciplina(Integer.parseInt(elemento)));
                }
            }
            Curso curso = Curso.obterCurso(codCurso);

            if (operacao.equals("incluir")) {
                disciplina = new Disciplina(codDisciplina, nomeDisciplina,ementa,periodo,qtdCreditos,curso,preRequisitos);
                disciplina.gravar();
            } else if (operacao.equals("editar")) {
                disciplina.setNome(nomeDisciplina);
                disciplina.setEmenta(ementa);
                disciplina.setPeriodo(periodo);
                disciplina.setQtdeCreditos(qtdCreditos);
                disciplina.setCurso(curso);
                disciplina.setDisciplinasForCodDisciplinaPreRequisito(preRequisitos);
                disciplina.editar();
            } else if (operacao.equals("excluir")) {
                disciplina.excluir();
            }
            
            RequestDispatcher view = request.getRequestDispatcher("PesquisarDisciplinaController?filtro=0");
            view.forward(request, response);
        
        }catch(ServletException e){
            throw e;
        }catch(IOException e){
            throw new ServletException(e);
        }catch(SQLException e){
            throw new ServletException(e);
        }catch(ClassNotFoundException e){
            throw new ServletException(e);
        }
    }
    
     public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException{
         try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("cursos", Curso.obterCursos());
            disciplinas = Disciplina.obterDisciplinas();
            request.setAttribute("preRequisitos", disciplinas);            
            if (!operacao.equals("incluir")) {
                int codDisciplina = Integer.parseInt(request.getParameter("codDisciplina"));
                disciplina = Disciplina.obterDisciplina(codDisciplina);
                request.setAttribute("disciplina", disciplina);
                String preRequisitosSerialized = "";
                for(Disciplina preRequisito: disciplina.getDisciplinasForCodDisciplinaPreRequisito()){
                    preRequisitosSerialized = preRequisitosSerialized + preRequisito.getCodDisciplina() + ",";
                }
                request.setAttribute("preRequisitosSerialized", preRequisitosSerialized);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterDisciplina.jsp");
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
}
