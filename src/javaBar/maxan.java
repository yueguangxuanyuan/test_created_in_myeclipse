package javaBar;

public class maxan {
public static void main(String[] args) 
{
int x[]={12,20,36,24,51,20,10,32};
int max=x[0];
int min=x[0];
for(int i=1;i<x.length;i++){
if (x[i]>max){
max=x[i];
}
if (x[i]<min){
min=x[i];
}
}
System.out.println("数列中最大的数是："+max);
System.out.println("数列中最小的数是："+min);
}
}
