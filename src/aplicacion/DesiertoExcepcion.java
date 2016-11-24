package aplicacion;

/*NO OLVIDEN ADICIONAR LA DOCUMENTACION*/
public class DesiertoExcepcion extends Exception{
  
    public static final String NO_CONSTRUIDO="Servicio no construido";
    public static final String ERROR="Error en la entrada o salida";
    
    public DesiertoExcepcion(String mensaje){
       super(mensaje);
    }
}
