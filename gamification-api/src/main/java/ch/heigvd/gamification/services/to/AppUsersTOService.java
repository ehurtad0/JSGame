package ch.heigvd.gamification.services.to;

import javax.ejb.Stateless;
import com.joyscrum.model.AppUser;
import com.joyscrum.model.Application;
import ch.heigvd.gamification.services.to.interfaces.IAppUsersTOService;
import ch.heigvd.gamification.to.AppUserPublicTO;
import ch.heigvd.gamification.to.AppUserTO;
import ch.heigvd.gamification.to.RankedAppUserTO;

/**
 * Implementation of the user transfert object management interface.
 *
 * @see IAppUsersTOService
 * @author Alexandre Perusset
 */
@Stateless
public class AppUsersTOService implements IAppUsersTOService {

  @Override
  public AppUserPublicTO buildPublicUserTO(AppUser source) {
    return new AppUserPublicTO(
            source.getId(),
            source.getName(),
            source.getSurname(),
            source.getNickname()
    );
  }

  @Override
  public AppUserTO buildUserTO(AppUser source) {
    return new AppUserTO(
            source.getId(),
            source.getName(),
            source.getSurname(),
            source.getNickname(),
            source.getPassword()
    );
  }

  @Override
  public void updateUserEntity(AppUser existing, AppUserTO newState, Application application) {
    existing.setName(newState.getName());
    existing.setSurname(newState.getSurname());
    existing.setNickname(newState.getNickname());
    existing.setPassword(newState.getPassword());
    existing.setApplication(application);
  }

  @Override
  public RankedAppUserTO buildRankedUserTO(AppUser source, Integer points) {
    return new RankedAppUserTO(
            source.getId(),
            points,
            source.getName(),
            source.getSurname(),
            source.getNickname()
    );
  }
}
