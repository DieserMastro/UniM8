package unim8.frontend;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import unim8.Backend.File_Manager;
import unim8.Backend.PDF_Viewer;

public class UI_MainMenu implements ActionListener{
	
	PDF_Viewer pdfViewer;
	File_Manager fileManager;
	
	Input_Manager inputManager;
	
	private JPanel viewerComponentICE;
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu fileMenu;	
	//private JMenu editMenu;
	
	private JMenuItem openMenuItem;
	private JMenuItem saveJMenuItem;
	private JMenuItem exitJMenuItem;
	//private JMenuItem highlightSelection;
	
	private JMenu newJMenu;
	private JMenuItem newFileMenuItem;
	private JMenuItem newFolderMenu;
	
	public UI_MainMenu() {
		initialize();
		
	}
	private void initialize() {
		
		pdfViewer = new PDF_Viewer();
		pdfViewer.initialize();
		inputManager = new Input_Manager(this.pdfViewer, this);
		inputManager.setPDFViewer(pdfViewer);
		this.viewerComponentICE = pdfViewer.getJPanel();
		setupFrame();
		setupFonts();
		setupMenuItems();
		
		this.frame.setVisible(true);
		
	}
	private void setupFrame() {
		
		this.frame = new JFrame("UniM8");		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.frame.pack(); Should automatically set size dimensions, but it sucks, so nah 
		this.frame.setSize(800, 600);
		this.frame.setLayout(new BorderLayout(10, 10));
		this.frame.setLocationRelativeTo(null);
		this.frame.getContentPane().add(viewerComponentICE);
		this.frame.revalidate();

		
	}
	private void setupFonts() {
		
		Font font = new Font("sans-serif", Font.PLAIN, 18);
		UIManager.put("Menu.font", font);
		UIManager.put("MenuItem.font", font);
		UIManager.put("CheckBoxMenuItem.font", font);
		UIManager.put("RadioButtonMenuItem.font", font);
		
	}
	private void setupMenuItems() {
		
		this.menuBar = new JMenuBar();
		//Images are 16px
		this.fileMenu = new JMenu("File");
		this.fileMenu.setMnemonic(KeyEvent.VK_F);
		//this.editMenu = new JMenu("Edit");
		//this.editMenu.setMnemonic(KeyEvent.VK_E);
		
		
		//All Menu items for the File Menu
		this.newJMenu = new JMenu("New...");
		ImageIcon defaultFileIcon = new ImageIcon("images/defaultFile_Icon.png");
		this.newJMenu.setIcon(defaultFileIcon);
		this.newFileMenuItem = new JMenuItem("File");
		this.newFileMenuItem.setActionCommand("New File");
		this.newFileMenuItem.addActionListener(this);
		this.newFolderMenu = new JMenuItem("Folder");
		this.newFolderMenu.setActionCommand("New Folder");
		this.newFolderMenu.addActionListener(this);
		
		
		this.newJMenu.add(this.newFileMenuItem);
		this.newJMenu.add(this.newFolderMenu);
		
		
		this.openMenuItem = new JMenuItem("Open");
		this.openMenuItem.setActionCommand("Open File");
		this.openMenuItem.addActionListener(this);
		ImageIcon defaultOpenIcon = new ImageIcon("images/defaultOpen_Icon.png");
		this.openMenuItem.setIcon(defaultOpenIcon);
		
		this.saveJMenuItem = new JMenuItem("Save");
		this.saveJMenuItem.setActionCommand("Save");
		this.saveJMenuItem.addActionListener(this);
		ImageIcon defaultSaveIcon = new ImageIcon("images/defaultSave_Icon.png");
		this.saveJMenuItem.setIcon(defaultSaveIcon);
		this.saveJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));


		
		this.exitJMenuItem = new JMenuItem("Exit");
		this.exitJMenuItem.setActionCommand("Exit");
		this.exitJMenuItem.addActionListener(this);
		ImageIcon defaultExitIcon = new ImageIcon("images/defaultExit_Icon.png");
		this.exitJMenuItem.setIcon(defaultExitIcon);
		
		this.fileMenu.add(this.newJMenu);
		this.fileMenu.add(this.openMenuItem);
		this.fileMenu.add(this.saveJMenuItem);
		this.fileMenu.add(this.exitJMenuItem);
		
		
		//All JMenu Items for the Edit Menu
		/*
		this.highlightSelection = new JMenuItem("Highlight Selection");
		this.highlightSelection.addActionListener(this);
		this.editMenu.add(this.highlightSelection);
		*/
		
		this.menuBar.add(this.fileMenu);
		//this.menuBar.add(this.editMenu);
		
		this.frame.setJMenuBar(this.menuBar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			JMenuItem item = (JMenuItem) e.getSource();
			inputManager.InputListener(item.getActionCommand());
			//JOptionPane.showConfirmDialog(item, item.getText());
			//String text = item.getText();
			//System.out.println(text);
		}
		
	}
	public void setViewer(PDF_Viewer viewer) {
		this.pdfViewer = viewer;
	}
	public PDF_Viewer getViewer() {
		return this.pdfViewer;
	}
	public JFrame getFrame() {
		return this.frame;
	}
	
}
