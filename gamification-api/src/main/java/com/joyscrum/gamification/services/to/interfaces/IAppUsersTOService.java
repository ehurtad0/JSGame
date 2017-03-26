package com.joyscrum.gamification.services.to.interfaces;

import com.joyscrum.model.AppUser;
import com.joyscrum.model.Application;
import com.joyscrum.gamification.to.AppUserPublicTO;
import com.joyscrum.gamification.to.AppUserTO;
import com.joyscrum.gamification.to.RankedAppUserTO;
import javax.ejb.Local;

/**
 * This interface provides methods for converting users to transfert object or
 * update users from transfert object.
 *
 * @author Alexandre Perusset
 */
@Local
public interface IAppUsersTOService {

  public AppUserPublicTO buildPublicUserTO(AppUser source);

  public AppUserTO buildUserTO(AppUser source);

  public RankedAppUserTO buildRankedUserTO(AppUser source, Integer points);

  public void updateUserEntity(AppUser existingEntity, AppUserTO newState, Application application);
}
