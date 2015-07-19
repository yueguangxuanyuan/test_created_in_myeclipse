package Reflect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 优华 on 2015/6/26.
 */
public class TestReflect {

    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;

        Method[] methods = intClass.getDeclaredMethods();

        List<Method> methodlist = Arrays.asList(methods);

        String k = "";
        methodlist.stream().filter(p->{
            return p.getName().length() > 7;
        }).sorted((a, b) -> {
            return (a.getName().length() > b.getName().length()) ? 1 : (a.getName().length() < b.getName().length()) ? -1 : (a.getName().compareTo(b.getName()));
        }).forEach((p) -> {
            System.out.println(p.getName() + " : " + p.getParameters().length);
        });

    }

}
