package ToMysqlDatabase;

import java.sql.SQLException;
import java.sql.Statement;
public class MultiThread {
	public static void main(String[] args) {
        MultiThread mt = new MultiThread();
        mt.test();
	}
    
	public void test(){
		Thread insert = new Thread(new insert());
		Thread delete = new Thread(new delete());
		Thread update = new Thread(new update());
		Thread select1 = new Thread(new select(1));
		Thread select2 = new Thread(new select(2));
		
		insert.start();
		delete.start();
		update.start();
		select1.start();
		select2.start();
	}
	
	class  insert implements Runnable{
        controlDatabase condb;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			condb = new controlDatabase();
			
			for(int i = 0 ; i < 10;i++){
				handle(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		private void handle(int i){
		   try {
			   
			Statement state = condb.con.createStatement();
			String sql = "insert into test1(`col1`,`col2`,`col3`) values('mike','abced',"+i+")";
			System.out.println("insert start. id: "+i);
			state.executeUpdate(sql);
			System.out.println("insert end. id: "+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	}
	
	class  delete implements Runnable{
        controlDatabase condb;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			condb = new controlDatabase();
			
			for(int i = 0 ; i < 10;i++){
				handle(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		private void handle(int i){
		   try {
			   
			Statement state = condb.con.createStatement();
			String sql = "delete from test1 where id = (select id from(select id from test1 limit 0,1) k)";
			System.out.println("delete start. id: "+i);
			state.executeUpdate(sql);
			System.out.println("delete end. id: "+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	}
	
	class  update implements Runnable{
        controlDatabase condb;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			condb = new controlDatabase();
			
			for(int i = 0 ; i < 10;i++){
				handle(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		private void handle(int i){
		   try {
			   
			Statement state = condb.con.createStatement();
			String sql = "update test1 set `col3`=1000 where id = (select id from(select id from test1 limit 0,1) k)";
			System.out.println("update start. id: "+i);
			state.executeUpdate(sql);
			System.out.println("update end. id: "+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	}
	class  select implements Runnable{
        controlDatabase condb;
        int num;
        public  select(int num){
        	this.num = num;
        }
		public void run() {
			// TODO Auto-generated method stub
			condb = new controlDatabase();
			
			for(int i = 0 ; i < 10;i++){
				handle(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		private void handle(int i){
		   try {
			   
			Statement state = condb.con.createStatement();
			String sql = "select * from test1"; 
			System.out.println("select start. id: "+i +" num:"+num);
			state.execute(sql);
			System.out.println("select end. id: "+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	}
}
