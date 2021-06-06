package dao;

import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Sinhvien;

import java.util.List;

public class SinhVienDAO {
    public static List<Sinhvien> selectAll() {
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
    public static List<Sinhvien> select(String maSo, String cmnd){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Sinhvien> sv = null;
        try {
            final String hql = "select s from Sinhvien s where s.khoaChinh.maSinhVien=:ms and s.khoaChinh.cmnd=:cm";
            Query query = session.createQuery(hql);
            query.setParameter("ms", maSo);
            query.setParameter("cm", cmnd);
            sv = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return sv;
    }
}