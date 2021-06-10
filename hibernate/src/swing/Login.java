package swing;

import dao.GiaoVuDAO;
import dao.TaiKhoanGiaoVuDAO;
import dao.TaiKhoanSinhVienDAO;
import pojo.Taikhoangiaovu;
import pojo.Taikhoansinhvien;
import swing.sinhvien.MenuSinhVien;
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
        JPanel pn1= new JPanel();
        JPanel pn2= new JPanel();
        JPanel pn3= new JPanel();
        JPanel pn4= new JPanel();
        JPanel pn5= new JPanel();

        JTextField user=new JTextField(20);
        JPasswordField pass=new JPasswordField(20);
        pass.setEchoChar('*');

        JButton hienThi=new JButton("()");
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

        JButton turnBack=new JButton("<-");
        turnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(true);
                gvdn.dispose();
            }
        });

        JButton submit=new JButton("Đăng nhập");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Taikhoangiaovu> taiKhoan=TaiKhoanGiaoVuDAO.selectAll();
                List<Taikhoangiaovu> tkgv = TaiKhoanGiaoVuDAO.select(user.getText());
                int i=0;
                for(;i<tkgv.size();i++)
                {
                    if(tkgv.get(i).getMatkhau().compareTo(String.valueOf(pass.getPassword()))==0)
                    {
                        new MenuGiaoVu(GiaoVuDAO.selectAll(), taiKhoan, tkgv.get(0));
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

        JLabel lb=new JLabel("Trang đăng nhập dành cho Giáo vụ");
        JLabel lbuser= new JLabel("Tài khoản: ");
        JLabel lbpass = new JLabel("Mật khẩu: ");

        pn1.setLayout(new BoxLayout(pn1, BoxLayout.X_AXIS));
        pn1.add(lb);
        pn1.add(turnBack);

        pn4.setLayout(new BoxLayout(pn4, BoxLayout.Y_AXIS));
        pn4.add(lbuser);
        pn4.add(lbpass);

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
    public static void sinhVienDangNhap() {
        JFrame svdn = new JFrame();
        JPanel pn1 = new JPanel();
        JPanel pn2 = new JPanel();
        JPanel pn3 = new JPanel();
        JPanel pn4 = new JPanel();
        JPanel pn5 = new JPanel();

        JTextField user = new JTextField(20);
        user.setToolTipText("Mã sinh viên.");

        JPasswordField pass = new JPasswordField(20);
        pass.setEchoChar('*');

        JButton hienThi = new JButton("()");
        hienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pass.echoCharIsSet()) {
                    pass.setEchoChar((char) 0);
                } else {
                    pass.setEchoChar('*');
                }
            }
        });

        JButton turnBack = new JButton("<-");
        turnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(true);
                svdn.dispose();
            }
        });

        JButton submit = new JButton("Đăng nhập");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Taikhoansinhvien> tksv = TaiKhoanSinhVienDAO.select(user.getText());
                int i = 0;
                for (; i < tksv.size(); i++) {
                    if (tksv.get(i).getMatkhau().compareTo(String.valueOf(pass.getPassword())) == 0) {
                        new MenuSinhVien();
                        break;
                    }
                }
                if (i == tksv.size()) {
                    JLabel err = new JLabel("Ten dang nhap hoac mat khau khong dung!");
                    svdn.add(err);
                }
                svdn.setVisible(true);
            }
        });

        JLabel lb = new JLabel("Trang đăng nhập dành cho Sinh viên");
        JLabel lbuser = new JLabel("Tài khoản: ");
        JLabel lbpass = new JLabel("Mật khẩu: ");

        pn1.setLayout(new BoxLayout(pn1, BoxLayout.X_AXIS));
        pn1.add(lb);
        pn1.add(turnBack);

        pn4.setLayout(new BoxLayout(pn4, BoxLayout.Y_AXIS));
        pn4.add(lbuser);
        pn4.add(lbpass);

        pn2.setLayout(new BoxLayout(pn2, BoxLayout.Y_AXIS));
        pn2.add(user);
        pn2.add(pass);

        pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
        pn3.add(hienThi);

        pn5.setLayout(new FlowLayout());
        pn5.add(pn4);
        pn5.add(pn2);

        svdn.add(pn1);
        svdn.add(pn5);
        svdn.add(pn3);
        svdn.add(submit);

        svdn.setLayout(new FlowLayout());
        svdn.setSize(400, 300);
        svdn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        svdn.setLocationRelativeTo(null);
        svdn.setVisible(true);
    }
}
