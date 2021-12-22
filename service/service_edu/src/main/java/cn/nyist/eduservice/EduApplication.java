package cn.nyist.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Fox
 * @date 2021/12/22 17:22
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.nyist"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
