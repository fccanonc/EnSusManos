package com.mycompany.apiensusmanos.modelo.dao;

import com.mycompany.apiensusmanos.modelo.entity.Eventos;
import com.mycompany.apiensusmanos.modelo.entity.Puntos;
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

    public List<Puntos> getPuntosdescripcion(String descripcion) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Puntos.class);
        if (descripcion != null) {
            criteria.add(Restrictions.eq("descripcion", descripcion));
        }
        return criteria.list();
    }

    public Puntos getPuntosID(int id) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Puntos.class);
        criteria.add(Restrictions.eq("id_puntos", id));
        return (Puntos) criteria.uniqueResult();
    }

    public long crearPuntos(Puntos puntos) {
        getSessionFactory().getCurrentSession().save(puntos);
        return puntos.getId_puntos();
    }

}
