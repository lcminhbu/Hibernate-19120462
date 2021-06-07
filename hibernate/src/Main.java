import Swing.firstScreen;
import dao.SinhVienDAO;
import dao.TaiKhoanGiaoVuDAO;
import pojo.Sinhvien;
import pojo.Taikhoangiaovu;

import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Sinhvien> sv=SinhVienDAO.selectAll();
        for(int i=0;i<sv.size();i++)
        {
            System.out.println(sv.get(i).getHoTen());
        }
        List <Taikhoangiaovu> tkgv= TaiKhoanGiaoVuDAO.selectAll();
        for(int i=0;i<tkgv.size();i++)
        {
            System.out.println(tkgv.get(i).getTk() +" "+ tkgv.get(i).getMk());
        }
        new firstScreen();
    }
}
