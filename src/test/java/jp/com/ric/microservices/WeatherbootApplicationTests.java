package jp.com.ric.microservices;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherbootApplicationTests {

	@Test
	public void testCreateWeatherInfo() {
		Weather weather = new Weather("晴れ");
		assertEquals("晴れ", weather.getInfo());
	}

}
