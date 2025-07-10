package unim8.frontend;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import org.icepdf.ri.common.SwingController;

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
	
	UI_MainMenu mainMenu;
	PDF_Viewer viewer;
	File_Manager fileManager;
	SwingController controller;
	
	public Input_Manager(PDF_Viewer viewer, UI_MainMenu mainMenu) {
		this.viewer = viewer;
		this.mainMenu = mainMenu;
		this.fileManager = new File_Manager();
		this.controller = viewer.getController();
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
        case "Highlight Selection":
        	highlightSelection();
        	break;
        default:
            System.out.println("Unknown action: " + actionCommand);
		}
	}
	
	private void exitApp() {
		System.out.println("exitApp Invoked");
		int choice = JOptionPane.showConfirmDialog(
				null,
				"Do you wish to save the current PDF Before exiting?",
				"Confirm choice",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE
				);
		switch (choice) {
			
			case JOptionPane.YES_OPTION:
				controller.saveFile();
				mainMenu.getFrame().dispose();
				System.exit(0);
			case JOptionPane.NO_OPTION:
				mainMenu.getFrame().dispose();
				System.exit(0);
			case JOptionPane.CANCEL_OPTION:
				break;
			case JOptionPane.CLOSED_OPTION:
				break;
		
		
		}
		
	}
	private void saveFile() {
		System.out.println("saveFile invoked");
		int choice = JOptionPane.showConfirmDialog(
				null,
				"Do you wish to save the current PDF?",
				"Confirm choice",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE
				);
		switch (choice) {
			
			case JOptionPane.YES_OPTION:
				controller.saveFile();
				break;
			case JOptionPane.NO_OPTION:
			case JOptionPane.CANCEL_OPTION:
			case JOptionPane.CLOSED_OPTION:
				break;
		
		
		}
	
		
		//Path saveFilePath = viewer.getCurrentDocumentPath();
		
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
	
	private void highlightSelection() {
		System.out.println("highligh selection invoked.");
	}
}
