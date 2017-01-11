/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zeichenchat;

import Adapter.ReceiveAdapter;
import Controller.DrawingController;
import Controller.MenuController;
import Controller.SendController;
import Model.ChatModel;
import View.ChatView;
import View.DrawingView;
import java.awt.Container;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Builder Class
 * @author kevin
 */
public class Start
{
  public Start()
  {
    ChatModel model = new ChatModel();
    ChatView view = new ChatView();
    Container kiste = view.getContentPane();
    DrawingView dView = new DrawingView(model);
    kiste.add(dView,0);
    DrawingController cController = new DrawingController(dView, model);
    cController.registerEvents();
    MenuController mController = new MenuController(view, model);
    mController.registerEvents();
    mController.registerCommands();
    SendController sController = new SendController(model, view);
    sController.registerEvents();
    ReceiveAdapter rAdapter = new ReceiveAdapter(model, view);
    rAdapter.registerObserver();
    view.setVisible(true);
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) 
  {     try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
    new Start();
  }
}
