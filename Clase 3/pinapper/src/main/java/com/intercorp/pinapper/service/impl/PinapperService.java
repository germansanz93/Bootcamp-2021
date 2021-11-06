package com.intercorp.pinapper.service.impl;

import com.intercorp.pinapper.controller.request.PinapperRequest;
import com.intercorp.pinapper.domain.mappers.PinapperMapper;
import com.intercorp.pinapper.domain.model.Pinapper;
import com.intercorp.pinapper.exceptions.PinapperExistException;
import com.intercorp.pinapper.exceptions.PinapperNotExistException;
import com.intercorp.pinapper.repository.PinapperRepository;
import com.intercorp.pinapper.service.IPinapperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.*;

@Slf4j
@Service
public class PinapperService implements IPinapperService {

    @Autowired
    private PinapperMapper pinapperMapper;

    @Autowired
    private PinapperRepository pinapperRepository;

    @Qualifier("pinappers")
    @Autowired
    private List<Pinapper> pinappers;

    private Map<Long, Pinapper> pinapperMap = new HashMap<>();

    @PostConstruct
    public void init() {
        //se ejecuta solo una vez cuando se crea el Bean
        pinappers.stream().forEach(pinapper -> {
            pinapperRepository.save(pinapper);

        });
    }

    public Pinapper getPinapper(Long id) {
        return pinapperRepository.findById(id).get();
    }

    public Pinapper deletePinapper(Long id) {
        pinapperRepository.deleteById(id);
        return null;
    }

    public Iterable<Pinapper> getPinappers() {
        return pinapperRepository.findAll();
    }

    public Pinapper createPinapper(PinapperRequest request) {
        Pinapper pinapper = pinapperMapper.apply(request);
        if (request.getId() != null && pinapperRepository.findById(request.getId()) != null) {
            log.error("El Pinnaper ya existe");
            throw new PinapperExistException("El Pinnaper ya existe");
        } else {
            pinapperRepository.save(pinapperMapper.apply(request));
        }

        return pinapper;
    }

    @Override
    public Pinapper editPinapper(PinapperRequest request, Long id) {
        Pinapper pinapper = null;
        if (pinapperRepository.findById(id) != null) {
            pinapper = pinapperMapper.apply(request);
            pinapper.setId(id);
            pinapperRepository.save(pinapper);
        } else {
            log.error("El Pinnaper NO existe");
            throw new PinapperNotExistException("El Pinnaper NO existe");
        }
        return pinapper;
    }


}
