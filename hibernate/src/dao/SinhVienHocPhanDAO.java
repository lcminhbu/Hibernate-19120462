package dao;

import pojo.SinhvienHocphan;

import java.util.List;

public class SinhVienHocPhanDAO {
    public static List<SinhvienHocphan> selectAll(){
        return Command.selectAll(new SinhvienHocphan());
    }
}
