package dao;

import pojo.Hocki;

import java.util.List;

public class HocKiDAO {
    public static List<Hocki> selectAll(){
        return Command.selectAll(new Hocki());
    }
}
