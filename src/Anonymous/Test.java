package Anonymous;

public class Test {
    class A implements Help {
               public String getName() {
                      return "Name-A";
              }
   }
   interface Help{
	   public String getName();
   }
   class TestClassB{
	   
   }
   interface estInterface{
	   
   }
   public static void main(String[] args) {
             //正确写法

             Help help = new Help() {
                     public String getName() {
                              return "Name-Help";
                     }
             };

             //用 Eclipse 检验有没语法错误，就知道答案了
             //预先告诉结果：这种写法是不可行的。

//             Help help1 = new Help() implements TestInterface {
//                     public String getName() {
//                              return "Name-Help";
//                     }
//             };
   }

}