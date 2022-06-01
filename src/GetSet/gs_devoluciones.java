/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetSet;

import java.util.Date;

/**
 *
 * @author jraraujo
 */
public class gs_devoluciones {
    
    int idventa, idproducto, iddevolucion, idalmacen, idpasillo, idanaquel, idbin, 
            idempleado, idempresa;

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    public int getIdpasillo() {
        return idpasillo;
    }

    public void setIdpasillo(int idpasillo) {
        this.idpasillo = idpasillo;
    }

    public int getIdanaquel() {
        return idanaquel;
    }

    public void setIdanaquel(int idanaquel) {
        this.idanaquel = idanaquel;
    }

    public int getIdbin() {
        return idbin;
    }

    public void setIdbin(int idbin) {
        this.idbin = idbin;
    }

    public int getIddevolucion() {
        return iddevolucion;
    }

    public void setIddevolucion(int iddevolucion) {
        this.iddevolucion = iddevolucion;
    }
    String razon;
    Date fecha;

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
