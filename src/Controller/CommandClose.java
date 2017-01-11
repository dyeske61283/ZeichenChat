/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.ChatModel;
import View.ChatView;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class CommandClose implements  CommandInterface
{
  private ChatView view;
  private ChatModel model;
  
  public CommandClose(ChatView view, ChatModel model)
  {
    this.model = model;
    this.view = view;
  }

  @Override
  public void execute()
  {
    lg.getLogger().info("performing closing command");
    int wahl = JOptionPane.showConfirmDialog(this.view, "Do you really want to close this app?", "Close", JOptionPane.OK_CANCEL_OPTION);
      if(wahl == JOptionPane.OK_OPTION)
      {
        System.exit(0);
      }
  }
}
