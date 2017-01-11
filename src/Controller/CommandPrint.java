/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.ChatModel;
import View.ChatView;
import View.DrawingView;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class CommandPrint implements CommandInterface
{
  private ChatModel model;
  private ChatView view;
  
  public CommandPrint(ChatModel model, ChatView view)
  {
    this.view = view;
    this.model = model;
  }

  @Override
  public void execute()
  {
    lg.getLogger().info("performing printing command");
    HashPrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
    aset.add(DialogTypeSelection.NATIVE);
      PrinterJob pj = PrinterJob.getPrinterJob();
      pj.setPrintable((DrawingView)this.view.getContentPane().getComponent(0));
      try
      {
        if(pj.printDialog(aset))
        {
          pj.print(aset);
        }
      }
      catch(PrinterException pe)
      {
        JOptionPane.showMessageDialog(this.view,pe);
      }
  }

}
