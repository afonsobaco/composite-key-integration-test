package br.com.aviz.empregado;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "empregado")
public class Empregado {

    @EmbeddedId
    private EmpregadoPK empregadoPK;

    @Column
    private String nome;

    public EmpregadoPK getEmpregadoPK() {
        return empregadoPK;
    }

    public void setEmpregadoPK(EmpregadoPK empregadoPK) {
        this.empregadoPK = empregadoPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
