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

@Repository
@Transactional
public class UsuariosRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Usuarios> Autenticacion(String usuario, String password) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Usuarios.class);
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

    public List<Usuarios> getAllCiudadanos() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Usuarios.class);
        return criteria.list();
    }

    public List<Usuarios> getUsuariosnombreybarrio(String nombre, String barrio) {

        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Usuarios.class);
        if (nombre != null) {
            criteria.add(Restrictions.eq("nombre", nombre));
        }
        if (barrio != null) {
            criteria.add(Restrictions.eq("barrio", barrio));
        }
        return criteria.list();
    }

    public Usuarios getUsuariosID(int id) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("id_usuarios", id));
        return (Usuarios) criteria.uniqueResult();

    }

    public List<Usuarios> getCiudadanosOrdenado() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Usuarios.class);
        criteria.addOrder(Order.desc("nombre"));
        return criteria.list();

    }

}
