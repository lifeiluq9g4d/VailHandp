/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;
import Controller.Controller;
import Model.Aplikasi;
import ViewConsole.Console;

/**
 *
 * Nama : Kukuh Rahingga Permadi
 * NIM  : 1301150035
 */
public class Driver {

    /**
     * 
     * 
     * @param args the command line arguments0
     * 
     */
    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
        
        new Controller();
        
        Console view = new Console(app);
        view.mainMenu();
    }
}