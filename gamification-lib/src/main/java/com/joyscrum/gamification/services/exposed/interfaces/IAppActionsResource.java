package com.joyscrum.gamification.services.exposed.interfaces;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.gamification.to.AppActionTO;
import java.util.List;
import javax.ejb.Remote;
import javax.ws.rs.core.Response;

/**
 * Interface for actions management. The methods inside can be called remotly or
 * with jax-rs rest api.
 *
 * @author Alexandre Perusset
 */
@Remote
public interface IAppActionsResource {

  public String createAction(AppActionTO actionTO, String idApp) throws EntityNotFoundException;

  public void updateAction(AppActionTO actionTO, String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public void deleteAction(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public List<AppActionTO> getActions(String idApp) throws EntityNotFoundException;

  public AppActionTO getAction(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public Response restCreateAction(AppActionTO actionTO, String idApp) throws EntityNotFoundException;

  public Response restUpdateAction(AppActionTO actionTO, String  id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public Response restDeleteAction(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;
}
