/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import Model.ChatModel;
import View.ChatView;
import View.DrawingView;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author kevin
 */
public class ReceiveAdapter implements Observer
{
  private ChatModel model;
  private ChatView view;
  private DrawingView dView;

  public ReceiveAdapter(ChatModel model, ChatView view)
  {
    this.view = view;
    this.model = model;
    dView = (DrawingView) view.getContentPane().getComponent(0);
  }

  public void registerObserver()
  {
    this.model.addObserver(this);
  }

  @Override
  public void update(Observable o, Object o1)
  {
    if(this.model.getChat().getConnected())
    {
      this.view.getRbConnected().setSelected(true);
      this.view.getRbConnected().setText("Connected");
      this.view.getMiConnect().setEnabled(false);
      this.view.getMiDisconnect().setEnabled(true);
    }
    else
    {
      this.view.getRbConnected().setSelected(false);
      this.view.getRbConnected().setText("Disconnected");
      this.view.getMiConnect().setEnabled(true);
      this.view.getMiDisconnect().setEnabled(false);
    }
    dView.repaint();
  }
}
