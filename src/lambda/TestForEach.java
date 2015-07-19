package lambda;

import java.util.List;

/**
 * Created by 优华 on 2015/6/25.
 */
public class TestForEach {
    public static void main(String[] args) {

             List<Person> pl = Person.createShortList();

             System.out.println("\n=== Western Phone List ===");
             pl.forEach( p -> System.out.println(p.getAddress()) );

//             System.out.println("\n=== Eastern Phone List ===");
//             pl.forEach(Person::printEasternName);

             System.out.println("\n=== Custom Phone List ===");
             pl.forEach(p -> { System.out.println(p.printCustom(r -> "Name: " + r.getGivenName() + " EMail: " + r.getEmail())); });

           }
}
