package com.joyscrum.gamification.services.exposed.interfaces;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.exceptions.UnauthorizedException;
import com.joyscrum.gamification.to.AppUserPublicTO;
import com.joyscrum.gamification.to.AppUserTO;
import com.joyscrum.gamification.to.EventTO;
import com.joyscrum.gamification.to.SuccessTO;

import java.util.List;
import javax.ejb.Remote;
import javax.ws.rs.core.Response;

/**
 * Interface for user management. The methods inside can be called remotly or
 * with jax-rs rest api.
 *
 * @author Alexandre Perusset
 */
@Remote
public interface IAppUsersResource {

  public String createUser(AppUserTO userTO, String idApp) throws EntityNotFoundException;

  public void updateUser(AppUserTO userTO, String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public void deleteUser(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public List<AppUserPublicTO> getAllUsers(String idApp) throws EntityNotFoundException;

  public AppUserPublicTO getUser(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public List<SuccessTO> getUserSuccesses(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public List<EventTO> getUserEvents(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public Response restCreateUser(AppUserTO userTO, String idApp) throws EntityNotFoundException;

  public Response restUpdateUser(AppUserTO userTO, String id, String idApp) throws EntityNotFoundException, UnauthorizedException;

  public Response restDeleteUser(String id, String idApp) throws EntityNotFoundException, UnauthorizedException;
}
