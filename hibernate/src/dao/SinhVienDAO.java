package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Sinhvien;
import util.HibernateUtil;

import java.util.List;

public class SinhVienDAO {

    public static List<Sinhvien> selectAll() {
        return Command.selectAll(new Sinhvien());
    }
    public static List<Sinhvien> select(String maSo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Sinhvien> sv = null;
        try {
            final String hql = "select s from Sinhvien s where s.masinhvien=:ms";
            Query query = session.createQuery(hql);
            query.setParameter("ms", maSo);
            sv = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return sv;
    }
    public static boolean add(Sinhvien sv){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(select(sv.getMasinhvien()).size()!=0)
        {
            return false;
        }
        boolean result=true;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(sv);
        }catch(HibernateException e){
            transaction.rollback();
            System.err.println(e);
            result=false;
        }finally{
            session.close();
        }
        return result;
    }
}
