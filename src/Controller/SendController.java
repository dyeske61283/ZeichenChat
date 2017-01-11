/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ChatModel;
import View.ChatView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class SendController implements ActionListener
{
  private ChatModel model;
  private ChatView view;

  public SendController(ChatModel model, ChatView view)
  {
    this.view = view;
    this.model = model;
  }

  public void registerEvents()
  {
    this.view.getBtnSend().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    
    if (this.model.getChat().getConnected())
    {
      try
      {
        this.model.getChat().send(this.model.getDrawing().getNeueFigur());
      }
      catch (IOException ex)
      {
        Logger.getLogger(SendController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
