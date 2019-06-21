package com.elca.fx.service.impl;

import org.springframework.stereotype.Service;

import com.elca.fx.service.PersonService;

/**
 *
 * @author bhr
 */
@Service
public class PersonServiceImpl implements PersonService {


    @Override
    public void printName(String name) {
        System.out.println(name);
    }
}

