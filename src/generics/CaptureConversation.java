package generics;

/**
 * Created by 优华 on 2015/6/26.
 */
public class CaptureConversation {
    static <T> void f1(Holder<T> holder){
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }


    static  void f2(Holder<?> holder){
        f1(holder);
    }

    public static void main(String[] args){
        Holder raw = new Holder<Integer>(1);
        f1(raw);
        f2(raw);

        Holder rawBasic  = new Holder();

        rawBasic.set(new Object());

        f2(rawBasic);
        Holder<?> wildcarded = new Holder<Double>(1.1);
        f2(wildcarded);
    }
}
