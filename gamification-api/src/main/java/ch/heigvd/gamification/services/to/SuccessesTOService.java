package ch.heigvd.gamification.services.to;

import com.joyscrum.model.Application;
import com.joyscrum.model.Success;
import ch.heigvd.gamification.services.to.interfaces.ISuccessesTOService;
import ch.heigvd.gamification.to.SuccessTO;
import javax.ejb.Stateless;

/**
 * Implementation of the success transfert object management interface.
 *
 * @see ISuccessesTOService
 * @author Gaël Jobin
 */
@Stateless
public class SuccessesTOService implements ISuccessesTOService {

  @Override
  public SuccessTO buildSuccessTO(Success source) {
    return new SuccessTO(
            source.getId().toHexString(),
            source.getName(),
            source.getBadge());
  }

  @Override
  public void updateSuccessEntity(Success existing, SuccessTO state, Application application) {
    existing.setName(state.getName());
    existing.setBadge(state.getBadge());
    existing.setApplication(application);
  }
}
