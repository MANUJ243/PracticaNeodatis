package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MANUEL MORENO DELGADO 2ºDAM
 */

public class Usuarios implements Serializable{
    private String DNI;
    private String NOMBRE;
    private String APELLIDO;
    private String CIUDAD;
    private String PAIS;
    private Date FECHA_NACIMIENTO;
    private Integer CANT_NUMEROS;
    
    public Usuarios(){}

    public Usuarios(String DNI, String NOMBRE, String APELLIDO, String CIUDAD, String PAIS, Date FECHA_NACIMIENTO, Integer CANT_NUMEROS) {
        this.DNI = DNI;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.CIUDAD = CIUDAD;
        this.PAIS = PAIS;
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
        this.CANT_NUMEROS = CANT_NUMEROS;
    }

    public String getDNI() {
        return DNI;
    }

    public String getCIUDAD() {
        return CIUDAD;
    }

    public void setCIUDAD(String CIUDAD) {
        this.CIUDAD = CIUDAD;
    }

    public String getPAIS() {
        return PAIS;
    }

    public void setPAIS(String PAIS) {
        this.PAIS = PAIS;
    }

    public Date getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    public void setFECHA_NACIMIENTO(Date FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public Integer getCANT_NUMEROS() {
        return CANT_NUMEROS;
    }

    public void setCANT_NUMEROS(Integer CANT_NUMEROS) {
        this.CANT_NUMEROS = CANT_NUMEROS;
    }
}
