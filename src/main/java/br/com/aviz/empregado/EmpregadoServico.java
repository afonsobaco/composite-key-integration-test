package br.com.aviz.empregado;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.aviz.comum.ServicoComum;

@Service
public class EmpregadoServico implements ServicoComum<Empregado, EmpregadoPK> {

    private EmpregadoRepositorio repositorio;

    @Override
    public List<Empregado> listAll() {
        List<Empregado> lista = new ArrayList<>();
        repositorio.findAll().forEach(lista::add);
        return lista;
    }

    @Override
    public Empregado getById(EmpregadoPK id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Empregado saveOrUpdate(Empregado empregado) {
        repositorio.save(empregado);
        return empregado;
    }

    @Override
    public void delete(EmpregadoPK id) {
        repositorio.deleteById(id);

    }

}