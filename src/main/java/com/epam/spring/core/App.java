package com.epam.spring.core;

import com.epam.spring.core.dao.AuditoriumDao;
import com.epam.spring.core.repository.Repository;
import com.epam.spring.core.service.AuditoriumService;
import com.epam.spring.core.service.BookingService;
import com.epam.spring.core.service.impl.BookingServiceImpl;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sergiy_Dakhniy
 */
public class App {

    public static void main(String args[]) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Repository repository = context.getBean(Repository.class);
        BookingService service = context.getBean(BookingServiceImpl.class);
        context.close();
    }
}
