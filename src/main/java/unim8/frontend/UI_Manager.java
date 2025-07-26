package unim8.frontend;
import unim8.Backend.*;

import javax.swing.*;

public class UI_Manager extends JFrame{
	
	UI_MainMenu mainMenu;
	PDF_Viewer pdfViewer;
	
	public UI_Manager(){
	
		this.mainMenu = new UI_MainMenu();
		this.pdfViewer = mainMenu.getViewer();
		pdfViewer.cleanUp();
	
	}
}