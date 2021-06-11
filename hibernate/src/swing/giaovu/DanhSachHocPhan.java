package swing.giaovu;

import dao.*;
import pojo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class DanhSachHocPhan {
    public DanhSachHocPhan(){
        List<Hocphan> dshp= HocPhanDAO.selectAll();
        List<MonHocki> dsmhk= MonHocKiDAO.selectAll();
        List<SinhvienHocphan> dssvhp=SinhVienHocPhanDAO.selectAll();
        List<Hocki> dshk=HocKiDAO.selectAll();

        JFrame hocPhan=new JFrame();
        JMenuBar top=new JMenuBar();
        JPanel addForm=new JPanel();
        JPanel label=new JPanel();
        JPanel tf=new JPanel();
        DefaultTableModel model=new DefaultTableModel();
        JTable table=new JTable(model);
        JScrollPane scrollPane=new JScrollPane(table);

        JMenu hocKiDangXem=new JMenu("Học kì đang xem: ");
        JMenuItem[] hkdx=new JMenuItem[dshk.size()+1];
        JMenu hocKiHienTai = new JMenu("Học kì hiện tại: ");
        JMenuItem[] menu=new JMenuItem[dshk.size()];
        JMenuItem add=new JMenuItem("Thêm");
        JMenuItem delete=new JMenuItem("Xóa dòng đang chọn");

        JTextField id=new JTextField(20);
        JTextField name=new JTextField(20);
        JTextField soTC=new JTextField(20);
        JTextField gv=new JTextField(20);
        JTextField phong=new JTextField(20);
        JTextField ngay=new JTextField(20);
        JTextField ca=new JTextField(20);
        JTextField soSlot=new JTextField(20);

        JButton submit=new JButton("Thêm vào");
        JButton confirm =new JButton("Chỉnh sửa");

        top.add(new JLabel("Học kì đang xem: "));
        top.add(hocKiDangXem);
        top.add(new JLabel("Học kì hiện tại: "));
        top.add(hocKiHienTai);
        top.add(add);
        top.add(delete);

        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        label.add(new JLabel("Tên môn học: "));
        label.add(new JLabel("Mã môn học: "));
        label.add(new JLabel("Số tín chỉ: "));
        label.add(new JLabel("Giáo viên lý thuyết: "));
        label.add(new JLabel("Phòng học: "));
        label.add(new JLabel("Học vào thứ: "));
        label.add(new JLabel("Ca học: "));
        label.add(new JLabel("Số slot tối đa: "));

        tf.setLayout(new BoxLayout(tf, BoxLayout.Y_AXIS));
        tf.add(name);
        tf.add(id);
        tf.add(soTC);
        tf.add(gv);
        tf.add(phong);
        tf.add(ngay);
        tf.add(ca);
        tf.add(soSlot);

        addForm.setLayout(new FlowLayout());

        model.addColumn("Mã môn học");
        model.addColumn("Tên môn học");
        model.addColumn("Mã học phần");
        model.addColumn("Tên học phần");
        model.addColumn("Số tín chỉ");
        model.addColumn("Giáo viên lý thuyết");
        model.addColumn("Phòng học");
        model.addColumn("Ngày học");
        model.addColumn("Ca học");
        model.addColumn("Số slot tối đa");
        model.addColumn("Học kì");
        for(int i=0;i<dshp.size();i++){
            Hocphan temp=dshp.get(i);
            Hocki[] HK= (Hocki[])temp.getKhoaChinh().getMon().getHockiSet().toArray();
            for(int j=0;j<HK.length;j++){
                model.addRow(new Object[]{temp.getKhoaChinh().getMon().getMamon(),
                        temp.getKhoaChinh().getMon().getTenmon(), temp.getKhoaChinh().getMahocphan(),
                        temp.getTenhocphan(), temp.getSotinchi(), temp.getGiangvienlythuyet(), temp.getPhonghoc(),
                        temp.getNgayhoc(), temp.getCahoc(), temp.getSoslottoida(), HK[j]});
            }
        }
        for(int i=0;i<dshk.size();i++){
            menu[i]=new JMenuItem(dshk.get(i).hocKiVaNam());
            hocKiHienTai.add(menu[i]);
            menu[i].setActionCommand(Integer.toString(i));
            menu[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int j=0;j<dshk.size();j++){
                        dshk.get(j).setHockihientai((byte)0);
                    }
                    int temp=Integer.valueOf(e.getActionCommand());
                    dshk.get(temp).setHockihientai((byte)1);
                    HocKiDAO.update(dshk.get(temp));
                    hocKiHienTai.setText(dshk.get(temp).hocKiVaNam());
                }
            });
        }

//        JMenuItem[] dangXem=new JMenuItem[dshk.size()+1];
//        for(int i=0;i<dshk.size();i++){
//            dangXem[i]=new JMenuItem(dshk.get(i).getKhoaChinh().getHocki()+" "+dshk.get(i).getKhoaChinh().getNamhoc());
//            hkdx.add(dangXem[i]);
//            dangXem[i].setActionCommand(Integer.toString(i));
//            dangXem[i].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    int mark= Integer.valueOf(e.getActionCommand());
//                    String temp= dshk.get(mark).getKhoaChinh().getHocki()+" "+dshk.get(mark).getKhoaChinh().getNamhoc();
//                    TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
//                    table.setRowSorter(tr);
//                    tr.setRowFilter(RowFilter.regexFilter(temp));
//                }
//            });
//        }
//        dangXem[dshk.size()]=new JMenuItem("Tất cả học kì");
//        dangXem[dshk.size()].addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
//                table.setRowSorter(tr);
//                tr.setRowFilter(RowFilter.regexFilter(""));
//            }
//        });
//        hkdx.add(dangXem[dshk.size()]);
//
//        add.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                top.remove(add);
//                top.updateUI();
//                addForm.add(label);
//                addForm.add(tf);
//                addForm.add(submit);
//                addForm.updateUI();
//            }
//        });
//
//        submit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (id.getText().equals("") || name.getText().equals("") || soTC.getText().equals("") || kh.getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Hãy điền đầy đủ nội dung");
//                }
//                else {
//                    model.addRow(new Object[]{id.getText(), name.getText(), soTC.getText(), kh.getText()});
//                    Mon m = new Mon(id.getText(), Integer.parseInt(soTC.getText()), name.getText(), kh.getText(), null);
//                    id.setText("");
//                    name.setText("");
//                    soTC.setText("");
//                    kh.setText("");
//                    MonDAO.add(m);
//                    dsm.add(m);
//                    addForm.removeAll();
//                    top.add(add);
//                    addForm.updateUI();
//                    top.updateUI();
//                    JOptionPane.showMessageDialog(null, "Thêm thành công");
//                }
//            }
//        });
//
//        update.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                top.remove(update);
//                top.updateUI();
//                addForm.add(label);
//                addForm.add(tf);
//                addForm.add(confirm);
//                addForm.updateUI();
//            }
//        });
//
//        confirm.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (id.getText().equals("") || name.getText().equals("") || soTC.getText().equals("") || kh.getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Hãy điền đầy đủ nội dung");
//                }
//                else {
//                    model.setValueAt(id.getText(), table.getSelectedRow(), 0);
//                    model.setValueAt(name.getText(), table.getSelectedRow(), 1);
//                    model.setValueAt(soTC.getText(), table.getSelectedRow(), 2);
//                    model.setValueAt(kh.getText(), table.getSelectedRow(), 3);
//                    Mon m = new Mon(id.getText(), Integer.parseInt(soTC.getText()), name.getText(), kh.getText(), null);
//                    id.setText("");
//                    name.setText("");
//                    soTC.setText("");
//                    kh.setText("");
//                    for(int i=0;i<dsm.size();i++){
//                        if(dsm.get(i).getMamon().compareTo(m.getMamon())==0){
//                            dsm.get(i).setTenmon(m.getTenmon());
//                            dsm.get(i).setSotinchi(m.getSotinchi());
//                            m.setHockiSet(dsm.get(i).getHockiSet());
//                            break;
//                        }
//                    }
//                    MonDAO.update(m);
//                    addForm.removeAll();
//                    top.add(update);
//                    addForm.updateUI();
//                    top.updateUI();
//                    JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công");
//                }
//            }
//        });
//
//        delete.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int con=JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa dòng này không?","Confirm",
//                        JOptionPane.YES_NO_OPTION,
//                        JOptionPane.PLAIN_MESSAGE);
//                if(con==0){
//                    String ID= (String) model.getValueAt(table.getSelectedRow(), 0);
//                    String NAME= (String) model.getValueAt(table.getSelectedRow(), 1);
//                    Integer SOTC= (Integer) model.getValueAt(table.getSelectedRow(), 2);
//                    String KHOA= (String) model.getValueAt(table.getSelectedRow(), 3);
//                    model.removeRow(table.getSelectedRow());
//                    Mon m=new Mon(ID, SOTC, NAME, KHOA, null);
//                    for(int i=0;i<dsm.size();i++){
//                        if(dsm.get(i).getMamon().compareTo(ID)==0){
//                            m.setHockiSet(dsm.get(i).getHockiSet());
//                            dsm.remove(i);
//                            break;
//                        }
//                    }
//                    MonDAO.delete(m);
//                }
//            }
//        });
//
//        table.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                id.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)));
//                name.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 1)));
//                soTC.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 2)));
//                kh.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 3)));
//            }
//            @Override
//            public void mousePressed(MouseEvent e) { }
//            @Override
//            public void mouseReleased(MouseEvent e) { }
//            @Override
//            public void mouseEntered(MouseEvent e) { }
//            @Override
//            public void mouseExited(MouseEvent e) { }
//        });
//
//        mon.setLayout(new BorderLayout());
//        mon.add(top, BorderLayout.NORTH);
//        mon.add(addForm, BorderLayout.WEST);
//        mon.add(scrollPane, BorderLayout.CENTER);
//        mon.setSize(600,300);
//        mon.setVisible(true);
    }
}
