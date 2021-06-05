package dao;

import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Sinhvien;

import java.util.List;

public class SinhVienDAO {
    public static List<Sinhvien> getAllStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Sinhvien> sv = null;
        try {
            final String hql = "select s from Sinhvien s";
            Query query = session.createQuery(hql);
            sv = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return sv;
    }
}
