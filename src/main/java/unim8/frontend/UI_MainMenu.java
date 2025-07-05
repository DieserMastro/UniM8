package unim8.frontend;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class UI_MainMenu implements ActionListener{
	
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu fileMenu;	

	private JMenuItem openMenuItem;
	private JMenuItem saveJMenuItem;
	private JMenuItem exitJMenuItem;
	
	private JMenu newJMenu;
	private JMenuItem newFileMenuItem;
	private JMenuItem newFolderMenu;
	
	public UI_MainMenu() {
		initialize();
		
	}
	private void initialize() {
		
		setupFrame();
		setupFonts();
		setupMenuItems();
		
		this.frame.setVisible(true);
		
	}
	private void setupFrame() {
		
		this.frame = new JFrame("UniM8");		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.frame.pack(); Uncomment after adding everything and comment line below 
		this.frame.setSize(800, 600);
		this.frame.setLayout(new BorderLayout(10, 10));
		this.frame.setLocationRelativeTo(null);
		
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
		
		this.newJMenu = new JMenu("New...");
		ImageIcon defaultFileIcon = new ImageIcon("images/defaultFile_Icon.png");
		this.newJMenu.setIcon(defaultFileIcon);
		this.newFileMenuItem = new JMenuItem("File");
		this.newFolderMenu = new JMenuItem("Folder");
		
		newJMenu.add(this.newFileMenuItem);
		newJMenu.add(this.newFolderMenu);
		
		
		this.openMenuItem = new JMenuItem("Open");
		ImageIcon defaultOpenIcon = new ImageIcon("images/defaultOpen_Icon.png");
		this.openMenuItem.setIcon(defaultOpenIcon);
		
		this.saveJMenuItem = new JMenuItem("Save");
		ImageIcon defaultSaveIcon = new ImageIcon("images/defaultSave_Icon.png");
		this.saveJMenuItem.setIcon(defaultSaveIcon);
		this.saveJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		this.saveJMenuItem.addActionListener(this);

		
		this.exitJMenuItem = new JMenuItem("Exit");
		ImageIcon defaultExitIcon = new ImageIcon("images/defaultExit_Icon.png");
		this.exitJMenuItem.setIcon(defaultExitIcon);
		
		this.fileMenu.add(this.newJMenu);
		this.fileMenu.add(this.openMenuItem);
		this.fileMenu.add(this.saveJMenuItem);
		this.fileMenu.add(this.exitJMenuItem);
		
		this.menuBar.add(this.fileMenu);
		
		this.frame.setJMenuBar(this.menuBar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			JMenuItem item = (JMenuItem) e.getSource();
			String text = item.getText();
			System.out.println(text);
		}
		
	}
}
