package lambda;

/**
 * Created by 优华 on 2015/6/25.
 */
public class TestRunnable {
    public static void main(String[] args){
        Runnable run1 = () ->{ System.out.println(2);};
//        Thread t1 = new Thread(run1);
//        t1.start();
        run1.run();
    }
}
