package Time;


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class CountTime {
	//使用Date 获取当前系统时间  然后使用getTime  来将日期时间转化成毫秒数
     public static void main(String[] args) throws InterruptedException{
//    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//    	 Date d1 = new Date();
//    	 Thread.sleep(1000);
//    	 Date d2 = new Date();
//    	 System.out.println(d2.getTime()-d1.getTime());// new Date()为获取当前系统时间
//    	 
//    	 
//    	 System.out.println(Calendar.getInstance().getTime());
    	 
//         Timestamp timestamp =new Timestamp(new Date().getTime());
//         System.out.println(timestamp);
//         Calendar calendar= Calendar.getInstance();
//         System.out.println(calendar.getTime());
//         calendar.setTime(timestamp);
//         System.out.println(calendar.getTime());
//         System.out.println(calendar.get(Calendar.MONTH)+1);
    	 
    	 Calendar calendar = Calendar.getInstance();
    	 calendar.add(Calendar.DATE, 120);
    	 calendar.set(Calendar.HOUR_OF_DAY, 10);
//    	 int dayDiff = calendar-DA;
//    	 System.out.println(dayDiff);
//    	 System.out.println(calendar);
//    	 Timestamp temp =new Timestamp(calendar.getTimeInMillis());
//    	 System.out.println(temp);
//    	 calendar.set(Calendar.HOUR_OF_DAY, 20);
//    	 System.out.println(temp);
//    	 Timestamp temp1 =new Timestamp(calendar.getTimeInMillis());
//         System.out.println(temp1);
//    	 System.out.println(temp1.after(temp));
//    	 System.out.println(temp1.before(temp));
     
     }
}
