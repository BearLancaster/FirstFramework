import com.tool.fun.Stringtotxt;

public class Main {

    public static void main(String[] args) {
        String path="D:\\data.txt";
        String pathW="D:\\data_1.txt";
        Stringtotxt a=new Stringtotxt();
        int i=a.readFileNumber(path);
        String[] lines=a.readFileLine(path,i);
        a.writeFile(lines,i,pathW);

    }
}
