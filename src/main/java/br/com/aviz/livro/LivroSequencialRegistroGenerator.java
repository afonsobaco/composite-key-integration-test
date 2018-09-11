package br.com.aviz.livro;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class LivroSequencialRegistroGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        EntityManager em = ((Session) session).getEntityManagerFactory().createEntityManager();
        Livro recibo = (Livro) object;
        String sql = "SELECT COUNT(n.registro)+1 AS id FROM Livro n where n.autor = :autor";
        TypedQuery<Long> query = em.createQuery(sql, Long.class);
        query.setParameter("autor", recibo.getAutor());
        Long singleResult = (Long) query.getSingleResult();
        return singleResult;
    }
}