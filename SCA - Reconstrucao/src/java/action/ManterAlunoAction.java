
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Curso;
import util.ConverteData;
import util.Estados;

public class ManterAlunoAction implements Action{

    private Aluno aluno;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        String acao = request.getParameter("acao");
        
        try {
            if(acao.equals("prepararOperacao")){
                prepararOperacao(request,response);
            }
            if(acao.equals("confirmarOperacao")){
                confirmarOperacao(request,response);
            }
        } catch (ServletException ex) {
            Logger.getLogger(ManterAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String operacao = request.getParameter("operacao");
            String nomeAluno = request.getParameter("nome");
            Date dataNascimento = ConverteData.converte(request.getParameter("dataNascimento"));
            String logradouro = request.getParameter("logradouro");
            int numero = 0;
            if(!request.getParameter("numero").equals("")){
                numero = Integer.parseInt(request.getParameter("numero"));
            }
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String cep = request.getParameter("cep");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");

            int anoIngresso = Integer.parseInt(request.getParameter("anoIngresso"));
            int semestreIngresso = Integer.parseInt(request.getParameter("semestreIngresso"));
            String status = request.getParameter("status");

            int posicaoVestibular = Integer.parseInt(request.getParameter("posicaoVestibular"));
            String posicaoVestibularString = String.valueOf(posicaoVestibular);
            if(posicaoVestibularString.length()==1){
                posicaoVestibularString="0".concat(posicaoVestibularString);
            }

            int codCurso = Integer.parseInt(request.getParameter("curso"));
            String codCursoString = String.valueOf(codCurso);
            if(codCursoString.length()==1){
                codCursoString="0".concat(codCursoString);
            }

            String anoIngressoString = String.valueOf(anoIngresso);
            if(anoIngressoString.length()>2){
                anoIngressoString = String.valueOf(anoIngresso).substring(String.valueOf(anoIngresso).length()-2,anoIngressoString.length());
            }

            String matriculaConcat = anoIngressoString + codCursoString+posicaoVestibularString;

            int matricula = Integer.parseInt(matriculaConcat);

            if (operacao.equals("Incluir")) {
                aluno = new Aluno(matricula, nomeAluno, dataNascimento,
                    logradouro, numero, complemento, bairro, cep, cidade, estado, rg,cpf,email,
                    anoIngresso, semestreIngresso, status, posicaoVestibular, Curso.obterCurso(codCurso));
                aluno.gravar();
            } else if (operacao.equals("Editar")) {
                aluno.setNome(nomeAluno);
                aluno.setDtNascimento(dataNascimento);
                aluno.setEndLogradouro(logradouro);
                aluno.setEndNumero(numero);
                aluno.setEndComplemento(complemento);
                aluno.setEndBairro(bairro);
                aluno.setEndCep(cep);
                aluno.setEndCidade(cidade);
                aluno.setEndEstado(estado);
                aluno.setRg(rg);
                aluno.setCpf(cpf);
                aluno.setEmail(email);
                aluno.setAnoIngresso(anoIngresso);
                aluno.setSemestreIngresso(semestreIngresso);
                aluno.setStatus(status);
                aluno.setPosicaoVestibular(posicaoVestibular);
                Curso curso = Curso.obterCurso(codCurso);
                aluno.setCurso(curso);
                aluno.editar();
            } else if (operacao.equals("Excluir")) {
                aluno.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarAlunoController");
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
            List<Enum> estados = new ArrayList<Enum>();
            estados.addAll(Arrays.asList(Estados.values()));
            
            request.setAttribute("estados", estados);
            
            if (!operacao.equals("Incluir")) {
                int matriculaAluno = Integer.parseInt(request.getParameter("matricula"));
                aluno = Aluno.obterAluno(matriculaAluno);
                request.setAttribute("aluno", aluno);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
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
