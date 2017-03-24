package ch.heigvd.gamification.services.crud.interfaces;

import ch.heigvd.gamification.exceptions.EntityNotFoundException;
import ch.heigvd.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.AppAction;
import com.joyscrum.model.Application;

import java.util.List;
import javax.ejb.Local;

/**
 * This interface provides method to create, update, delete and get actions.
 *
 * @author Gaël Jobin
 */
@Local
public interface IAppActionsManager {

  public String create(AppAction actionTypeData);

  public void update(AppAction newState, Application application) throws EntityNotFoundException, UnauthorizedException;

  public void delete(String id, Application application) throws EntityNotFoundException, UnauthorizedException;

  public AppAction findById(String id, Application application) throws EntityNotFoundException, UnauthorizedException;

  public List<AppAction> findAll(Application application);

  public void checkRights(AppAction action, Application app) throws UnauthorizedException;
}
