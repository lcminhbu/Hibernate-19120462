package swing.giaovu;

import dao.HocKiDAO;
import pojo.Hocki;
import pojo.HockiPK;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

public class DanhSachHocKi {
    public DanhSachHocKi(){
        List<Hocki> dshk= HocKiDAO.selectAll();
        JFrame hk=new JFrame();
        JMenuBar top=new JMenuBar();
        JPanel addForm=new JPanel();
        JPanel label=new JPanel();
        JPanel tf=new JPanel();
        DefaultTableModel model=new DefaultTableModel();
        JTable table=new JTable(model);
        JScrollPane scrollPane=new JScrollPane(table);

        JMenuItem add=new JMenuItem("Thêm");
        top.add(add);

        JTextField hocki=new JTextField(20);
        hocki.setToolTipText("hk + {1,2,3}");
        JTextField namhoc=new JTextField(20);
        namhoc.setToolTipText("namhoc1 + ' - '+ namhoc2");
        JTextField batdau=new JTextField(20);
        batdau.setToolTipText("yyyy-mm-dd");
        JTextField ketthuc=new JTextField(20);

        JButton submit=new JButton("Thêm vào");

        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        label.add(new JLabel("Học kì: "));
        label.add(new JLabel("Năm học: "));
        label.add(new JLabel("Ngày bắt đầu: "));
        label.add(new JLabel("Ngày kết thúc: "));

        tf.setLayout(new BoxLayout(tf, BoxLayout.Y_AXIS));
        tf.add(hocki);
        tf.add(namhoc);
        tf.add(batdau);
        tf.add(ketthuc);

        addForm.setLayout(new FlowLayout());

        model.addColumn("Học kì");
        model.addColumn("Năm học");
        model.addColumn("Ngày bắt đầu");
        model.addColumn("Ngày kết thúc");

        for(int i=0;i<dshk.size();i++){
            model.addRow(new Object[]{dshk.get(i).getKhoaChinh().getHocki(),dshk.get(i).getKhoaChinh().getNamhoc(),
                    dshk.get(i).getThoigianbatdau(), dshk.get(i).getThoigianketthuc()});
        }

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                top.remove(add);
                top.updateUI();
                addForm.add(label);
                addForm.add(tf);
                addForm.add(submit);
                addForm.updateUI();
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hocki.getText().equals("") || namhoc.getText().equals("") || batdau.getText().equals("") || ketthuc.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Hãy điền đầy đủ nội dung");
                }
                else {
                    String temp=hocki.getText().toLowerCase(Locale.ROOT);
                    if(temp.compareTo("hk1")!=0&&temp.compareTo("hk2")!=0&&temp.compareTo("hk3")!=0){
                        JOptionPane.showMessageDialog(null, "Định dạng học kì không đúng");
                    }
                    else {
                        int i=0;
                        for(;i<dshk.size();i++){
                            if(dshk.get(i).getKhoaChinh().getHocki().toLowerCase(Locale.ROOT).compareTo(temp)==0){
                                if(dshk.get(i).getKhoaChinh().getNamhoc().compareTo(namhoc.getText())==0){
                                    JOptionPane.showMessageDialog(null, "Học kì vừa nhập đã tồn tại");
                                    break;
                                }
                            }
                        }
                        if(i==dshk.size()){
                            model.addRow(new Object[]{hocki.getText(), namhoc.getText(), batdau.getText(), ketthuc.getText()});
                            HockiPK kc=new HockiPK(hocki.getText(), namhoc.getText());
                            Hocki HOCKI = new Hocki(kc, Timestamp.valueOf(batdau.getText()+" 00:00:00"),
                                    Timestamp.valueOf(ketthuc.getText()+" 00:00:00"), (byte)0, null);
                            hocki.setText("");
                            namhoc.setText("");
                            batdau.setText("");
                            ketthuc.setText("");
                            if(HocKiDAO.add(HOCKI)){
                                dshk.add(HOCKI);
                                JOptionPane.showMessageDialog(null, "Thêm thành công");
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Định dạng thời gian không đúng");
                            }
                            addForm.removeAll();
                            top.add(add);
                            addForm.updateUI();
                            top.updateUI();
                        }
                    }
                }
            }
        });
        hk.setLayout(new BorderLayout());
        hk.add(top, BorderLayout.NORTH);
        hk.add(addForm, BorderLayout.WEST);
        hk.add(scrollPane, BorderLayout.CENTER);
        hk.setSize(600,300);
        hk.setVisible(true);
    }
}
