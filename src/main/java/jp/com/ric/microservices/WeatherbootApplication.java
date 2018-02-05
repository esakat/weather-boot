package jp.com.ric.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WeatherbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherbootApplication.class, args);
	}
}

@RestController
class HomeController {
	@RequestMapping("/")
	public Weather getTodaysWeather() {
		return new Weather("晴れ");
	}
}

class Weather {
	private String info;
	public Weather(String info) {
		this.setInfo(info);
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}