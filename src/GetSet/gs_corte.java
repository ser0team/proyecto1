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
public class gs_corte {
    
    int idcorte, idempleado, idempresa;

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }
    double corte;
    Date fechacorte, fechacompras;

    public Date getFechacompras() {
        return fechacompras;
    }

    public void setFechacompras(Date fechacompras) {
        this.fechacompras = fechacompras;
    }

    public int getIdcorte() {
        return idcorte;
    }

    public void setIdcorte(int idcorte) {
        this.idcorte = idcorte;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public double getCorte() {
        return corte;
    }

    public void setCorte(double corte) {
        this.corte = corte;
    }

    public Date getFechacorte() {
        return fechacorte;
    }

    public void setFechacorte(Date fechacorte) {
        this.fechacorte = fechacorte;
    }
    
}
