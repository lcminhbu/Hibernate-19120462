package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Hocki;
import pojo.HockiPK;
import pojo.Kidangkyhocphan;
import pojo.KidangkyhocphanPK;
import util.HibernateUtil;

import java.util.List;

public class KiDangKyHocPhanDAO {
    public static List<Kidangkyhocphan> selectAll(){
        return Command.selectAll(new Kidangkyhocphan());
    }
    public static Kidangkyhocphan select(KidangkyhocphanPK khoaChinh){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Kidangkyhocphan dkhp = null;
        try {
            final String hql = "select s from Kidangkyhocphan s where s.khoaChinh.hocki=:hocKi and s.khoaChinh.namhoc=:namHoc" +
                    " and s.khoaChinh.thoigianbatdau=:tgbd";
            Query query = session.createQuery(hql);
            query.setParameter("hocKi", khoaChinh.getHocki());
            query.setParameter("namHoc", khoaChinh.getNamhoc());
            query.setParameter("tgbd", khoaChinh.getThoigianbatdau());
            dkhp = (Kidangkyhocphan)query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return dkhp;
    }
    public static boolean add(Kidangkyhocphan dkhp){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(select(dkhp.getKhoaChinh())!=null)
        {
            return false;
        }
        boolean result=true;
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(dkhp);
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
}
