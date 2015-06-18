package DateFormat;

import java.sql.Date;
import java.util.Calendar;

public class sql_Date {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date(calendar.getTimeInMillis());
		System.out.println(date);
	}
}
