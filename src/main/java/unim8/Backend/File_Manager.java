package unim8.Backend;

import java.nio.file.*;
import java.awt.Desktop;
import java.awt.desktop.*;
import java.io.IOException;

public class File_Manager {

	private Desktop desktop;
	private Path defaultPath;
	public File_Manager() {
		desktop = Desktop.getDesktop();
		this.defaultPath = Path.of("C:\\Users\\sinan\\Desktop\\HTW\\Info3\\Unim8_Project\\Tests");
	}
	public void printPath() {
		System.out.println(this.defaultPath);
	}
	public boolean checkIfPathExists(Path path) {
		boolean EXISTS = Files.exists(path);		
		return EXISTS;
	}
	public void makeNewDirectory(Path path) throws IOException {
		
		if(checkIfPathExists(path)) {
			System.out.println("Directory exists already");
			return;
		}
		Files.createDirectory(path);
		System.out.println(path + " has been created.");
	}
	public void createNewFile(Path path) throws IOException {
		if(checkIfPathExists(path)) {
			System.out.println("File exists already");
			return;
		}
		Files.createFile(path);
		System.out.println(path + " has been created.");
	}
}
