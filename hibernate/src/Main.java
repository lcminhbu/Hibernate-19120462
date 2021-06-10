import java.util.List;

import dao.GiaoVuDAO;
import pojo.Giaovu;
import swing.Login;

public class Main {

    public static void main(String[] args) {
    	List<Giaovu> gv= GiaoVuDAO.selectAll();
    	for(int i=0;i<gv.size();i++)
    	{
    		System.out.println(gv.get(i).getHoten());
    	}
	    new Login();
    }
}
