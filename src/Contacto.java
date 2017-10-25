public class Contacto
{
    private String nombre;
    private String direccion;
    private long telefono;

    public Contacto(String nom, String dir, long tel)
    {
        if (nom.charAt(0) >= 'a' && nom.charAt(0) <= 'z'
                || nom.charAt(0) >= 'A' && nom.charAt(0) <= 'Z')
        {
            this.nombre = nom;
        }
        else
        {
            /*RuntimeException ex = new IllegalArgumentException();
            throw ex;*/ // tambien se puede hacer de esta manera

            throw new IllegalArgumentException("El nombre debe iniciar con una letra");
        }
        dir = dir.trim();// regresa una copia y quita los espacios del inicio y al final
        if(dir.isEmpty()){
            throw new IllegalArgumentException("La direccion no debe estar vacia");
        }
        else{
            this.direccion = dir;
        }
//        String cadTel = (String)tel; // esto no se puede hacer cast de primitivo a objeto
        String cadTel = Long.toString(tel);
        if(cadTel.length() == 10)
        {
            this.telefono = tel;
        }
        else
        {
            throw new IllegalArgumentException("El telefono debe de ser de 10 digitos");
        }


    }

    @Override
    public String toString() {

        return "Nombre: " + nombre + ", " + "Direccion: " + direccion + ", " + "Telefono: "+ telefono;
    }
}
