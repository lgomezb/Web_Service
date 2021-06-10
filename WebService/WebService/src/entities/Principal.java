package entities;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


import webservice.WebServiceAlta;


@WebListener
public class Principal implements ServletContextListener{
	
	
	//Pool de hilos
	ThreadPool tp = new ThreadPool();
	//Función que realiza lo que hay en su interior cuando se levanta el servidor
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
		
		ServletContext ctx = servletContextEvent.getServletContext();
        tp.start();
    }
	
	//Función que realiza lo que hay en su interior antes de cerrar el servidor
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        tp.stop();
        System.out.println("adios");

        
    }
}


