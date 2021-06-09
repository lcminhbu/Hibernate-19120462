package dao;

import pojo.MonHocki;

import java.util.List;

public class MonHocKiDAO {
    public static List<MonHocki> selectAll(){
        return Command.selectAll(new MonHocki());
    }
}
