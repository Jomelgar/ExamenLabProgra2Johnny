
package Clases;

import java.util.ArrayList;

/**
 *
 * @author jomel
 */
public abstract class SocialClass {
    protected ArrayList<String> friends;
    protected ArrayList<String> posts;
    protected String Username;

    public SocialClass(String Username) {
        this.Username = Username;
        friends = new ArrayList();
        posts = new ArrayList();
    }
    
    public boolean addFriend(String user){
        if(friends != null && friends.contains(user)){
            return false;
        }
        friends.add(user);
        return true;
    }
    
    public void addPost(String msg){
        posts.add(msg);
    }
    
    public abstract String timeline();
    
    public String myProfile(){
        String texto = "   Perfil: " + Username + "\n   Posts: \n   ";
        texto += timeline() + "\n   Amigos:\n   ";
        for(String friend: friends){
            texto += (friend + " ");
            if(friends.indexOf(friend)%9 == 0)
                texto+="\n"; 
        }
        return texto;
    }

    public String getUsername() {
        return Username;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public ArrayList<String> getPosts() {
        return posts;
    }
    
}
