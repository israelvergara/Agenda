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

        //Agenda agenda = new Agenda();
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
                System.out.println("Opciones agregar - imprimir - terminar");
                opcion = entrada.nextLine();
                switch (opcion) {
                    case "agregar":
                        agregar(entrada);
                        break;
                    case "imprimir":
                        agenda.imprimeTodo();
                        break;
                }
            }
            catch(IllegalArgumentException ex)
            {
                System.out.print(ex.getMessage());
                opcion = "";
            }
        } while (opcion != "terminar");
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
        aplicacion.entradaUsuario();

    }
}
