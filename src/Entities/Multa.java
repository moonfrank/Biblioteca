package Entities;

import java.util.Date;

public class Multa extends Entity
{
    private int _IDSocio,
                _IDBibliotecario;
    private Date    _FechaComienzo,
                    _FechaFin;

    public int getIDSocio() {return _IDSocio;}
    public void setIDSocio(int _IDSocio) {this._IDSocio = _IDSocio;}

    public int getIDBibliotecario() {return _IDBibliotecario;}
    public void setIDBibliotecario(int _IDBibliotecario) {this._IDBibliotecario = _IDBibliotecario;}

    public Date getFechaComienzo() {return _FechaComienzo;}
    public void setFechaComienzo(Date _FechaComienzo) {this._FechaComienzo = _FechaComienzo;}

    public Date getFechaFin() {return _FechaFin;}
    public void setFechaFin(Date _FechaFin) {this._FechaFin = _FechaFin;}
}
