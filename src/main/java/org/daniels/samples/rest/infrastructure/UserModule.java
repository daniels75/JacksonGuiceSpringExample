package org.daniels.samples.rest.infrastructure;

import org.daniels.samples.rest.repositories.contract.DummyRepository;
import org.daniels.samples.rest.repositories.contract.UserRepository;
import org.daniels.samples.rest.repositories.impl.mock.DummyMockRepositoryImpl;
import org.daniels.samples.rest.repositories.impl.mock.UserMockRepositoryImpl;
import org.daniels.samples.rest.service.contract.DummyService;
import org.daniels.samples.rest.service.contract.UserService;
import org.daniels.samples.rest.service.impl.DummyServiceImpl;
import org.daniels.samples.rest.service.impl.UserServiceImpl;

import com.google.inject.AbstractModule;

public class UserModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DummyRepository.class).to(DummyMockRepositoryImpl.class);
        bind(DummyService.class).to(DummyServiceImpl.class);

        bind(UserRepository.class).to(UserMockRepositoryImpl.class);
        bind(UserService.class).to(UserServiceImpl.class);
    }
}
