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
public class gs_compras {
    int idcompra, idproveedor, idusuario, idempresa, idempleado, idalmacen, idpasillo, idanaquel,
            idbin, cantidad, idproducto;

  public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }
    public int getIdempresa() {
        return idempresa;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
        public int getIdusuario() {
        return idusuario;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
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

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    Double precio, total, cantidad_ajuste;

    public Double getCantidad_ajuste() {
        return cantidad_ajuste;
    }

    public void setCantidad_ajuste(Double cantidad_ajuste) {
        this.cantidad_ajuste = cantidad_ajuste;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    String proveedor, ticket, producto, observaciones, unidad, razon_ajuste, tipo_ajuste;

    public String getTipo_ajuste() {
        return tipo_ajuste;
    }

    public void setTipo_ajuste(String tipo_ajuste) {
        this.tipo_ajuste = tipo_ajuste;
    }

    public Date getFecha_ajuste() {
        return fecha_ajuste;
    }

    public void setFecha_ajuste(Date fecha_ajuste) {
        this.fecha_ajuste = fecha_ajuste;
    }

    public String getRazon_ajuste() {
        return razon_ajuste;
    }

    public void setRazon_ajuste(String razon_ajuste) {
        this.razon_ajuste = razon_ajuste;
    }
    Date fechacom, fecha_ajuste;
    
    public Date getFechacom() {
        return fechacom;
    }

    public void setFechacom(Date fechacom) {
        this.fechacom = fechacom;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
}
