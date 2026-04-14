public class Nodo
{
    private Libro libro;
    private String usuario;
    private Nodo next;
    
    public Nodo(Libro elLibro)
    {
        this(elLibro, null);
    }

    public Nodo(Libro elLibro, String usuario)
    {
        this.libro = elLibro;
        this.usuario = usuario;
        this.next = null;
    }

    public Libro getLibro()
    {
       return this.libro;
    }

    public String getUsuario()
    {
       return this.usuario;
    }
    
    public Nodo getNext()
    {
       return this.next;
    }
    
    public void setNext(Nodo siguiente)
    {
      this.next= siguiente;
    }
}