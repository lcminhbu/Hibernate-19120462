package swing.giaovu;

import dao.GiaoVuDAO;
import dao.TaiKhoanGiaoVuDAO;
import pojo.Giaovu;
import pojo.Taikhoangiaovu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuGiaoVu {
    public MenuGiaoVu(){
        JFrame menu=new JFrame("Menu");
        JButton info=new JButton("Xem thong tin");
        JButton changePass=new JButton("Thay doi mat khau");
        JButton logout=new JButton("Dang xuat");
        JButton giaoVuList=new JButton("Danh sach giao vu");
        JButton monHocList = new JButton("Danh sach mon hoc");
        JButton danhSachHocKi = new JButton("Danh sach hoc ki");
        JButton danhSachSinhVien = new JButton("Danh sach sinh vien");
        JButton kyDKHP = new JButton("Ky dang ky hoc phan");
        JButton danhSachHocPhan = new JButton("Danh sach hoc phan");
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Giaovu> gv= GiaoVuDAO.selectAll();
                new ThongTin(gv.get(0));
            }
        });
        changePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Taikhoangiaovu> gv= TaiKhoanGiaoVuDAO.selectAll();
                new DoiMatKhau(gv.get(0));
            }
        });
        menu.setSize(400,200);
        menu.add(info);
        menu.add(changePass);
        menu.add(logout);
        menu.add(giaoVuList);
        menu.add(monHocList);
        menu.add(danhSachHocKi);
        menu.add(danhSachSinhVien);
        menu.add(kyDKHP);
        menu.add(danhSachHocPhan);
        menu.setLayout(new FlowLayout());
        menu.setVisible(true);
    }
}
