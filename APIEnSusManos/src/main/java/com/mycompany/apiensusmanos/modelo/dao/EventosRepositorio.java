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
public class EventosRepositorio {

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

    public Eventos obtenerPersonaPorID(int id) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Eventos.class);
        criteria.add(Restrictions.eq("id_eventos", id));
        return (Eventos) criteria.uniqueResult();
    }

    public List<Eventos> getEventosBynombreydescripcion(String nombre, String descripcion) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Eventos.class);
        if (nombre != null) {
            criteria.add(Restrictions.eq("nombre", nombre));
        }
        if (descripcion != null) {
            criteria.add(Restrictions.eq("descripcion", descripcion));
        }
        return criteria.list();
    }

    public Eventos getEventoID(int id) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Eventos.class);
        criteria.add(Restrictions.eq("id_eventos", id));
        return (Eventos) criteria.uniqueResult();

    }

    public long crearEventos(Eventos eventos) {
        getSessionFactory().getCurrentSession().save(eventos);
        return eventos.getId_eventos();
    }

}
