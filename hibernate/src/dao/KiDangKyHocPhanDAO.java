package dao;

import pojo.Kidangkyhocphan;

import java.util.List;

public class KiDangKyHocPhanDAO {
    public static List<Kidangkyhocphan> selectAll(){
        return Command.selectAll(new Kidangkyhocphan());
    }
}
