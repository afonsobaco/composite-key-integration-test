package br.com.aviz.empregado;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpregadoPK implements Serializable {

    @Column
    private Long idEmpresa;

    @Column
    private Long idEmpregado;

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(Long idEmpregado) {
        this.idEmpregado = idEmpregado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idEmpregado == null) ? 0 : idEmpregado.hashCode());
        result = prime * result + ((idEmpresa == null) ? 0 : idEmpresa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmpregadoPK other = (EmpregadoPK) obj;
        if (idEmpregado == null) {
            if (other.idEmpregado != null)
                return false;
        } else if (!idEmpregado.equals(other.idEmpregado))
            return false;
        if (idEmpresa == null) {
            if (other.idEmpresa != null)
                return false;
        } else if (!idEmpresa.equals(other.idEmpresa))
            return false;
        return true;
    }

}
