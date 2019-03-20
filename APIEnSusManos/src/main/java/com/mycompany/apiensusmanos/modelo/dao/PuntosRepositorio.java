package com.mycompany.apiensusmanos.modelo.dao;

import com.mycompany.apiensusmanos.modelo.entity.Eventos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PuntosRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public long registrarEventoByCiudadano(Eventos eventos) {
        getSessionFactory().getCurrentSession().save(eventos);
        return eventos.getId_eventos();
    }

    public Eventos getEventosByCiudadano(int id) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Eventos.class);
        criteria.add(Restrictions.eq("id_eventos", id));
        return (Eventos) criteria.uniqueResult();
    }

    public List<Eventos> getAllPuntos() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Eventos.class);
        return criteria.list();
    }
    
    
}
