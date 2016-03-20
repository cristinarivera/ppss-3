package ppss.ejercicio1;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class TestableGestorLlamadas extends GestorLlamadas{
    private Calendario cal;
    @Override
    public Calendario getCalendario() {
        return cal;
    }
    public void setCalendario(Calendario c){
        this.cal = c;
    }
}
