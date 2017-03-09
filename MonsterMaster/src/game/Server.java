/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Michael
 */
public class Server {
    private void startServer() {
        try {
            // create on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // create a new service named Game
            registry.rebind("Game", new ClientImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Server is up and ready");
    }
    
    public static void main(String[] args) {
        Server main = new Server();
        main.startServer();
    }
}
