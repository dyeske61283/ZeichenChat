/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Logger.OhmLogger;
import Model.ChatModel;
import View.DrawingView;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author kevin
 */
public class DrawingController implements MouseMotionListener, MouseListener 
                                         
{
  private DrawingView view;
  private ChatModel model;
  private OhmLogger lg;
  
  
  public DrawingController(DrawingView view, ChatModel model)
  {
    this.view = view;
    this.model = model;
    lg = OhmLogger.getInstance();    
    lg.getLogger().info("Begin of logging in controller");
  }
  
  public void registerEvents()
  {
    view.addMouseMotionListener(this);
    view.addMouseListener(this);
    lg.getLogger().info("Added Listeners to the view");
  }

  @Override
  public void mouseDragged(MouseEvent me)
  {
    if(model.getDrawing().getNeueFigur() == null)
    {
      model.getDrawing().addFigure();
    }
    Point p = me.getPoint();
    Point p2 = model.getDrawing().getNeueFigur().getNeuerPunkt();
    if(p2 != null)
    {
      view.drawPoint(p2,p);
    }
    model.getDrawing().addPoint(p);
    lg.getLogger().info("Mouse got dragged");
  }

  @Override
  public void mouseMoved(MouseEvent me)
  {
  }

  @Override
  public void mouseClicked(MouseEvent me)
  {
  }

  @Override
  public void mousePressed(MouseEvent me)
  {
  }

  @Override
  public void mouseReleased(MouseEvent me)
  {
    model.getDrawing().resetFigure();
  }

  @Override
  public void mouseEntered(MouseEvent me)
  {
  }

  @Override
  public void mouseExited(MouseEvent me)
  {
  }
}
