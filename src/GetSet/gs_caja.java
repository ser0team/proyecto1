/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetSet;

/**
 *
 * @author jraraujo
 */
public class gs_caja {
    
    int idcaja, idempleado, idempresa;

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }
    Double caja;
    String fecha;

    public int getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }

    public Double getCaja() {
        return caja;
    }

    public void setCaja(Double caja) {
        this.caja = caja;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
