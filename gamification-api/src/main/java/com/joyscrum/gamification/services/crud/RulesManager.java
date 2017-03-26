package com.joyscrum.gamification.services.crud;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.AppAction;
import com.joyscrum.model.Application;
import com.joyscrum.model.Rule;
import com.joyscrum.gamification.services.crud.interfaces.IRulesManager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * Implementation of the rules manager interface.
 *
 * @author Gaël Jobin
 * @see IRulesManager
 */
@Stateless
public class RulesManager implements IRulesManager {

    //@PersistenceContext(unitName = "Gamification")
    private EntityManager em;

    @Override
    public String create(Rule rule) {
        if (rule.getApplication() == null) { //Check if application setted
            throw new InvalidParameterException("Cannot save a rule without application");
        }
        Rule newRule = new Rule(rule);
        em.persist(newRule);
        return newRule.getId().toHexString();
    }

    @Override
    public void update(Rule newState, Application application) throws EntityNotFoundException, UnauthorizedException {
        findById(newState.getId().toHexString(), application);
        em.merge(newState);
    }

    @Override
    public void delete(String id, Application application) throws EntityNotFoundException, UnauthorizedException {
        em.remove(findById(id, application));
    }

    @Override
    public Rule findById(String id, Application application) throws EntityNotFoundException, UnauthorizedException {
        Rule rule = em.find(Rule.class, id);
        if (rule == null) {
            throw new EntityNotFoundException();
        }
        checkRights(rule, application);
        return rule;
    }

    @Override
    public List<Rule> findAll(Application application) {
        // return em.createNamedQuery("findAllRules")
        //         .setParameter("appid", application.getId())
        //         .getResultList();
        return null;
    }

    @Override
    public List<Rule> findAllForAction(AppAction action) {
        //return em.createNamedQuery("findAllRulesForAction")
        //        .setParameter("actionid", action.getId())
        //        .getResultList();
        return null;
    }

    @Override
    public void checkRights(Rule rule, Application app) throws UnauthorizedException {
        if (rule.getApplication() == null || !rule.getApplication().equals(app)) {
            throw new UnauthorizedException();
        }
    }
}
