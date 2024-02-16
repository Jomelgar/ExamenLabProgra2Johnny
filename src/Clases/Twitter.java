/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author jomel
 */
public class Twitter extends SocialClass{

    public Twitter(String Username) {
        super(Username);
    }
    
    
    @Override
    public String timeline() {
        String texto = "";
        for(String post: posts){
            texto += post + "\n";
        }
        return texto;
    }
    
}
