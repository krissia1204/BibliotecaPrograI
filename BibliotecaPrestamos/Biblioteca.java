import java.util.ArrayList;
public class Biblioteca
{
    private Nodo cabeza;
    private Nodo espera;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Usuario> usuariosEspera;
    
    public Biblioteca()
    {
       this.cabeza=null;
       this.espera= null;
       this.usuarios= new ArrayList<>();
    }

   
    public Nodo getCabeza()
    {
        return this.cabeza;
    }
    
    public void prestarLibro(String nombre, String nombreU){
        Nodo actual= cabeza;
        Usuario uActual = this.buscarUsuario(nombreU);
        
        while(actual!=null && ! actual.getLibro().getTitulo().equalsIgnoreCase(nombre)){
            actual= actual.getNext();
        }
        
        if (actual.getLibro().getEstado()==true){
            
            if(uActual.getLibros().size()<3){
                uActual.agregarLibro(actual.getLibro());
                actual.getLibro().setEstado(false);
            }
            
            else{
                System.out.println("Ha alcanzado el maximo de libros que puede solicitar");
            }
        }
        
        else{
            
             System.out.println("Libro ocupado, será agregado a la lista de espera");
             agregarLibroLE(actual.getLibro());
             this.agregarUsuarioALE(nombreU);
             //llamado interno, llama a metodo dentro de su propia clase
        }
        
    }
    
    public void devolverLibro(String nombre, String nombreU){
        Nodo actual= cabeza;
        Usuario uActual = this.buscarUsuario(nombreU);
        while(actual!=null && ! actual.getLibro().getTitulo().equalsIgnoreCase(nombre)){
            actual= actual.getNext();
        }
        
        actual.getLibro().setEstado(true);
        uActual.getLibros().remove(actual);
        
        //boolean condi= false;
        
        if(actual==this.enListaE(nombre)){
           
            System.out.println("Asignando libro a usuario en lista de espera");
            this.eliminarLE(nombre);
        
            
            
        }
        
        
    }
    
    public void agregarLibro(Libro libro){
        
        Nodo nuevo= new Nodo(libro);
        Nodo actual = cabeza;
     if (cabeza==null){
         cabeza=nuevo;
     }
     else{
         while (actual.getNext()!=null){
             actual= actual.getNext();
         }
         actual.setNext(nuevo);
     }
    }
    
    public void agregarLibroLE(Libro libro){
     Nodo nuevo= new Nodo(libro);
        Nodo actual = espera;
     if (espera==null){
         espera=nuevo;
     }
     else{
         while (actual.getNext()!=null){
             actual= actual.getNext();
         }
         actual.setNext(nuevo);
     }
    }
    
    public void listarLibrosD(){
        Nodo actual= cabeza;
        while(actual!=null){
            actual.getLibro().imprimirDetalles();
            actual= actual.getNext();
            
        }
        
        
        
    }
    
    public void listarLibrosE(){
        Nodo actual= espera;
        while(actual!=null){
            actual.getLibro().imprimirDetalles();
            actual= actual.getNext();
            
        }
    }
    
    private Usuario buscarUsuario(String nombre){
        Usuario buscado= null;
        for (int i= 0; i<usuarios.size(); i++){
            Usuario actual= usuarios.get(i);
            
            if (actual.getNombre().equals(nombre)){
                buscado= actual;
            }
        }
        
        return buscado;
    }
    
    
    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    private Nodo enListaE(String nombreLibro){
        Nodo actual= espera;
      
        
        while(actual!=null && ! actual.getLibro().getTitulo().equalsIgnoreCase(nombreLibro)){
            actual= actual.getNext();
        }
        
        return actual;
    }
    
    public void agregarUsuarioALE(String nombreU){
        Usuario listaE= this.buscarUsuario(nombreU);
        usuariosEspera.add(listaE);
        
       
    }
    
    public void eliminarLE(String nombre){
        if (cabeza.getLibro().getTitulo().equals(nombre)){
            cabeza= cabeza.getNext();
            
        }
        
        else{
        Nodo actual= cabeza;
        while(actual!=null && ! actual.getLibro().getTitulo().equalsIgnoreCase(nombre)){
            actual=actual.getNext();
        }
        
        actual= actual.getNext();
    }
        
    }
    
    public void listarLibrosU(String nombre){
        
        Usuario u = this.buscarUsuario(nombre);
        u.imprimirLibros();
    }
}