package aplicacion;

/*NO OLVIDEN ADICIONAR LA DOCUMENTACION*/
public class DesiertoExcepcion extends Exception{
  
    public static final String NO_CONSTRUIDO="Servicio no construido";
    public static final String ERROR_IO="Error en la entrada o salida";
    public static final String ERROR_CLASE="Clase no encontrada";
    public DesiertoExcepcion(String mensaje){
       super(mensaje);
    }
}
