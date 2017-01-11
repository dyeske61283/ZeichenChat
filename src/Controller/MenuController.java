/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.ChatModel;
import View.ChatView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kevin
 */
public class MenuController implements ActionListener
{
  private ChatView view;
  private ChatModel model;
  private CommandInvoker invoker;
  
  public MenuController(ChatView view, ChatModel model)
  {
      this.view = view;
      this.model = model;
      this.invoker = new CommandInvoker();
  }
  
  public void registerEvents()
  {
      view.getMiPrint().addActionListener(this);
      view.getMiLoad().addActionListener(this);
      view.getMiSave().addActionListener(this);
      view.getMiClose().addActionListener(this);
      view.getMiConnect().addActionListener(this);
      view.getMiDisconnect().addActionListener(this);
  }
  
  public void registerCommands()
  {
    this.invoker.addCommand(view.getMiLoad(), new CommandLoad(model, view));
    this.invoker.addCommand(view.getMiPrint(), new CommandPrint(model, view));
    this.invoker.addCommand(view.getMiSave(), new CommandSave(model, view));
    this.invoker.addCommand(view.getMiClose(), new CommandClose(view, model));
    this.invoker.addCommand(view.getMiConnect(), new CommandConnect(view, model));
    this.invoker.addCommand(view.getMiDisconnect(), new CommandDisconnect(view,model));
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    Component key = (Component)e.getSource();
    this.invoker.executeCommand(key);
  }
}
