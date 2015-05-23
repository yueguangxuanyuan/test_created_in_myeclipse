package StringCopy;

public class Stringcopy {
    public static void main(String[] args){
    	String in= "1+1=";
        char[] input = in.toCharArray();
        System.out.println(String.copyValueOf(input, 0, 2));
    }
}
