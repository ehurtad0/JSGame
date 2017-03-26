package com.joyscrum.gamification.services.crud;

import com.joyscrum.ConnectionDB;
import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.gamification.services.crud.interfaces.IAppActionsManager;
import com.joyscrum.model.AppAction;
import com.joyscrum.model.Application;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * Implementation of the actions manager interface.
 *
 * @author Gaël Jobin
 * @see IAppActionsManager
 */
@Stateless
public class AppActionsManager implements IAppActionsManager {

    //@PersistenceContext(unitName = "Gamification")
    //private EntityManager em;
    @Inject
    ConnectionDB connection;

    @Override
    public String create(AppAction action) {
        if (action.getApplication() == null) { //Check if application setted
            throw new InvalidParameterException("Cannot save an AppAction without application");
        }
        AppAction newAction = new AppAction(action);
        connection.getDataStore().save(newAction);
        //em.persist(newAction);
        return newAction.getId().toHexString();

    }

    @Override
    public void update(AppAction newState, Application application) throws EntityNotFoundException, UnauthorizedException {
        AppAction action = findById(newState.getId().toHexString(), application);
        action.setApplication(application);
        action.setDescription(newState.getDescription());
        action.setPoints(newState.getPoints());
        action.setTitle(newState.getTitle());
        connection.getDataStore().save(action);
        //em.merge(newState);
    }

    @Override
    public void delete(String id, Application application) throws EntityNotFoundException, UnauthorizedException {
        connection.getDataStore().delete(findById(id, application));
        //em.remove(findById(id, application));
    }

    @Override
    public AppAction findById(String id, Application application) throws EntityNotFoundException, UnauthorizedException {
        if (!ObjectId.isValid(id)) {
            throw new EntityNotFoundException();
        }
        Datastore store = connection.getDataStore();
        AppAction action = store.createQuery(AppAction.class).field("_id").equal(new ObjectId(id)).get();
        if (action == null) {
            throw new EntityNotFoundException();
        }

        //AppAction action = em.find(AppAction.class, id);
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
        Datastore store = connection.getDataStore();
        return store.find(AppAction.class).field("application").equal(application).asList();
    }

    @Override
    public void checkRights(AppAction action, Application app) throws UnauthorizedException {
        if (action.getApplication() == null || !action.getApplication().equals(app)) {
            throw new UnauthorizedException();
        }
    }
}
