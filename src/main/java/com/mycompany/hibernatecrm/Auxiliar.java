/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatecrm;
        
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

/**
 *
 * @author Pablo Martínez y Santiago Ucero.
 */
public class Auxiliar {

    // Carga todos los datos de una clase específica en una lista y la devuelve
    public static <T> List<T> loadAllData(Class<T> type, Session sesion) {
        CriteriaBuilder builder = sesion.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = sesion.createQuery(criteria).getResultList();
        return data;
    }
}

