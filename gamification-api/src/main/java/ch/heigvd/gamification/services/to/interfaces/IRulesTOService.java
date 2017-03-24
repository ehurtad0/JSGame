package ch.heigvd.gamification.services.to.interfaces;

import ch.heigvd.gamification.exceptions.EntityNotFoundException;
import ch.heigvd.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.Application;
import com.joyscrum.model.Rule;
import ch.heigvd.gamification.to.RuleTO;
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
