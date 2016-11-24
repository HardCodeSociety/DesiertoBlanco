package aplicacion;
import java.awt.Color;

public interface Elemento {
    int getPosX();
    int getPosY();
    boolean esHumano();
    Color getColor();
    String mensaje();
}
