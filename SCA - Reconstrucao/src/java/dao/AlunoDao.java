package dao;

import java.sql.SQLException;
import java.util.List;
import model.Aluno;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AlunoDao {
    public static List<Aluno> obterAlunos() throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        List<Aluno> alunos = session.createCriteria(Aluno.class).list();
        session.close();
        return alunos;
    }
    
    public static List<Aluno> obterAlunosPorNome(String nome) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        List<Aluno> alunos = session.createQuery(
                "from Aluno where nome like'%"+nome+"%'").list();
        session.close();
        return alunos;
    }
    
    public static Aluno obterAluno(int matricula) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        Aluno aluno = (Aluno) session.load(Aluno.class, matricula);
        session.close();
        
        return aluno;
    }
    
    public static void gravarAluno(Aluno aluno) throws SQLException, ClassNotFoundException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(aluno);
        transaction.commit();
        session.close();
    }
    
    public static void editarAluno(Aluno aluno) throws SQLException, ClassNotFoundException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(aluno);
        transaction.commit();
        session.close();
    }
    
    public static void excluirAluno(Aluno aluno) throws SQLException, ClassNotFoundException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(aluno);
        transaction.commit();
        session.close();
    }
    
}
