package com.intercorp.pinapper.service;

import com.intercorp.pinapper.controller.request.PinapperRequest;
import com.intercorp.pinapper.domain.model.Pinapper;

import java.util.List;

public interface IPinapperService {

    Pinapper getPinapper(Long id);

    List<Pinapper> getPinappers();

    Pinapper createPinapper(PinapperRequest request);

    Pinapper editPinapper(PinapperRequest request, Long id);

    Pinapper deletePinapper(Long id);

}
