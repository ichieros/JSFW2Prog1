/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfw2p1javashell;

/**
 *
 * @author jsf3
 */
public class JSFW2P1JavaShell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Test");
        String testEnv = System.getenv("TestEnviron");
        System.out.print(testEnv);
    }
    
}
