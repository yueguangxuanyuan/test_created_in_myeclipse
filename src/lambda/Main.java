package lambda;

import java.util.*;
import java.util.function.Function;

/**
 * Created by 优华 on 2015/6/25.
 */
public class Main {
    public static void main(String[] args) {
        Function<Person, String> easternStyle = p -> "\nName: " + p.getSurName() + " "
                + p.getGivenName() + "\n" + "Age: " + p.getAge() + "  " +
                "Gender: " + p.getGender() + "\n" +
                "EMail: " + p.getEmail() + "\n" +
                "Phone: " + p.getPhone() + "\n" +
                "Address: " + p.getAddress();

        List<HashMap<Person, String>> lhps = new ArrayList<HashMap<Person, String>>();
        HashMap<Person, String> hps = new HashMap();
        System.out.println(hps.getClass());
        hps.put(new Person(), "AA");
        lhps.add(hps);
        Main.test(lhps);

        ArrayList<String>[] aa = new ArrayList[10];
        aa[0] = new ArrayList<String>();
        aa[0].add("ssssss");
        Object[] objects = aa;
        objects[1] = new ArrayList<Integer>();
        System.out.println(aa[0].get(0).getClass());
    }

    /*
                    这里的IDE 报错属于泛型的一个bug 泛型在编译过程中是类型擦除的
                    在强转的过程中 需要用到类型兼容的时候需要访问实际的类型  此时就会报错
                    但是可以使用,能够编译通过
    */
    public static <T extends Person, M extends Map<T, String>> void test(List<M> haha) {
//        @SuppressWarnings("unchecked")
//        List<Map<Person, String>> p = (List<Map<Person, String>>) haha;
//        Map<Person, String> mps = p.get(0);
//        System.out.println(mps.keySet().size())
        ;
        List<Person> pl = Person.createShortList();
        pl.stream().forEach(Person::printEasternName);
    }

    /*
    这部分是在ArrayList中的策略   内部使用Object存储对象  出来的时候使用一次类型强转
     */
    public <E> E testReturn() {
        return (E) new Object();
    }
}
