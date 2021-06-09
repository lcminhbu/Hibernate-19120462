package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Taikhoangiaovu;
import util.HibernateUtil;

import java.util.List;

public class TaiKhoanGiaoVuDAO {
    public static List<Taikhoangiaovu> selectAll(){
        return Command.selectAll(new Taikhoangiaovu());
    }
    public static List<Taikhoangiaovu> select(String tk){
        Session session= HibernateUtil.getSessionFactory().openSession();
        List<Taikhoangiaovu> tkgv=null;
        try{
            final String hql="select tkgv from Taikhoangiaovu tkgv where tkgv.taikhoan=:tk";
            Query query= session.createQuery(hql);
            query.setParameter("tk", tk);
            tkgv=query.list();
        }catch(HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return tkgv;
    }
}
