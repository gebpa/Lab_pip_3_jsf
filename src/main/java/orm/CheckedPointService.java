package orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class CheckedPointService {
    private static SessionFactory sessionFactory = null;

    static{
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public CheckedPointService() {
    }

    public CheckedPoint update (CheckedPoint point) throws ClassNotFoundException{
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(point);
        session.getTransaction().commit();
        return point;
    }

    public CheckedPoint add (CheckedPoint point) throws ClassNotFoundException{
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(point);
        session.getTransaction().commit();
        return point;
    }

    public void delete(CheckedPoint point) throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(point);
        session.getTransaction().commit();
    }

    public List<CheckedPoint> getAllPoints() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException{
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<CheckedPoint> result = session.createQuery("from CheckedPoint order by id").list();
        session.getTransaction().commit();
        return result;
    }
}