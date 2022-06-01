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
public class gs_entradasdevoluciones {
    
    int iddevolucion, idproducto, idalmacen, idpasillo, idanaquel, idbin, cant, 
            idcompra, idempleado, idempresa;

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

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getIddevolucion() {
        return iddevolucion;
    }

    public void setIddevolucion(int iddevolucion) {
        this.iddevolucion = iddevolucion;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
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

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public Date getFechadev() {
        return fechadev;
    }

    public void setFechadev(Date fechadev) {
        this.fechadev = fechadev;
    }

    public Date getFechaent() {
        return fechaent;
    }

    public void setFechaent(Date fechaent) {
        this.fechaent = fechaent;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    Date fechadev, fechaent;
    String  producto, comentarios;

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
}
