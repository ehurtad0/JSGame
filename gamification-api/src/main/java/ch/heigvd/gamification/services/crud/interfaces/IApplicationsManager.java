package ch.heigvd.gamification.services.crud.interfaces;

import ch.heigvd.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.model.Application;

import java.util.List;
import javax.ejb.Local;

/**
 * This interface provides method to create, update, delete and get
 * applications.
 *
 * @author Gaël Jobin
 */
@Local
public interface IApplicationsManager {

  public String create(Application applicationData);

  public void update(Application newState) throws EntityNotFoundException;

  public void delete(String id) throws EntityNotFoundException;

  public Application findById(String id) throws EntityNotFoundException;

  public List<Application> findAll();
}
