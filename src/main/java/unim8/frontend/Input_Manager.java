package unim8.frontend;
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
	

	
	public Input_Manager() {
		
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
		System.out.println("openFile invoked");
	}
	private void newFolder() {
		System.out.println("newFolder invoked");
		
	}
	private void newFile() {
		System.out.println("newFile invoked");
		
	}
	
	
	
}
