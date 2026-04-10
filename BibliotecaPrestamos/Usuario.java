
import java.util.ArrayList;
public class Usuario
{   
    private String nombre;
    private ArrayList<Libro> libros;
    public Usuario(String elNombre)
    {
      this.nombre= elNombre;
      this.libros= null;
      
    }

    public String getNombre(){
        return this.nombre;
    }
    
    public ArrayList getLibros()
    {
        return this.libros;
    }
    
    public void agregarLibro(Libro libroB){
        
        libros.add(libroB);
    }
}