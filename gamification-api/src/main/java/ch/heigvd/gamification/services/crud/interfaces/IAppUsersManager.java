package ch.heigvd.gamification.services.crud.interfaces;

import ch.heigvd.gamification.exceptions.EntityNotFoundException;
import ch.heigvd.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.AppUser;
import com.joyscrum.model.Application;
import com.joyscrum.model.Success;

import java.util.List;
import javax.ejb.Local;

/**
 * This interface provides method to create, update, delete and get users. It is
 * also possible to get the user successes or check if user has obtained new
 * successes.
 *
 * @author Alexandre perusset
 */
@Local
public interface IAppUsersManager {

  public String create(AppUser user);

  public void update(AppUser state, Application app) throws EntityNotFoundException, UnauthorizedException;

  public void delete(String id, Application app) throws EntityNotFoundException, UnauthorizedException;

  public AppUser findById(String id, Application app) throws EntityNotFoundException, UnauthorizedException;

  public List<AppUser> findAll(Application app);

  public List<AppUser> findAllBySuccess(Success success, Application app) throws UnauthorizedException;

  public void checkRights(AppUser user, Application app) throws UnauthorizedException;

  public List<Success> checkForNewSuccesses(AppUser user);
}
