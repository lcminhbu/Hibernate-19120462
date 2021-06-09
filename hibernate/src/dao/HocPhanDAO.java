package dao;

import pojo.Hocphan;

import java.util.List;

public class HocPhanDAO {
    public static List<Hocphan> selectAll(){
        return Command.selectAll(new Hocphan());
    }
}
