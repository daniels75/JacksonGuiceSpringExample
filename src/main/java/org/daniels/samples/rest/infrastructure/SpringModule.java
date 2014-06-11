package org.daniels.samples.rest.infrastructure;

import org.daniels.samples.rest.repositories.contract.DummyRepository;
import org.daniels.samples.rest.repositories.contract.UserRepository;
import org.daniels.samples.rest.repositories.impl.mock.DummyMockRepositoryImpl;
import org.daniels.samples.rest.repositories.impl.mock.UserMockRepositoryImpl;
import org.daniels.samples.rest.service.contract.DummyService;
import org.daniels.samples.rest.service.contract.UserService;
import org.daniels.samples.rest.service.impl.DummyServiceImpl;
import org.daniels.samples.rest.service.impl.UserServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daniels.transaction.TransactionBo;
import com.google.inject.AbstractModule;
import com.google.inject.spring.SpringIntegration;

public class SpringModule extends AbstractModule {
    @Override
    protected void configure() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        bind(BeanFactory.class).toInstance(applicationContext);
        bind(TransactionBo.class).toProvider(SpringIntegration.fromSpring(TransactionBo.class, "transactionBo"));
       //  this doesnt work!
        // SpringIntegration.bindAll(binder(), applicationContext);
    }
}
