package br.com.aviz.livro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.aviz.comum.ServicoComum;

@Service
public class LivroServico implements ServicoComum<Livro, LivroPK> {

    private LivroRepositorio repositorio;

    @Override
    public List<Livro> listAll() {
        List<Livro> lista = new ArrayList<>();
        repositorio.findAll().forEach(lista::add);
        return lista;
    }

    @Override
    public Livro getById(LivroPK id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Livro saveOrUpdate(Livro Livro) {
        repositorio.save(Livro);
        return Livro;
    }

    @Override
    public void delete(LivroPK id) {
        repositorio.deleteById(id);

    }

}