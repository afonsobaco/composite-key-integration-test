package br.com.aviz.livro;

import java.io.Serializable;

public class LivroPK implements Serializable {

    private Long registro;
    private String autor;

    public Long getRegistro() {
        return registro;
    }

    public void setRegistro(Long registro) {
        this.registro = registro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        result = prime * result + ((registro == null) ? 0 : registro.hashCode());
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
        LivroPK other = (LivroPK) obj;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        if (registro == null) {
            if (other.registro != null)
                return false;
        } else if (!registro.equals(other.registro))
            return false;
        return true;
    }

}
