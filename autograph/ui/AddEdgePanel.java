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
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		// Setup
		GraphicsEnvironment ge;
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
		String[] fontNames = ge.getAvailableFontFamilyNames();
		
		setBackground(new java.awt.Color(255, 255, 255));
		setMinimumSize(new java.awt.Dimension(200, 512));
		setPreferredSize(new java.awt.Dimension(200, 512));
		
		labelColor = Color.BLACK;
		edgeColor = Color.BLACK;
		
		// Add Edge Panel
		AddEdgePanel = new JPanel();
		AddEdgePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		AddEdgePanel.setPreferredSize(new java.awt.Dimension(200, 512));
		
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
		
		// Direction Label
		DirectionLabel = new JLabel();
		DirectionLabel.setText("Direction");
		
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
		
		// Direction Combo Box
		DirectionComboBox = new JComboBox();
		DirectionComboBox.setModel(new DefaultComboBoxModel(new String[] {"NoDirection", "StartDirection", "EndDirection", "DoubleDirection"}));
		
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
																						.addComponent(DirectionLabel)
																						.addComponent(EdgeColorLabel)
																						.addComponent(StartNodeLabel)
																						.addComponent(EndNodeLabel))
																						.addGap(10, 10, 10)
																						.addGroup(AddEdgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(EdgeColorBtn, 0, GroupLayout.DEFAULT_SIZE, 120)
																								.addComponent(LabelColorBtn, 0, GroupLayout.DEFAULT_SIZE, 120)
																								.addComponent(EdgeDesignComboBox, 0, GroupLayout.DEFAULT_SIZE, 120)
																								.addComponent(DirectionComboBox, 0, GroupLayout.DEFAULT_SIZE, 120)
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
												.addComponent(DirectionLabel)
												.addComponent(DirectionComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

		javax.swing.GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(panelFiller, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(AddEdgePanel, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
								.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(AddEdgePanel, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelFiller, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0))
				);
	}

	protected void EndNodeSelectItemChanged(ItemEvent evt) {
		if(evt.getStateChange() == ItemEvent.DESELECTED) {
			deSelectedItem = (String)evt.getItem();
		}
		else if(evt.getStateChange() == ItemEvent.SELECTED) {
			// Graph/Window pointers
			mainWindowTabbedPane = mainWindow.getMainWindowPane();
			JScrollPane currentPane = (JScrollPane)mainWindowTabbedPane.getSelectedComponent();
			GraphPanel currentPanel = (GraphPanel)currentPane.getViewport().getView();
			Graph currentGraph = currentPanel.mGetGraph();
			//int numNodes = currentGraph.mGetNodeList().size();

			// Get the new selected Node's ID
			String selectedItem = (String)evt.getItem();
			String[] splitItem = selectedItem.split(" - ");

			// Set the local Node pointer
			endNode = currentGraph.mGetNodeById(splitItem[0]);
			currentGraph.vSelectedItems.mAppendNode(endNode);
			currentPanel.repaint();
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
				edgeLabel = "";
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
			

			// Try to add the edge
			try {
			   //KMW Note: do all of this in the try, because if it fails to create the edge we don't want to
			   //          add it to the edge list.
			   Edge.mValidateEdge(Integer.toString(numEdges), startNode, endNode, currentGraph);
			   // Create the new edge
	         Edge newEdge = new Edge(Integer.toString(numEdges), edgeLabel, startNode, endNode, (String)DirectionComboBox.getSelectedItem(), (String)EdgeDesignComboBox.getSelectedItem());
	         newEdge.mSetPairPosition(currentGraph.mCheckForEdgeTwin(newEdge));
	         if(newEdge != null){
   	         // Set the font
   	         newEdge.mSetFont(Font.decode((String)LabelFontComboBox.getSelectedItem()));
   	         // Set the Colors
   	         newEdge.mSetEdgeColor(edgeColor);
   	         newEdge.mSetLabelColor(labelColor);
   				currentGraph.mAddEdge(newEdge);
   				
   				//KMW Note: We should not attempt to draw the graph if we get a 
   				//          CannotAddEdge exception.
   			   // Redraw the graph with the new edge
   	         GraphHelper.mDrawForceDirectedGraph(currentPanel);
   	         currentPanel.repaint();
   	         int newWidth = GraphHelper.mGetPreferredImageWidth(currentGraph);
   	         currentPanel.setPreferredSize(new Dimension(newWidth, newWidth));
   	         currentPane.revalidate();
   	         //mainWindow.resetSidePane();
	         }
			} catch (CannotAddEdgeException e) {
			   JOptionPane errorDialog = new JOptionPane();
			   JOptionPane.showMessageDialog(errorDialog, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
			
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
	private JComboBox DirectionComboBox;
	private JLabel DirectionLabel;
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
