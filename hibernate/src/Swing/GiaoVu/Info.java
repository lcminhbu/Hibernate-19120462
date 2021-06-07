package Swing.GiaoVu;

import pojo.Giaovu;

import javax.swing.*;

public class Info {
    public Info(Giaovu gv){
        JFrame info=new JFrame("Infomation");
        String name[]={"Ho va ten", "Ma so", "Dia chi", "Gioi", "Ngay sinh"};
        Object data[][]= {{gv.getHoTen(), gv.getMaGiaoVu(), gv.getDiaChi(), gv.getGioi(), gv.getNgaySinh()}};
        JTable table=new JTable(data, name);
        JScrollPane pane=new JScrollPane(table);
        info.add(pane);
        info.pack();
        info.setVisible(true);
    }
}
