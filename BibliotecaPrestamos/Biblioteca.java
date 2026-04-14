import java.util.ArrayList;
public class Biblioteca
{
    private Nodo cabeza;
    private Nodo espera;
    private ArrayList<Usuario> usuarios;
    
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

        if (actual == null){
            System.out.println("No existe el libro solicitado.");
            return;
        }

        if (uActual == null){
            System.out.println("Usuario no encontrado.");
            return;
        }

        if (estaBloqueado(uActual)){
            System.out.println("Usuario " + nombreU + " está [BLOQUEADO]. Devuelva al menos un libro antes de realizar nuevas solicitudes.");
            return;
        }

        actual.getLibro().incrementarSolicitudes();
        
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
             agregarLibroLE(actual.getLibro(), nombreU);
             if (uActual.getLibros().size() >= 3 && contarSolicitudesEspera(nombreU) >= 2){
                 System.out.println("Usuario " + nombreU + " está [BLOQUEADO] por tener 2 o más libros en lista de espera.");
             }
        }
        
    }
    
    public void devolverLibro(String nombre, String nombreU){
        Nodo actual= cabeza;
        Usuario uActual = this.buscarUsuario(nombreU);
        while(actual!=null && ! actual.getLibro().getTitulo().equalsIgnoreCase(nombre)){
            actual= actual.getNext();
        }

        if (actual == null){
            System.out.println("No existe el libro a devolver.");
            return;
        }

        if (uActual == null){
            System.out.println("Usuario no encontrado.");
            return;
        }

        actual.getLibro().setEstado(true);
        uActual.getLibros().remove(actual.getLibro());
        
        if(this.enListaE(nombre) != null){
           
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
    
    public void agregarLibroLE(Libro libro, String nombreU){
     Nodo nuevo= new Nodo(libro, nombreU);
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
            System.out.println("Usuario en espera: " + actual.getUsuario());
            actual.getLibro().imprimirDetalles();
            actual= actual.getNext();
            
        }
    }

    public void listarRankingLibros(){
        ArrayList<Libro> lista = new ArrayList<>();
        Nodo actual = cabeza;
        while(actual != null){
            lista.add(actual.getLibro());
            actual = actual.getNext();
        }

        for (int i = 0; i < lista.size() - 1; i++){
            int maxIndex = i;
            for (int j = i + 1; j < lista.size(); j++){
                Libro libroJ = lista.get(j);
                Libro libroMax = lista.get(maxIndex);
                if (libroJ.getSolicitudes() > libroMax.getSolicitudes()){
                    maxIndex = j;
                } else if (libroJ.getSolicitudes() == libroMax.getSolicitudes()){
                    if (libroJ.getTitulo().compareToIgnoreCase(libroMax.getTitulo()) < 0){
                        maxIndex = j;
                    }
                }
            }
            if (maxIndex != i){
                Libro temp = lista.get(i);
                lista.set(i, lista.get(maxIndex));
                lista.set(maxIndex, temp);
            }
        }

        System.out.println("Ranking de libros por demanda:");
        for (int i = 0; i < lista.size(); i++){
            System.out.println("#" + (i + 1));
            lista.get(i).imprimirDetalles();
            System.out.println();
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
    
    private int contarSolicitudesEspera(String nombreU){
        int contador = 0;
        Nodo actual = espera;
        while(actual != null){
            if (actual.getUsuario() != null && actual.getUsuario().equalsIgnoreCase(nombreU)){
                contador++;
            }
            actual = actual.getNext();
        }
        return contador;
    }
    
    private boolean estaBloqueado(Usuario usuario){
        return usuario.getLibros().size() >= 3 && contarSolicitudesEspera(usuario.getNombre()) >= 2;
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
    
    public void eliminarLE(String nombre){
        if (espera == null){
            return;
        }

        if (espera.getLibro().getTitulo().equalsIgnoreCase(nombre)){
            espera = espera.getNext();
            return;
        }

        Nodo actual = espera;
        while(actual.getNext() != null && ! actual.getNext().getLibro().getTitulo().equalsIgnoreCase(nombre)){
            actual = actual.getNext();
        }

        if (actual.getNext() != null){
            actual.setNext(actual.getNext().getNext());
        }
    }
    
    public void listarLibrosU(String nombre){
        
        Usuario u = this.buscarUsuario(nombre);
        u.imprimirLibros();
    }
}