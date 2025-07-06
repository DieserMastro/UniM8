package unim8.frontend;
import java.io.IOException;
import java.util.HashMap;

import unim8.Backend.*;

/*
 * Receive User interactions with the UI, sort the input, 
 * Invoke the corresponding function.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
public class Input_Manager {
	
	PDF_Viewer viewer;
	File_Manager fileManager;
	
	public Input_Manager() {
		this.fileManager = new File_Manager();
	}
	public void InputListener(String actionCommand) {
		switch (actionCommand) {
        case "New File":
            newFile();
            break;
        case "New Folder":
            newFolder();
            break;
        case "Open File":
            openFile();
            break;
        case "Save":
            saveFile();
            break;
        case "Exit":
            exitApp();
            break;
        default:
            System.out.println("Unknown action: " + actionCommand);
		}
	}
	
	private void exitApp() {
		System.out.println("exitApp Invoked");
		
	}
	private void saveFile() {
		System.out.println("saveFile invoked");
		
	}
	private void openFile() {
		
		try {
			viewer.viewPDF(fileManager.chooseFile());
		} catch (IOException e) {
			System.out.println("Couldnt Open File... :(");
			e.printStackTrace();
		}
	}
	private void newFolder() {
		System.out.println("newFolder invoked");
		
	}
	private void newFile() {
		System.out.println("newFile invoked");
		
	}
	public void setPDFViewer(PDF_Viewer pdfViewer) {
		this.viewer = pdfViewer;
	}
	
	
}
