package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.StateEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StateDao {

    @PersistenceContext
    private EntityManager em;

    public List<StateEntity> getAllState() {
        try {
            return em.createNamedQuery("getAllState", StateEntity.class).getResultList();
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public StateEntity getStateByUuid(String uuid) {
        try {
            return em.createNamedQuery("getStateByUuid", StateEntity.class).setParameter("uuid", uuid).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
