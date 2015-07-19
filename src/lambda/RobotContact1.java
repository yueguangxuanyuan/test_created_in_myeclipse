package lambda;

import java.util.List;

/**
 * Created by 优华 on 2015/6/25.
 * 使用foreach 迭代器的方式来遍历List
 */
public class RobotContact1 {
    public void callDrivers(List<Person> pl) {
        for (Person p : pl) {
            if (p.getAge() >= 16) {
                roboCall(p);
            }
        }
    }

    public void emailDraftees(List<Person> pl) {
        for (Person p : pl) {
            if (p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE) {
                roboEmail(p);
            }
        }
    }

    public void mailPilots(List<Person> pl) {
        for (Person p : pl) {
            if (p.getAge() >= 23 && p.getAge() <= 65) {
                roboMail(p);
            }
        }
    }


    public void roboCall(Person p) {
        System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone());
    }

    public void roboEmail(Person p) {
        System.out.println("EMailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail());
    }

    public void roboMail(Person p) {
        System.out.println("Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress());
    }
}
