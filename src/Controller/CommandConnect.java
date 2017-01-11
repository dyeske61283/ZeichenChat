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
public class CommandConnect implements CommandInterface
{
  private ChatView view;
  private ChatModel model;
  
  public CommandConnect(ChatView view, ChatModel model)
  {
    this.model = model;
    this.view = view;
  }

  @Override
  public void execute()
  {
    lg.getLogger().info("performing connecting command");
    this.view.getRbConnected().setText("Connecting..");
    this.model.getChat().connecting();
  }
}
