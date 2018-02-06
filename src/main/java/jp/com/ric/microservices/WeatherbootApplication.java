package jp.com.ric.microservices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WeatherbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherbootApplication.class, args);
	}
}

@RestController
class WeatherController {
	@RequestMapping("/weather/")
	public Weather getTodaysWeather() throws IOException {
		return new Weather();
	}
}

class Weather {
	private String info;
	private int temperature;
	public Weather() throws IOException {
		Resource resource = new ClassPathResource("static/temperature.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		String line = reader.readLine();
		reader.close();
		String[] weatherdata = line.split("\\,",0);
		this.setInfo(weatherdata[0]);
		this.setTemperature(Integer.parseInt(weatherdata[1]));
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
}