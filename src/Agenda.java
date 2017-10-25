import java.util.LinkedList;

public class Agenda
{
    private LinkedList<Contacto> contactos;

    public Agenda()
    {
        contactos = new LinkedList<Contacto>();//notacion diamante <> es valido
    }

    public void agregaContacto(Contacto nuevo)
    {
        contactos.add(nuevo);
    }

    public void imprimeTodo()
    {
        //for traddicional
/*        for (int i=0; i < contactos.size(); i++)
        {
            System.out.println(contactos.get(i));
        }
*/
        //for-each
        //sintaxis:
        //for(Tipo var : coleccion
        //{
        //acciones con la variable var
        //}
        for(Contacto c : contactos)
        {
            System.out.println(c);
        }
    }
}
