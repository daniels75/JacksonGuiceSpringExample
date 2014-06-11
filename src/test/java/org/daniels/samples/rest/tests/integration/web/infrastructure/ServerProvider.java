package org.daniels.samples.rest.tests.integration.web.infrastructure;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.guice.spi.container.GuiceComponentProviderFactory;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.daniels.samples.rest.repositories.contract.DummyRepository;
import org.daniels.samples.rest.repositories.contract.UserRepository;
import org.daniels.samples.rest.repositories.impl.mock.DummyMockRepositoryImpl;
import org.daniels.samples.rest.repositories.impl.mock.UserMockRepositoryImpl;
import org.daniels.samples.rest.service.contract.DummyService;
import org.daniels.samples.rest.service.contract.UserService;
import org.daniels.samples.rest.service.impl.DummyServiceImpl;
import org.daniels.samples.rest.service.impl.UserServiceImpl;
import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.core.UriBuilder;

import java.io.IOException;
import java.net.URI;

public class ServerProvider {

    private final URI BASE_URI = getBaseURI();
    private HttpServer server;

    protected URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(9998).build();
    }

    public void createServer() throws IOException {
        System.out.println("Starting grizzly...");

        Injector injector = Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(UserService.class).to(UserServiceImpl.class);
                bind(UserRepository.class).to(UserMockRepositoryImpl.class);
                bind(DummyService.class).to(DummyServiceImpl.class);
                bind(DummyRepository.class).to(DummyMockRepositoryImpl.class);

                // hook Jackson into Jersey as the POJO <-> JSON mapper
                bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);
            }
        });

        ResourceConfig rc = new PackagesResourceConfig("org.daniels");
        IoCComponentProviderFactory ioc = new GuiceComponentProviderFactory(rc, injector);
        server = GrizzlyServerFactory.createHttpServer(BASE_URI + "web/", rc, ioc);

        System.out.println(String.format("Jersey app started with WADL available at "
                + "%srest/application.wadl\nTry out %sngdemo\nHit enter to stop it...",
                BASE_URI, BASE_URI));
    }

    public void stop() {
        server.stop();
    }
}
