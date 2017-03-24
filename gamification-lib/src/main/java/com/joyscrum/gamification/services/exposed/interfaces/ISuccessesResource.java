package com.joyscrum.gamification.services.exposed.interfaces;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.gamification.to.AppUserPublicTO;
import com.joyscrum.gamification.to.GenericOnlyIDTO;
import com.joyscrum.gamification.to.RuleTO;
import com.joyscrum.gamification.to.SuccessTO;
import java.util.List;
import javax.ejb.Remote;
import javax.ws.rs.core.Response;

/**
 * Interface for successes management. The methods inside can be called remotly
 * or with jax-rs rest api.
 *
 * @author Alexandre Perusset
 */
@Remote
public interface ISuccessesResource {

  public String createSuccess(SuccessTO successTO, String idApp) throws EntityNotFoundException;

  public void updateSuccess(SuccessTO successTO, String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public void deleteSuccess(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public void linkRuletoSuccess(GenericOnlyIDTO to, String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public void unlinkRuleFromSuccess(String id, String idRule, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public List<SuccessTO> getSuccesses(String idApp) throws EntityNotFoundException;

  public SuccessTO getSuccess(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public List<RuleTO> getSuccessRules(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public List<AppUserPublicTO> getSuccessUsers(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public Response restCreateSuccess(SuccessTO successTO, String idApp) throws EntityNotFoundException;

  public Response restUpdateSuccess(SuccessTO successTO, String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public Response restDeleteSuccess(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public Response restLinkRuletoSuccess(GenericOnlyIDTO to, String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public Response restUnlinkRuleFromSuccess(String id, String idRule, String idApp) throws EntityNotFoundException, UnauthorizedException;
}
