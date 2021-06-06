package dao;

import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Dangkyhocphan;

import java.util.List;

public class dkhpDAO {
    public static List<Dangkyhocphan> selectAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Dangkyhocphan> dkhp = null;
        try {
            final String hql = "select dkhp from Dangkyhocphan dkhp";
            Query query = session.createQuery(hql);
            dkhp = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return dkhp;
    }
}
