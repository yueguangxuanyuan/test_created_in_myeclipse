package Time;

import java.util.Calendar;
import java.util.Date;

public class TestTime {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.set(Calendar.MONTH, 3); //设定4月
        newCalendar.set(Calendar.DATE, 1);
        java.sql.Date date =new java.sql.Date( newCalendar.getTimeInMillis());
        java.sql.Date date2 = new java.sql.Date(calendar.getTimeInMillis());
        System.out.println((date2.getTime() -date.getTime())/1000/24/3600);
        
//		java.sql.Date end = new java.sql.Date(calendar.getTimeInMillis());
//
//		calendar.add(Calendar.DATE, 0 - 2);
//
//		java.sql.Date start = new java.sql.Date(calendar.getTimeInMillis());
//
//		System.out.println(start.toString() + "|" + end.toString());

	}

}
