import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AplicacionTerminal
{
    private Agenda agenda;

    public AplicacionTerminal() {
        agenda = new Agenda();
    }

    public void demo()
    {
        Contacto c1 = new Contacto("Israel", "Mi casa", 1234578900 );
        Contacto c2 = new Contacto("Mario", "la casa de el", 1234578900L );
        Contacto c3 = new Contacto("alejadro", "mx", 1234578900L );


        this.agenda.agregaContacto(c1);
        this.agenda.agregaContacto(c2);
        this.agenda.agregaContacto(c3);
        this.agenda.imprimeTodo();
    }

    public void entradaUsuario() {
        Scanner entrada = new Scanner(System.in);
        String opcion = "";

        do {
            try {
                System.out.println("Opciones agregar - cargar - eliminar - guardar -imprimir - terminar - contar -");
                opcion = entrada.nextLine();
                switch (opcion) {
                    case "agregar":
                        agregar(entrada);
                        break;
                    case "cargar":
                        cargar(entrada);
                        break;
                    case "eliminar":
                        eliminar(entrada);
                        break;
                    case "guardar":
                        guardar(entrada);
                        break;
                    case "contar":
                        contar();
                        break;
                    case "imprimir":
                        agenda.imprimeTodo();
                        break;
                    case "terminar":
                        System.out.println("Nos vemos");
                        break;
                }
            }
            catch(IllegalArgumentException ex)
            {
                System.out.print(ex.getMessage());
                opcion = "";
            }
            catch(InputMismatchException ex)
            {
                System.out.println("El telefono debe tener digitos unicamente");
                opcion = "";
            }
            catch (FileNotFoundException e)
            {
                System.out.println("El archivo no existe");
                opcion = "";
            }
            catch(StringIndexOutOfBoundsException ex1) {
                System.out.println(ex1.getMessage());
                opcion = "";
            }
            catch (IOException e)
            {
                //e.printStackTrace();
                System.out.println("Nombre no Valido");
                opcion = "";
            }
            catch(NullContactException ex2)
            {
                ex2.getMessage();
            }
        } while (opcion != "terminar");
    }

    private void contar()
    {
        System.out.println("Tienes un total de: " + agenda.dimeContactos() + " Contactos");
    }

    private void eliminar(Scanner entrada)
    {
        System.out.println("Telefono del contacto a eliminar: ");
        long telEliminar = entrada.nextLong();
        agenda.elimina(telEliminar);
    }

    private void cargar(Scanner entrada) throws FileNotFoundException
    {
        System.out.print("Nombre del archivo: ");
        String nomArchivo = entrada.nextLine();
        agenda.cargar(nomArchivo);
    }

    private void guardar(Scanner entrada) throws IOException
    {
        System.out.print("Nombre del Archivo: ");
        String nomArchivo = entrada.nextLine();
        agenda.guardar(nomArchivo);
    }


    private void agregar(Scanner entrada) {
        System.out.println("Agregar un contacto nuevo");
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Direccion: ");
        String direccion = entrada.nextLine();
        System.out.print("Telefono: ");
        Long tel = entrada.nextLong();
        Contacto nuevo = new Contacto (nombre, direccion, tel);
        agenda.agregaContacto(nuevo);

    }

    public static void main(String[] args) {
        AplicacionTerminal aplicacion = new AplicacionTerminal();

        aplicacion.demo();
        aplicacion.entradaUsuario();

    }
}
