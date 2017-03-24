package ch.heigvd.gamification.services.to;

import ch.heigvd.gamification.exceptions.EntityNotFoundException;
import ch.heigvd.gamification.exceptions.UnauthorizedException;
import com.joyscrum.model.Application;
import ch.heigvd.gamification.services.to.interfaces.IRulesTOService;
import com.joyscrum.model.Rule;
import ch.heigvd.gamification.services.crud.interfaces.IAppActionsManager;
import ch.heigvd.gamification.to.RuleTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Implementation of the rule transfert object management interface.
 *
 * @see IRulesTOService
 * @author Gaël Jobin
 */
@Stateless
public class RulesTOService implements IRulesTOService {

  @EJB
  IAppActionsManager actionsManager;

  @Override
  public RuleTO buildPublicRuleTO(Rule source) {
    return new RuleTO(
            source.getId().toHexString(),
            source.getName(),
            source.getDescription(),
            source.getGoalPoints(),
            source.getAction().getId().toHexString()
    );
  }

  /**
   *
   * @param existing
   * @param state
   * @param application
   * @throws EntityNotFoundException if the action does not exists
   * @throws UnauthorizedException action does not belong to application
   */
  @Override
  public void updateRuleEntity(Rule existing, RuleTO state, Application application) throws EntityNotFoundException, UnauthorizedException {
    existing.setName(state.getName());
    existing.setDescription(state.getDescription());
    existing.setGoalPoints(state.getGoalPoints());
    existing.setAction(actionsManager.findById(state.getActionID(), application));
    existing.setApplication(application);
  }
}
