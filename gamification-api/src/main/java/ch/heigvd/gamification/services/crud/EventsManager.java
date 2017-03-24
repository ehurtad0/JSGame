package ch.heigvd.gamification.services.crud;

import ch.heigvd.gamification.exceptions.EntityNotFoundException;
import ch.heigvd.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.AppUser;
import com.joyscrum.model.Application;
import com.joyscrum.model.Event;
import com.joyscrum.model.Success;
import ch.heigvd.gamification.services.crud.interfaces.IAppUsersManager;
import ch.heigvd.gamification.services.crud.interfaces.IEventsManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * Implementation of the events manager interface.
 *
 * @see IEventsManager
 * @author Alexandre Perusset
 */
@Stateless
public class EventsManager implements IEventsManager {

  //@PersistenceContext(unitName = "Gamification")
  private EntityManager em;

  @EJB
  private IAppUsersManager usersManager;

  @Override
  public String create(Event event) throws EntityNotFoundException, UnauthorizedException {
    if (event.getApplication() == null) { //Check if application setted
      throw new InvalidParameterException("Cannot save an event without application");
    }
    Event newEvent = new Event(event);
    em.persist(newEvent);
    AppUser user = newEvent.getUser();
    user.addEvent(newEvent);
    //Add new success if needed
    for (Success success : usersManager.checkForNewSuccesses(newEvent.getUser())) {
      user.addSuccess(success);
    }
    usersManager.update(user, newEvent.getApplication());
    return newEvent.getId().toHexString();
  }

  @Override
  public void delete(String id, Application application) throws EntityNotFoundException, UnauthorizedException {
    em.remove(findById(id, application));
  }

  @Override
  public Event findById(String id, Application application) throws EntityNotFoundException, UnauthorizedException {
    Event event = em.find(Event.class, id);
    if (event == null) {
      throw new EntityNotFoundException("Cannot find Event with id " + id);
    }
    checkRights(event, application);
    return event;
  }

  @Override
  public List<Event> findAll(Application application) {
    //return em.createNamedQuery("findAllEvents")
    //        .setParameter("appid", application.getId())
    //        .getResultList();
    return null;
  }

  @Override
  public void checkRights(Event event, Application app) throws UnauthorizedException {
    if (event.getApplication() == null || !event.getApplication().equals(app)) {
      throw new UnauthorizedException();
    }
  }
}
