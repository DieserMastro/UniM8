package unim8.Backend;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

////import java.awt.Desktop;
//import java.awt.desktop.*;
import javax.swing.JFileChooser;

import java.io.File;
import java.io.IOException;

public class File_Manager {

	List<Path> directories = new ArrayList<>();
	private JFileChooser jFileChooser;
	//private Desktop desktop;
	private Path defaultPath;
	public File_Manager() {
		
		//this should now direct to the Tests folder from wherever the application is launched from
		this.defaultPath = Paths.get("").toAbsolutePath().getParent();
		this.defaultPath = defaultPath.resolve("Tests");
		directories.add(defaultPath);
		jFileChooser = new JFileChooser();
		jFileChooser.setCurrentDirectory(this.defaultPath.toFile());
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
	
	private void addDirectoryToList(Path directory) {
		directories.add(directory);
	}
	
	public void chooseNewDirectory() {
		Path directory;
		this.jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		this.jFileChooser.setAcceptAllFileFilterUsed(true);
		if(this.jFileChooser.showOpenDialog(this.jFileChooser) == JFileChooser.APPROVE_OPTION) {
			System.out.println("Directory chosen: " + this.jFileChooser.getCurrentDirectory());
			directory = this.jFileChooser.getCurrentDirectory().toPath();
			addDirectoryToList(directory);
		}
		else {
			System.out.println("No directory chosen");
		}
		
	}
	public Path chooseFile() {
		Path file = null;
		this.jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		this.jFileChooser.setAcceptAllFileFilterUsed(false);
		if(this.jFileChooser.showOpenDialog(this.jFileChooser) == JFileChooser.APPROVE_OPTION) {
			System.out.println("Directory chosen: " + this.jFileChooser.getCurrentDirectory());
			File temp = this.jFileChooser.getSelectedFile();
			file = Path.of(temp.getAbsolutePath());
			
		}
		else {
			System.out.println("No directory chosen");
		}
		return file;
	}
	public void saveFilePath(Path path) {
		File file = path.toFile();
		
	}
	/*public void openDesktopDirectory() {
		File path = this.defaultPath.toFile();
		try {
			desktop.open(path);
		}
		catch(IllegalArgumentException | IOException iae) {
			System.out.println("Path not found");
		}
	}*/
}
