package Entities;

import java.util.Date;
import java.util.Map;

public class Pedido extends Entity
{
    private Date _FechaRealizacion;
    private Map.Entry<Integer,Integer> Libros;

    public Date getFechaRealizacion() {return _FechaRealizacion;}
    public void setFechaRealizacion(Date _FechaRealizacion) {this._FechaRealizacion = _FechaRealizacion;}
}
