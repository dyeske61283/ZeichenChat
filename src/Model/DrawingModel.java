/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Logger.OhmLogger;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.prefs.Preferences;

/**
 *
 * @author kevin
 */
public class DrawingModel
{
  private ArrayList<Figur> daten;
  private Figur neueFigur;
  private static OhmLogger lg;
  private Preferences filePath;
  
  public DrawingModel()
  {
      daten = new ArrayList<>();
      filePath = Preferences.userNodeForPackage(this.getClass());
      lg = OhmLogger.getInstance();
      lg.getLogger().info("Begin of logging in model");
  }
  
  public void addPoint(Point p)
  {
    neueFigur.addPoint(p);
    lg.getLogger().info("Added new point to new figure in model");
  }
  
  public void addFigure()
  {
    neueFigur = new Figur();
    daten.add(neueFigur);
    lg.getLogger().info("Added new figure to model");
  }
  
  public ArrayList<Figur> getDaten()
  {
    return daten;
  }
  
  public Figur getNeueFigur()
  {
    return neueFigur;
  }
  
  public void resetFigure()
  {
    neueFigur = null;
    lg.getLogger().info("Resetted figure to null");
  }
  
  public void saveData(File f) throws FileNotFoundException, IOException
  {
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
    out.writeObject(daten);
    lg.getLogger().info("Saved all data to file");
    
    out.close();
  }
  
  public void readData(File f) throws FileNotFoundException, IOException, ClassNotFoundException
  {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
    daten = (ArrayList<Figur>) in.readObject();
    lg.getLogger().info("Read file into data");
    
    in.close();
  }

  public String getFilePath()
  {
    return this.filePath.get("LAST_OUTPUT_DIR", "~"+ File.pathSeparator);
  }

  public void setFilePath(String filePath)
  {
    this.filePath.put("LAST_OUTPUT_DIR", filePath);
  }
  
  
}
