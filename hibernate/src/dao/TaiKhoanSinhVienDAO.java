package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Taikhoansinhvien;
import util.HibernateUtil;

import java.util.List;

public class TaiKhoanSinhVienDAO {
    public static List<Taikhoansinhvien> selectAll(){
        return Command.selectAll(new Taikhoansinhvien());
    }
    public static List<Taikhoansinhvien> select(String tk) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Taikhoansinhvien> tksv = null;
        try {
            final String hql = "select tksv from Taikhoansinhvien tksv where tksv.taikhoan=:tk";
            Query query = session.createQuery(hql);
            query.setParameter("tk", tk);
            tksv = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return tksv;
    }
}
