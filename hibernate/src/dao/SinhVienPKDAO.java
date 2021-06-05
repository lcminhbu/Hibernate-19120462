package dao;

import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.SinhvienPK;

import java.util.List;

public class SinhVienPKDAO {
    public static List<SinhvienPK> getAllStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SinhvienPK> st_class = null;
        try {
            final String hql = "select st from SinhvienLop st";
            Query query = session.createQuery(hql);
            st_class = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return st_class;
    }
}
