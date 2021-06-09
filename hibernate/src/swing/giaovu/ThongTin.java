package swing.giaovu;

import pojo.Giaovu;

import javax.swing.*;

public class ThongTin {
    public ThongTin(Giaovu gv){
        JFrame info=new JFrame("Infomation");
        String name[]={"Ho va ten", "Ma so", "Dia chi", "Gioi", "Ngay sinh"};
        Object data[][]= {{gv.getHoten(), gv.getMagiaovu(), gv.getDiachi(), gv.getGioi(), gv.getNgaysinh()}};
        JTable table=new JTable(data, name);
        JScrollPane pane=new JScrollPane(table);
        info.add(pane);
        info.pack();
        info.setVisible(true);
    }
}
