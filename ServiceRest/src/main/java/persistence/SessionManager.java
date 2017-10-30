package persistence;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionManager {
    private static Session session;
    private static Transaction currentTransaction;

    public Session getSession(){ return session;}
    public SessionManager(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public static Session openCurrentSessionWithTransaction() {
        currentTransaction = session.beginTransaction();
        return session;
    }
    public void closeCurrentSession() {
        session.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        session.close();
    }

}
