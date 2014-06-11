package org.daniels.samples.rest.repositories.impl.mock;

import java.util.List;

import org.daniels.samples.rest.repositories.contract.Repository;

public abstract class GenericMockRepository<T> implements Repository<T> {

    @Override
    public List<T> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T getById(int id) {
        return (T) null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
