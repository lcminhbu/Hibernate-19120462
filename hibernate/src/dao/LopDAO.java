package dao;

import pojo.Lop;

import java.util.List;

public class LopDAO {
    public static List<Lop> selectAll(){
        return Command.selectAll(new Lop());
    }
}
