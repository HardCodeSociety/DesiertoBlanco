package aplicacion;

/*NO OLVIDEN ADICIONAR LA DOCUMENTACION*/
public class DesiertoExcepcion extends Exception{

    public static final String NO_CONSTRUIDO="Servicio no construido";
    public static final String ERROR="Error en la entrada o salida";
    public static final String NO_VALOR_PARAMETR="El parametro no tiene ningun tipo de error ";
    public static final String ERROR_IMPORTACION ="El archivo no pudo ser importado";
    public DesiertoExcepcion(String mensaje){
       super(mensaje);
    }
}
