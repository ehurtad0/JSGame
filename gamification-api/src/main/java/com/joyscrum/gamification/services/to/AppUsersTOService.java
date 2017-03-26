package com.joyscrum.gamification.services.to;

import javax.ejb.Stateless;
import com.joyscrum.model.AppUser;
import com.joyscrum.model.Application;
import com.joyscrum.gamification.services.to.interfaces.IAppUsersTOService;
import com.joyscrum.gamification.to.AppUserPublicTO;
import com.joyscrum.gamification.to.AppUserTO;
import com.joyscrum.gamification.to.RankedAppUserTO;

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
