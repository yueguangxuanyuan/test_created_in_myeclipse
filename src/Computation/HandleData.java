package Computation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HandleData {
	int[] game_count_list;
	double[]  average_score_list;
	
	public HandleData(){
		game_count_list= new int[7];
		average_score_list= new double[7];
	}
	
	public void solution(List<GameInfo> list){
        for(int i = 0 ; i < list.size() ;i++){
        	String date = (list.get(i).getTime().split(" "))[0];
        	SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );    
        	Date d1 = new Date();
        	try {
        		d1 = df.parse( date );
        	} catch (ParseException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	} 
        	Date d2 = new Date();
        	
        	long Day = 24L * 60L * 60L * 1000L;
        	int interval = (int) (( d2.getTime() - d1.getTime() ) / Day);
        	
        	int index = 6-interval;
        	
        	average_score_list[index] = (game_count_list[index]*game_count_list[index]+Integer.parseInt(list.get(i).getScore()))/(game_count_list[index]+1);
        	game_count_list[index]++;
        }
        
        
	}
    public static void main(String[] args){
    	HandleData handleData = new HandleData();
    	handleData.solution(null);
    }
}
