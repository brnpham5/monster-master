/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author rajmahal
 */
public class SaveLoadClass {
    private int winsave;
    int losesave;
    int drawsave;
    
    SaveLoadClass(player user){
        winsave =  user.getwin();
        drawsave = user.getdraw();
        losesave = user.getloss();
    }
    
    
   public void save(){
          try{
        FileOutputStream files = new  FileOutputStream(new File("playerstats.txt"));
        ObjectOutputStream o = new ObjectOutputStream(files);
        o.writeObject(winsave);
        o.writeObject(losesave);
        o.writeObject(drawsave);
    	o.close();
	files.close();

    
    } catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
    }
       
   }
    

