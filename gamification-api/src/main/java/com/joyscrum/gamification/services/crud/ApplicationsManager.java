package com.joyscrum.gamification.services.crud;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.model.Application;
import com.joyscrum.gamification.services.crud.interfaces.IApplicationsManager;
import com.joyscrum.ConnectionDB;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Implementation of the application manager interface.
 *
 * @see IApplicationsManager
 * @author Gaël Jobin
 */
@Stateless
public class ApplicationsManager implements IApplicationsManager {
@Inject
ConnectionDB connection;
  //@PersistenceContext(unitName = "Gamification")
  private EntityManager em;

  @Override
  public String create(Application applicationData) {
    Application newApplication = new Application(applicationData);
    em.persist(newApplication);
    return newApplication.getId().toHexString();
  }

  @Override
  public void update(Application newState) throws EntityNotFoundException {
    findById(newState.getId().toHexString());
    em.merge(newState);
  }

  @Override
  public void delete(String id) throws EntityNotFoundException {
    //Is delete cascade setted ?
    //em.remove(findById(id));
    if (!ObjectId.isValid(id)){
      throw new EntityNotFoundException();
    }
    Datastore datastore= connection.getDataStore();
    datastore.delete(datastore.createQuery(Application.class).filter("_id", new ObjectId(id)));
  }

  @Override
  public Application findById(String id) throws EntityNotFoundException {
    if (!ObjectId.isValid(id)){
      throw new EntityNotFoundException();
    }
    Datastore store = connection.getDataStore();
    Application existingApplication=store.createQuery(Application.class).field("_id").equal(new ObjectId(id)).get();
    if (existingApplication == null) {
      throw new EntityNotFoundException();
    }
    return existingApplication;
  }

  @Override
  public List<Application> findAll() {

    Datastore dataStore = connection.getDataStore();
    //Application app = new Application();
    //app.setName("Fase 1");
    //dataStore.save(app);
    return dataStore.createQuery(Application.class).asList();
    //return em.createNamedQuery("findAllApplication").getResultList();
    //return null;
  }
}
