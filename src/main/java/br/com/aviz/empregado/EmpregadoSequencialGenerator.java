package br.com.aviz.empregado;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmpregadoSequencialGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        EntityManager em = ((Session) session).getEntityManagerFactory().createEntityManager();
        Empregado recibo = (Empregado) object;
        String sql = "SELECT COUNT(n.idEmpregado)+1 AS id FROM Empregado n where n.idEmpresa = :empresa";
        TypedQuery<Long> query = em.createQuery(sql, Long.class);
        query.setParameter("empresa", recibo.getEmpregadoPK().getIdEmpresa());
        Long singleResult = (Long) query.getSingleResult();
        return singleResult;
    }
}