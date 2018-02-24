package modelo;

import java.util.Date;

/**
 * @author MANUEL MORENO DELGADO 2ºDAM
 */


public class Numeros {
    private String NUMERO;
    private Date FECHA_MOD;
    private Usuarios user;
    
    public Numeros(){}

    public Numeros(String NUMERO,Date FECHA_MOD, Usuarios user) {
        this.NUMERO = NUMERO;
        this.FECHA_MOD = FECHA_MOD;
        this.user = user;
    }

    public Usuarios getUser() {
        return user;
    }
    
    public Date getFECHA_MOD() {
        return FECHA_MOD;
    }

    public void setFECHA_MOD(Date FECHA_MOD) {
        this.FECHA_MOD = FECHA_MOD;
    }

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }
}
