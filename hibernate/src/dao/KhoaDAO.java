package dao;

import pojo.Khoa;

import java.util.List;

public class KhoaDAO {
    public static List<Khoa> selectAll(){
        return Command.selectAll(new Khoa());
    }
}
