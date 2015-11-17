package Files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestFiles {
   public static void main(String[] args){
	   Path dir = FileSystems.getDefault().getPath("", "C:\\Users\\Zengjie\\Desktop\\哈哈");
	   System.out.println(dir.getFileName());
	   try {
		DirectoryStream<Path> paths = Files.newDirectoryStream(dir,"*");
		
		for(Path temp_path : paths){
			System.out.println(temp_path.toFile().getAbsolutePath());
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
