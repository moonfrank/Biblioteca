package Entities;

import java.util.Date;

public class Prestamo extends Entity
{
    private int _IDSocio,
                _IDLibro;
    private Date    _FechaInicio,
                    _FechaFin;

    public int getIDSocio() {return _IDSocio;}
    public void setIDSocio(int _IDSocio) {this._IDSocio = _IDSocio;}

    public int getIDLibro() {return _IDLibro;}
    public void setIDLibro(int _IDLibro) {this._IDLibro = _IDLibro;}

    public Date getFechaInicio() {return _FechaInicio;}
    public void setFechaInicio(Date _FechaInicio) {this._FechaInicio = _FechaInicio;}

    public Date getFechaFin() {return _FechaFin;}
    public void setFechaFin(Date _FechaFin) {this._FechaFin = _FechaFin;}
}
