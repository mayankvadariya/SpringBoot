package com.concordia.didemo;

import com.concordia.didemo.controllers.ConstructorInjectedController;
import com.concordia.didemo.controllers.GetterInjectedController;
import com.concordia.didemo.controllers.MyController;
import com.concordia.didemo.controllers.PropertyInjectedController;
import com.concordia.didemo.examplebeans.FakeDataSource;
import com.concordia.didemo.examplebeans.FakeJmsBrocker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getPassword());

        FakeJmsBrocker fakeJmsBrocker = (FakeJmsBrocker) ctx.getBean(FakeJmsBrocker.class);
        System.out.println(fakeJmsBrocker.getUsername());
    }
}
