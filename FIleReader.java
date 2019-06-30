import java.text.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.File;
import java.io.IOException;


class FIleReader
{

   public static String doesFileExist(String path){ //check to see if the file exist or it does not and return a statement
		File tmpDir = new File(path);
        String FileExist = "File does exist.";
        String FileDoesntExist = "File doesn't exist.";
        boolean exist = tmpDir.exists();
        
        if(exist = false){
            return FileDoesntExist; 
        }
        else{
            return FileExist;
        }   
    }

	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner scanner = new Scanner(System.in); //user inputs path
	    String path = scanner.nextLine();
		BufferedReader br = new BufferedReader(new FileReader(path));
	    String st;
    System.out.println(doesFileExist(path));
	    

	    while ((st = br.readLine()) != null){ //runs through each line and outputs the word before the '-' and the meaning afterwords
	        for(int i=0;i<st.length();i++){
	            String word = "";
				String meaning = "";
				char c = st.charAt(i);
	            if(c == '–'){
	               for(int j=0;j<i;j++){
	                   word = word + st.charAt(j);
	               }
	               for(int k=i+1;k<st.length();k++){
	                   meaning = meaning + st.charAt(k);
	               }
	               System.out.println(word);
	               System.out.println(meaning);
	            }
	        }
	            
	        }
	    }
	    
	}

