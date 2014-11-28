package Survey;
import java.io.*;
import java.util.*;
public class FileIo {
    public String[] line={};
    int ln=0;
    
    public int[][] ans;
    private Scanner sc;
    String path="";
    public FileIo() throws IOException
    {
       File f=new File(".") ;
        path=f.getAbsolutePath();
        if(path.endsWith("."))
        path=path.substring(0,path.length()-2);
       File f1=new File(path+"\\questions.txt");
       sc=new Scanner(f1);
       ln=0;
     do
     {
         
         String s=sc.nextLine();
         if(s.equalsIgnoreCase("END"))
             break;
         else
             ln++;
     }
     while(sc.hasNextLine());
    
     line=new String[ln];
     ans=new int[ln/5][5];
     sc.close();
     sc=new Scanner(f1);
     int i=0;
     while(i<ln)
     {
         line[i]=sc.nextLine();
         i++;
     }
     sc.close();
     f1=new File(path+"\\ans.txt");
    
     sc=new Scanner(f1);
     i=0;
     int j=0;
     for(i=0;i<ln/5;i++)
     {
         for(j=0;j<5;j++)
         {
             try{
         ans[i][j]=sc.nextInt();
             }
             catch(Exception ex){}
         }
     }
    
         
        
     
     sc.close();
    }
    public void update()
    {
        try
        {
        FileWriter f=new FileWriter(new File(path+"\\ans.txt"));
        for(int i=0;i<ln/5;i++)
        {ans[i][0]=i+1;
      
        f.write(ans[i][0]+" "+ans[i][1]+" "+ans[i][2]+" "+ans[i][3]+" "+ans[i][4]+"\r\n");
        }
        f.close();
        
        
        }
        catch(Exception ex)
        {
        
        }
    }
}
