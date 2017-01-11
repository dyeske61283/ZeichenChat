/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Logger.OhmLogger;

/**
 *
 * @author kevin
 */
public interface CommandInterface
{
  public static OhmLogger lg = OhmLogger.getInstance();
  public void execute();
}
