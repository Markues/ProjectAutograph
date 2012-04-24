/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autograph.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;

import autograph.Graph;
import autograph.GraphHelper;
import autograph.GraphPanel;
import autograph.Edge;
import autograph.Node;
import autograph.exception.CannotAddEdgeException;
import autograph.exception.CannotAddNodeException;

public class AddEdgePanel extends JPanel {

	/**
	 * Creates new form AddNodePanel
	 */
	public AddEdgePanel() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		// Setup
		GraphicsEnvironment ge;
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
		String[] fontNames = ge.getAvailableFontFamilyNames();
		
		setBackground(new java.awt.Color(255, 255, 255));
		setMinimumSize(new java.awt.Dimension(200, 510));
		setPreferredSize(new java.awt.Dimension(200, 510));
		
		labelColor = Color.BLACK;
		edgeColor = Color.BLACK;
		
		// Panel Scroll Pane
		panelScrollPane = new JScrollPane();
		panelScrollPane.setBorder(null);
		panelScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// Add Edge Panel
		AddEdgePanel = new JPanel();
		AddEdgePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		AddEdgePanel.setPreferredSize(new java.awt.Dimension(200, 510));
		
		// Add Edge Title Label
		AddEdgeTitleLabel = new JLabel();
		AddEdgeTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); 
		AddEdgeTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		AddEdgeTitleLabel.setText("Add Edge");
		
		// Label Subtitle Label
		LabelSubtitleLabel = new JLabel();
		LabelSubtitleLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); 
		LabelSubtitleLabel.setText("Label");
		
		// Label Text Label
		LabelTextLabel = new JLabel();
		LabelTextLabel.setText("Label Text");
		
		// Label Text Field
		LabelTextField = new JTextField();
		
		// Label Font Label
		LabelFontLabel = new JLabel();
		LabelFontLabel.setText("Label Font");
		
		// Label Font Combo Box
		LabelFontComboBox = new JComboBox();
		LabelFontComboBox.setModel(new DefaultComboBoxModel(fontNames));
		LabelFontComboBox.setSelectedItem("Courier");
		
		// Label Color Label
		LabelColorLabel = new JLabel();
		LabelColorLabel.setText("Label Color");
		
		// Label Color Button
		LabelColorBtn = new JButton();
		LabelColorBtn.setText("Select Color");
		LabelColorBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
		LabelColorBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				LabelColorBtnActionPerformed(evt);
			}
		});
		
		// Edge Subtitle Label
		EdgeSubtitleLabel = new JLabel();
		EdgeSubtitleLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); 
		EdgeSubtitleLabel.setText("Edge");
		
		// Edge Design Label
		EdgeDesignLabel = new JLabel();
		EdgeDesignLabel.setText("Edge Design");
		
		// End Shape Label
		EndShapeLabel = new JLabel();
		EndShapeLabel.setText("End Shape");
		
		// Edge Color Label
		EdgeColorLabel = new JLabel();
		EdgeColorLabel.setText("Edge Color");
		
		// Edge Color Button
		EdgeColorBtn = new JButton();
		EdgeColorBtn.setText("Select Color");
		EdgeColorBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
		EdgeColorBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				EdgeColorBtnActionPerformed(evt);
			}
		});
		
		// Edge Design Combo Box
		EdgeDesignComboBox = new JComboBox();
		EdgeDesignComboBox.setModel(new DefaultComboBoxModel(new String[] {"Solid", "Dotted", "Dashed"}));
		
		// Edge Shape Combo Box
		EndShapeComboBox = new JComboBox();
		EndShapeComboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Line Arrow", "Shape Arrow", "Filled Arrow"}));
		
		// Panel Separator
		panelSeperator = new JSeparator();
		
		// Ok Button
		OkBtn = new JButton();
		OkBtn.setText("Add Edge");
		OkBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				OkBtnActionPerformed(evt);
			}
		});
		
		// Source Node Label
		StartNodeLabel = new JLabel();
		StartNodeLabel.setText("Start Node");
		
		// Select Source Node Combo Box
		SelectStartNodeComboBox = new JComboBox(getNodeList());
		//SelectStartNodeComboBox.setModel(new DefaultComboBoxModel(getNodeList()));
		SelectStartNodeComboBox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				StartNodeSelectItemChanged(evt);
			}
		});
		
		// Destination Node Label
		EndNodeLabel = new JLabel();
		EndNodeLabel.setText("End Node");
		
		// Select Destination Combo Box
		SelectEndNodeComboBox = new JComboBox(getNodeList());
		//SelectEndNodeComboBox.setModel(new DefaultComboBoxModel(getNodeList()));
		SelectEndNodeComboBox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				EndNodeSelectItemChanged(evt);
			}
		});
		
		// Panel Filler
		panelFiller = new Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 32767));

		// Layout
		javax.swing.GroupLayout AddEdgePanelLayout = new GroupLayout(AddEdgePanel);
		AddEdgePanel.setLayout(AddEdgePanelLayout);
		AddEdgePanelLayout.setHorizontalGroup(
				AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(AddEdgePanelLayout.createSequentialGroup()
						.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(LabelSubtitleLabel)
								.addComponent(EdgeSubtitleLabel))
								.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(AddEdgePanelLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(AddEdgeTitleLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(LabelTextField, 0, GroupLayout.DEFAULT_SIZE, 190)
												.addComponent(LabelFontComboBox, 0, GroupLayout.DEFAULT_SIZE, 190)
												.addComponent(panelSeperator, 0, GroupLayout.DEFAULT_SIZE, 186)
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddEdgePanelLayout.createSequentialGroup()
														.addGap(0, 0, Short.MAX_VALUE)
														.addComponent(OkBtn))
														.addGroup(AddEdgePanelLayout.createSequentialGroup()
																.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																		.addGroup(AddEdgePanelLayout.createSequentialGroup()
																				.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(LabelTextLabel)
																						.addComponent(LabelFontLabel)
																						.addComponent(EndShapeLabel)
																						.addComponent(EdgeColorLabel)
																						.addComponent(StartNodeLabel)
																						.addComponent(EndNodeLabel))
																						.addGap(10, 10, 10)
																						.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(EdgeColorBtn, 0, GroupLayout.DEFAULT_SIZE, 120)
																								.addComponent(LabelColorBtn, 0, GroupLayout.DEFAULT_SIZE, 120)
																								.addComponent(EdgeDesignComboBox, 0, GroupLayout.DEFAULT_SIZE, 120)
																								.addComponent(EndShapeComboBox, 0, GroupLayout.DEFAULT_SIZE, 120)
																								.addComponent(SelectEndNodeComboBox, 0, GroupLayout.DEFAULT_SIZE, 120)
																								.addComponent(SelectStartNodeComboBox, 0, GroupLayout.DEFAULT_SIZE, 120)))
																								.addGroup(AddEdgePanelLayout.createSequentialGroup()
																										.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(EdgeDesignLabel)
																												.addComponent(LabelColorLabel))
																												.addGap(18, 18, 18)
																												.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING))))
																														.addGap(0, 0, Short.MAX_VALUE)))
																														.addContainerGap())
				);
		AddEdgePanelLayout.setVerticalGroup(
				AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(AddEdgePanelLayout.createSequentialGroup()
						.addComponent(AddEdgeTitleLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(LabelSubtitleLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(LabelTextLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(LabelTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(LabelFontLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(LabelFontComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(LabelColorLabel)
								.addComponent(LabelColorBtn))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(panelSeperator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addGap(3, 3, 3)
								.addComponent(EdgeSubtitleLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(EdgeDesignLabel)
										.addComponent(EdgeDesignComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(EndShapeLabel)
												.addComponent(EndShapeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(18, 18, 18)
												.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(EdgeColorLabel)
														.addComponent(EdgeColorBtn))
														.addGap(18, 18, 18)
														.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(StartNodeLabel)
																.addComponent(SelectStartNodeComboBox))
																.addGap(18, 18, 18)
																.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(EndNodeLabel)
																		.addComponent(SelectEndNodeComboBox))
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(OkBtn)
																		.addContainerGap())
				);

		panelScrollPane.setViewportView(AddEdgePanel);

		javax.swing.GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(panelFiller, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(panelScrollPane, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(panelScrollPane, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelFiller, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0))
				);
	}

	protected void EndNodeSelectItemChanged(ItemEvent evt) {
		System.out.println("Point 0");
		if(evt.getStateChange() == ItemEvent.DESELECTED) {
			System.out.println("Point 1");
			deSelectedItem = (String)evt.getItem();
		}
		else if(evt.getStateChange() == ItemEvent.SELECTED) {
			// Graph/Window pointers
			mainWindowTabbedPane = mainWindow.getMainWindowPane();
			JScrollPane currentPane = (JScrollPane)mainWindowTabbedPane.getSelectedComponent();
			GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
			Graph currentGraph = currentPanel.mGetGraph();
			//int numNodes = currentGraph.mGetNodeList().size();
			System.out.println("Point 2");

			// Get the new selected Node's ID
			String selectedItem = (String)evt.getItem();
			String[] splitItem = selectedItem.split(" - ");
			if(selectedItem.equals((String)SelectStartNodeComboBox.getSelectedItem()) && !selectedItem.equals("")) {
				SelectEndNodeComboBox.setSelectedItem(deSelectedItem);
				JOptionPane.showMessageDialog(AddEdgePanel.this, "Cannot Connect A Node to Itself (Yet)!", "Attention!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			System.out.println("Point 3");

			// Set the local Node pointer
			endNode = currentGraph.mGetNodeById(splitItem[0]);
			currentGraph.vSelectedItems.mAppendNode(endNode);
			currentPanel.repaint();
			System.out.println("Point 4");
		}
	}

	protected void StartNodeSelectItemChanged(ItemEvent evt) {
		if(evt.getStateChange() == ItemEvent.DESELECTED) {
			deSelectedItem = (String)evt.getItem();
		}
		if(evt.getStateChange() == ItemEvent.SELECTED) {
			// Graph/Window pointers
			mainWindowTabbedPane = mainWindow.getMainWindowPane();
			JScrollPane currentPane = (JScrollPane)mainWindowTabbedPane.getSelectedComponent();
			GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
			Graph currentGraph = currentPanel.mGetGraph();
			//int numNodes = currentGraph.mGetNodeList().size();
			
			// Get the new selected Node's ID
			String selectedItem = (String)SelectStartNodeComboBox.getSelectedItem();
			String[] splitItem = selectedItem.split(" - ");
			if(selectedItem.equals((String)SelectEndNodeComboBox.getSelectedItem()) && !selectedItem.equals("")) {
				SelectStartNodeComboBox.setSelectedItem(deSelectedItem);
				JOptionPane.showMessageDialog(AddEdgePanel.this, "Cannot Connect A Node to Itself (Yet)!", "Attention!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// Set the local Node pointer
			startNode = currentGraph.mGetNodeById(splitItem[0]);
			currentGraph.vSelectedItems.mAppendNode(startNode);
			currentPanel.repaint();
		}	
	}

	protected String[] getNodeList() {
		// Graph/Window pointers
		mainWindowTabbedPane = mainWindow.getMainWindowPane();
		JScrollPane currentPane = (JScrollPane)mainWindowTabbedPane.getSelectedComponent();
		GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
		Graph currentGraph = currentPanel.mGetGraph();
		int numNodes = currentGraph.mGetNodeList().size();
		String[] nodeList = new String[numNodes + 1];
		nodeList[0] = "";
		for(int i = 0; i < numNodes; i++) {
			// "NodeId - NodeLabel"
			String nodeLabel;
			if((nodeLabel = currentGraph.mGetNodeList().get(i).mGetLabel()) == "") {
				nodeLabel = "No Label";
			}
			nodeList[i + 1] = (currentGraph.mGetNodeList().get(i).mGetId()) + " - " + nodeLabel;
		}
		return nodeList;
	}

	// If the Edge Color Button is clicked
	protected void EdgeColorBtnActionPerformed(MouseEvent evt) {
		Color newColor = JColorChooser.showDialog(AddEdgePanel.this, "Choose Edge Color", edgeColor);

		if (newColor != null) {
			edgeColor = newColor;
		}
	}

	// If the Label Color Button is clicked
	protected void LabelColorBtnActionPerformed(MouseEvent evt) {
		Color newColor = JColorChooser.showDialog(AddEdgePanel.this, "Choose Border Color", labelColor);

		if (newColor != null) {
			labelColor = newColor;
		}
	}

	private void OkBtnActionPerformed(java.awt.event.ActionEvent evt) {
		// Graph/Window pointers
		mainWindowTabbedPane = mainWindow.getMainWindowPane();
		JScrollPane currentPane = (JScrollPane)mainWindowTabbedPane.getSelectedComponent();
		GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
		Graph currentGraph = currentPanel.mGetGraph();
		//int numNodes = currentGraph.mGetNodeList().size();
		int numEdges = currentGraph.mGetEdgeList().size();

		// If auto Label Edges is on
		if(mainWindow.isAutoLabelEdges()) {
			// Make a Node Label
			if(LabelTextField.getText().isEmpty()) {
				edgeLabel = "Edge" + Integer.toString(numEdges + 1);
			}
			// Retrieve the node label
			else {
				edgeLabel = LabelTextField.getText();
			}
		}
		// Otherwise...
		else {
			// They need to enter a Node Label
			if(LabelTextField.getText().isEmpty()) {
				edgeLabel = null;
				//JOptionPane.showMessageDialog(AddEdgePanel.this, "Please specify an Edge Label!", "Attention!", JOptionPane.WARNING_MESSAGE);
				//return;
			}
			// Retrieve the node label
			else {
				edgeLabel = LabelTextField.getText();
			}
		}
		// If both nodes have been selected
		if(!(((String)SelectStartNodeComboBox.getSelectedItem()).equals("")) && !(((String)SelectEndNodeComboBox.getSelectedItem()).equals(""))) {
			// Create the new edge
			Edge newEdge = new Edge(Integer.toString(numEdges), edgeLabel, startNode, endNode, "NODIRECTION", (String)EdgeDesignComboBox.getSelectedItem(), false);
			// Set the font
			newEdge.mSetFont(Font.decode((String)LabelFontComboBox.getSelectedItem()));
			// Set the Colors
			newEdge.mSetEdgeColor(edgeColor);
			newEdge.mSetLabelColor(labelColor);

			// Try to add the node
			try {
				currentGraph.mAddEdge(newEdge);
			} catch (CannotAddEdgeException e) {
				e.printStackTrace();
			}
			
			// Redraw the graph with the new node
			GraphHelper.mDrawForceDirectedGraph(currentPanel);
			currentPanel.repaint();
			int newWidth = GraphHelper.mGetPreferredImageWidth(currentGraph);
			currentPanel.setPreferredSize(new Dimension(newWidth, newWidth));
			currentPane.revalidate();
			//mainWindow.resetSidePane();
		}
		else {
			JOptionPane.showMessageDialog(AddEdgePanel.this, "Please select both nodes!", "Attention!", JOptionPane.WARNING_MESSAGE);
		}
		
		SelectStartNodeComboBox.setSelectedItem("");
		SelectEndNodeComboBox.setSelectedItem("");
		currentGraph.vSelectedItems.mClearSelectedItems();	
	}

	// Variables declaration
	private JPanel AddEdgePanel;
	private JLabel AddEdgeTitleLabel;
	private JButton EdgeColorBtn;
	private JLabel EdgeColorLabel;
	private JComboBox EdgeDesignComboBox;
	private JLabel EdgeDesignLabel;
	private JLabel EdgeSubtitleLabel;
	private JComboBox EndShapeComboBox;
	private JLabel EndShapeLabel;
	private JButton LabelColorBtn;
	private JLabel LabelColorLabel;
	private JComboBox LabelFontComboBox;
	private JLabel LabelFontLabel;
	private JLabel LabelSubtitleLabel;
	private JTextField LabelTextField;
	private JLabel LabelTextLabel;
	private JButton OkBtn;
	private JLabel EndNodeLabel;
	protected static JComboBox SelectEndNodeComboBox;
	private JLabel StartNodeLabel;
	protected static JComboBox SelectStartNodeComboBox;
	private Box.Filler panelFiller;
	private JScrollPane panelScrollPane;
	private JSeparator panelSeperator;
	
	protected JTabbedPane mainWindowTabbedPane;
	protected JScrollPane currentPane;
	protected GraphPanel currentPanel;
	protected Graph currentGraph;
	protected String edgeLabel;
	
	protected Color labelColor;
	protected Color edgeColor;
	
	protected String deSelectedItem;
	
	protected Node startNode;
	protected Node endNode;
}
