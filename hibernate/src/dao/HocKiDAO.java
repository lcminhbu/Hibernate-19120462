package dao;

import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Hocki;

import java.util.List;

public class HocKiDAO {
    public static List<Hocki> getAllStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Hocki> hk = null;
        try {
            final String hql = "select hk from Hocki hk";
            Query query = session.createQuery(hql);
            hk = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return hk;
    }
}
