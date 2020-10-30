package com.everis.d4i.tutorial.controller;

import com.everis.d4i.tutorial.controller.rest.CastRest;
import com.everis.d4i.tutorial.controller.rest.response.NetflixResponse;
import com.everis.d4i.tutorial.exception.NetflixException;

public interface CastController {

	NetflixResponse<CastRest[]> getCasts() throws NetflixException;

}
