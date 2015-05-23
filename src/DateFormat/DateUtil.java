package DateFormat;

import java.text.SimpleDateFormat;

public class DateUtil
{
	public static void main(String[] args){
	   System.out.println(DateUtil.isValidDate("1992-2-29"));
	}
    private static SimpleDateFormat dateFormat = null;
    static 
    {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
    }

    public static boolean isValidDate(String s)
    {
        try
        {
             dateFormat.parse(s);
             return true;
         }
        catch (Exception e)
        {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }
    
    
}
