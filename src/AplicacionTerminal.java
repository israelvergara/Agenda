public class AplicacionTerminal
{
    public static void main(String[] args) {
        Contacto c1 = new Contacto("Israel", "Mi casa", 1234578900 );
        Contacto c2 = new Contacto("Mario", "la casa de el", 1234578900L );
        Contacto c3 = new Contacto("alejadro", "mx", 1234578900L );

        Agenda agenda = new Agenda();
        agenda.agregaContacto(c1);
        agenda.agregaContacto(c2);
        agenda.agregaContacto(c3);
        agenda.imprimeTodo();

    }
}
