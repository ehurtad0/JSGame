package com.joyscrum.gamification.services.crud;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.AppAction;
import com.joyscrum.model.Application;
import com.joyscrum.gamification.services.crud.interfaces.IAppActionsManager;

import java.security.InvalidParameterException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 * Implementation of the actions manager interface.
 *
 * @see IAppActionsManager
 * @author Gaël Jobin
 */
@Stateless
public class AppActionsManager implements IAppActionsManager {

  //@PersistenceContext(unitName = "Gamification")
  private EntityManager em;

  @Override
  public String create(AppAction action) {
    if (action.getApplication() == null) { //Check if application setted
      throw new InvalidParameterException("Cannot save an AppAction without application");
    }
    AppAction newAction = new AppAction(action);
    em.persist(newAction);
    return newAction.getId().toHexString();
  }

  @Override
  public void update(AppAction newState, Application application) throws EntityNotFoundException, UnauthorizedException {
    findById(newState.getId().toHexString(), application);
    em.merge(newState);
  }

  @Override
  public void delete(String id, Application application) throws EntityNotFoundException, UnauthorizedException {
    em.remove(findById(id, application));
  }

  @Override
  public AppAction findById(String id, Application application) throws EntityNotFoundException, UnauthorizedException {
    AppAction action = em.find(AppAction.class, id);
    if (action == null) {
      throw new EntityNotFoundException();
    }
    checkRights(action, application);
    return action;
  }

  @Override
  public List<AppAction> findAll(Application application) {
  //  return em.createNamedQuery("findAllAppActions")
  //          .setParameter("appid", application.getId())
  //          .getResultList();
    return null;
  }

  @Override
  public void checkRights(AppAction action, Application app) throws UnauthorizedException {
    if (action.getApplication() == null || !action.getApplication().equals(app)) {
      throw new UnauthorizedException();
    }
  }
}
