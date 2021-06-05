package dao;

import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Kydkhp;

import java.util.List;

public class KyDkhpDAO {
    public static List<Kydkhp> getAllStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Kydkhp> ky = null;
        try {
            final String hql = "select ky from Kydkhp ky";
            Query query = session.createQuery(hql);
            ky = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return ky;
    }
}
