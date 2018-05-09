package dao;

import java.sql.SQLException;
import java.util.List;
import model.Curso;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CursoDAO {
    public static void gravarCurso(Curso curso) throws SQLException, ClassNotFoundException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(curso);
        transaction.commit();
    }
    
    public static void editarCurso(Curso curso) throws SQLException, ClassNotFoundException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(curso);
        transaction.commit();
    }
    
    public static void excluirCurso(Curso curso) throws SQLException, ClassNotFoundException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(curso);
        transaction.commit();
    }
    
    public static List<Curso> obterCursos() throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Curso> cursos = session.createCriteria(Curso.class).list();
        return cursos;
    }
    
    public static Curso obterCurso(int codCurso) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Curso curso = (Curso) session.load(Curso.class, codCurso);
        return curso;
    }
}
