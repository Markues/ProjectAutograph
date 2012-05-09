/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autograph.ui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.EventQueue;
import javax.swing.event.ChangeEvent;

import autograph.Edge;
import autograph.Graph;
import autograph.GraphHelper;
import autograph.Node;
import autograph.GraphPanel;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;

import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

public class mainWindow extends JFrame {

	/**
	 * Creates new form mainWindow
	 */
	public mainWindow() {
		initComponents();
	}

	/*
	 * Exit the program
	 */
	public void exit() { 
		setVisible(false); 
		dispose(); 
		System.exit(0); 
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {
		// This is necessary to allow heavy weight and lightweight components to be used together
		// Without this the menu items popup (light weight) is overridden by the GraphPanel (heavy weight)
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
		MainWindowComponent = new JFrame();
		MainWindowComponent.setMinimumSize(new Dimension(800, 650));
		MainWindowComponent.setBounds(100, 100, 575, 316);
		MainWindowComponent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainWindowPanel = new JPanel();
		MainWindowComponent.getContentPane().add(MainWindowPanel, BorderLayout.CENTER);
		MainWindowPanel.setLayout(new BorderLayout(0, 0));
		
		MainWindowSplitPane = new JSplitPane();
		MainWindowPanel.add(MainWindowSplitPane);
		
		MainWindowTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		MainWindowTabbedPane.setBorder(UIManager.getBorder("TitledBorder.border"));
		MainWindowSplitPane.setRightComponent(MainWindowTabbedPane);

		Graph graph = new Graph("New Graph");
		GraphPanel graphTabSubPane = new GraphPanel(graph);
		graphTabSubPane.setBackground(new java.awt.Color(255, 255, 255));
		//graphTabSubPane.setPreferredSize(new java.awt.Dimension(600, 400));
		
		JScrollPane graphTabPane = new JScrollPane();
		graphTabPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		graphTabPane.setViewportView(graphTabSubPane);

		MainWindowTabbedPane.addTab("New Graph", null, graphTabPane, null);
		
		// Add Node Panel
		addNodePanel = new AddNodePanel();
		//addNodePanel.setPreferredSize(new java.awt.Dimension(200, 512));

		// Add Edge Panel
		addEdgePanel = new AddEdgePanel();
		//addEdgePanel.setPreferredSize(new java.awt.Dimension(200, 512));

		// Edit Node Panel
		editNodePanel = new EditNodePanel();
		//editNodePanel.setPreferredSize(new java.awt.Dimension(200, 512));

		// Edit Edge Panel
		editEdgePanel = new EditEdgePanel();
		//editEdgePanel.setPreferredSize(new java.awt.Dimension(200, 512));

		// Edit Both Panel
		editNodeEdgePanel = new EditNodeEdgePanel();
		//editNodeEdgePanel.setPreferredSize(new java.awt.Dimension(200, 512));
		
		// Edit Panel
		EditPanel = new JPanel();
		//EditPanel.setPreferredSize(new java.awt.Dimension(200, 512));

		SidePanelScrollPane = new JScrollPane();
		SidePanelScrollPane.setPreferredSize(new java.awt.Dimension(230,550));
		SidePanelScrollPane.setBackground(new java.awt.Color(255, 255, 255));
		SidePanelScrollPane.setViewportView(addNodePanel);
		MainWindowSplitPane.setLeftComponent(SidePanelScrollPane);
		
		MainWindowToolBar = new JToolBar();
		MainWindowToolBar.setFloatable(false);
		MainWindowPanel.add(MainWindowToolBar, BorderLayout.NORTH);
		
		AddNodeBtn = new JButton("Add Node");
		AddNodeBtn.setFocusable(false);
		MainWindowToolBar.add(AddNodeBtn);
		AddNodeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		AddNodeBtn.setVerticalAlignment(SwingConstants.BOTTOM);
		AddNodeBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		AddNodeBtn.setIcon(new ImageIcon("resources/AddNode.png"));
		
		AddEdgeBtn = new JButton("Add Edge");
		AddEdgeBtn.setFocusable(false);
		MainWindowToolBar.add(AddEdgeBtn);
		AddEdgeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		AddEdgeBtn.setVerticalAlignment(SwingConstants.BOTTOM);
		AddEdgeBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		AddEdgeBtn.setIcon(new ImageIcon("resources/AddEdge.png"));
		
		// This is used for dynamic spcaing between the Add edge-Node buttons and the 
		// Toggle Buttons - it will increase/descrease in size as necessary to push
		// the buttons to the far left and far right
		MainWindowToolBarHorizontalGlue = Box.createHorizontalGlue();
		MainWindowToolBar.add(MainWindowToolBarHorizontalGlue);
		
		AutoLabelNodesTog = new JToggleButton("Auto-Label Nodes");
		AutoLabelNodesTog.setSelectedIcon(new ImageIcon("resources/ToggleOn.png"));
		AutoLabelNodesTog.setIcon(new ImageIcon("resources/ToggleOff.png"));
		MainWindowToolBar.add(AutoLabelNodesTog);
		
		AutoLabelEdgesTog = new JToggleButton("Auto-Label Edges");
		AutoLabelEdgesTog.setSelectedIcon(new ImageIcon("resources/ToggleOn.png"));
		AutoLabelEdgesTog.setIcon(new ImageIcon("resources/ToggleOff.png"));
		MainWindowToolBar.add(AutoLabelEdgesTog);
		
		AutoConnectNodesTog = new JToggleButton("Auto-Connect Nodes");
		AutoConnectNodesTog.setSelectedIcon(new ImageIcon("resources/ToggleOn.png"));
		AutoConnectNodesTog.setIcon(new ImageIcon("resources/ToggleOff.png"));
		MainWindowToolBar.add(AutoConnectNodesTog);
		
		MainWindowMenuBar = new JMenuBar();
		MainWindowMenuBar.setInheritsPopupMenu(true);
		MainWindowComponent.getContentPane().add(MainWindowMenuBar, BorderLayout.NORTH);
		
		FileDropdownMenu = new JMenu("File");
		MainWindowMenuBar.add(FileDropdownMenu);
		
		NewGraphMenuItem = new JMenuItem("New Graph...");
		NewGraphMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		FileDropdownMenu.add(NewGraphMenuItem);
		
		OpenMenuItem = new JMenuItem("Open...");
		OpenMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		FileDropdownMenu.add(OpenMenuItem);
		
		SaveMenuItem = new JMenuItem("Save");
		SaveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		FileDropdownMenu.add(SaveMenuItem);
		
		SaveAsMenuItem = new JMenuItem("Save As...");
		FileDropdownMenu.add(SaveAsMenuItem);
		
		PrintMenuItem = new JMenuItem("Print...");
		PrintMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		FileDropdownMenu.add(PrintMenuItem);
		
		PrintPreviewMenuItem = new JMenuItem("Print Preview");
		FileDropdownMenu.add(PrintPreviewMenuItem);
		
		CloseGraphMenuItem = new JMenuItem("Close Graph");
		CloseGraphMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, InputEvent.SHIFT_MASK));
		FileDropdownMenu.add(CloseGraphMenuItem);
		
		ExitMenuItem = new JMenuItem("Exit");
		ExitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		FileDropdownMenu.add(ExitMenuItem);
		
		EditDropdownMenu = new JMenu("Edit");
		MainWindowMenuBar.add(EditDropdownMenu);
		
		SelectAllMenuItem = new JMenuItem("Select All");
		SelectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		EditDropdownMenu.add(SelectAllMenuItem);
		
		SelectAllNodesMenuItem = new JMenuItem("Select All Nodes");
		EditDropdownMenu.add(SelectAllNodesMenuItem);
		
		SelectAllEdgesMenuItem = new JMenuItem("Select All Edges");
		EditDropdownMenu.add(SelectAllEdgesMenuItem);
		
		DeselectMenuItem = new JMenuItem("Deselect All");
		DeselectMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		EditDropdownMenu.add(DeselectMenuItem);

		DeleteSelectedMenuItem = new JMenuItem("Delete Selected");
		DeleteSelectedMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		EditDropdownMenu.add(DeleteSelectedMenuItem);

		DeleteSelectedNodesMenuItem = new JMenuItem("Delete Selected Nodes");
		EditDropdownMenu.add(DeleteSelectedNodesMenuItem);

		DeleteSelectedEdgesMenuItem = new JMenuItem("Delete Selected Edges");
		EditDropdownMenu.add(DeleteSelectedEdgesMenuItem);
		
		ViewDropdownMenu = new JMenu("View");
		MainWindowMenuBar.add(ViewDropdownMenu);
		
		CloseTabMenuItem = new JMenuItem("Close Tab");
		ViewDropdownMenu.add(CloseTabMenuItem);
		
		CloseAllOtherTabsMenuItem = new JMenuItem("Close All Other Tabs");
		ViewDropdownMenu.add(CloseAllOtherTabsMenuItem);
		
		OpenAdvancedCodeViewMenuItem = new JMenuItem("Open Advanced Code View");
		ViewDropdownMenu.add(OpenAdvancedCodeViewMenuItem);
		
		ChangeBGColorMenuItem = new JMenuItem("Change Background Color");
		ViewDropdownMenu.add(ChangeBGColorMenuItem);
		
		ToolsDropdownMenu = new JMenu("Tools");
		MainWindowMenuBar.add(ToolsDropdownMenu);
		
		AutoLabelNodesMenuItem = new JCheckBoxMenuItem("Auto-Label Nodes");
		//AutoLabelNodesMenuItem.setSelected(true);
		AutoLabelNodesMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		ToolsDropdownMenu.add(AutoLabelNodesMenuItem);
		
		AutoLabelEdgesMenuItem = new JCheckBoxMenuItem("Auto-Label Edges");
		AutoLabelEdgesMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		ToolsDropdownMenu.add(AutoLabelEdgesMenuItem);
		
		AutoConnectNodesMenuItem = new JCheckBoxMenuItem("Auto-Connect Nodes");
		ToolsDropdownMenu.add(AutoConnectNodesMenuItem);
		
		HelpDropdownMenu = new JMenu("Help");
		MainWindowMenuBar.add(HelpDropdownMenu);
		
		UserGuideMenuItem = new JMenuItem("User Guide");
		HelpDropdownMenu.add(UserGuideMenuItem);
		
		LaunchWebsiteMenuItem = new JMenuItem("Launch Website");
		HelpDropdownMenu.add(LaunchWebsiteMenuItem);
		
		AboutAutographMenuItem = new JMenuItem("About Autograph");
		HelpDropdownMenu.add(AboutAutographMenuItem);

		// Regsiter Events
		AddNodeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				AddNodeBtnActionPerformed(evt);
			}
		});
		AddEdgeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				AddEdgeBtnActionPerformed(evt);
			}
		});
		AutoLabelNodesTog.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AutoLabelNodesTogActionPerformed(evt);
			}
		});
		AutoLabelEdgesTog.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AutoLabelEdgesTogActionPerformed(evt);
			}
		});
		AutoConnectNodesTog.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AutoConnectNodesTogActionPerformed(evt);
			}
		});
		MainWindowTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				JTabbedPane pane = (JTabbedPane)evt.getSource();
				if(!(pane.getTabCount() == 0)) {
					JScrollPane currentPane = (JScrollPane)pane.getSelectedComponent();
					GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
					Graph currentGraph = currentPanel.mGetGraph();
					// Update the AddEdge lists
					AddEdgePanel.updateNodeList(currentGraph.mGetNodeList());
				}
				else {
					return;
				}
			}	
		});
		NewGraphMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				NewGraphMenuItemActionPerformed(evt);
			}
		});
		OpenMenuItem.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				OpenMenuItemActionPerformed(evt);
			}
		});
		SaveMenuItem.addActionListener(new java.awt.event.ActionListener(){
		   public void actionPerformed(java.awt.event.ActionEvent evt){
		      SaveMenuItemActionPerformed(evt);
		   }
		});
		SaveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SaveAsMenuItemActionPerformed(evt);
			}
		});
		CloseGraphMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CloseGraphMenuItemActionPerformed(evt);
			}
		});
		ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ExitMenuItemActionPerformed(evt);
			}
		});
		SelectAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SelectAllMenuItemActionPerformed(evt);
			}
		});
		SelectAllNodesMenuItem.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SelectAllNodesMenuItemActionPerformed(evt);
			}
		});
		SelectAllEdgesMenuItem.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SelectAllEdgesMenuItemActionPerformed(evt);
			}
		});
		DeselectMenuItem.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeselectMenuItemActionPerformed(evt);
			}
		});

		DeleteSelectedMenuItem.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteSelectedMenuItemActionPerformed(evt);
			}
		});

		DeleteSelectedNodesMenuItem.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteSelectedNodesMenuItemActionPerformed(evt);
			}
		});

		DeleteSelectedEdgesMenuItem.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteSelectedEdgesMenuItemActionPerformed(evt);
			}
		});
		CloseTabMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CloseTabMenuItemActionPerformed(evt);
			}
		});
		CloseAllOtherTabsMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt){
				CloseAllOtherTabsMenuItemActionPerformed(evt);
			}
		});
		AutoLabelNodesMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AutoLabelNodesMenuItemActionPerformed(evt);
			}
		});
		AutoLabelEdgesMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AutoLabelEdgesMenuItemActionPerformed(evt);
			}
		});
		AutoConnectNodesMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AutoConnectNodesMenuItemActionPerformed(evt);
			}
		});
	} // End Initialization

	// EVENT Functions
	protected void AutoConnectNodesTogActionPerformed(ActionEvent evt) {
		AutoConnectNodesMenuItem.setState(!AutoConnectNodesMenuItem.getState());
	}

	private void AutoLabelNodesTogActionPerformed(java.awt.event.ActionEvent evt) {
		AutoLabelNodesMenuItem.setState(!AutoLabelNodesMenuItem.getState());
	}

	private void AutoLabelEdgesTogActionPerformed(java.awt.event.ActionEvent evt) {
		AutoLabelEdgesMenuItem.setState(!AutoLabelEdgesMenuItem.getState());
	}

	/**
	 * Opens a new tab on the main window with an empty graph.
	 * @param evt
	 */
	private void NewGraphMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		//first get a unique title for the new tab
		String newTitle = "New Graph";
		if(MainWindowTabbedPane.getTabCount() > 0){
			Boolean uniqueTitle = false;
			int currentNum = 1;
			while(!uniqueTitle){
				//loop through each tab and check the titles.
				for(int i = 0; i < MainWindowTabbedPane.getTabCount(); i++){
					GraphPanel panel = (GraphPanel)(((JScrollPane)MainWindowTabbedPane.getComponentAt(i)).getViewport().getView());
					//check the current tab has the same name as the new title we are creating
					if(panel.mGetGraph().mGetTitle().compareTo(newTitle) == 0){
						//if it does reset newTitle to be of the form "New Graph[1]"
						newTitle = "New Graph[" + currentNum + "]";
						currentNum++;
						break;
					}
					if(i == MainWindowTabbedPane.getTabCount() - 1){
						//if we get here then we have gone through the whole list and not found
						//a duplicate title, so we will break out of the while loop.
						uniqueTitle = true;
					}
				}
			}
		}

		//KMW Note: We are simply creating a new blank tab right now. We do not need to worry
		//          about drawing any graphs in this function.
		Graph newGraph = new Graph(newTitle);
		//GraphHelper.mImportGraphFromXML("Graph.xml");
		JScrollPane newPane = new JScrollPane();
		GraphPanel newGraphPanel = new GraphPanel(newGraph);
		newPane.setBorder(null);

		newGraphPanel.setBackground(new java.awt.Color(255, 255, 255));
		newGraphPanel.setPreferredSize(new java.awt.Dimension(600, 600));

		newPane.setViewportView(newGraphPanel);


		MainWindowTabbedPane.addTab(newTitle, newPane);
		MainWindowTabbedPane.setTabComponentAt(MainWindowTabbedPane.indexOfComponent(newPane), new ButtonTabComponent(newTitle, MainWindowTabbedPane));
	}

	private void SelectAllMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		JScrollPane currentPane = (JScrollPane)MainWindowTabbedPane.getSelectedComponent();
		GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
		Graph currentGraph = currentPanel.mGetGraph();
		ArrayList<Node> nodes = currentGraph.mGetNodeList();
		ArrayList<Edge> edges = currentGraph.mGetEdgeList();
		currentGraph.vSelectedItems.mSelectAllNodes(nodes);
		currentGraph.vSelectedItems.mSelectAllEdges(edges);
		currentPanel.repaint();
	}

	private void SelectAllNodesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		JScrollPane currentPane = (JScrollPane)MainWindowTabbedPane.getSelectedComponent();
		GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
		Graph currentGraph = currentPanel.mGetGraph();
		ArrayList<Node> nodes = currentGraph.mGetNodeList();
		currentGraph.vSelectedItems.mClearSelectedItems();
		currentGraph.vSelectedItems.mSelectAllNodes(nodes);
		currentPanel.repaint();
	}

	private void SelectAllEdgesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		JScrollPane currentPane = (JScrollPane)MainWindowTabbedPane.getSelectedComponent();
		GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
		Graph currentGraph = currentPanel.mGetGraph();
		ArrayList<Edge> edges = currentGraph.mGetEdgeList();
		currentGraph.vSelectedItems.mClearSelectedItems();
		currentGraph.vSelectedItems.mSelectAllEdges(edges);
		currentPanel.repaint();
	}

	public void DeselectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		JScrollPane currentPane = (JScrollPane)MainWindowTabbedPane.getSelectedComponent();
		GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
		Graph currentGraph = currentPanel.mGetGraph();
		currentGraph.vSelectedItems.mClearSelectedItems();
		currentPanel.repaint();
	}

	private void DeleteSelectedMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		JScrollPane currentPane = (JScrollPane)MainWindowTabbedPane.getSelectedComponent();
		GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
		Graph currentGraph = currentPanel.mGetGraph();
		currentGraph.mDeleteSelectedItems();
		AddEdgePanel.updateNodeList(currentGraph.mGetNodeList());
		currentPanel.repaint();
	}

	private void DeleteSelectedNodesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		JScrollPane currentPane = (JScrollPane)MainWindowTabbedPane.getSelectedComponent();
		GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
		Graph currentGraph = currentPanel.mGetGraph();
		currentGraph.mDeleteSelectedNodes();
		AddEdgePanel.updateNodeList(currentGraph.mGetNodeList());
		currentPanel.repaint();
	}

	private void DeleteSelectedEdgesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		JScrollPane currentPane = (JScrollPane)MainWindowTabbedPane.getSelectedComponent();
		GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
		Graph currentGraph = currentPanel.mGetGraph();
		currentGraph.mDeleteSelectedEdges();
		currentPanel.repaint();
	}

	private void CloseTabMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		int selectedTab = MainWindowTabbedPane.getSelectedIndex();
		MainWindowTabbedPane.remove(selectedTab);
	}

	private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		this.exit();
	}

	private void CloseGraphMenuItemActionPerformed(java.awt.event.ActionEvent evt){
		int selectedTab = MainWindowTabbedPane.getSelectedIndex();
		MainWindowTabbedPane.remove(selectedTab);
	}

	private void CloseAllOtherTabsMenuItemActionPerformed(java.awt.event.ActionEvent evt){
		int selectedTab = MainWindowTabbedPane.getSelectedIndex();
		int initialCount = MainWindowTabbedPane.getTabCount();
		//we are removing from the end of the list because the count and index of the last item
		//will constantly shift if we remove from the front of the list, giving inaccurate results.
		for(int i = initialCount -1; i >= 0; i--){
			if(i != selectedTab){
				MainWindowTabbedPane.remove(i);
			}
		}
	}

	private void SaveMenuItemActionPerformed(java.awt.event.ActionEvent evt){
	   int selectedIndex = MainWindowTabbedPane.getSelectedIndex();
	   GraphPanel currentPanel = (GraphPanel)(((JScrollPane)MainWindowTabbedPane.getComponentAt(selectedIndex)).getViewport().getView());
	   String filePath = currentPanel.mGetFilePath();
	   if(filePath != null && !filePath.isEmpty()){
	      //now we check the various extensions that we support and save accordingly.
	      if(filePath.endsWith(".ag")){
	         GraphHelper.mSaveGraphObject(currentPanel.mGetGraph(), filePath);
	      }
	      else if(filePath.endsWith(".xml")){
	         GraphHelper.mExportGraphToXML(currentPanel.mGetGraph(), filePath);
	      }
	      else if(filePath.endsWith(".txt")){
	         try{
	            GraphHelper.mExportGraphToGML(currentPanel.mGetGraph(), filePath);
	         }
	         catch (Exception e){
	            //TODO: implement error dialog
	         }
	      }
	      else if(filePath.endsWith(".png")){
	         GraphHelper.mSavePNG(currentPanel, filePath);
	      }
	      else if(filePath.endsWith(".bmp")){
	         GraphHelper.mSaveBMP(currentPanel, filePath);
	      }
	      else if(filePath.endsWith(".jpg")){
	         GraphHelper.mSaveJPG(currentPanel, filePath);
	      }
	      else if(filePath.endsWith(".gif")){
	         GraphHelper.mSaveGIF(currentPanel, filePath);
	      }
	      else{
	         //something is wrong. Open the filePickerDialog so the user can choose where
	         //and how to open this object.
	         FilePickerDialog saveDialog = new FilePickerDialog(this, true);
	         saveDialog.mOpenSaveDialog(MainWindowTabbedPane);
	      }

	   }
	   else{
	      //something is wrong. Open the filePickerDialog so the user can choose where
	      //and how to save this object.
	      FilePickerDialog saveDialog = new FilePickerDialog(this, true);
	      saveDialog.mOpenSaveDialog(MainWindowTabbedPane);
	   }
	}

	private void SaveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt){
		FilePickerDialog saveDialog = new FilePickerDialog(this, true);
		saveDialog.mOpenSaveDialog(MainWindowTabbedPane);
	}

	/**
	 * Open the file picker dialog.
	 * @param evt
	 */
	private void OpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		FilePickerDialog dialog = new FilePickerDialog(this, true);
		dialog.mOpenFilePickerDialog(MainWindowTabbedPane);
	}

	protected void AutoLabelEdgesMenuItemActionPerformed(ActionEvent evt) {
		AutoLabelEdgesTog.setSelected(!AutoLabelEdgesTog.isSelected());		
	}
	
	private void AutoLabelNodesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		AutoLabelNodesTog.setSelected(!AutoLabelNodesTog.isSelected());
	}

	private void AutoConnectNodesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		AutoConnectNodesTog.setSelected(!AutoConnectNodesTog.isSelected());
	}

	private void AddNodeBtnActionPerformed(java.awt.event.MouseEvent evt) {
		// Bring up the Add Node panel
		SidePanelScrollPane.setViewportView(addNodePanel);
	}

	private void AddEdgeBtnActionPerformed(java.awt.event.MouseEvent evt) {
		// Bring up the Add Node panel
		SidePanelScrollPane.setViewportView(addEdgePanel);
	}

	public static JTabbedPane getMainWindowPane() {
		return MainWindowTabbedPane;
	}

	public static void setSidePanel(String selected) {
		if(selected == "Node") {
			SidePanelScrollPane.setViewportView(editNodePanel);
			editNodePanel.updateFields();
		}
		else if(selected == "Edge") {
			SidePanelScrollPane.setViewportView(editEdgePanel);
			editEdgePanel.updateFields();
		}
		else if(selected == "Both") {
			SidePanelScrollPane.setViewportView(editNodeEdgePanel);
			editNodeEdgePanel.updateFields();
		}
		else if(selected == "Deselect") {
			SidePanelScrollPane.setViewportView(addNodePanel);
		}
		else {
			System.out.println("Oops! - The string was wrong");
		}
	}
	
	public static void resetSidePane() {
		SidePanelScrollPane.setViewportView(addNodePanel);
	}

	public static boolean isAutoLabelNodes() {
		return AutoLabelNodesTog.isSelected();
	}

	public static boolean isAutoLabelEdges() {
		return AutoLabelEdgesTog.isSelected();
	}

	public static boolean isAutoConnectNodes() {
		return AutoConnectNodesTog.isSelected();
	}

	// The Panels
	protected JFrame MainWindowComponent;
	protected JPanel MainWindowPanel;
	protected JSplitPane MainWindowSplitPane;
	protected static JTabbedPane MainWindowTabbedPane;
	// The side panels
	protected static JPanel EditPanel;	
	protected static JScrollPane SidePanelScrollPane;
	protected static AddNodePanel addNodePanel;
	protected static AddEdgePanel addEdgePanel;
	protected static EditNodePanel editNodePanel;
	protected static EditEdgePanel editEdgePanel;
	protected static EditNodeEdgePanel editNodeEdgePanel;
	// The Menubar
	protected JMenuBar MainWindowMenuBar;
	// File Menu
	protected JMenu FileDropdownMenu;
	protected JMenuItem NewGraphMenuItem;
	protected JMenuItem OpenMenuItem;
	protected JMenuItem SaveMenuItem;
	protected JMenuItem SaveAsMenuItem;
	protected JMenuItem PrintMenuItem;
	protected JMenuItem PrintPreviewMenuItem;
	protected JMenuItem CloseGraphMenuItem;
	protected JMenuItem ExitMenuItem;
	// Edit Menu
	protected JMenu EditDropdownMenu;
	protected JMenuItem SelectAllMenuItem;
	protected JMenuItem SelectAllNodesMenuItem;
	protected JMenuItem SelectAllEdgesMenuItem;
	protected JMenuItem DeselectMenuItem;
	protected JMenuItem DeleteSelectedMenuItem;
	protected JMenuItem DeleteSelectedNodesMenuItem;
	protected JMenuItem DeleteSelectedEdgesMenuItem;
	// View Menu
	protected JMenu ViewDropdownMenu;
	protected JMenuItem CloseTabMenuItem;
	protected JMenuItem CloseAllOtherTabsMenuItem;
	protected JMenuItem OpenAdvancedCodeViewMenuItem;
	protected JMenuItem ChangeBGColorMenuItem;
	//Tools Menu
	protected JMenu ToolsDropdownMenu;
	protected JCheckBoxMenuItem AutoLabelNodesMenuItem;
	protected JCheckBoxMenuItem AutoLabelEdgesMenuItem;
	protected JCheckBoxMenuItem AutoConnectNodesMenuItem;
	//Help Menu
	protected JMenu HelpDropdownMenu;
	protected JMenuItem UserGuideMenuItem;
	protected JMenuItem LaunchWebsiteMenuItem;
	protected JMenuItem AboutAutographMenuItem;
	// The Toolbar
	protected JToolBar MainWindowToolBar;
	protected JButton AddNodeBtn;
	protected JButton AddEdgeBtn;
	protected Component MainWindowToolBarHorizontalGlue;
	protected static JToggleButton AutoLabelNodesTog;
	protected static JToggleButton AutoLabelEdgesTog;
	protected static JToggleButton AutoConnectNodesTog;
}


