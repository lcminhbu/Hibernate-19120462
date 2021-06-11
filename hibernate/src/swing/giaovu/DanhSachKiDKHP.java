package swing.giaovu;

import dao.Command;
import dao.HocKiDAO;
import dao.KiDangKyHocPhanDAO;
import dao.MonDAO;
import pojo.Hocki;
import pojo.Kidangkyhocphan;
import pojo.KidangkyhocphanPK;
import pojo.Mon;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

public class DanhSachKiDKHP {
    public DanhSachKiDKHP(){
        List<Kidangkyhocphan> dsdkhp =KiDangKyHocPhanDAO.selectAll();
        List<Hocki> dshk= HocKiDAO.selectAll();
        JFrame kidkhp=new JFrame();
        JMenuBar top=new JMenuBar();
        JPanel addForm=new JPanel();
        JPanel label=new JPanel();
        JPanel tf=new JPanel();
        DefaultTableModel model=new DefaultTableModel();
        JTable table=new JTable(model);
        JScrollPane scrollPane=new JScrollPane(table);

        JLabel hkDangXem= new JLabel("Học kì đang xem: ");
        top.add(hkDangXem);
        JMenu hkdx=new JMenu("Tất cả học kì");
        top.add(hkdx);

        JLabel hkHienTai=new JLabel("Học kì hiện tại: ");
        top.add(hkHienTai);
        JMenu hk=new JMenu("----");
        top.add(hk);
        JMenuItem add=new JMenuItem("Thêm");
        top.add(add);

        Hocki hkht=Command.hocKiHienTai(dshk);
        if(hkht!=null){
            hk.setText(hkht.getKhoaChinh().getHocki()+" "+hkht.getKhoaChinh().getNamhoc());
        }

        JTextField batdau=new JTextField(20);
        batdau.setToolTipText("yyyy-mm-dd hh:mm:ss");
        JTextField ketthuc=new JTextField(20);
        ketthuc.setToolTipText("yyyy-mm-dd hh:mm:ss");

        JButton submit=new JButton("Thêm vào");

        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        label.add(new JLabel("Thời gian bắt đầu: "));
        label.add(new JLabel("Thời gian kết thúc: "));

        tf.setLayout(new BoxLayout(tf, BoxLayout.Y_AXIS));
        tf.add(batdau);
        tf.add(ketthuc);

        addForm.setLayout(new FlowLayout());

        model.addColumn("Học kì");
        model.addColumn("Thời gian bắt đầu");
        model.addColumn("Thời gian kết thúc");

        for(int i=0;i<dsdkhp.size();i++){
            model.addRow(new Object[]{dsdkhp.get(i).getKhoaChinh().getHocki()+" "+dsdkhp.get(i).getKhoaChinh().getNamhoc(),
                    dsdkhp.get(i).getKhoaChinh().getThoigianbatdau(), dsdkhp.get(i).getThoigianketthuc()});
        }
        JMenuItem menu[]=new JMenuItem[dshk.size()];
        for(int i=0;i<dshk.size();i++){
            menu[i]=new JMenuItem(dshk.get(i).getKhoaChinh().getHocki()+" "+dshk.get(i).getKhoaChinh().getNamhoc());
            hk.add(menu[i]);
            menu[i].setActionCommand(Integer.toString(i));
            menu[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    for(int j=0;j<dshk.size();j++){
                        dshk.get(j).setHockihientai((byte)0);
                        HocKiDAO.update(dshk.get(j));
                    }
                    int temp=Integer.valueOf(e.getActionCommand());
                    dshk.get(temp).setHockihientai((byte)1);
                    HocKiDAO.update(dshk.get(temp));
                    hk.setText(dshk.get(temp).getKhoaChinh().getHocki()+" "+dshk.get(temp).getKhoaChinh().getNamhoc());
                    List<Mon>mon= MonDAO.selectAll();
                    for(int j=0;j<mon.size();j++){
                        Iterator<Hocki> hks=mon.get(j).getHockiSet().iterator();
                        while(hks.hasNext()){
                            Hocki hk=hks.next();
                            System.out.println(mon.get(j).getMamon()+" "+hk.hocKiVaNam()+" "+hk.getHockihientai());
                        }
                    }
                    System.out.println();
                }
            });
        }

        JMenuItem[] dangXem=new JMenuItem[dshk.size()+1];
        for(int i=0;i<dshk.size();i++){
            dangXem[i]=new JMenuItem(dshk.get(i).getKhoaChinh().getHocki()+" "+dshk.get(i).getKhoaChinh().getNamhoc());
            hkdx.add(dangXem[i]);
            dangXem[i].setActionCommand(Integer.toString(i));
            dangXem[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int mark= Integer.valueOf(e.getActionCommand());
                    String temp= dshk.get(mark).getKhoaChinh().getHocki()+" "+dshk.get(mark).getKhoaChinh().getNamhoc();
                    TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
                    table.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter(temp));
                }
            });
        }
        dangXem[dshk.size()]=new JMenuItem("Tất cả học kì");
        dangXem[dshk.size()].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
                table.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(""));
            }
        });
        hkdx.add(dangXem[dshk.size()]);

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
                if (batdau.getText().equals("") || ketthuc.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Hãy điền đầy đủ nội dung");
                }
                else {
                    Hocki hkht= Command.hocKiHienTai(dshk);
                    model.addRow(new Object[]{hkht.getKhoaChinh().getHocki()+" "+hkht.getKhoaChinh().getNamhoc()
                            , batdau.getText(), ketthuc.getText()});
                    KidangkyhocphanPK kc=new KidangkyhocphanPK(hkht.getKhoaChinh().getHocki(), hkht.getKhoaChinh().getNamhoc()
                            , Timestamp.valueOf(batdau.getText()));
                    Kidangkyhocphan dkhp = new Kidangkyhocphan(kc, Timestamp.valueOf(ketthuc.getText()));
                    batdau.setText("");
                    ketthuc.setText("");
                    if(KiDangKyHocPhanDAO.add(dkhp)){
                        dsdkhp.add(dkhp);
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
        });
        kidkhp.setLayout(new BorderLayout());
        kidkhp.add(top, BorderLayout.NORTH);
        kidkhp.add(addForm, BorderLayout.WEST);
        kidkhp.add(scrollPane, BorderLayout.CENTER);
        kidkhp.setSize(600,300);
        kidkhp.setVisible(true);
    }
}
