package com.joyscrum.gamification.services.to.interfaces;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.Application;
import com.joyscrum.model.Rule;
import com.joyscrum.gamification.to.RuleTO;
import javax.ejb.Local;

/**
 * This interface provides methods for converting rules to transfert object or
 * update rules from transfert object.
 *
 * @author Gaël Jobin
 */
@Local
public interface IRulesTOService {

  public RuleTO buildPublicRuleTO(Rule source);

  public void updateRuleEntity(Rule existing, RuleTO state, Application application) throws EntityNotFoundException, UnauthorizedException;
}
