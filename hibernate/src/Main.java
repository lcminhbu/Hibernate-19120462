import dao.SinhVienDAO;
import pojo.Sinhvien;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Sinhvien> sv= SinhVienDAO.getAllStudent();
        for(Sinhvien item:sv)
        {
            System.out.println(item.getHoTen());
        }
    }
}
