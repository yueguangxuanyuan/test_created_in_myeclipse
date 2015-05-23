package Computation;

import java.io.Serializable;

public class GameInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//time format: yyyy-mm-dd hh:mm:ss
	private String time;
	private String score;
	private int highest_link;
	private boolean isMulti;
	public GameInfo(String t, String s, int hl, boolean im){
		time=t;
		score=s;
		highest_link=hl;
		isMulti=im;
	}
	public String getTime() {
		return time;
	}

	public String getScore() {
		return score;
	}

	public int getHighest_link() {
		return highest_link;
	}

	public boolean isMulti() {
		return isMulti;
	}

	
}
