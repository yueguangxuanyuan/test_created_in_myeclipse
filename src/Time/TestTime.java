package Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import DateFormat.Dateformat;

public class TestTime {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.set(Calendar.MONTH, 5); //设定4月
        newCalendar.set(Calendar.DATE, 15);
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
        
        SimpleDateFormat  dateformat = new SimpleDateFormat ("yyyy-MM-dd'T'hh:mm:ss");
        dateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
			System.out.println(dateformat.parse("2015-11-13T03:11:29.823242+00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      

	}

}
