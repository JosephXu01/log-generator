package org.joseph.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class LogGeneratorApplication {


	public static Logger log = Logger.getLogger("LogGeneratorApplication");

	public static void main(String[] args) {
		SpringApplication.run(LogGeneratorApplication.class, args);

		for(;;){
			log.info("hello");
			try {
				sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
