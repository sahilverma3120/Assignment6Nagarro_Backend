package com.nagarro.advancejava.webpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class HelloWorldApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(HelloWorldApplication.class, args);
        System.out.println( "Hello World!" );
    }
}
