package Swing.GiaoVu;

import pojo.Giaovu;
import pojo.Taikhoangiaovu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePass {
    public ChangePass(Taikhoangiaovu tkgv){
        JFrame changePass = new JFrame();
        changePass.setLayout(new FlowLayout());
        JLabel confirm = new JLabel("Hay nhap mat khau cu");
        JPasswordField oldPass = new JPasswordField(20);
        JLabel newP = new JLabel("Hay nhap mat khau moi");
        JPasswordField newPass = new JPasswordField(20);
        JButton submit = new JButton("Doi mat khau");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(String.valueOf(oldPass.getPassword()).compareTo(tkgv.getMk())!=0)
                {
                    JLabel err = new JLabel("Sai mat khau cu");
                    changePass.add(err);
                }
                else if(String.valueOf(newPass.getPassword()).compareTo("")==0){
                    JLabel err = new JLabel("Mat khau moi khong duoc de trong");
                    changePass.add(err);
                }
                else{
                    //dat mat khau moi.
                    tkgv.setMk(String.valueOf(newPass.getPassword()));
                }
            }
        });
        changePass.add(confirm);
        changePass.add(oldPass);
        changePass.add(newP);
        changePass.add(newPass);
        changePass.add(submit);
        changePass.setVisible(true);
    }
}
