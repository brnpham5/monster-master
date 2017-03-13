/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.io.*;
import java.util.*;

/**
 *
 * @author rajmahal
 */
public class Save {
    
    Save(){
        
    }
    
    public boolean savetofile(player human, player cpu, playerField humanfield, playerField cpufield, playerDeck humandeck, playerDeck cpudeck, playerGrave humangrave, playerGrave cpugrave){
           try{
        FileOutputStream files = new  FileOutputStream(new File("Save.txt"));
        ObjectOutputStream o = new ObjectOutputStream(files);
        o.writeObject(human);
        o.writeObject(cpu);
        o.writeObject(humanfield);
        o.writeObject(cpufield);
        o.writeObject(humandeck);
        o.writeObject(cpudeck);
        o.writeObject(humangrave);
        o.writeObject(cpugrave);
    	o.close();
	files.close();

    
    } catch (FileNotFoundException e) {
			System.out.println("File not found");
                        return false;
		} catch (IOException e) {
			System.out.println("Error initializing stream");
                        return false;
                }
           
      return true;
    }   
        
    
    
    public List<player> load(player human, player cpu, playerField humanfield, playerField cpufield, playerDeck humandeck, playerDeck cpudeck, playerGrave humanGrave, playerGrave cpuGrave){
    File f = new File("Save.txt");
    player hum;
    player comp;
    playerField humfield;
    playerField compfield;
    playerDeck humdeck;
    playerDeck compdeck;
    playerGrave humgrave;
    playerGrave compgrave;
    List<player> playerinfo = Arrays.asList(hum, comp, humfield, compfield, humdeck, compdeck, humgrave, compgrave);
    try {
        ObjectInputStream objinutstream = new ObjectInputStream(
                new FileInputStream(f));
        List<player> deserializedplayer = (List<playerinfo>) objinutstream.readObject();
        objinutstream.close();
    } catch (Exception e) {
        e.printStackTrace(); // handle this appropriately
    }      
        
        return playerinfo;
    } 
    
}
