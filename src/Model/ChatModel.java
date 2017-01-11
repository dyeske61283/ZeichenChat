/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Logger.OhmLogger;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author kevin
 */
public class ChatModel extends Observable implements Observer
{
  private Transmitter chat;
  private DrawingModel drawing;
  private static OhmLogger lg;
  
  public ChatModel()
  {
    chat = new Transmitter();
    drawing = new DrawingModel();
    this.chat.addObserver(this);
    lg.getLogger().info("ChatModel is set up! Lets rock");
  }

  @Override
  public void update(Observable o, Object arg)
  {
    lg.getLogger().info("ChatModel got notified about changes by its components");
    this.drawing.getDaten().add(this.chat.getRcvMsg());
    setChanged();
    notifyObservers();
  }

  public Transmitter getChat()
  {
    return chat;
  }

  public DrawingModel getDrawing()
  {
    return drawing;
  }
  
  
}
