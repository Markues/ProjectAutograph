/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autograph.ui;

import java.util.ArrayList;

import javax.swing.*;

import autograph.Edge;
import autograph.Graph;
import autograph.GraphHelper;
import autograph.Node;
import autograph.GraphPanel;

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
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(800, 600));
		
		// Add Node Button
		AddNodeBtn = new JButton();
		Icon addIcon = new ImageIcon("resources/AddNode.png");
		AddNodeBtn.setIcon(addIcon);
		AddNodeBtn.setText("Add Node");
		AddNodeBtn.setFocusable(false);
		AddNodeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		AddNodeBtn.setMargin(new java.awt.Insets(5, 5, 2, 5));
		AddNodeBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		AddNodeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				AddNodeBtnActionPerformed(evt);
			}
		});
		
		// Add Edge Button
		AddEdgeBtn = new JButton();
		Icon edgeIcon = new ImageIcon("resources/AddEdge.png");
		AddEdgeBtn.setIcon(edgeIcon);
		AddEdgeBtn.setText("Add Edge");
		AddEdgeBtn.setFocusable(false);
		AddEdgeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		AddEdgeBtn.setMargin(new java.awt.Insets(5, 5, 2, 5));
		AddEdgeBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		AddEdgeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				AddEdgeBtnActionPerformed(evt);
			}
		});

		// Filler 1
		filler1 = new Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 32767));

		// Filler 2
		filler2 = new Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(100, 0));

		// Filler 3
		filler3 = new Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(25, 0));

		// Filler 4
		filler4 = new Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(25, 0));

		// Filler 5
		filler5 = new Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(25, 0));

		// Auto Label Nodes Toggle
		AutoLabelNodesTog = new JToggleButton();
		Icon ALNTIcon = new ImageIcon("resources/ToggleOn.png");
		AutoLabelNodesTog.setIcon(ALNTIcon);
		AutoLabelNodesTog.setSelected(true);
		AutoLabelNodesTog.setText("Auto-Label Nodes");
		AutoLabelNodesTog.setFocusable(false);
		AutoLabelNodesTog.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AutoLabelNodesTogActionPerformed(evt);
			}
		});
		
		// Auto Label Edges Toggle
		AutoLabelEdgesTog = new JToggleButton();
		Icon ALETIcon = new ImageIcon("resources/ToggleOff.png");
		AutoLabelEdgesTog.setIcon(ALETIcon);
		AutoLabelEdgesTog.setText("Auto-Label Edges");
		AutoLabelEdgesTog.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		AutoLabelEdgesTog.setFocusable(false);
		AutoLabelEdgesTog.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		AutoLabelEdgesTog.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AutoLabelEdgesTogActionPerformed(evt);
			}
		});
		
		// Auto Connect Nodes Toggle
		AutoConnectNodesTog = new JToggleButton();
		Icon ACNTIcon = new ImageIcon("resources/ToggleOff.png");
		AutoConnectNodesTog.setIcon(ACNTIcon);
		AutoConnectNodesTog.setText("Auto-Connect Nodes");
		AutoConnectNodesTog.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		AutoConnectNodesTog.setFocusable(false);
		AutoConnectNodesTog.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		MainWindowToolBar.add(AutoConnectNodesTog);
		
		// Main Window Toolbar
		MainWindowToolBar = new JToolBar();
		MainWindowToolBar.setFloatable(false);
		MainWindowToolBar.setRollover(true);
		MainWindowToolBar.add(AddNodeBtn);
		MainWindowToolBar.add(AddEdgeBtn);
		MainWindowToolBar.add(filler2);
		MainWindowToolBar.add(filler3);
		MainWindowToolBar.add(filler4);
		MainWindowToolBar.add(filler5);
		MainWindowToolBar.add(AutoLabelNodesTog);
		MainWindowToolBar.add(AutoLabelEdgesTog);
		
		// Graph Tab Subpane
		Graph graph = GraphHelper.mImportGraphFromXML("Graph.xml");	
		GraphTabSubPane = new GraphPanel(graph);
		GraphTabSubPane.setBackground(new java.awt.Color(255, 255, 255));
		GraphTabSubPane.setPreferredSize(new java.awt.Dimension(600, 600));
		javax.swing.GroupLayout GraphTabSubPaneLayout = new GroupLayout(GraphTabSubPane);
		GraphTabSubPane.setLayout(GraphTabSubPaneLayout);
		GraphTabSubPaneLayout.setHorizontalGroup(
				GraphTabSubPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 912, Short.MAX_VALUE)
				);
		GraphTabSubPaneLayout.setVerticalGroup(
				GraphTabSubPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 476, Short.MAX_VALUE)
				);
		
		// Graph Tab Pane
		GraphTabPane = new JScrollPane();
		GraphTabPane.setBorder(null);
		GraphTabPane.setViewportView(GraphTabSubPane);
		
		// Main Window Tabbed Pane
		MainWindowTabbedPane = new JTabbedPane();
		MainWindowTabbedPane.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		MainWindowTabbedPane.setMinimumSize(new java.awt.Dimension(114, 95));
		MainWindowTabbedPane.addTab("Original Tab", GraphTabPane);

		// Add Node Panel
		addNodePanel = new AddNodePanel();
		addNodePanel.setPreferredSize(new java.awt.Dimension(200, 512));
		
		// Add Edge Panel
		addEdgePanel = new AddEdgePanel();
		addEdgePanel.setPreferredSize(new java.awt.Dimension(200, 512));
		
		// Edit Node Panel
		editNodePanel = new EditNodePanel();
		editNodePanel.setPreferredSize(new java.awt.Dimension(200, 512));
		
		// Edit Edge Panel
		editEdgePanel = new EditEdgePanel();
		editEdgePanel.setPreferredSize(new java.awt.Dimension(200, 512));
		
		// Edit Both Panel
		editNodeEdgePanel = new EditNodeEdgePanel();
		editNodeEdgePanel.setPreferredSize(new java.awt.Dimension(200, 512));
		
		// Edit Panel
		EditPanel = new JPanel();
		EditPanel.setPreferredSize(new java.awt.Dimension(200, 512));
		javax.swing.GroupLayout EditPanelLayout = new GroupLayout(EditPanel);
		EditPanel.setLayout(EditPanelLayout);
		
		// Side Panel Scroll Pane
		sidePanelScrollPane = new JScrollPane();
		sidePanelScrollPane.setBorder(null);
		sidePanelScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sidePanelScrollPane.setViewportView(EditPanel);
		
		// Main Panel
		mainPanel = new JPanel();
		mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		javax.swing.GroupLayout jPanel2Layout = new GroupLayout(mainPanel);
		mainPanel.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(sidePanelScrollPane, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(filler1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
								.addGap(0, 0, Short.MAX_VALUE))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(sidePanelScrollPane, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0))
				);
		
		// New Graph Menu Item
		NewGraphMenuItem = new JMenuItem();
		NewGraphMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
		NewGraphMenuItem.setText("New Graph...");
		NewGraphMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				NewGraphMenuItemActionPerformed(evt);
			}
		});

		// Open Menu Item
		OpenMenuItem = new JMenuItem();
		OpenMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
		OpenMenuItem.setText("Open...");
		OpenMenuItem.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				OpenMenuItemActionPerformed(evt);
			}
		});
		
		// Save Menu Item
		SaveMenuItem = new JMenuItem();
		SaveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
		SaveMenuItem.setText("Save");
		
		// Save As Menu Item
		SaveAsMenuItem = new JMenuItem();
		SaveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
		SaveAsMenuItem.setText("Save As...");
		SaveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SaveAsMenuItemActionPerformed(evt);
			}
		});
		
		// Print Menu Item
		PrintMenuItem = new JMenuItem();
		PrintMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
		PrintMenuItem.setText("Print...");
		
		// Print Preview Menu Item
		PrintPreviewMenuItem = new JMenuItem();
		PrintPreviewMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
		PrintPreviewMenuItem.setText("Print Preview");
		
		// Close Graph Menu Item
		CloseGraphMenuItem = new JMenuItem();
		CloseGraphMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
		CloseGraphMenuItem.setText("Close Graph");
		CloseGraphMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CloseGraphMenuItemActionPerformed(evt);
			}
		});
		
		// Exit Menu Item
		ExitMenuItem = new JMenuItem();
		ExitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
		ExitMenuItem.setText("Exit");
		ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ExitMenuItemActionPerformed(evt);
			}
		});
		
		// Select All Menu Item
		SelectAllMenuItem = new JMenuItem();
		SelectAllMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
		SelectAllMenuItem.setText("Select All");
		SelectAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SelectAllMenuItemActionPerformed(evt);
			}
		});
		
		// Select All Nodes Menu Item
		SelectAllNodesMenuItem = new JMenuItem();
		SelectAllNodesMenuItem.setText("Select All Nodes");
		SelectAllNodesMenuItem.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SelectAllNodesMenuItemActionPerformed(evt);
			}
		});
		
		// Select All Adges Menu Item
		SelectAllEdgesMenuItem = new JMenuItem();
		SelectAllEdgesMenuItem.setText("Select All Edges");
		SelectAllEdgesMenuItem.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SelectAllEdgesMenuItemActionPerformed(evt);
			}
		});
		
		// Deselect Menu Item
		DeselectMenuItem = new JMenuItem();
		DeselectMenuItem.setText("Deselect");
		DeselectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
		DeselectMenuItem.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeselectMenuItemActionPerformed(evt);
			}
		});
		
		// Close Tab Menu Item
		CloseTabMenuItem = new JMenuItem();
		CloseTabMenuItem.setText("Close Tab");
		CloseTabMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CloseTabMenuItemActionPerformed(evt);
			}
		});
		
		// Close All Other Tabes Menu Item
		CloseAllOtherTabsMenuItem = new JMenuItem();
		CloseAllOtherTabsMenuItem.setText("Close All Other Tabs");
		CloseAllOtherTabsMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt){
				CloseAllOtherTabsMenuItemActionPerformed(evt);
			}
		});
		
		// Open Advanced Code View Menu Item
		OpenAdvancedCodeViewMenuItem = new JMenuItem();
		OpenAdvancedCodeViewMenuItem.setText("Open Advanced Code View");
			
		// Auto Label Nodes Menu Item
		AutoLabelNodesMenuItem = new JCheckBoxMenuItem();
		AutoLabelNodesMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		AutoLabelNodesMenuItem.setSelected(true);
		AutoLabelNodesMenuItem.setText("Auto-Label Nodes");
		AutoLabelNodesMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AutoLabelNodesMenuItemActionPerformed(evt);
			}
		});
		
		// Auto Label Edges Menu Item
		AutoLabelEdgesMenuItem = new JCheckBoxMenuItem();
		AutoLabelEdgesMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		AutoLabelEdgesMenuItem.setText("Auto-Label Edges");
		
		// Auto Connect Nodes Menu Item
		AutoConnectNodesMenuItem = new JCheckBoxMenuItem();
		AutoConnectNodesMenuItem.setText("Auto-Connect Nodes");
		AutoConnectNodesMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AutoConnectNodesMenuItemActionPerformed(evt);
			}
		});
		
		// Change Background Color Menu Item
		ChangeBgColorMenuItem = new JMenuItem();
		ChangeBgColorMenuItem.setText("Change Background Color");
		
		// View User Guide Menu Item
		ViewUserGuideMenuItem = new JMenuItem();
		ViewUserGuideMenuItem.setText("View User Guide");
		
		// About Autograph Menu Item
		AboutAutographMenuItem = new JMenuItem();
		AboutAutographMenuItem.setText("About Autograph...");

		// File Drop Down Menu
		FileDropdownMenu = new JMenu();
		FileDropdownMenu.setText("File");
		FileDropdownMenu.add(NewGraphMenuItem);
		FileDropdownMenu.add(OpenMenuItem);
		FileDropdownMenu.add(SaveMenuItem);
		FileDropdownMenu.add(SaveAsMenuItem);
		FileDropdownMenu.add(PrintMenuItem);
		FileDropdownMenu.add(PrintPreviewMenuItem);
		FileDropdownMenu.add(CloseGraphMenuItem);
		FileDropdownMenu.add(ExitMenuItem);

		// Edit Drop Down Menu
		EditDropdownMenu = new JMenu();
		EditDropdownMenu.setText("Edit");
		EditDropdownMenu.add(SelectAllMenuItem);
		EditDropdownMenu.add(SelectAllNodesMenuItem);
		EditDropdownMenu.add(SelectAllEdgesMenuItem);
		EditDropdownMenu.add(DeselectMenuItem);

		// View Drop Down Menu
		ViewDropdownMenu = new JMenu();
		ViewDropdownMenu.setText("View");
		ViewDropdownMenu.add(CloseTabMenuItem);
		ViewDropdownMenu.add(CloseAllOtherTabsMenuItem);
		ViewDropdownMenu.add(OpenAdvancedCodeViewMenuItem);

		// Tools Drop Down Menu
		ToolsDropdownMenu = new JMenu();
		ToolsDropdownMenu.setText("Tools");
		ToolsDropdownMenu.add(AutoLabelNodesMenuItem);
		ToolsDropdownMenu.add(AutoLabelEdgesMenuItem);
		ToolsDropdownMenu.add(AutoConnectNodesMenuItem);
		ToolsDropdownMenu.add(ChangeBgColorMenuItem);
		
		HelpDropdownMenu = new JMenu();
		HelpDropdownMenu.setText("Help");
		HelpDropdownMenu.add(ViewUserGuideMenuItem);
		HelpDropdownMenu.add(AboutAutographMenuItem);
		
		// Main Window Menu Bar
		MainWindowMenuBar = new JMenuBar();
		MainWindowMenuBar.add(FileDropdownMenu);
		MainWindowMenuBar.add(EditDropdownMenu);
		MainWindowMenuBar.add(ViewDropdownMenu);
		MainWindowMenuBar.add(ToolsDropdownMenu);
		MainWindowMenuBar.add(HelpDropdownMenu);		
		setJMenuBar(MainWindowMenuBar);

		// Layout
		javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(MainWindowTabbedPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(MainWindowToolBar, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(MainWindowToolBar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(MainWindowTabbedPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
								.addContainerGap())
				);

		pack();
	}

	private void AutoLabelNodesTogActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void AutoLabelEdgesTogActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
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

		javax.swing.GroupLayout newGraphPanelLayout = new GroupLayout(newGraphPanel);
		newGraphPanel.setLayout(newGraphPanelLayout);
		newGraphPanelLayout.setHorizontalGroup(
				newGraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 912, Short.MAX_VALUE)
				);
		newGraphPanelLayout.setVerticalGroup(
				newGraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 476, Short.MAX_VALUE)
				);
		MainWindowTabbedPane.addTab(newTitle, newPane);

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

	private void AutoLabelNodesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void AutoConnectNodesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void AddNodeBtnActionPerformed(java.awt.event.MouseEvent evt) {
		// Bring up the Add Node panel
		sidePanelScrollPane.setViewportView(addNodePanel);
	}
	
	private void AddEdgeBtnActionPerformed(java.awt.event.MouseEvent evt) {
		// Bring up the Add Node panel
		sidePanelScrollPane.setViewportView(addEdgePanel);
	}

	public static JTabbedPane getMainWindowPane() {
		return MainWindowTabbedPane;
	}
	
	public static void resetSidePane() {
		sidePanelScrollPane.setViewportView(EditPanel);
	}
	
	// Variables declaration
	private JButton AddEdgeBtn;
	private JButton AddNodeBtn;
	private JCheckBoxMenuItem AutoConnectNodesMenuItem;
	private JToggleButton AutoConnectNodesTog;
	private JToggleButton AutoLabelEdgesTog;
	private JToggleButton AutoLabelNodesTog;
	private JCheckBoxMenuItem AutoLabelNodesMenuItem;
	private JCheckBoxMenuItem AutoLabelEdgesMenuItem;
	protected static JTabbedPane MainWindowTabbedPane;
	private JToolBar MainWindowToolBar;
	private JMenuItem NewGraphMenuItem;
	private JMenuItem OpenAdvancedCodeViewMenuItem;
	private JMenuItem OpenMenuItem;
	private JMenuItem PrintMenuItem;
	private JMenuItem PrintPreviewMenuItem;
	private JMenuItem SaveAsMenuItem;
	private JMenuItem SaveMenuItem;
	private JMenuItem SelectAllEdgesMenuItem;
	private JMenuItem SelectAllMenuItem;
	private JMenuItem SelectAllNodesMenuItem;
	private JMenuItem ChangeBgColorMenuItem;
	private JMenuItem CloseAllOtherTabsMenuItem;
	private JMenuItem CloseGraphMenuItem;
	private JMenuItem CloseTabMenuItem;
	private JMenuItem DeselectMenuItem;
	private JMenuItem ViewUserGuideMenuItem;
	private JMenuItem AboutAutographMenuItem;
	private JMenuItem ExitMenuItem;
	private JMenuBar MainWindowMenuBar;
	private JMenu FileDropdownMenu;
	private JMenu HelpDropdownMenu;
	private JMenu ToolsDropdownMenu;
	private JMenu ViewDropdownMenu;
	private JMenu EditDropdownMenu;	
	private Box.Filler filler1;
	private Box.Filler filler2;
	private Box.Filler filler3;
	private Box.Filler filler4;
	private Box.Filler filler5;
	private JPanel mainPanel;
	private static JPanel EditPanel;	
	public GraphPanel GraphTabSubPane;
	private JScrollPane GraphTabPane;
	private static JScrollPane sidePanelScrollPane;

	// The side panels
	protected AddNodePanel addNodePanel;
	protected AddEdgePanel addEdgePanel;
	protected EditNodePanel editNodePanel;
	protected EditEdgePanel editEdgePanel;
	protected EditNodeEdgePanel editNodeEdgePanel;

}


