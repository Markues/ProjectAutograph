/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autograph.ui;

import java.awt.event.MouseEvent;

import javax.swing.*;

public class AutoLabelDialog extends JDialog {

	/**
	 * Creates new form AutoLabelDialog
	 */
	public AutoLabelDialog(java.awt.Frame parent, boolean modal, boolean nodesOrEdges) {
		super(parent, modal);
		this.noe = nodesOrEdges;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		AutoLabelOptionsTitle = new JLabel();
		LabelTextLabel = new JLabel();
		LabelTextField = new JTextField();
		PrependRadioBtn = new JRadioButton();
		AppendRadioBtn = new JRadioButton();
		NoNumberRadioBtn = new JRadioButton();
		NumberingLabel = new JLabel();
		jScrollPane2 = new JScrollPane();
		AutoLabelTextPane = new JTextPane();
		StartingNumberLabel = new JLabel();
		AutoNumberSpinner = new JSpinner();
		CancelBtn = new JButton();
		OkBtn = new JButton();
		theLabel = "";

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		AutoLabelOptionsTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		AutoLabelOptionsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		AutoLabelOptionsTitle.setText("Auto-Label Options");

		LabelTextLabel.setText("Label Text");
		
		group = new ButtonGroup();
		selected = 0;
		
		PrependRadioBtn.setText("Prepend Node/Edge Number");
		group.add(PrependRadioBtn);
		AppendRadioBtn.setText("Append Node/Edge Number");
		group.add(AppendRadioBtn);
		NoNumberRadioBtn.setText("Do Not Include Node/Edge Number");
		group.add(NoNumberRadioBtn);
		
		PrependRadioBtn.setSelected(true);

		NumberingLabel.setText("Numbering");

		AutoLabelTextPane.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
		AutoLabelTextPane.setBorder(null);
		AutoLabelTextPane.setEditable(false);
		AutoLabelTextPane.setText("Auto-Labeling can be used to automatically label nodes or edges as they are added to your graph. The label will be the same for every node/edge but can include a number that will increment with each node/edge added.");
		AutoLabelTextPane.setAutoscrolls(false);
		AutoLabelTextPane.setOpaque(false);
		jScrollPane2.setViewportView(AutoLabelTextPane);

		StartingNumberLabel.setText("Starting Number");

		AutoNumberSpinner.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		
		CancelBtn.setText("Cancel");
		CancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				CancelBtnActionPerformed(evt);
			}
		});

		OkBtn.setText("Ok");
		OkBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				OkBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(NumberingLabel)
										.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(LabelTextLabel)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(LabelTextField))
																.addComponent(AutoLabelOptionsTitle, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																		.addComponent(StartingNumberLabel)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(AutoNumberSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(OkBtn, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(CancelBtn))
																		.addGroup(layout.createSequentialGroup()
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(AppendRadioBtn)
																						.addComponent(PrependRadioBtn)
																						.addComponent(NoNumberRadioBtn))
																						.addGap(0, 0, Short.MAX_VALUE))
																						.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
																						.addContainerGap())))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(AutoLabelOptionsTitle)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(LabelTextLabel)
								.addComponent(LabelTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(NumberingLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(PrependRadioBtn)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(AppendRadioBtn)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(NoNumberRadioBtn)
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGap(0, 50, Short.MAX_VALUE)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(CancelBtn)
														.addComponent(OkBtn)))
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(StartingNumberLabel)
																		.addComponent(AutoNumberSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																		.addGap(0, 0, Short.MAX_VALUE)))
																		.addContainerGap())
				);

		pack();
		setVisible(true);
	}// </editor-fold>//GEN-END:initComponents

	protected void OkBtnActionPerformed(MouseEvent evt) {
		if(PrependRadioBtn.isSelected()) {
			selected = 1;
		}
		else if(AppendRadioBtn.isSelected()) {
			selected = 2;
		}
		else if(NoNumberRadioBtn.isSelected()) {
			selected = 3;
		}
		if(noe) {
			if(LabelTextField.getText().isEmpty()) {
				theLabel = "";
			}
			else {
				theLabel = LabelTextField.getText();
			}
			mainWindow.setAutoNode(theLabel, Integer.parseInt(AutoNumberSpinner.getValue().toString()), selected);
		}
		else {
			if(LabelTextField.getText().isEmpty()) {
				theLabel = "";
			}
			else {
				theLabel = LabelTextField.getText();
			}
			mainWindow.setAutoEdge(theLabel, Integer.parseInt(AutoNumberSpinner.getValue().toString()), selected);
		}
		this.dispose();
	}

	protected void CancelBtnActionPerformed(MouseEvent evt) {
		if(noe == true) {
			mainWindow.setAutoLabelNodes(false);
		}
		else {
			mainWindow.setAutoLabelEdges(false);
		}
		this.dispose();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JRadioButton AppendRadioBtn;
	private JLabel AutoLabelOptionsTitle;
	private JTextPane AutoLabelTextPane;
	private JSpinner AutoNumberSpinner;
	private JButton CancelBtn;
	private JTextField LabelTextField;
	private JLabel LabelTextLabel;
	private JRadioButton NoNumberRadioBtn;
	private JLabel NumberingLabel;
	private JButton OkBtn;
	private JRadioButton PrependRadioBtn;
	private JLabel StartingNumberLabel;
	private JScrollPane jScrollPane2;
	private boolean noe;
	private ButtonGroup group;
	private int selected;
	
	private String theLabel;
	// End of variables declaration//GEN-END:variables
}
