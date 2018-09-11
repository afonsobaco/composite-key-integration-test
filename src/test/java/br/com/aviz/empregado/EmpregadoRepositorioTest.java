package br.com.aviz.empregado;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmpregadoRepositorioTest {

    @Autowired
    private EmpregadoRepositorio repositorio;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void TestaPersistenciaMockada() {
        // given
        Empregado empregado = new Empregado();
        EmpregadoPK empregadoPK = new EmpregadoPK();

        // Não pode inserir ID null com EMBEDDEDID
        empregadoPK.setIdEmpregado(1L);
        empregadoPK.setIdEmpresa(1234L);
        empregado.setEmpregadoPK(empregadoPK);
        empregado.setNome("Pedro de Aviz");

        // when
        Empregado saved = repositorio.save(empregado);

        // then
        Assert.assertNotNull(saved);
        Empregado novoEmpregado = repositorio.findById(empregadoPK).get();
        Assert.assertNotNull(novoEmpregado);
    }

    @Test
    public void TestaChaveCompostaSequencialEmbeddedId() {
        // given
        Empregado empregado = new Empregado();
        EmpregadoPK empregadoPK = new EmpregadoPK();

        // Não pode inserir ID null com EMBEDDEDID
        empregadoPK.setIdEmpregado(2L);
        empregadoPK.setIdEmpresa(1234L);
        empregado.setEmpregadoPK(empregadoPK);
        empregado.setNome("Pedro de Aviz");

        // when
        Empregado saved = repositorio.save(empregado);

        // then
        Assert.assertNotNull(saved.getEmpregadoPK().getIdEmpregado());
        Assert.assertTrue(saved.getEmpregadoPK().getIdEmpregado() == 2);
    }

}