
import java.util.Scanner;
public class Main
{
   public static void main(String [] args){
       Biblioteca biblioteca = new Biblioteca();
       Usuario usuario1= new Usuario("Juan");
       Usuario usuario2= new Usuario("Ana");
       Usuario usuario3= new Usuario("Maria");
       Usuario usuario4= new Usuario("Fernando");
       Scanner sc = new Scanner(System.in);
       
       System.out.println("Bienvenido/a. \n Digite 1 si es un nuevo usuario");
       
        int opcion= sc.nextInt();
        
        if (opcion==1){
            System.out.println("Digite su nombre para crear su usuario");
            String nombre= sc.next();
            Usuario nuevo= new Usuario(nombre);
        }
        
        System.out.println("¿Qué acción desea realizar \n 1.Prestar un libro. \n 2.Devolver un libro");
        int opcionB = sc.nextInt();
        switch(opcionB){
            case 1:
                System.out.println("Se mostrará la lista de libros disponibles en la biblioteca");
                biblioteca.listarLibrosD();
                System.out.println("Por favor digite el nombre del libro que desea llevar");
                String nombreL= sc.next();
                biblioteca.prestarLibro(nombreL);   
            
        }
       
   }
}