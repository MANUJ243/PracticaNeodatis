package Main;

import controlador.controladorVista;
import vista.Vista;

/**
 * @author MANUEL MORENO DELGADO 2ºDAM
 */
public class MainClass {

    public static void main(String[] args) {
        Vista vistaPrincipal = new Vista();
        controladorVista principalController = new controladorVista(vistaPrincipal);
        vistaPrincipal.setBounds(200, 50, 600, 371);
        vistaPrincipal.setVisible(true);
    }
}
