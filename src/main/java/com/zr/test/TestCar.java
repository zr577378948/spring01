package com.zr.test;

import com.zr.entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestCar {
    public static void main(String[] args) {
       /* Car car = new Car();
        car.setBrand("BMW");
        car.setId(1);
        car.setPrice(100000.00);
        System.out.println(car);*/

        ApplicationContext app = new FileSystemXmlApplicationContext("src/main/resources/spring/applicationContext.xml");
        Car ca = app.getBean("myCar",Car.class);
        System.out.println(ca);
    }
}
