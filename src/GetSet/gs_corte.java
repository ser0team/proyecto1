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
    
    int idcorte, idusuario, idempresa;

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }
    double corte;
    Date fechacorte, fechacom;

    public Date getFechacom() {
        return fechacom;
    }

    public void setFechacom(Date fechacom) {
        this.fechacom = fechacom;
    }

    public int getIdcorte() {
        return idcorte;
    }

    public void setIdcorte(int idcorte) {
        this.idcorte = idcorte;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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
