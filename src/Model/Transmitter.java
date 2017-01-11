/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Logger.OhmLogger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class Transmitter extends Observable implements ServerClientInterface
{
  final Object[] options =
  {
    "Server", "Client"
  };
  private static OhmLogger lg;
  private Boolean ready;
  private Boolean server;
  private Boolean connected;
  private Figur rcvMsg;
  private Thread thd;
  private Socket s;
  private ObjectInputStream reader;
  private ObjectOutputStream writer;

  public Transmitter()
  {
    int wahl = JOptionPane.showOptionDialog(null, "Do you want to be Server, or Client?",
                                            "Connection", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                            null, options, options[0]);

    this.server = (wahl == JOptionPane.YES_OPTION);
    rcvMsg = null;
  }

  public void connecting()
  {
    connect();
    thd = new Thread(this);
    thd.start();
  }

  @Override
  public synchronized void connect()
  {
    if (server)
    {
      try
      {
        ServerSocket ss;
        ss = new ServerSocket(PORT);
        this.s = ss.accept();
      }
      catch (IOException ex)
      {
        Logger.getLogger(Transmitter.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    else
    {
      try
      {
        s = new Socket(IP, PORT);
      }
      catch (IOException ex)
      {
        Logger.getLogger(Transmitter.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    try
    {
      OutputStream os = s.getOutputStream();
      this.writer = new ObjectOutputStream(os);
      InputStream is = s.getInputStream();
      BufferedInputStream bis = new BufferedInputStream(is);
      this.reader = new ObjectInputStream(bis);
      connected = true;
      notifyAll();
      this.setChanged();
      this.notifyObservers();
    }
    catch (Exception ex)
    {
      System.err.println(ex.toString());
    }
  }

  @Override
  public void disconnect()
  {
    try
    {
      s.close();
      writer.close();
      reader.close();
      connected = false;
      setChanged();
      notifyObservers();
    }
    catch (IOException ex)
    {
      Logger.getLogger(Transmitter.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  @Override
  public void send(Figur message) throws IOException
  {
    lg.getLogger().info("sending message..");
      this.writer.writeObject(message);
      this.writer.flush();
  }

  @Override
  public Figur receive()
  {
    Figur msg = null;
    try
    {
      msg = (Figur) this.reader.readObject();
    }
    catch (IOException ex)
    {
      lg.getLogger().log(Level.SEVERE, null, ex);
    }
    catch (ClassNotFoundException ex)
    {
      lg.getLogger().log(Level.SEVERE, null, ex);
    }
    return msg;
  }

  @Override
  public Boolean getConnected()
  {
    return connected;
  }

  @Override
  public void run()
  {
    while (connected)
    {
      this.rcvMsg = this.receive();
      if (rcvMsg != null)
      {
        this.setChanged();
        this.notifyObservers();
      }
    }

  }

  public Boolean getServer()
  {
    return server;
  }

  public synchronized void setServer(Boolean server)
  {
    this.server = server;
    this.ready = true;
    notifyAll();
  }

  public Figur getRcvMsg()
  {
    return rcvMsg;
  }

  public Boolean getReady()
  {
    return ready;
  }

  public void setReady(Boolean ready)
  {
    this.ready = ready;
  }

}
