/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apiensusmanos.modelo.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.apiensusmanos.modelo.entity.Usuarios;
import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author Camilo Cañon
 */
@Repository
@Transactional
public class UsuariosRepositorio {

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

    public List<Usuarios> Autenticacion(String usuario, String password) {
        criteria = getSessionFactory().getCurrentSession().createCriteria(Usuarios.class);
        if (usuario != null) {
            criteria.add(Restrictions.eq("usuario", usuario));
        }

        if (password != null) {
            criteria.add(Restrictions.eq("password", password));
        }

        return criteria.list();
    }

    public long crearUsuario(Usuarios usuarios) {
        getSessionFactory().getCurrentSession().save(usuarios);
        return usuarios.getId_usuarios();
    }

    public Usuarios getCiudadanoById(int id) {
        criteria = getSessionFactory().getCurrentSession().createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("id_usuarios", id));
        return (Usuarios) criteria.uniqueResult();
    }

    public List<Usuarios> getAllCiudadanos() {
        criteria = getSessionFactory().getCurrentSession().createCriteria(Usuarios.class);
        return criteria.list();
    }
    
    public List<Usuarios> getCiudadanosOrdenados(){
        criteria = getSessionFactory().getCurrentSession().createCriteria(Usuarios.class);
        criteria.addOrder(Order.asc("nombre"));
        return criteria.list();
    }
}
