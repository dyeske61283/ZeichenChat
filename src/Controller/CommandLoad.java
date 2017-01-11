/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.ChatModel;
import View.ChatView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author kevin
 */
public class CommandLoad implements CommandInterface
{
  private ChatModel model;
  private ChatView view;
  
  public CommandLoad(ChatModel model, ChatView view)
  {
    this.view = view;
    this.model = model;
  }

  @Override
  public void execute()
  {
    lg.getLogger().info("performing loading command");
    JFileChooser fcLoad = new JFileChooser(this.model.getDrawing().getFilePath());
    if(fcLoad.showOpenDialog(this.view)==JFileChooser.APPROVE_OPTION)
    {
      try
      {
        this.model.getDrawing().readData(fcLoad.getSelectedFile());
      }
      catch (IOException ex)
      {
        Logger.getLogger(CommandLoad.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (ClassNotFoundException ex)
      {
        Logger.getLogger(CommandLoad.class.getName()).log(Level.SEVERE, null, ex);
      }
      this.model.getDrawing().setFilePath(fcLoad.getSelectedFile().getAbsolutePath());
      this.view.getContentPane().getComponent(0).repaint();
    }
  }

}
