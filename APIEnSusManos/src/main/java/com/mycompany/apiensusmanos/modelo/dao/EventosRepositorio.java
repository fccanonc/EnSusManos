/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apiensusmanos.modelo.dao;

import com.mycompany.apiensusmanos.modelo.entity.Eventos;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Camilo Cañon
 */
@Repository
@Transactional
public class EventosRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private Criteria criteria;

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
        criteria = getSessionFactory().getCurrentSession().createCriteria(Eventos.class);
        criteria.add(Restrictions.eq("id_eventos", id));
        return (Eventos) criteria.uniqueResult();
    }

}
