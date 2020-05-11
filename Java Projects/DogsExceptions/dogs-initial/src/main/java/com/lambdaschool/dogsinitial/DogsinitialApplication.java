package com.lambdaschool.dogsinitial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
// inorder to catch an endpoint that doesnt exist we have to enable this ^ as well as some front end work
@SpringBootApplication
public class DogsinitialApplication
{

    public static DogList ourDogList;
    // setting this to public allows controller to see ourDogList
    public static void main(String[] args)
    {
        ourDogList = new DogList();
        ApplicationContext ctx = SpringApplication.run(DogsinitialApplication.class, args);

        // in the background spring runs a dispatch servlet that handles all of our routing for us
        // so we send it an endpoint and it finds where it goes and runs the proper method. IF it doesnt find one, it has its own method for that.
        // lets use ours instead.
        // we added ApplicationContext ctx =

        DispatcherServlet dispatcherServlet = (DispatcherServlet)ctx.getBean("dispatcherServlet");
        // remember a bean is an java object (json). if this is spelled wrong theres no error checking for this. get it right every time.
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        // when we dont find an endpoint we will handle it not the dispatcher servlet



    }

}

