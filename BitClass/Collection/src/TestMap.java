import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<Character,Integer> hashtable=new HashMap<>();
        String s="abcdefgh";
        for(int i=0;i<s.length();i++){
            Integer count=hashtable.get(s.charAt(i));
            hashtable.put(s.charAt(i),count==null?1:count+1);
        }
        for(int i=97;i<=122;i++){
            System.out.println(hashtable.get((char)i));
        }
    }
}
