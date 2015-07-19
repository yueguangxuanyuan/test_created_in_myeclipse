package Biconsumer;


import java.util.function.BiConsumer;

/**
 * Created by 优华 on 2015/6/24.
 */
public class TestAndthen {
    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (String c,String z) -> {
            System.out.println(c);
            System.out.println("233");
        };

        biConsumer.andThen(biConsumer).accept("java2s.com", " tutorial");
    }
}
