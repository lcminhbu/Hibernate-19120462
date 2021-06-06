package dao;

import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Taikhoangiaovu;

import java.util.List;

public class TaiKhoanGiaoVuDAO {
    public static List<Taikhoangiaovu> selectAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Taikhoangiaovu> tkgv = null;
        try {
            final String hql = "select tkgv from Taikhoangiaovu tkgv";
            Query query = session.createQuery(hql);
            tkgv = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return tkgv;
    }
}
