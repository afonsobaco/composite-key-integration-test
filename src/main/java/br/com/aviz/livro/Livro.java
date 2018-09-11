package br.com.aviz.livro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "livro")
@IdClass(LivroPK.class)
public class Livro {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_REGISTRO_LIVRO")
    @GenericGenerator(name = "SEQ_REGISTRO_LIVRO", strategy = "br.com.aviz.livro.LivroSequencialRegistroGenerator",
                      parameters = { @Parameter(name = "sequence", value = "SEQ_REGISTRO_LIVRO") })
    private Long registro;

    @Id
    @Column
    private String autor;

    @Column
    private String titulo;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getRegistro() {
        return registro;
    }

    public void setRegistro(Long registro) {
        this.registro = registro;
    }

}
