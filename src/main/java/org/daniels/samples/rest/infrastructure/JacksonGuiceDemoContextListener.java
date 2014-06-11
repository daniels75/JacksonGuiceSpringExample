package org.daniels.samples.rest.infrastructure;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.daniels.samples.rest.web.rest.ResponseCorsFilter;

public class JacksonGuiceDemoContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {

            @Override
            protected void configureServlets() {

                super.configureServlets();

                // Configuring Jersey via Guice:
                ResourceConfig resourceConfig = new PackagesResourceConfig("org/daniels/samples/rest/web");
                for (Class<?> resource : resourceConfig.getClasses()) {
                    bind(resource);
                }

                // hook Jackson into Jersey as the POJO <-> JSON mapper
                bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);

                serve("/web/*").with(GuiceContainer.class);

                filter("/web/*").through(ResponseCorsFilter.class);
            }
        }, new UserModule(), new SpringModule());
    }
}
