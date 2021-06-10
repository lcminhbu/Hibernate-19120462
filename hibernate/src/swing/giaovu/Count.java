package swing.giaovu;

public class Count {
    private static int count;
    public Count(){
        count=0;
    }
    public static int add(){
        count+=1;
        return count;
    }
    public static int reset(){
        count=0;
        return count;
    }
    public int getCount(){
        return count;
    }
}
