
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
       
        //int opcion= sc.nextInt();
        
       // if (opcion==1){
            //System.out.println("Digite su nombre para crear su usuario");
            //String nombre= sc.next();
           // Usuario nuevo= new Usuario(nombre);
        // era para agregar otro usuario, pero x
        
        do{

        System.out.println("¿Qué acción desea realizar \n 1.Prestar un libro. \n 2.Devolver un libro \n 3.Consultar lista de espera");
        opcionB = sc.nextInt();
        switch(opcionB){
            case 1:
                System.out.println("Se mostrará la lista de libros disponibles en la biblioteca");
                biblioteca.listarLibrosD();
                System.out.println("Por favor digite el nombre del libro que desea llevar");
                String nombreL= sc.next();
                System.out.println("Por favor digite su nombre");
                String nombreU= sc.next();
                biblioteca.prestarLibro(nombreL, nombreU);
                break;
            case 2:
                System.out.println("Por favor digite el nombre del libro que desea devolver");
                String nombreD= sc.next();
                System.out.println("Por favor digite su nombre");
                String nombreUD= sc.next();
                biblioteca.devolverLibro(nombreD, nombreUD);
                break;
            case 3:
                biblioteca.listarLibrosE();
                break;
            case 4:
                System.out.println("Gracias por su visita");
            default:
                System.out.println("Opcion incorrecta, intente de nuevo");
            
        }
       
   } while (opcionB!=4);
}
}
