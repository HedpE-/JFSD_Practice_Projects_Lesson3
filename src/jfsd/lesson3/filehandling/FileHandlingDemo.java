package jfsd.lesson3.filehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandlingDemo {
	
	public void writeFile(Path filePath, String content) {
		try	{
			System.out.println("Writing to file (ovewrite if exists): "+filePath.toString());

			Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

			System.out.println("File write operation success!");			
		}
		catch(IOException e) {
			System.out.println(getErrorMessage(e.getClass().getName()));
		}
	}

	public void appendFile(Path filePath, String content) {
		try	{
			System.out.println("Appending text to file: "+filePath.toString());

			Files.write(filePath, content.getBytes(), StandardOpenOption.APPEND);

			System.out.println("Append text to file operation success!");			
		}
		catch(IOException e) {
			System.out.println(getErrorMessage(e.getClass().getName()));
		}
	}

	public void readFile(Path filePath)	{
		try	{
			System.out.println("Reading text from file: "+filePath.toString());

			String content = new String(Files.readAllBytes(filePath));

			System.out.println("Read from file operation success!");
			System.out.println("\nContent:\n"+content);
		}
		catch(IOException e) {
			System.out.println(getErrorMessage(e.getClass().getName()));
		}
	}

	public void deleteFile(Path filePath) throws IOException {
		try	{
			System.out.println("Deleting file: "+filePath.toString());

			Files.delete(filePath);

			System.out.println("Delete file operation success!");
		}
		catch(IOException e) {
			System.out.println(getErrorMessage(e.getClass().getName()));
		}
	}

	private String getErrorMessage(String exceptionClassName) {
		return "Operation failed: "+exceptionClassName;
	}

	public static void main(String[] args) throws IOException {
		Path existingFilePath = Paths.get(System.getProperty("user.dir"), "DemoFile.txt");
		Path nonExistingFilePath = Paths.get(System.getProperty("user.dir"), "NoFile.txt");

		String creationContent = "This is the File Handling Project Demo File\nThis text was written on file creation.\n";
		String appendContent = "This text was appended later.";
		
		FileHandlingDemo fileHandler = new FileHandlingDemo();

		try	{
			Files.deleteIfExists(nonExistingFilePath);

			fileHandler.writeFile(existingFilePath, creationContent);
			System.out.println();

			fileHandler.appendFile(nonExistingFilePath, appendContent);
			System.out.println();

			fileHandler.appendFile(existingFilePath, appendContent);
			System.out.println();

			fileHandler.readFile(nonExistingFilePath);		
			System.out.println();

			fileHandler.readFile(existingFilePath);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally	{
			Files.deleteIfExists(existingFilePath);
		}
	}
}
