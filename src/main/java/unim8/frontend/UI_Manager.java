package unim8.frontend;
import unim8.Backend.*;

import javax.swing.*;

public class UI_Manager extends JFrame{
	

	public static void main(String[] args) {
	
		UI_MainMenu mainMenu = new UI_MainMenu();
		PDF_Viewer pdfViewer = mainMenu.getViewer();
		pdfViewer.cleanUp();
	
	}
}