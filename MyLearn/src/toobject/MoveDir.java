package toobject;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
public class MoveDir {
      public static void main(String[] args) throws Exception {
    	  	//得到目录
            File srcDir = new File("java");
            if(!(srcDir.exists() && srcDir.isDirectory()))

                        throw new Exception("目录不存在");
            //目录下所有文件
            File[] files = srcDir.listFiles(
                    //过滤器
            		new FilenameFilter(){
                              public boolean accept(File dir, String name) {
                                    return name.endsWith(".java");
                              }
                        }
            );
            System.out.println(files.length);
            File destDir = new File("jad");
            if(!destDir.exists()) destDir.mkdir();
            for(File f :files){
                  FileInputStream  fis = new FileInputStream(f);
                  String destFileName = f.getName().replaceAll("\\.java$", ".jad");
                 FileOutputStream fos = new FileOutputStream(new File(destDir,destFileName));
                 //文件内容
                  copy(fis,fos);
                  fis.close();
                  fos.close();
            }
      }

     

      private static void copy(InputStream ips,OutputStream ops) throws Exception{
            int len = 0;
            byte[] buf = new byte[1024];
            while((len = ips.read(buf)) != -1){
                  ops.write(buf,0,len);
            }
      }
      //分析listFiles方法内部的策略模式实现原理
//      File[] listFiles(FileFilter filter){
//            File[] files = listFiles();
//            //Arraylist acceptedFilesList = new ArrayList();
//            File[] acceptedFiles = new File[files.length];
//            int pos = 0;
//            for(File file: files){
//                  boolean accepted = filter.accept(file);
//                  if(accepted){
//                        //acceptedFilesList.add(file);
//                        acceptedFiles[pos++] = file;
//                  }          
//            }
//            Arrays.copyOf(acceptedFiles,pos);
//            //return (File[])accpetedFilesList.toArray();
//      }

}
