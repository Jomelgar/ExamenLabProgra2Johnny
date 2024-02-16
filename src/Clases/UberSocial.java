
package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jomel
 */
public class UberSocial {
    public ArrayList<SocialClass> sociales;

    public UberSocial() {
        sociales = new ArrayList();
    }
    
    public SocialClass buscar(String Username){
        return buscar(Username, 0);
    }
    
    private SocialClass buscar(String Username, int posicion){
        if(posicion < sociales.size()){
            if(sociales.get(posicion).getUsername().equals(Username)){
                return sociales.get(posicion);
            }
            return buscar(Username, posicion +1);
        }
        return null;
    }
    
    public void agregarCuenta(String username, String tipo){
        if(buscar(username) ==  null){
            if(tipo.equalsIgnoreCase("FACEBOOK")){
                sociales.add(new Facebook(username));
                JOptionPane.showMessageDialog(new java.awt.Frame(), "Cuenta " + username + " agregada en Facebook.");
            }else{
                sociales.add(new Twitter(username));
                JOptionPane.showMessageDialog(new java.awt.Frame(), "Cuenta " + username + " agregada en Twitter.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Cuenta ya existe en una de las aplicaciones.");
        }
    }
    
    public void agregarPost(String user, String Post){
        SocialClass social = buscar(user);
        if(social != null){
            social.addPost(Post);
            JOptionPane.showMessageDialog(null, "Post agregado.");
        }else{
            JOptionPane.showMessageDialog(null, "No existe ese usuario.");
        }
    }
    
    public void agregarAmigo(String user1, String user2){
        SocialClass social1 = buscar(user1);
        SocialClass social2 = buscar(user2);
        
        if(!user1.equals(user2)){
            if(social1 != null && social2 != null){
            if(social1 instanceof Facebook && social2 instanceof Facebook){
                sociales.get(sociales.indexOf(social1)).addFriend(user2);
                sociales.get(sociales.indexOf(social2)).addFriend(user1);
                JOptionPane.showMessageDialog(null, user1 + " y " + user2 + " ahora son amigos.");
            }else if(social1 instanceof Twitter && social2 instanceof Twitter){
                sociales.get(sociales.indexOf(social1)).addFriend(user2);
                JOptionPane.showMessageDialog(null, user1 + " sigue a " + user2 + ".");
            }else{
                JOptionPane.showMessageDialog(null, "Estos usuarios no son compatibles.");
            }
            }else{
                JOptionPane.showMessageDialog(null, "Uno de estos usuarios no existen.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "ERROR: Es el mismo usuario al que quiere agregar.");
        }
    }
    
    public void agregarComment(String user, int postId, String autor, String comment){
        SocialClass social = buscar(user);
        
        if(social != null){
            if(social instanceof Facebook){
                if(((Facebook)social).addComment(new Comment(postId,autor, comment))){
                    JOptionPane.showMessageDialog(null, "Comentario subido.");
                }else{
                     JOptionPane.showMessageDialog(null, "No existe ese espacio para subir el comentario.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se puede agregar comentarios a este post.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No existe ese usuario.");
        }
    }
    
    public String profileFrom(String user){
        return buscar(user).myProfile();
    }
}