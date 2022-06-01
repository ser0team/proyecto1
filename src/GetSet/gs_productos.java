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
public class gs_productos {
    
    String productos, descripcion, unidad, marca, proveedor, 
            nombreimagen, direccionimagen, strfechaprecio, estatus;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
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

    int idproducto, idcategoria, idalmacen, idpasillo, idanaquel, idbin, idempleado, 
            idempresa, cantmax, cantmin, idproveedor;

    public int getCantmax() {
        return cantmax;
    }

    public void setCantmax(int cantmax) {
        this.cantmax = cantmax;
    }

    public int getCantmin() {
        return cantmin;
    }

    public void setCantmin(int cantmin) {
        this.cantmin = cantmin;
    }

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

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getStrfechaprecio() {
        return strfechaprecio;
    }

    public void setStrfechaprecio(String strfechaprecio) {
        this.strfechaprecio = strfechaprecio;
    }    

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombreimagen() {
        return nombreimagen;
    }

    public void setNombreimagen(String nombreimagen) {
        this.nombreimagen = nombreimagen;
    }

    public String getDireccionimagen() {
        return direccionimagen;
    }

    public void setDireccionimagen(String direccionimagen) {
        this.direccionimagen = direccionimagen;
    }
    Double precio; 
    Date fechaprecio; 

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaprecio() {
        return fechaprecio;
    }

    public void setFechaprecio(Date fechaprecio) {
        this.fechaprecio = fechaprecio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
}
