package ch.heigvd.gamification.services.crud;

import ch.heigvd.gamification.exceptions.EntityNotFoundException;
import ch.heigvd.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.Application;
import com.joyscrum.model.Success;
import ch.heigvd.gamification.services.crud.interfaces.ISuccessesManager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * Implementation of the successes manager interface.
 *
 * @see ISuccessesManager
 * @author Alexandre Perusset
 */
@Stateless
public class SuccessesManager implements ISuccessesManager {

  //@PersistenceContext(unitName = "Gamification")
  private EntityManager em;

  @Override
  public String create(Success success) {
    if (success.getApplication() == null) { //Check if application setted
      throw new InvalidParameterException("Cannot save a success without application");
    }
    Success newSuccess = new Success(success);
    em.persist(newSuccess);
    return newSuccess.getId().toHexString();
  }

  @Override
  public void update(Success newState, Application app) throws EntityNotFoundException, UnauthorizedException {
    findById(newState.getId().toHexString(), app);
    em.merge(newState);
  }

  @Override
  public void delete(String id, Application app) throws EntityNotFoundException, UnauthorizedException {
    em.remove(findById(id, app));
  }

  @Override
  public Success findById(String id, Application app) throws EntityNotFoundException, UnauthorizedException {
    Success success = em.find(Success.class, id);
    if (success == null) {
      throw new EntityNotFoundException();
    }
    checkRights(success, app);
    return success;
  }

  @Override
  public List<Success> findAll(Application app) {
    //return em.createNamedQuery("findAllSuccess")
    //        .setParameter("appid", app.getId())
    //        .getResultList();
    return null;
  }

  @Override
  public void checkRights(Success success, Application app) throws UnauthorizedException {
    if (success.getApplication() == null || !success.getApplication().equals(app)) {
      throw new UnauthorizedException();
    }
  }
}
