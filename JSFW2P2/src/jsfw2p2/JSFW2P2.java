/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfw2p2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jsf3
 */
public class JSFW2P2 {

    /**
     * @param args the command line arguments
     */
    private static void ReadExistingProps(File file){
        try {
            FileInputStream fi = new FileInputStream(file);
            Properties readProps = new Properties();
            readProps.load(fi);
            fi.close();
            
            System.out.println("---------");
            System.out.println("Existing file:");
            System.out.println(readProps.toString());
            System.out.println("---------");
            
        } catch (FileNotFoundException ex) {
            System.out.println("Geen file");
            //Logger.getLogger(JSFW2P2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("IO Error");
            //Logger.getLogger(JSFW2P2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("TestProps.properties");
        
        ReadExistingProps(file);
        
        Properties props = new Properties();
        String buffer = "";
        Boolean buffered = false;
        
        for(String s : args){
            if (buffered) {
                props.setProperty(buffer, s);
                buffered = false;
            }
            else{
                buffer = s;
                buffered = true;
            }
        }
        
        try {
            
            FileOutputStream fs = new FileOutputStream(file);
            props.store(fs, null);
            fs.close();
        } catch (FileNotFoundException ex) {
            System.out.println("no file");
            //Logger.getLogger(JSFW2P2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("IO error");
            //Logger.getLogger(JSFW2P2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (buffered) {
            System.out.println("No value for: " + buffer);
        }
        
        ReadExistingProps(file);
    }
    
}
