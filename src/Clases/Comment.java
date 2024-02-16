/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author jomel
 */

public final class Comment {
    int postId;
    String autor;
    String contenido;
    Calendar fecha;

    public Comment(int postId, String autor, String contenido) {
        this.postId = postId;
        this.autor = autor;
        this.contenido = contenido;
        fecha = Calendar.getInstance();
    }
    
    public String print(){
        return "   " + autor + "- " + new SimpleDateFormat("dd/MM/yy").format(fecha.getTime()) + "\n  " + contenido;
    }

    public int getPostId() {
        return postId;
    }

    public String getAutor() {
        return autor;
    }

    public String getContenido() {
        return contenido;
    }

    public Calendar getFecha() {
        return fecha;
    }
    
    
}