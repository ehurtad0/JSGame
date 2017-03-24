package com.joyscrum.gamification.services.to.interfaces;

import com.joyscrum.model.Application;
import com.joyscrum.gamification.to.ApplicationTO;
import javax.ejb.Local;

/**
 * This interface provides methods for converting applications to transfert
 * object or update applications from transfert object.
 *
 * @author Thomas Moegli
 */
@Local
public interface IApplicationsTOService {

  public ApplicationTO buildPublicApplicationTO(Application source);

  public void updateApplicationEntity(Application existing, ApplicationTO state);
}
