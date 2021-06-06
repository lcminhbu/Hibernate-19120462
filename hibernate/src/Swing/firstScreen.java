package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
                giaoVuDangNhap();
            }
        });
        sv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sinhVienDangNhap();
            }
        });
        start.add(lb);
        start.add(gv);
        start.add(sv);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setLayout(new FlowLayout());
        start.setSize(400,300);
        start.setVisible(true);
    }
    public static void giaoVuDangNhap(){
        JFrame gvdn =new JFrame();
        JTextField user=new JTextField(20);
        JTextField pass=new JTextField(20);
        JButton submit=new JButton("Đăng nhập");
        submit.setActionCommand("submit");
        JLabel lb=new JLabel("Trang đăng nhập dành cho Giáo vụ");
        gvdn.add(lb);
        gvdn.add(user);
        user.setToolTipText("Ma giao vu");
        user.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("submit".equals(e.getActionCommand()))
                {
                    System.out.println(user.getText());
                }
            }
        });
        gvdn.add(pass);
        gvdn.add(submit);
        gvdn.setSize(400,300);
        gvdn.setLayout(new FlowLayout());
        gvdn.setVisible(true);
    }
    public static void sinhVienDangNhap(){
        JFrame svdn =new JFrame();
        JTextField user=new JTextField(20);
        JTextField pass=new JTextField(20);
        JButton submit=new JButton("Đăng nhập");
        submit.setActionCommand("submit");
        JLabel lb=new JLabel("Trang đăng nhập dành cho Sinh viên");
        svdn.add(lb);
        svdn.add(user);
        user.setToolTipText("Ma giao vu");
        user.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("submit".equals(e.getActionCommand()))
                {
                    System.out.println(user.getText());
                }
            }
        });
        svdn.add(pass);
        svdn.add(submit);
        svdn.setSize(400,300);
        svdn.setLayout(new FlowLayout());
        svdn.setVisible(true);
    }
}
