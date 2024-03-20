package microservice65;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Microservice65Application extends SpringBootServletInitializer{
	public static void main(String[] args) {
			SpringApplication.run(Microservice65Application.class, args);
	}
	
	public static void deploy() throws UnknownHostException {
		new Microservice65Application().configure(new SpringApplicationBuilder(Microservice65Application.class)).run(InetAddress.getLocalHost().getHostAddress());
	}
}