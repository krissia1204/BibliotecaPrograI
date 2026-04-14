import java.util.Scanner;
public class Main
{
   public static void main(String [] args){
       int opcionB;
       Biblioteca biblioteca = new Biblioteca();
       Usuario u1= new Usuario("Juan");
       Usuario u2= new Usuario("Ana");  
       biblioteca.agregarUsuario(u1);
       biblioteca.agregarUsuario(u2);
       
       Libro libro1 = new Libro ("Demian", "Herman Hesse");
       biblioteca.agregarLibro(libro1);
       Libro libro2 = new Libro ("1984", "George Orwell");
       biblioteca.agregarLibro(libro2);
       Libro libro3 = new Libro ("Dune", "Frank Herbert");
       biblioteca.agregarLibro(libro3);
       Libro libro4 = new Libro ("Rayuela", "Julio Cortazar");
       biblioteca.agregarLibro(libro4);
       
       Scanner sc = new Scanner(System.in);
       
       System.out.println("Bienvenido/a.");
       
        
        do{

        System.out.println("¿Qué acción desea realizar \n 1. Crear Usuario \n 2. Prestar un libro. \n 3.Devolver un libro \n 4.Consultar lista de espera \n 5.Ver mi lista de libros prestados \n 6.Ver ranking de libros más solicitados \n 7. Cerrar \n");
        opcionB = sc.nextInt();
        switch(opcionB){
            case 1:
                System.out.println("Por favor digite su nombre");
                String nombreU= sc.next();
                Usuario nuevoUsuario= new Usuario(nombreU);
                biblioteca.agregarUsuario(nuevoUsuario);
                System.out.println("Usuario creado exitosamente");
                break;
            case 2:
                System.out.println("Se mostrará la lista de libros disponibles en la biblioteca");
                biblioteca.listarLibrosD();
                System.out.println("Por favor digite el nombre del libro que desea llevar");
                String nombreL= sc.next();
                System.out.println("Por favor digite su nombre");
                String nombreU1= sc.next();
                biblioteca.prestarLibro(nombreL, nombreU1);
                break;
            case 3:
                System.out.println("Por favor digite el nombre del libro que desea devolver");
                String nombreD= sc.next();
                System.out.println("Por favor digite su nombre");
                String nombreUD= sc.next();
                biblioteca.devolverLibro(nombreD, nombreUD);
                break;
            case 4:
                biblioteca.listarLibrosE();
                break;
            case 5:
                System.out.println("Por favor digite su nombre");
                String nombreULista= sc.next();
                biblioteca.listarLibrosU(nombreULista);     
                break;
            case 6:
                biblioteca.listarRankingLibros();
                break;
            case 7:
                System.out.println("Gracias por su visita");
            
            
        }
       
   } while (opcionB!=7);
   sc.close();
}
}