/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.ChatModel;
import View.ChatView;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author kevin
 */
public class CommandSave implements CommandInterface
{
  private ChatModel model;
  private ChatView view;
  
  public CommandSave(ChatModel model, ChatView view)
  {
    this.view = view;
    this.model = model;
  }

  @Override
  public void execute()
  {
    lg.getLogger().info("performing saving command");
    JFileChooser fcSave = new JFileChooser(this.model.getDrawing().getFilePath());
    fcSave.setDialogTitle("Specify a file to save");
    if(fcSave.showSaveDialog(this.view) == JFileChooser.APPROVE_OPTION)
    {
      File fileToSave = fcSave.getSelectedFile();
      if(fileToSave.exists())
      {
        
      }
      else
      {
        try
        {
          fileToSave.createNewFile();
        }
        catch (IOException ex)
        {
          Logger.getLogger(CommandSave.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      try
      {
        this.model.getDrawing().saveData(fileToSave);
      }
      catch (IOException ex)
      {
        Logger.getLogger(CommandSave.class.getName()).log(Level.SEVERE, null, ex);
      }
      this.model.getDrawing().setFilePath(fileToSave.getAbsolutePath());
    }
  }
  
  
}
