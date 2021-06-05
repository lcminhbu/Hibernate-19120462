package dao;

import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Giaovu;

import java.util.List;

public class GiaoVuDAO {
    public static List<Giaovu> getAllStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Giaovu> gv = null;
        try {
            final String hql = "select gv from Giaovu gv";
            Query query = session.createQuery(hql);
            gv = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return gv;
    }
}
