package Swing;

import Swing.GiaoVu.GiaoVuMenu;
import dao.TaiKhoanGiaoVuDAO;
import dao.TaiKhoanSinhVienDAO;
import pojo.Taikhoangiaovu;
import pojo.Taikhoansinhvien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class firstScreen {
private static JFrame start;
    public firstScreen(){
        start=new JFrame();
        JLabel lb=new JLabel("Bạn muốn đăng nhập với tư cách giáo vụ hay sinh viên?");
        JButton gv=new JButton("Giáo vụ");
        JButton sv=new JButton("Sinh viên");
        gv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(false);
                giaoVuDangNhap(start);
            }
        });
        sv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(false);
                sinhVienDangNhap();
            }
        });
        start.add(lb);
        start.add(gv);
        start.add(sv);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setLayout(new FlowLayout());
        start.setSize(400,300);
        start.setLocationRelativeTo(null);
        start.setVisible(true);
    }
    public static void giaoVuDangNhap(JFrame start){
        JFrame gvdn =new JFrame();
        JButton hienThi=new JButton("()");
        JButton turnBack=new JButton("<-");
        JTextField user=new JTextField(20);
        JPasswordField pass=new JPasswordField(20);
        pass.setEchoChar('*');
        JButton submit=new JButton("Đăng nhập");
        submit.setActionCommand("submit");
        JLabel lb=new JLabel("Trang đăng nhập dành cho Giáo vụ");
        gvdn.add(lb);
        gvdn.add(user);
        user.setToolTipText("Ma giao vu");
        gvdn.add(turnBack);
        turnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(true);
                gvdn.dispose();
            }
        });
        hienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pass.echoCharIsSet())
                {
                    pass.setEchoChar((char)0);
                }
                else
                {
                    pass.setEchoChar('*');
                }
            }
        });
        gvdn.add(hienThi);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Taikhoangiaovu> tkgv = TaiKhoanGiaoVuDAO.select(user.getText());
                int i=0;
                for(;i<tkgv.size();i++)
                {
                    if(tkgv.get(i).getMk().compareTo(String.valueOf(pass.getPassword()))==0)
                    {
                        new GiaoVuMenu();
                        break;
                    }
                }
                if(i==tkgv.size())
                {
                    JLabel err=new JLabel("Ten dang nhap hoac mat khau khong dung!");
                    gvdn.add(err);
                }
                gvdn.setVisible(true);
            }
        });
        gvdn.add(pass);
        gvdn.add(submit);
        gvdn.setSize(400,300);
        gvdn.setLayout(new FlowLayout());
        gvdn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gvdn.setVisible(true);
    }
    public static void sinhVienDangNhap(){
        JFrame svdn =new JFrame();
        JTextField user=new JTextField(20);
        JPasswordField pass=new JPasswordField(20);
        pass.setEchoChar('*');
        JButton submit=new JButton("Đăng nhập");
        submit.setActionCommand("submit");
        JLabel lb=new JLabel("Trang đăng nhập dành cho Sinh viên");
        svdn.add(lb);
        svdn.add(user);
        user.setToolTipText("Ma sinh vien");
        JButton hienThi=new JButton("()");
        JButton turnBack=new JButton("<-");
        svdn.add(turnBack);
        turnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(true);
                svdn.dispose();
            }
        });
        hienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pass.echoCharIsSet())
                {
                    pass.setEchoChar((char)0);
                }
                else
                {
                    pass.setEchoChar('*');
                }
            }
        });
        svdn.add(hienThi);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Taikhoansinhvien> tksv = TaiKhoanSinhVienDAO.select(user.getText());
                int i=0;
                for(;i<tksv.size();i++)
                {
                    if(tksv.get(i).getMk().compareTo(String.valueOf(pass.getPassword()))==0)
                    {
                           JLabel success=new JLabel("Dang nhap thanh cong!");
                           svdn.add(success);
                           break;
                    }
                }
                if(i==tksv.size())
                {
                    JLabel err=new JLabel("Ten dang nhap hoac mat khau khong dung!");
                    svdn.add(err);
                }
                svdn.setVisible(true);
            }
        });
        svdn.add(pass);
        svdn.add(submit);
        svdn.setSize(400,300);
        svdn.setLayout(new FlowLayout());
        svdn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        svdn.setVisible(true);
    }
}
