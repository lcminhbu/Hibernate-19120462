package dao;

import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Lop;

import java.util.List;

public class LopDAO {
    public static List<Lop> getAllStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Lop> l = null;
        try {
            final String hql = "select l from Lop l";
            Query query = session.createQuery(hql);
            l = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return l;
    }
}
