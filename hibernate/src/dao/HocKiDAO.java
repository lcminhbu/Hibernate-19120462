package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Hocki;
import pojo.HockiPK;
import pojo.Mon;
import util.HibernateUtil;

import java.util.List;

public class HocKiDAO {
    public static List<Hocki> selectAll(){
        return Command.selectAll(new Hocki());
    }
    public static Hocki select(HockiPK khoaChinh){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Hocki hocki = null;
        try {
            final String hql = "select s from Hocki s where s.khoaChinh.hocki=:hocKi and s.khoaChinh.namhoc=:namHoc";
            Query query = session.createQuery(hql);
            query.setParameter("hocKi", khoaChinh.getHocki());
            query.setParameter("namHoc", khoaChinh.getNamhoc());
            hocki = (Hocki)query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return hocki;
    }
    public static boolean add(Hocki hk){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(select(hk.getKhoaChinh())!=null)
        {
            return false;
        }
        boolean result=true;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(hk);
            transaction.commit();
        }catch(HibernateException e){
            transaction.rollback();
            System.err.println(e);
            result=false;
        }finally{
            session.close();
        }
        return result;
    }
    public static boolean update(Hocki hk){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.update(hk);
            session.beginTransaction().commit();
        }catch(HibernateException e){
            System.err.println(e);
            return false;
        }finally{
            session.close();
        }
        return true;
    }
}
