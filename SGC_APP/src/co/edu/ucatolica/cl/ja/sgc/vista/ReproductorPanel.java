/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgc.vista;

/**
 *
 * @author sala1
 */
public class ReproductorPanel extends javax.swing.JPanel {
    private final PrincipalFrame principalFrame;

    /**
     * Creates new form PanelREPRODUCTOR
     * @param principalFrame
     */
    public ReproductorPanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonHome = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPaneListaDeReproduccion = new javax.swing.JScrollPane();
        jListListaDeReproduccion = new javax.swing.JList<>();
        jButtonRetroceder = new javax.swing.JButton();
        jButtonReproducir = new javax.swing.JButton();
        jButtonPausa = new javax.swing.JButton();
        jButtonAdelantar = new javax.swing.JButton();
        jProgressBarTiempo = new javax.swing.JProgressBar();

        jLabelTitulo.setFont(new java.awt.Font("Swis721 BlkEx BT", 0, 24)); // NOI18N
        jLabelTitulo.setText("REPRODUCTOR SGM");

        jButtonHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/iconos/home.png"))); // NOI18N
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });

        jScrollPaneListaDeReproduccion.setViewportView(jListListaDeReproduccion);

        jButtonRetroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/iconos/atrasar.jpg"))); // NOI18N
        jButtonRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetrocederActionPerformed(evt);
            }
        });

        jButtonReproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/iconos/play.png"))); // NOI18N
        jButtonReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReproducirActionPerformed(evt);
            }
        });

        jButtonPausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/iconos/pause.png"))); // NOI18N
        jButtonPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPausaActionPerformed(evt);
            }
        });

        jButtonAdelantar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/iconos/adelantar.jpg"))); // NOI18N
        jButtonAdelantar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdelantarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jProgressBarTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneListaDeReproduccion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonRetroceder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonReproducir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonPausa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAdelantar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonHome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addGap(20, 20, 20)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPaneListaDeReproduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonRetroceder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAdelantar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonReproducir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPausa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBarTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReproducirActionPerformed
        reproducirCancion();
    }//GEN-LAST:event_jButtonReproducirActionPerformed

    private void jButtonRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetrocederActionPerformed
        retrocederCancion();
    }//GEN-LAST:event_jButtonRetrocederActionPerformed

    private void jButtonPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPausaActionPerformed
        pausarCancion();
    }//GEN-LAST:event_jButtonPausaActionPerformed

    private void jButtonAdelantarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdelantarActionPerformed
        avanzarCancion();
    }//GEN-LAST:event_jButtonAdelantarActionPerformed

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        principalFrame.irAHome();
    }//GEN-LAST:event_jButtonHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdelantar;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonPausa;
    private javax.swing.JButton jButtonReproducir;
    private javax.swing.JButton jButtonRetroceder;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JList<String> jListListaDeReproduccion;
    private javax.swing.JProgressBar jProgressBarTiempo;
    private javax.swing.JScrollPane jScrollPaneListaDeReproduccion;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

    private void avanzarCancion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pausarCancion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void retrocederCancion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void reproducirCancion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected void cargarCanciones(int idLista){
        
    }
}
