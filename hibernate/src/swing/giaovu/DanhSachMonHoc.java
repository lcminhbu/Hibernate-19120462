package swing.giaovu;

import dao.KhoaDAO;
import dao.MonDAO;
import pojo.Khoa;
import pojo.Mon;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class DanhSachMonHoc {
    public DanhSachMonHoc(){
        List<Khoa> k= KhoaDAO.selectAll();
        List<Mon> dsm= MonDAO.selectAll();

        JFrame mon=new JFrame();
        JMenuBar top=new JMenuBar();
        JPanel addForm=new JPanel();
        JPanel label=new JPanel();
        JPanel tf=new JPanel();
        DefaultTableModel model=new DefaultTableModel();
        JTable table=new JTable(model);
        JScrollPane scrollPane=new JScrollPane(table);

        JMenu khoa=new JMenu("Khoa");
        JMenuItem[] menuItems=new JMenuItem[k.size()+1];
        JMenuItem add=new JMenuItem("Thêm");
        JMenuItem update=new JMenuItem("Sửa dòng đang chọn");
        JMenuItem delete=new JMenuItem("Xóa dòng đang chọn");

        JTextField id=new JTextField(20);
        JTextField name=new JTextField(20);
        JTextField soTC=new JTextField(20);
        JTextField kh=new JTextField(20);

        JButton submit=new JButton("Thêm vào");
        JButton confirm =new JButton("Chỉnh sửa");

        top.add(khoa);
        top.add(add);
        top.add(update);
        top.add(delete);

        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        label.add(new JLabel("Tên môn học: "));
        label.add(new JLabel("Mã môn học: "));
        label.add(new JLabel("Số tín chỉ: "));
        label.add(new JLabel("Khoa: "));

        tf.setLayout(new BoxLayout(tf, BoxLayout.Y_AXIS));
        tf.add(name);
        tf.add(id);
        tf.add(soTC);
        tf.add(kh);

        addForm.setLayout(new FlowLayout());

        model.addColumn("Mã môn học");
        model.addColumn("Tên môn học");
        model.addColumn("Số tín chỉ");
        model.addColumn("Khoa");
        for(int i=0;i<dsm.size();i++){
            model.addRow(new Object[]{dsm.get(i).getMamon(),dsm.get(i).getTenmon(),dsm.get(i).getSotinchi(), dsm.get(i).getMakhoa()});
        }
        for(int i=0;i<k.size();i++){
            menuItems[i]= new JMenuItem(k.get(i).getMakhoa());
            String temp=k.get(i).getMakhoa();
            menuItems[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    khoa.setText(temp);
                    TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
                    table.setRowSorter(tr);
                    tr.setRowFilter(RowFilter.regexFilter("^"+temp));
                }
            });
        }
        menuItems[k.size()]=new JMenuItem("Tất cả");
        menuItems[k.size()].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
                table.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(""));
            }
        });
        for(int i=0;i<k.size()+1;i++){
            khoa.add(menuItems[i]);
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
                if (id.getText().equals("") || name.getText().equals("") || soTC.getText().equals("") || kh.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Hãy điền đầy đủ nội dung");
                }
                else {
                    model.addRow(new Object[]{id.getText(), name.getText(), soTC.getText(), kh.getText()});
                    Mon m = new Mon(id.getText(), Integer.parseInt(soTC.getText()), name.getText(), kh.getText(), null);
                    id.setText("");
                    name.setText("");
                    soTC.setText("");
                    kh.setText("");
                    MonDAO.add(m);
                    dsm.add(m);
                    addForm.removeAll();
                    top.add(add);
                    addForm.updateUI();
                    top.updateUI();
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                top.remove(update);
                top.updateUI();
                addForm.add(label);
                addForm.add(tf);
                addForm.add(confirm);
                addForm.updateUI();
            }
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id.getText().equals("") || name.getText().equals("") || soTC.getText().equals("") || kh.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Hãy điền đầy đủ nội dung");
                }
                else {
                    model.setValueAt(id.getText(), table.getSelectedRow(), 0);
                    model.setValueAt(name.getText(), table.getSelectedRow(), 1);
                    model.setValueAt(soTC.getText(), table.getSelectedRow(), 2);
                    model.setValueAt(kh.getText(), table.getSelectedRow(), 3);
                    Mon m = new Mon(id.getText(), Integer.parseInt(soTC.getText()), name.getText(), kh.getText(), null);
                    id.setText("");
                    name.setText("");
                    soTC.setText("");
                    kh.setText("");
                    for(int i=0;i<dsm.size();i++){
                     if(dsm.get(i).getMamon().compareTo(m.getMamon())==0){
                         dsm.get(i).setTenmon(m.getTenmon());
                         dsm.get(i).setSotinchi(m.getSotinchi());
                         m.setHockiSet(dsm.get(i).getHockiSet());
                         break;
                     }
                    }
                    MonDAO.update(m);
                    addForm.removeAll();
                    top.add(update);
                    addForm.updateUI();
                    top.updateUI();
                    JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công");
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int con=JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa dòng này không?","Confirm",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);
                if(con==0){
                    String ID= (String) model.getValueAt(table.getSelectedRow(), 0);
                    String NAME= (String) model.getValueAt(table.getSelectedRow(), 1);
                    Integer SOTC= (Integer) model.getValueAt(table.getSelectedRow(), 2);
                    String KHOA= (String) model.getValueAt(table.getSelectedRow(), 3);
                    model.removeRow(table.getSelectedRow());
                    Mon m=new Mon(ID, SOTC, NAME, KHOA, null);
                    for(int i=0;i<dsm.size();i++){
                        if(dsm.get(i).getMamon().compareTo(ID)==0){
                            m.setHockiSet(dsm.get(i).getHockiSet());
                            dsm.remove(i);
                            break;
                        }
                    }
                    MonDAO.delete(m);
                }
            }
        });

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                id.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)));
                name.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 1)));
                soTC.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 2)));
                kh.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 3)));
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });

        mon.setLayout(new BorderLayout());
        mon.add(top, BorderLayout.NORTH);
        mon.add(addForm, BorderLayout.WEST);
        mon.add(scrollPane, BorderLayout.CENTER);
        mon.setSize(600,300);
        mon.setVisible(true);
    }
}
