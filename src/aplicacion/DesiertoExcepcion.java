package aplicacion;

/*NO OLVIDEN ADICIONAR LA DOCUMENTACION*/
public class DesiertoExcepcion extends Exception{
  
    public static final String NO_CONSTRUIDO="Servicio no construido";
    
    public DesiertoExcepcion(String mensaje){
       super(mensaje);
    }
}
