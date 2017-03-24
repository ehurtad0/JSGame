package ch.heigvd.gamification.services.exposed.interfaces;

import ch.heigvd.gamification.exceptions.EntityNotFoundException;
import ch.heigvd.gamification.to.ApplicationTO;
import java.util.List;
import javax.ejb.Remote;
import javax.ws.rs.core.Response;

/**
 * Interface for applications management. The methods inside can be called
 * remotly or with jax-rs rest api.
 *
 * @author Alexandre Perusset
 */
@Remote
public interface IApplicationsResource {

  public List<ApplicationTO> getApplications();

  public String createApplication(ApplicationTO applicationTO);

  public ApplicationTO getApplication(String id) throws EntityNotFoundException;

  public void updateApplication(ApplicationTO applicationTO, String id) throws EntityNotFoundException;

  public void deleteApplication(String id) throws EntityNotFoundException;

  public Response restCreateApplication(ApplicationTO applicationTO);

  public Response restUpdateApplication(ApplicationTO applicationTO, String id) throws EntityNotFoundException;

  public Response restDeleteApplication(String id) throws EntityNotFoundException;
}
