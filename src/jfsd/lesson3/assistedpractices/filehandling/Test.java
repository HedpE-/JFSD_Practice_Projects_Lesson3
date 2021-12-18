package jfsd.lesson3.assistedpractices.filehandling;

import java.io.IOException;
import java.nio.file.*;

public class Test 
{ 
    public static void main(String[] args) 
    { 
    	for (int i = 1; i < 4; i++)
    	{
        	String filePath = "c:\\temp\\testFile"+ i +".txt";
            try
            {
                Files.delete(Paths.get(filePath));
                
                System.out.println(filePath+": Deletion successful.");
            } 
            catch(NoSuchFileException e) 
            { 
                System.out.println(filePath+": No such file/directory exists"); 
            } 
            catch(DirectoryNotEmptyException e) 
            { 
                System.out.println(filePath+": Directory is not empty."); 
            }
            catch(SecurityException | IOException e)
            { 
                System.out.println(filePath+": Invalid permissions."); 
            }              
    	}
    } 
}
