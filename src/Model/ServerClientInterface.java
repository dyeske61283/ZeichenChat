/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;

/**
 *
 * @author kevin
 */
public interface ServerClientInterface extends Runnable
{
  final static int PORT = 8468;
  final static String IP = "127.0.0.1";
  public void connect();
  public void disconnect();
  public void send(Figur message) throws IOException;
  public Figur receive();
  public Boolean getConnected();
}
