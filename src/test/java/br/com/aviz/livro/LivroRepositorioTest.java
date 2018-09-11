package br.com.aviz.livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LivroRepositorioTest {

    private static String TITULO = "123 DE OLIVEIRA 4";
    private static String AUTOR = "Salvador Daqui";

    @Autowired
    private LivroRepositorio repositorio;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void TestaPersistenciaMockada() {
        // given
        Livro livro = new Livro();
        livro.setAutor(AUTOR);
        livro.setTitulo(TITULO);

        // when
        Livro saved = repositorio.save(livro);

        // then
        Assert.assertNotNull(saved.getRegistro());
    }

    @Test
    public void TestaChaveCompostaSequencialIdClass() {
        // given
        Livro livro = new Livro();
        livro.setAutor("Pedro de Aviz");
        livro.setTitulo("Derby - Primeiros passos");

        // when
        Livro saved = repositorio.save(livro);

        // then
        Assert.assertNotNull(saved.getRegistro());
        Assert.assertTrue(saved.getRegistro() == 1);

        // given
        livro = new Livro();
        livro.setAutor(AUTOR);
        livro.setTitulo(TITULO);

        // when
        saved = repositorio.save(livro);

        // then
        Assert.assertNotNull(saved.getRegistro());
        Assert.assertTrue(saved.getRegistro() == 2);
        List<Livro> list = (ArrayList<Livro>) repositorio.findAll();
        Assert.assertTrue(list.size() >= 2);
    }

}