package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Mon;
import pojo.Sinhvien;
import util.HibernateUtil;

import java.util.List;

public class MonDAO {
    public static List<Mon> selectAll(){
        return Command.selectAll(new Mon());
    }
    public static Mon select(String mamon){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Mon mon = null;
        try {
            final String hql = "select s from Mon s where s.mamon=:ms";
            Query query = session.createQuery(hql);
            query.setParameter("ms", mamon);
            mon = (Mon)query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return mon;
    }
    public static boolean add(Mon m){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(select(m.getMamon())!=null)
        {
            return false;
        }
        boolean result=true;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(m);
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
    public static boolean delete(Mon m){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.remove(m);
            session.beginTransaction().commit();
        }catch(HibernateException e){
            System.err.println(e);
            return false;
        }finally{
            session.close();
        }
        return true;
    }
    public static boolean update(Mon m){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.update(m);
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
