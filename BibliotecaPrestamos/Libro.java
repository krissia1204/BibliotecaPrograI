public class Libro
{
    
    private String titulo;
    private String autor;
    private boolean estado;
    private int solicitudes;

    
    public Libro(String elTitulo, String elAutor)
    {
        this.titulo= elTitulo;
        this.autor= elAutor;
        this.estado=true;
        this.solicitudes=0;
        //estado se inicializa en true, porque al agregar un nuevo libro a la
        //biblioteca, va a estar disponible al instante, se cambia a false cuando se presta.
    }
    
    public String getTitulo(){
        return this.titulo;
    }
  
    public boolean getEstado()
    {
       return this.estado;
    }
    
    public void setEstado(boolean nuevoE){
        this.estado= nuevoE;
    }

    public int getSolicitudes()
    {
        return this.solicitudes;
    }

    public void incrementarSolicitudes()
    {
        this.solicitudes++;
    }
    
    public void imprimirDetalles(){
        System.out.println("Autor: "+autor+"\n Titulo: "+titulo+"\n Solicitudes: "+solicitudes);
    }
    
    
}