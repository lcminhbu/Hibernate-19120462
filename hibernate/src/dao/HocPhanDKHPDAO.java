package dao;

import pojo.HocphanDkhp;

import java.util.List;

public class HocPhanDKHPDAO {
    public static List<HocphanDkhp> selectAll(){
        return Command.selectAll(new HocphanDkhp());
    }
}
