package swing;

import dao.TaiKhoanGiaoVuDAO;
import dao.TaiKhoanSinhVienDAO;
import pojo.Taikhoangiaovu;
import pojo.Taikhoansinhvien;
import swing.giaovu.MenuGiaoVu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login {
    private static JFrame start;
    public Login(){
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
        JButton submit=new JButton("Đăng nhập");
        JLabel lb=new JLabel("Trang đăng nhập dành cho Giáo vụ");
        JLabel lbuser= new JLabel("Tài khoản: ");
        JLabel lbpass = new JLabel("Mật khẩu: ");
        JPanel pn4= new JPanel();
        JPanel pn1= new JPanel();
        JPanel pn2= new JPanel();
        JPanel pn3= new JPanel();
        JPanel pn5= new JPanel();

        pass.setEchoChar('*');
        submit.setActionCommand("submit");
        user.setToolTipText("Ma giao vu");

        pn4.setLayout(new BoxLayout(pn4, BoxLayout.Y_AXIS));
        pn4.add(lbuser);
        pn4.add(lbpass);

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
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Taikhoangiaovu> tkgv = TaiKhoanGiaoVuDAO.select(user.getText());
                int i=0;
                for(;i<tkgv.size();i++)
                {
                    if(tkgv.get(i).getMatkhau().compareTo(String.valueOf(pass.getPassword()))==0)
                    {
                        new MenuGiaoVu();
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
        pn1.setLayout(new BoxLayout(pn1, BoxLayout.X_AXIS));
        pn1.add(lb);
        pn1.add(turnBack);
        pn2.setLayout(new BoxLayout(pn2, BoxLayout.Y_AXIS));
        pn2.add(user);
        pn2.add(pass);
        pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
        pn3.add(hienThi);
        pn5.setLayout(new FlowLayout());
        pn5.add(pn4);
        pn5.add(pn2);
        gvdn.add(pn1);
        gvdn.add(pn5);
        gvdn.add(pn3);
        gvdn.add(submit);
        gvdn.setLayout(new FlowLayout());
        gvdn.setSize(400,300);
        gvdn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gvdn.setLocationRelativeTo(null);
        gvdn.setVisible(true);
    }
    public static void sinhVienDangNhap(){
        JFrame svdn =new JFrame();
        JPanel pn1= new JPanel();
        JPanel pn2 = new JPanel();
        JPanel pn3= new JPanel();
        JPanel pn4 = new JPanel();
        JPanel pn5= new JPanel();

        JLabel lb=new JLabel("Trang đăng nhập dành cho Sinh viên");
        JLabel userlb=new JLabel("Tài khoản: ");
        JLabel passlb=new JLabel("Mật khẩu: ");

        JTextField user=new JTextField(20);
        JPasswordField pass=new JPasswordField(20);

        JButton submit=new JButton("Đăng nhập");
        JButton hienThi=new JButton("()");
        JButton turnBack=new JButton("<-");

        svdn.add(pass);
        svdn.add(submit);
        svdn.setSize(400,300);
        svdn.setLayout(new FlowLayout());
        svdn.setLocationRelativeTo(null);
        svdn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        user.setToolTipText("Ma sinh vien");
        submit.setActionCommand("submit");
        pass.setEchoChar('*');

        svdn.setLayout(new BoxLayout(svdn, BoxLayout.Y_AXIS));
        pn1.setLayout(new BoxLayout(pn1, BoxLayout.X_AXIS));
        pn2.setLayout(new BoxLayout(pn2, BoxLayout.Y_AXIS));
        pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
        pn4.setLayout(new BoxLayout(pn4, BoxLayout.X_AXIS));
        pn5.setLayout(new BoxLayout(pn5, BoxLayout.Y_AXIS));



        pn1.add(lb);
        pn1.add(turnBack);

        pn2.add(userlb);
        pn2.add(passlb);

        pn3.add(user);
        pn3.add(pass);

        pn4.add(pn2);
        pn4.add(pn3);

        pn5.add(pn1, hienThi);
        pn5.add(pn4, submit);

        svdn.add(pn5);

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
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Taikhoansinhvien> tksv = TaiKhoanSinhVienDAO.select(user.getText());
                int i=0;
                for(;i<tksv.size();i++)
                {
                    if(tksv.get(i).getMatkhau().compareTo(String.valueOf(pass.getPassword()))==0)
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

        svdn.setVisible(true);
    }
}
