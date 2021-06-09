package dao;

import pojo.SinhvienLop;

import java.util.List;

public class SinhVienLopDAO {
    public static List<SinhvienLop> selectAll(){
        return Command.selectAll(new SinhvienLop());
    }
}
