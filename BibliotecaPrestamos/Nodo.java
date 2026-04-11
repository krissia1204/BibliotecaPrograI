public class Nodo
{
    private Libro libro;
    private Nodo next;
    
    public Nodo(Libro elLibro)
    {
        this.libro= elLibro;
        this.next= null;
    }

    
    public Libro getLibro()
    {
       return this.libro;
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