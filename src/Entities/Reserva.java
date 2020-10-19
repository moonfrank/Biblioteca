package Entities;

import java.util.Date;

public class Reserva extends Entity
{
    private int _IDSocio,
                _IDLibro;
    private Date    _FechaRealizacion,
                    _FechaCancelacion;

    public int getIDSocio() {return _IDSocio;}
    public void setIDSocio(int _IDSocio) {this._IDSocio = _IDSocio;}

    public int getIDLibro() {return _IDLibro;}
    public void setIDLibro(int _IDLibro) {this._IDLibro = _IDLibro;}

    public Date getFechaRealizacion() {return _FechaRealizacion;}
    public void setFechaRealizacion(Date _FechaRealizacion) {this._FechaRealizacion = _FechaRealizacion;}

    public Date getFechaCancelacion() {return _FechaCancelacion;}
    public void setFechaCancelacion(Date _FechaCancelacion) {this._FechaCancelacion = _FechaCancelacion;}
}
