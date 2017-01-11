/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.ChatModel;
import View.ChatView;

/**
 *
 * @author kevin
 */
public class CommandDisconnect implements CommandInterface
{
  private ChatView view;
  private ChatModel model;
  
  public CommandDisconnect(ChatView view, ChatModel model)
  {
    this.model = model;
    this.view = view;
  }

  @Override
  public void execute()
  {
    lg.getLogger().info("performing disconnecting command");
    this.model.getChat().disconnect(); 
  }
}
