package org.codice.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestServiceImpl implements RestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestServiceImpl.class);

    public RestServiceImpl() {

    }

    @SuppressWarnings("rawtypes")
    public void init() {

        LOGGER.trace("Initializing {}", RestServiceImpl.class.getName());
/*        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        factory.setAddress("http://localhost:8282/person");
        //factory.setResourceClasses(PersonServiceImpl.class);
        //factory.setResourceProvider(new SingletonResourceProvider(new PersonServiceImpl()));
        factory.setProvider(new JAXBElementProvider<>());
        Server server = factory.create();
        server.start();*/
    }

    @Override
    public String test(String name) {
        return "tst" + name;
    }

    @Override
    public void insert(String id) {

    }

    @Override
    public void update(String id, String value) {

    }

    @Override
    public void delete(String id) {

    }
}
