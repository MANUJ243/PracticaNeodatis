package modelo;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.util.Date;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 * @author MANUEL MORENO DELGADO 2ºDAM
 */
public class Negocio {

    static Objects<Usuarios> usuarios;
    static Objects<Numeros> numeros;
    public static ODB odb = null;

    public static DefaultListModel getTelefonosModel() {
        DefaultListModel model = new DefaultListModel();
        numeros = odb.getObjects(Numeros.class);

        while (numeros.hasNext()) {
            Numeros numero = (Numeros) numeros.next();
            model.addElement(numero.getNUMERO());
        }

        return model;
    }

    public static void initNeodatis() {
        Usuarios usuario1 = new Usuarios("21145194Y", "MANUEL", "MORENO", "MADRID", "ESPANA", new Date(), 6);
        Usuarios usuario2 = new Usuarios("58630875B", "JORGE", "DIAZ", "SEVILLA", "ESPANA", new Date(), 3);
        Usuarios usuario3 = new Usuarios("21145194Y", "LUCAS", "SANZ", "GALICIA", "ESPANA", new Date(), 6);

        Numeros numero1 = new Numeros("626444155", new Date(), usuario1);
        Numeros numero2 = new Numeros("604038927", new Date(), usuario1);
        Numeros numero3 = new Numeros("601194650", new Date(), usuario1);
        Numeros numero4 = new Numeros("670095742", new Date(), usuario1);
        Numeros numero5 = new Numeros("655910350", new Date(), usuario1);
        Numeros numero6 = new Numeros("600016618", new Date(), usuario1);
        Numeros numero7 = new Numeros("677024139", new Date(), usuario2);
        Numeros numero8 = new Numeros("678014871", new Date(), usuario2);
        Numeros numero9 = new Numeros("627662223", new Date(), usuario2);
        Numeros numero10 = new Numeros("613469521", new Date(), usuario3);
        Numeros numero11 = new Numeros("616434875", new Date(), usuario3);
        Numeros numero12 = new Numeros("638299588", new Date(), usuario3);
        Numeros numero13 = new Numeros("637182706", new Date(), usuario3);
        Numeros numero14 = new Numeros("652508932", new Date(), usuario3);
        Numeros numero15 = new Numeros("603593899", new Date(), usuario3);

        odb.store(numero1);
        odb.store(numero2);
        odb.store(numero3);
        odb.store(numero4);
        odb.store(numero5);
        odb.store(numero6);
        odb.store(numero7);
        odb.store(numero8);
        odb.store(numero9);
        odb.store(numero10);
        odb.store(numero11);
        odb.store(numero12);
        odb.store(numero13);
        odb.store(numero14);
        odb.store(numero15);
        odb.close();
    }

    public static void rellenarCampos(String valor, JLabel nombre, JLabel apellido,
            JLabel dni, JLabel numero, JLabel cant, JLabel fecha) {

        IQuery query = new CriteriaQuery(Numeros.class, Where.equal("NUMERO", valor));
        Objects<Numeros> num = odb.getObjects(query);
        Numeros numM = num.getFirst();

        numero.setText(numM.getNUMERO());
        dni.setText(numM.getUser().getDNI());
        fecha.setText(numM.getFECHA_MOD().toString());

        nombre.setText(numM.getUser().getNOMBRE());
        apellido.setText(numM.getUser().getAPELLIDO());
        cant.setText(numM.getUser().getCANT_NUMEROS() + "");
    }
}
