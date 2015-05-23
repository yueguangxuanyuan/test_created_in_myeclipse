package File;

import java.io.*;

/**
 * 在本程序中又采用了另一种方法：同时开通N个输入流分别指向N个要合并的数据文件，
 * 写入最后的单个结果文件。效果证明运行时间差不多，但是占用内存更少。
 * <p>
 * PS: 但是发现了一个Linux下特有的问题（因为此问题在Windows下不存在）：
 * 当文件读到大约第4092个时，抛出了“文件找不到“的异常。
 * 所以断定同时打开输入流的数目在Linux下此时被限制为4092。
 * 所以此时必须分批来处理，每批处理数目自动设为能够同时打开的最大流数目
 * （实际发现是输入流和输出流的总数，而此数字可以通过抛出的异常信息获得）。
 * <p>
 * 总结：这样此程序即可以在Linux中运行，又可以在Windows中运行，就是做到了真正的跨平台！
 * @author han
 *
 */
public class CombinedTextSpectres6 {
	
	private final int N=6;//N是保存的文件名称的长度
	private final int M=4520;//M是保存的文件数目 
	String ExperienceCondition="Integrated time is 1 ms, with the HR Spectrometer, with polarizorH, using the syringe Rh6G+Glycol and the other is Huile";
	String dirPath="/media/96D0265ED0264539/Users/HAN/Documents/Thèse ISMO/DonneesLabo/17_10-21_10/apresmidi sans pola";//定义存放离散采样数据文件的文件夹
	//	String dirPath="/media/96D0265ED0264539/Users/HAN/Documents/Thèse ISMO/DonneesLabo/10_10-14_10/spectre sans pola";
	static String destDirPath="/home/han/Desktop";//定义存放最终结果文件的文件夹
	File new_file;

	File[] FileArray;
	int Column;
	FileReader[] fr;
	BufferedReader[] bfr;
	FileWriter fw;
	BufferedWriter bfw;
	/**
	 * the construct function
	 * @throws IOException 
	 */
	public CombinedTextSpectres6() throws IOException{
		long startTime=System.currentTimeMillis();
		try{
			/*****************写入全部数据********************/
			//初始化文件输入流
			FileArray=new File(dirPath).listFiles();
			Column=FileArray.length;// 4000 limit
			fr=new FileReader[Column];//声明
			bfr=new BufferedReader[Column];
			/*for(int i=0;i<Column;i++){
			System.out.println(FileArray[i]);
		}*/
			for(int i=0;i<Column;i++){//初始化
				fr[i]=new FileReader(FileArray[i]);
				bfr[i]=new BufferedReader(fr[i]);
			}
			//初始化文件输出流
			new_file=new File(destDirPath,"CombinedSpectres.txt");
			fw = new FileWriter(new_file);
			bfw=new BufferedWriter(fw);
			
			//写入文件头  包括实验提哦叫  每类列的数值含义，以及读入的文件名
			/***************加入实验条件**********************/
			bfw.write(ExperienceCondition);
			bfw.newLine();
			/***************加入每列数值代表的物理含义***********/
			bfw.write("Wavelength (nm)\t");
			for(int i=0;i<M;i++){
				String filename="00"+i;//"00"是保存的文件的前缀	
				int temLength=filename.length();
				for(int j=0;j<N-temLength;j++){//对齐文件名
					filename="0"+filename;
				}
				filename=filename+".txt";
				bfw.write(filename);
				bfw.write("\t");
			}
			bfw.newLine();
			
			//遍历文件，解析并将结果写入输出文件
			String s;
			while((s=bfr[0].readLine())!=null){
				for(int i=0;i<Column;i++){
					if(i==0){
						bfw.write(s.replace(',', '.'));
						bfw.write("\t");
					}else{
						bfw.write(bfr[i].readLine().split("\t")[1].replace(',', '.'));
						bfw.write("\t");
					}
				}
				bfw.newLine();
			}
			
			//关闭文件输入流
			for(int i=0;i<Column;i++){
				bfr[i].close();
				fr[i].close();			
			}
			//关闭文件输出流
			bfw.close();
			fw.close();
			
			//输出程序结束标志
			System.out.println(new_file);
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String strFile=e.getMessage();
			String fileName=strFile.substring(dirPath.length()+1, dirPath.length()+7);
			int maxNumFile=Integer.parseInt(fileName);
			maxNumFile=maxNumFile-6;//for "bfr[i].close();" successful
			/*System.out.println(fileName);
			System.out.println(maxNumFile);*/
			for(int i=0;i<maxNumFile;i++){ //close all input streams opened for the aims of releasing the resources.
				bfr[i].close();
				fr[i].close();			
			}	
			System.out.printf("The maximum opened file number limited by the current computer environment is : %d\n",maxNumFile-1);
			System.out.println("So we have to retreat the problem by considering the limitation of the computer resources.");
			new LinuxLimit(maxNumFile-1).run();
		}
		//计时
		long endTime=System.currentTimeMillis();
		System.out.println("耗费时间： "+(endTime-startTime)+" ms");
	}
	class LinuxLimit{
		private final int maxNumFile;
		File tempDir=new File(destDirPath,"temp");

		LinuxLimit(int maxNumFile){
			this.maxNumFile=maxNumFile;
		}
		void run(){	
			int fileStart=0;
			int fileEnd=0;
			int num=0;
			String filename=num+".txt";
			if(!tempDir.exists()){
				tempDir.mkdir();
			}
			Column=maxNumFile;
			try{
				while(Column>=maxNumFile){
					fileEnd=fileStart+maxNumFile;
					fw=new FileWriter(new File(tempDir,filename));
					bfw=new BufferedWriter(fw);
					System.out.println(fileStart);
					System.out.println(fileEnd);
					for(int i=fileStart;i<fileEnd;i++){//初始化
						fr[i-fileStart]=new FileReader(FileArray[i]);
						bfr[i-fileStart]=new BufferedReader(fr[i-fileStart]);
					}
					String s;
					while((s=bfr[0].readLine())!=null){
						for(int i=0;i<maxNumFile;i++){
							if(i==0 && num==0){
								bfw.write(s.replace(',', '.'));
								bfw.write("\t");
							}else if(i==0 && num!=0){
								bfw.write(s.split("\t")[1].replace(',', '.'));
								bfw.write("\t");
							}else if(i!=0){
								bfw.write(bfr[i].readLine().split("\t")[1].replace(',', '.'));
								bfw.write("\t");
							}
						}
						bfw.newLine();
					}
					for(int i=0;i<maxNumFile;i++){
						bfr[i].close();
						fr[i].close();			
					}
					bfw.close();
					fw.close();	
					fileStart=fileEnd;
					Column=M-fileEnd;		
					num++;
					filename=num+".txt";
				}
				if(Column!=0){
					fw=new FileWriter(new File(tempDir,filename));
					bfw=new BufferedWriter(fw);
					for(int i=fileStart;i<M;i++){//初始化 M=fileStart+Column
						fr[i-fileStart]=new FileReader(FileArray[i]);
						bfr[i-fileStart]=new BufferedReader(fr[i-fileStart]);
					}
					String s;
					while((s=bfr[0].readLine())!=null){
						for(int i=0;i<Column;i++){
							if(i==0){
								bfw.write(s.split("\t")[1].replace(',', '.'));
								bfw.write("\t");
							}else{
								bfw.write(bfr[i].readLine().split("\t")[1].replace(',', '.'));
								bfw.write("\t");
							}
						}
						bfw.newLine();
					}
					for(int i=0;i<Column;i++){
						bfr[i].close();
						fr[i].close();			
					}
					bfw.close();
					fw.close();					
				}

				/*****************************/
				FileArray=tempDir.listFiles();
				Column=FileArray.length; 
				fr=new FileReader[Column];//声明
				bfr=new BufferedReader[Column];
				new_file=new File(destDirPath,"CombinedSpectres.txt");
				fw = new FileWriter(new_file);
				bfw=new BufferedWriter(fw);
				for(int i=0;i<Column;i++){
					System.out.println(FileArray[i]);
				}
				for(int i=0;i<Column;i++){//初始化
					fr[i]=new FileReader(FileArray[i]);
					bfr[i]=new BufferedReader(fr[i]);
				}
				
				/***************加入实验条件**********************/
				bfw.write(ExperienceCondition);
				bfw.newLine();
				/***************加入每列数值代表的物理含义***********/
				bfw.write("Wavelength (nm)\t");
				for(int i=0;i<M;i++){
					String fname="00"+i;//"00"是保存的文件的前缀	
					int temLength=fname.length();
					for(int j=0;j<N-temLength;j++){
						fname="0"+fname;
					}
					fname=fname+".txt";
					bfw.write(fname);
					bfw.write("\t");
				}
				bfw.newLine();
				
				String s;
				while((s=bfr[0].readLine())!=null){
					for(int i=0;i<Column;i++){
						if(i==0){
							bfw.write(s);
							bfw.write("\t");
						}else{
							bfw.write(bfr[i].readLine());
							bfw.write("\t");
						}
					}
					bfw.newLine();
				}
				for(int i=0;i<Column;i++){
					bfr[i].close();
					fr[i].close();			
				}	
				bfw.close();
				fw.close();
				for(File e:FileArray){
					e.delete();
				}
				tempDir.delete();
				System.out.println("The temp folder has been deleted.");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		try {
			new CombinedTextSpectres6();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}	
