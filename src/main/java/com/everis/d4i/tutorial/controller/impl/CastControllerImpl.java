package com.everis.d4i.tutorial.controller.impl;


import com.everis.d4i.tutorial.controller.CastController;
import com.everis.d4i.tutorial.controller.mapper.CastRestMapper;
import com.everis.d4i.tutorial.controller.rest.CastRest;
import com.everis.d4i.tutorial.controller.rest.response.NetflixResponse;
import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.service.CastService;
import com.everis.d4i.tutorial.util.constant.CommonConstants;
import com.everis.d4i.tutorial.util.constant.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1)
@RequiredArgsConstructor
public class CastControllerImpl implements CastController {

	private final CastService castService;

	private final CastRestMapper castRestMapper;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.RESOURCE_CAST, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<CastRest[]> getCasts() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				castService.getAllCasts().parallelStream()
						.map(castRestMapper::mapToRest).toArray(CastRest[]::new));
	}


}
