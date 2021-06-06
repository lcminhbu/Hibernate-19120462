package dao;

import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Hocphan;

import java.util.List;

public class HocPhanDAO {
    public static List<Hocphan> selectAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Hocphan> hp = null;
        try {
            final String hql = "select hp from Hocphan hp";
            Query query = session.createQuery(hql);
            hp = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return hp;
    }
}
