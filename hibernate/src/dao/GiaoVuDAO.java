package dao;

import pojo.Giaovu;

import java.util.List;

public class GiaoVuDAO {
    public static List<Giaovu> selectAll()
    {
        return Command.selectAll(new Giaovu());
    }

}
