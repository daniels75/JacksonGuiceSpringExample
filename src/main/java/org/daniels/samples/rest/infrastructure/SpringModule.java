package org.daniels.samples.rest.infrastructure;

import org.hibernate.SessionFactory;
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
        bind( SessionFactory.class ).toProvider( SpringIntegration.fromSpring( SessionFactory.class, "sessionFactory" ) );
        
       //  this doesn't work!
        // SpringIntegration.bindAll(binder(), applicationContext);
    }
}
