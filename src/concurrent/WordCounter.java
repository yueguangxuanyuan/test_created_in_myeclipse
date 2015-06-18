package concurrent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class WordCounter {

	
	public static void main(String[] args) throws IOException {
	    WordCounter wordCounter = new WordCounter();
	    Folder folder = Folder.fromDirectory(new File("D:\\数据文件\\html demo"));
	    Date d0 = new Date();
//	    System.out.println(wordCounter.countOccurrencesOnSingleThread(folder, "test"));
	    System.out.println(wordCounter.countOccurrencesInParallel(folder,"test"));
	    
	    Date d1 = new Date();
	    System.out.println(wordCounter.countOccurrencesOnSingleThread(folder, "test"));
	    Date d2 = new Date();
	    Date d3 = new Date();
	    System.out.println(wordCounter.countOccurrencesInParallel(folder,"test"));
	    Date d4 = new Date();
        System.out.println(d2.getTime()-d1.getTime());
        System.out.println(d4.getTime()-d3.getTime());
	}
	

	
	Long countOccurrencesOnSingleThread(Folder folder, String searchedWord) {
	    long count = 0;
	    for (Folder subFolder : folder.getSubFolders()) {
	        count = count + countOccurrencesOnSingleThread(subFolder, searchedWord);
	    }
	    for (Document document : folder.getDocuments()) {
	       count = count + occurrencesCount(document, searchedWord);
	    }
	   return count;
	}
	
	//针对问文件夹 查找文件夹下 特定字符串的在文档中的出现次数
	class FolderSearchTask extends RecursiveTask<Long> {
	    private final Folder folder;
	    private final String searchedWord;
	  
	    FolderSearchTask(Folder folder, String searchedWord) {
	        super();
	        this.folder = folder;
	        this.searchedWord = searchedWord;
	    }
	  
	    @Override
	    protected Long compute() {
	        long count = 0L;
	        List<RecursiveTask<Long>> forks = new LinkedList<>();
	        for (Folder subFolder : folder.getSubFolders()) {
	            FolderSearchTask task = new FolderSearchTask(subFolder, searchedWord);
	            forks.add(task);
	            task.fork();
	       }
	        for (Document document : folder.getDocuments()) {
	            DocumentSearchTask task = new DocumentSearchTask(document, searchedWord);
	            forks.add(task);
	            task.fork();
	       }
	        for (RecursiveTask<Long> task : forks) {
	            count = count + task.join();
	       }
	    return count;
	  }
	}

	//定义一个 RecursiveTask类
	//来进行  文档 字符串查找工作
	class DocumentSearchTask extends RecursiveTask<Long> {
	    private final Document document;
	    private final String searchedWord;
	  
	    DocumentSearchTask(Document document, String searchedWord) {
	        super();
	        this.document = document;
	        this.searchedWord = searchedWord;
	    }
	  
	    @Override
	    protected Long compute() {
	        return occurrencesCount(document, searchedWord);
	    }
	}

	
	
	private final ForkJoinPool forkJoinPool = new ForkJoinPool();

	Long countOccurrencesInParallel(Folder folder, String searchedWord) {
	    return forkJoinPool.invoke(new FolderSearchTask(folder, searchedWord));
	}
	
	//将一个String字符串  按照行拆解
	//风格符为  空白字符或者特殊字符
	String[] wordsIn(String line) {
		return line.trim().split("(\\s|\\p{Punct})+");
	}

	//针对一个document 文件 查找并返回指定字符串的出现次数
	Long occurrencesCount(Document document, String searchedWord) {
		long count = 0;
		for (String line : document.getLines()) {
			for (String word : wordsIn(line)) {
				if (searchedWord.equals(word)) {
					count = count + 1;
				}
			}
		}
		return count;
	}
}

/*
 * 用树形结构组织一个文件夹下面的所有文件
 * 树状图节点包含两个List  一个是由读入的文件组成的List  一个是子文件夹    
 * 子树挂载在子文件夹的列表下
 */
class Folder {
	private final List<Folder> subFolders;
	private final List<Document> documents;

	Folder(List<Folder> subFolders, List<Document> documents) {
		this.subFolders = subFolders;
		this.documents = documents;
	}

	List<Folder> getSubFolders() {
		return this.subFolders;
	}

	List<Document> getDocuments() {
		return this.documents;
	}

	static Folder fromDirectory(File dir) throws IOException {
		List<Document> documents = new LinkedList<>();
		List<Folder> subFolders = new LinkedList<>();
		for (File entry : dir.listFiles()) {
			if (entry.isDirectory()) {
				subFolders.add(Folder.fromDirectory(entry));
			} else {
				documents.add(Document.fromFile(entry));
			}
		}
		return new Folder(subFolders, documents);
	}
}

/*
 * 按行读入一个文件
 */
class Document {
	private final List<String> lines;

	Document(List<String> lines) {
		this.lines = lines;
	}

	List<String> getLines() {
		return this.lines;
	}

	// LinkedList 使用尖括号语法 (<>) 告知编译器推断通用类型参数。由于行是 List<String>，LinkedList<> 扩展为
	// LinkedList<String>。使用尖括号运算符，对于那些能在编译时轻松推断的类型就不必再重复，从而使得通用类型的处理更轻松。

	// try 块使用新的自动资源管理语言特性。在 try 块的开头可以使用实现 java.lang.AutoCloseable
	// 的任何类。无论是否引发异常，当执行离开 try 块时，在此声明的任何资源都将正常关闭。在 Java SE 7
	// 之前，正常关闭多个资源很快会变成一场嵌套 if/try/catch/finally 块的梦魇，这种嵌套块通常很难正确编写。
	static Document fromFile(File file) throws IOException {
		List<String> lines = new LinkedList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
		}
		return new Document(lines);
	}

}





