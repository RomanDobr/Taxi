package org.javaacademy.taxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Runner {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Runner.class, args);
		Taxi taxi = context.getBean(Taxi.class);
		Client client1 = new Client(Address.CANDICLE);
		Client client2 = new Client(Address.BUILDER);
		Client client3 = new Client(Address.BIRCH_GROVE);
		Client client4 = new Client(Address.LOMONOSOV);

		taxi.takeOrder(client1, false);
		taxi.takeOrder(client2, false);
		taxi.takeOrder(client3, true);
		taxi.takeOrder(client4, true);
		context.close();

	}

}
