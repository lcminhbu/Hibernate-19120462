package swing.giaovu;

import pojo.Giaovu;
import pojo.Taikhoangiaovu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuGiaoVu {
    public MenuGiaoVu(List<Giaovu> dsgv, List<Taikhoangiaovu> tkgv, Taikhoangiaovu gvHienTai){
        JPanel top=new JPanel();
        JPanel center=new JPanel();
        JFrame menu=new JFrame();
        menu.setLayout(new BorderLayout());
        menu.add(top, BorderLayout.NORTH);
        menu.add(center, BorderLayout.CENTER);
        JLabel hello=new JLabel("Xin chào " + gvHienTai.getGiaovu().getHoten());
        JButton thongTin=new JButton("Thông tin");
        thongTin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThongTin(gvHienTai.getGiaovu());
            }
        });
        thongTin.setSize(40,20);
        JButton doiMatKhau=new JButton("Đổi mật khẩu");
        doiMatKhau.setSize(40,20);
        doiMatKhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoiMatKhau(gvHienTai);
            }
        });

        JButton dangXuat=new JButton("Đăng xuất");
        top.add(hello);
        top.add(thongTin);
        top.add(doiMatKhau);
        top.add(dangXuat);
        top.setLayout(new FlowLayout());

        JButton dsSinhVien=new JButton("Danh sách sinh viên");
        dsSinhVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DanhSachSinhVien();
            }
        });
        center.add(dsSinhVien);

        JButton dsGiaoVu = new JButton("Danh sách giáo vụ");
        dsGiaoVu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DanhSachGiaoVu(dsgv, tkgv);
            }
        });

        center.add(dsGiaoVu);

        JButton dsHocKi=new JButton("Danh sách học kì");
        dsHocKi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DanhSachHocKi();
            }
        });

        center.add(dsHocKi);

        JButton dsHocPhan=new JButton("Danh sách học phần");
        dsHocPhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DanhSachHocPhan();
            }
        });

        center.add(dsHocPhan);

        JButton dsKiDKHP=new JButton("Danh sách kì DKHP");
        dsKiDKHP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DanhSachKiDKHP();
            }
        });

        center.add(dsKiDKHP);

        JButton dsLop=new JButton("Danh sách lớp");
        dsLop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DanhSachLop();
            }
        });

        center.add(dsLop);

        JButton dsMon=new JButton("Danh sách môn học");
        dsMon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DanhSachMonHoc();
            }
        });

        center.add(dsMon);
        center.setLayout(new GridLayout(3,2,20,20));
        menu.setSize(800,400);
        menu.setVisible(true);
    }
}
