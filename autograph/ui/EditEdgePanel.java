/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autograph.ui;

public class EditEdgePanel extends javax.swing.JPanel {

    /**
     * Creates new form AddNodePanel
     */
    public EditEdgePanel() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        EdgeOptionsPanel = new javax.swing.JPanel();
        EdgeOptionsTitleLabel = new javax.swing.JLabel();
        LabelTextLabel = new javax.swing.JLabel();
        LabelTextField = new javax.swing.JTextField();
        TextColorLabel = new javax.swing.JLabel();
        EdgeDesignComboBox = new javax.swing.JComboBox();
        EndShapeLabel = new javax.swing.JLabel();
        EndShapeComboBox = new javax.swing.JComboBox();
        EdgeColorLabel = new javax.swing.JLabel();
        EdgeColorBtn = new javax.swing.JButton();
        EdgeDesignLabel = new javax.swing.JLabel();
        TextColorBtn = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 32767));

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(200, 300));
        setPreferredSize(new java.awt.Dimension(200, 459));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        EdgeOptionsPanel.setPreferredSize(new java.awt.Dimension(200, 457));

        EdgeOptionsTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EdgeOptionsTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EdgeOptionsTitleLabel.setText("Edge Options");
        EdgeOptionsTitleLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        EdgeOptionsTitleLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        LabelTextLabel.setText("Label Text");

        TextColorLabel.setText("Text Color");

        EdgeDesignComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "____", "_ _ _", "- - - -", "......", "===", " " }));

        EndShapeLabel.setText("End Shape");

        EndShapeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A-A", "A-B", "A-C", "B-B", "B-C", "C-C" }));

        EdgeColorLabel.setText("Edge Color");

        EdgeColorBtn.setText("[  ]");
        EdgeColorBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));

        EdgeDesignLabel.setText("Edge Design");

        TextColorBtn.setText("[  ]");
        TextColorBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));

        javax.swing.GroupLayout EdgeOptionsPanelLayout = new javax.swing.GroupLayout(EdgeOptionsPanel);
        EdgeOptionsPanel.setLayout(EdgeOptionsPanelLayout);
        EdgeOptionsPanelLayout.setHorizontalGroup(
            EdgeOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EdgeOptionsTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EdgeOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EdgeOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EdgeOptionsPanelLayout.createSequentialGroup()
                        .addGroup(EdgeOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextColorLabel)
                            .addComponent(EndShapeLabel)
                            .addComponent(EdgeColorLabel)
                            .addComponent(EdgeDesignLabel))
                        .addGap(18, 18, 18)
                        .addGroup(EdgeOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EndShapeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdgeColorBtn)
                            .addComponent(EdgeDesignComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextColorBtn))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(EdgeOptionsPanelLayout.createSequentialGroup()
                        .addGroup(EdgeOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelTextField)
                            .addGroup(EdgeOptionsPanelLayout.createSequentialGroup()
                                .addComponent(LabelTextLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        EdgeOptionsPanelLayout.setVerticalGroup(
            EdgeOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdgeOptionsPanelLayout.createSequentialGroup()
                .addComponent(EdgeOptionsTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelTextLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(EdgeOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EdgeOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextColorLabel)
                        .addComponent(TextColorBtn))
                    .addGroup(EdgeOptionsPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(EdgeOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EndShapeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EndShapeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(EdgeOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EdgeColorBtn)
                            .addComponent(EdgeColorLabel))
                        .addGap(18, 18, 18)
                        .addGroup(EdgeOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EdgeDesignComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdgeDesignLabel))))
                .addContainerGap(203, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(EdgeOptionsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(161, 161, 161)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(298, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EdgeColorBtn;
    private javax.swing.JLabel EdgeColorLabel;
    private javax.swing.JComboBox EdgeDesignComboBox;
    private javax.swing.JLabel EdgeDesignLabel;
    private javax.swing.JPanel EdgeOptionsPanel;
    private javax.swing.JLabel EdgeOptionsTitleLabel;
    private javax.swing.JComboBox EndShapeComboBox;
    private javax.swing.JLabel EndShapeLabel;
    private javax.swing.JTextField LabelTextField;
    private javax.swing.JLabel LabelTextLabel;
    private javax.swing.JButton TextColorBtn;
    private javax.swing.JLabel TextColorLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
