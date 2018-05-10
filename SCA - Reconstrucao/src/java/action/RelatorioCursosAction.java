
package action;

import controller.Action;
import dao.BD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class RelatorioCursosAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            
            String acao = request.getParameter("acao");

            if(acao.equals("prepararOperacao")){
               prepararOperacao(request,response);
            } else {
                if(acao.equals("confirmarOperacao")){
                    confirmarOperacao(request,response);
                }
            }
        } catch (ServletException ex) {
            Logger.getLogger(RelatorioCursosAction.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        RequestDispatcher view = request.getRequestDispatcher("/relatorioCurso.jsp");
        try {
            view.forward(request, response);
        } catch (IOException ex) {
            throw new ServletException(ex);
        }
    }
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        Connection conexao = null;

        try {
            conexao = BD.getConexao();
            HashMap parametros = new HashMap();
            parametros.put("PAR_codCurso", Integer.parseInt(request.getParameter("txtCodCurso")));
//            String relatorio = getServletContext().getRealPath("/WEB-INF/classes/report")+"/relatorioCurso.jasper";
//            JasperPrint jp = JasperFillManager.fillReport(relatorio, parametros, conexao);
//            byte[] relat = JasperExportManager.exportReportToPdf(jp);
            response.setHeader("Content-Disposition", "attachment;filename=relatorioCurso.pdf");
            response.setContentType("application/pdf");
//            response.getOutputStream().write(relat);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ServletException(ex);
        } finally {
            try {
                if (!conexao.isClosed()) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
    }
    
}
