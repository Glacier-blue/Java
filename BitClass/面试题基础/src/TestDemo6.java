import java.util.ArrayList;
import java.util.List;

class A{}
class B extends A{}
class C extends A{}
public class TestDemo6 {
    List<A> list1=new ArrayList<>();
    List<B> list2=new ArrayList<>();
    list1=list2;
    list2=list1;
}
