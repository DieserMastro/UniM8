package unim8.Backend;

import java.nio.file.*;
import java.awt.Desktop;
import java.awt.desktop.*;

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
	public boolean checkIfFileExists(Path path) {
		boolean EXISTS = Files.exists(path);		
		return EXISTS;
	}
}
