package ch.heigvd.gamification.services.to;

import com.joyscrum.model.Application;
import ch.heigvd.gamification.services.to.interfaces.IApplicationsTOService;
import ch.heigvd.gamification.to.ApplicationTO;
import javax.ejb.Stateless;

/**
 * Implementation of the application transfert object management interface.
 *
 * @see IApplicationsTOService
 * @author Thomas Moegli
 */
@Stateless
public class ApplicationsTOService implements IApplicationsTOService {

  @Override
  public ApplicationTO buildPublicApplicationTO(Application source) {
    return new ApplicationTO(source.getId().toHexString(), source.getName());
  }

  @Override
  public void updateApplicationEntity(Application existing, ApplicationTO state) {
    existing.setName(state.getName());
  }
}
