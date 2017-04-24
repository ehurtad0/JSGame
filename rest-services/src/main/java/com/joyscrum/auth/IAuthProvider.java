package com.joyscrum.auth;

import com.joyscrum.models.Player;

/**
 * Created by jorge on 4/23/17.
 */
public interface IAuthProvider {

    Player logonPlayer(String origin, String token);
}
