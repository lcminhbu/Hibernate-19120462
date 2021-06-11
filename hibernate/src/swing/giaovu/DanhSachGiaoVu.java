package swing.giaovu;

import pojo.Giaovu;
import pojo.Taikhoangiaovu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class DanhSachGiaoVu {
    public DanhSachGiaoVu(List<Giaovu> dsgv, List<Taikhoangiaovu> tkgv){
        JFrame dsGV=new JFrame("Danh sách giáo vụ");
        JButton findButt=new JButton("Tìm kiếm giáo vụ");
        findButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TimKiem(tkgv);
            }
        });
        dsGV.setLayout(new BorderLayout());
        dsGV.add(findButt, BorderLayout.NORTH);
        String name[]={"Mã số", "Họ tên", "Khoa", "Giới", "Địa chỉ", "SĐT", "Ngày sinh"};
        Object data[][]=new Object[dsgv.size()][];
        for(int i=0;i<dsgv.size();i++){
            Object dat[]={dsgv.get(i).getMagiaovu(),dsgv.get(i).getHoten(), dsgv.get(i).getMakhoa(), dsgv.get(i).getGioi()
            , dsgv.get(i).getDiachi(), dsgv.get(i).getSdt(), dsgv.get(i).getNgaysinh()};
            data[i]=dat;
        }
        JTable table=new JTable(data, name);
        JScrollPane scroll= new JScrollPane(table);
        dsGV.add(scroll, BorderLayout.CENTER);
        dsGV.setSize(800,400);
        dsGV.setVisible(true);
    }

    public static void TimKiem(List<Taikhoangiaovu> tkgv){
        JFrame find=new JFrame("Tìm tài khoản");
        find.setLayout(new BorderLayout());

        JLabel findlb=new JLabel("Nhập mã giáo vụ cần tìm: ");
        JTextField tf=new JTextField(10);

        JPanel pnl=new JPanel();
        pnl.setLayout(new FlowLayout());
        pnl.add(findlb);
        pnl.add(tf);
        find.add(pnl, BorderLayout.NORTH);
        DefaultTableModel model=new DefaultTableModel();
        JTable table=new JTable(model);
        model.addColumn("Mã giáo vụ");
        model.addColumn("Họ tên");
        model.addColumn("Tài khoản");

        for(int i=0;i<tkgv.size();i++){
            model.addRow(new Object[]{tkgv.get(i).getGiaovu().getMagiaovu(), tkgv.get(i).getGiaovu().getHoten(), tkgv.get(i).getTaikhoan()});
        }
        JScrollPane scrollPane=new JScrollPane(table);
        tf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String search=tf.getText();
                TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
                table.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(search));
            }
        });
        find.add(scrollPane);
        find.setSize(400,300);
        find.setVisible(true);
    }
}
