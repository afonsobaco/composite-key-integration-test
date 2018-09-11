package br.com.aviz.comum;

import java.util.List;

public interface ServicoComum<T, PK /* ,DTO */> {

    List<T> listAll();

    T getById(PK pk);

    T saveOrUpdate(T entity);

    void delete(PK pk);

    // T saveOrUpdateFromDTO(DTO dto);
}