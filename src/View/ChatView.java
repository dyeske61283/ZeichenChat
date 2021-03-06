/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;

/**
 *
 * @author kevin
 */
public class ChatView extends javax.swing.JFrame
{

  /**
   * Creates new form ChatView
   */
  public ChatView()
  {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    jPanel2 = new javax.swing.JPanel();
    rbConnected = new javax.swing.JRadioButton();
    btnSend = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    mnFile = new javax.swing.JMenu();
    miLoad = new javax.swing.JMenuItem();
    miSave = new javax.swing.JMenuItem();
    miPrint = new javax.swing.JMenuItem();
    miClose = new javax.swing.JMenuItem();
    mnConnect = new javax.swing.JMenu();
    miConnect = new javax.swing.JMenuItem();
    miDisconnect = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("MyChat");
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

    jPanel2.setMaximumSize(new java.awt.Dimension(320, 40));
    jPanel2.setMinimumSize(new java.awt.Dimension(320, 40));
    jPanel2.setPreferredSize(new java.awt.Dimension(320, 40));

    rbConnected.setText("Disconnected");
    rbConnected.setEnabled(false);
    rbConnected.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jPanel2.add(rbConnected);

    btnSend.setText("Send");
    btnSend.setToolTipText("send the message");
    btnSend.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    jPanel2.add(btnSend);

    getContentPane().add(jPanel2);

    mnFile.setText("File");

    miLoad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
    miLoad.setMnemonic('L');
    miLoad.setText("Load");
    mnFile.add(miLoad);

    miSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
    miSave.setMnemonic('S');
    miSave.setText("Save");
    mnFile.add(miSave);

    miPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
    miPrint.setMnemonic('P');
    miPrint.setText("Print");
    mnFile.add(miPrint);

    miClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.ALT_MASK));
    miClose.setMnemonic('C');
    miClose.setText("Close");
    mnFile.add(miClose);

    jMenuBar1.add(mnFile);

    mnConnect.setText("Connection");

    miConnect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
    miConnect.setMnemonic('C');
    miConnect.setText("Connect");
    mnConnect.add(miConnect);

    miDisconnect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
    miDisconnect.setMnemonic('D');
    miDisconnect.setText("Disconnect");
    miDisconnect.setEnabled(false);
    mnConnect.add(miDisconnect);

    jMenuBar1.add(mnConnect);

    setJMenuBar(jMenuBar1);

    setSize(new java.awt.Dimension(310, 530));
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new ChatView().setVisible(true);
      }
    });
  }


  public JMenuItem getMiLoad()
  {
    return miLoad;
  }

  public JMenuItem getMiPrint()
  {
    return miPrint;
  }

  public JMenuItem getMiSave()
  {
    return miSave;
  }

  public JButton getBtnSend()
  {
    return btnSend;
  }


  public JMenu getMnConnect()
  {
    return mnConnect;
  }

  public JMenu getMnFile()
  {
    return mnFile;
  }


  public JRadioButton getRbConnected()
  {
    return rbConnected;
  }

  public JMenuItem getMiConnect()
  {
    return miConnect;
  }

  public JMenuItem getMiClose()
  {
    return miClose;
  }

  public JMenuItem getMiDisconnect()
  {
    return miDisconnect;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnSend;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JMenuItem miClose;
  private javax.swing.JMenuItem miConnect;
  private javax.swing.JMenuItem miDisconnect;
  private javax.swing.JMenuItem miLoad;
  private javax.swing.JMenuItem miPrint;
  private javax.swing.JMenuItem miSave;
  private javax.swing.JMenu mnConnect;
  private javax.swing.JMenu mnFile;
  private javax.swing.JRadioButton rbConnected;
  // End of variables declaration//GEN-END:variables
}
