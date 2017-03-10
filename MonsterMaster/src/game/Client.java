/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Michael
 */
public interface Client extends Remote{
    public String chooseGame(int choice) throws RemoteException;
    public int getState() throws RemoteException;
    public char getGame() throws RemoteException;
    public void endGame() throws RemoteException;
    public int gameMainMenu(int choice) throws RemoteException;
    
}
