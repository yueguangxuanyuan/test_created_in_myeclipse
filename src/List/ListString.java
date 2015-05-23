package List;

public class ListString{   
	static int numOfElements = 0;    
	int id;    
	String name;   
	ListString next;
	
	// Constructor    
	ListString(String name, ListString tail) {	
		this.id = numOfElements;	
		this.name = new String(name); 	
		this.next = tail;	
		numOfElements++;   
	}    
	
	static ListString Insert(String s, ListString tail) {	
		return new ListString(s, tail);    
	}    
	
	static void Display(ListString element) {	
		while (element != null) {	    
			System.out.print(element.name+"[" + element.id + "]"+"-->");	    
			element = element.next;	
		}	
		System.out.println("null");   
	}    
	
	// Q4    
	static ListString Delete(String s, ListString head){
		if(head  == null){
			return null;
		}
		if(head.name.equals(s)){
			numOfElements--;
			return head.next;
		}
		ListString curHead = head.next;
		ListString preHead = head;
		while (curHead != null) {	
			if(s.equals(curHead.name)){
				preHead.next = curHead.next;
				numOfElements--;
				return head;
			}else{
				preHead = curHead;
				curHead = curHead.next;
			}
		}
		return head;
	}   
	static ListString DeleteDisplay(String string, ListString head)    {
		if(head == null){
			System.out.println("[删除] " + string+"   此时的HEAD是"+null);	
		}else{
			System.out.println("[删除] " + string+"   此时的HEAD是"+head.name);	
		}
		head = ListString.Delete(string, head); // head	
		ListString.Display(head);	
		System.out.println("元素总数: " + ListString.numOfElements);		
		return head;    
	}
	
	public static void main (String[] args)    {	
		ListString head;		
		head = new ListString("Tokyo", null);	
		head = new ListString("Kyoto", head);	
		head = new ListString("Tsukuba", head);	
		head = new ListString("Nara", head);	
		head = new ListString("Ueno", head);
		head = new ListString("Ehime", head);	
		ListString.Display(head);
		System.out.println("=====================================");
	
		head = ListString.DeleteDisplay("Ehime", head);
		head = ListString.DeleteDisplay("Fukuoka", head);
		head = ListString.DeleteDisplay("Tokyo", head);
		head = ListString.DeleteDisplay("Tsukuba", head);
		head = ListString.DeleteDisplay("Kyoto", head);
		head = ListString.DeleteDisplay("Nara", head);
		head = ListString.DeleteDisplay("Ueno", head);
		head = ListString.DeleteDisplay("Ueno", head); 
	}
}

