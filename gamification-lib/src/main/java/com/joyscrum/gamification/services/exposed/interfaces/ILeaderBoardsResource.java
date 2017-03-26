package com.joyscrum.gamification.services.exposed.interfaces;

import com.joyscrum.gamification.exceptions.EntityNotFoundException;
import com.joyscrum.gamification.to.RankedAppUserTO;
import java.util.List;
import javax.ejb.Remote;

/**
 * Interface for leaderboard management. The method inside can be called remotly
 * or with jax-rs rest api.
 *
 * @author Alexandre Perusset
 */
@Remote
public interface ILeaderBoardsResource {

  public List<RankedAppUserTO> getLeaderboard(String idApp) throws EntityNotFoundException;
}
