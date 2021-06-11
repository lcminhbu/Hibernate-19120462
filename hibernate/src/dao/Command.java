package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Hocki;
import pojo.Sinhvien;
import util.HibernateUtil;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Command <T> {
    public static <T> List<T> selectAll(T type){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<T> data = null;
        try {
            final String hql = "select s from " + type.getClass().getName() +" s";
            Query query = session.createQuery(hql);
            data = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return data;
    }
    public static Hocki hocKiHienTai(List<Hocki> dshk) {
        for (int i = 0; i < dshk.size(); i++) {
            if (dshk.get(i).getHockihientai() == 1) {
                return dshk.get(i);
            }
        }
        return null;
    }
}
