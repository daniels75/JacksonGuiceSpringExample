package org.daniels.samples.rest.service.impl;

import org.daniels.samples.rest.domain.User;
import org.daniels.samples.rest.repositories.contract.DummyRepository;
import org.daniels.samples.rest.service.contract.DummyService;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DummyServiceImpl implements DummyService {

    private final DummyRepository dummyRepository;

    @Inject
    public DummyServiceImpl(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    @Override
    public User getDefaultUser() {
        Object defaultUser = this.dummyRepository.getDefaultUser();
        return this.dummyRepository.getDefaultUser();
    }

}
