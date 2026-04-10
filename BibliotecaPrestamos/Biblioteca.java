

public class Biblioteca
{
    private Nodo cabeza;
    private Nodo espera;
    private Usuario usuario;
    
    public Biblioteca()
    {
       this.cabeza=null;
       this.espera= null;
       this.usuario= null;
    }

   
    public Nodo getCabeza()
    {
        return this.cabeza;
    }
    
    public void prestarLibro(Libro libroB){
        Nodo actual= cabeza;
        while(actual.getLibro()!= libroB){
            actual= actual.getNext();
        }
        
        if (actual.getLibro().getEstado()==true){
            
            if(usuario.getLibros().size()<3){
                usuario.agregarLibro(libroB);
                actual.getLibro().setEstado(false);
            }
            
            else{
                System.out.println("Ha alcanzado el maximo de libros que puede solicitar");
            }
        }
        
        else{
            
             System.out.println("Libro ocupado, será agregado a la lista de espera");
             agregarLibroLE(libroB);
             //llamado interno, llama a metodo dentro de su propia clase
        }
        
    }
    
    public void devolverLibro(Libro libroD){
        Nodo actual= cabeza;
        while(actual.getLibro()!= libroD){
            actual= actual.getNext();
        }
        
        actual.getLibro().setEstado(true);
        //ver lista de espera y asignar
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
        while(actual.getNext()!=null){
            actual.getLibro().imprimirDetalles();
            actual= actual.getNext();
            
        }
        
    }
    }
