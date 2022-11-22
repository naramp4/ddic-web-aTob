package io.goorm.ddic;

import io.goorm.ddic.domain.Car;
import io.goorm.ddic.repository.CarRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@RunWith(SpringRunner.class)
@SpringBootTest
class DdicApplicationTests {
	@Autowired
	CarRepository carRepository;
	@Test
	@Transactional
	@Rollback(value = false)
	void contextLoads() throws IOException, ParseException {



		// 1. URL을 만들기 위한 StringBuilder.
		StringBuilder urlBuilder = new StringBuilder("https://open.jejudatahub.net/api/proxy/atDab6t8218btaa122b26DDtbatD86t1/o4eo6b7r31416er4je41oo7pj73676tp"); /*URL*/
		// 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
		urlBuilder.append("?" + URLEncoder.encode("number","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("limit","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8"));
		// 3. URL 객체 생성.
		URL url = new URL(urlBuilder.toString());
		// 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 5. 통신을 위한 메소드 SET.
		conn.setRequestMethod("GET");
		// 6. 통신을 위한 Content-type SET.
		conn.setRequestProperty("Content-type", "application/json");
		// 7. 통신 응답 코드 확인.
		System.out.println("Response code: " + conn.getResponseCode());
		// 8. 전달받은 데이터를 BufferedReader 객체로 저장.
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		// 10. 객체 해제.

		JSONParser parser = new JSONParser();
		// 2. 문자열을 JSON 형태로 JSONObject 객체에 저장.
		JSONObject obj = (JSONObject)parser.parse(rd.readLine());
		// 3. 필요한 리스트 데이터 부분만 가져와 JSONArray로 저장.
		JSONArray dataArr = (JSONArray) obj.get("data");
		JSONObject tmp = (JSONObject) dataArr.get(0);

		for (int i = 0; i < dataArr.size(); i++){
			Car car = new Car();
			tmp = (JSONObject) dataArr.get(i);
			car.setChargingPlace(tmp.get("chargingPlace").toString());
			car.setLatitude(tmp.get("latitude").toString());
			car.setLongitude(tmp.get("longitude").toString());
			carRepository.save(car);
		}
		rd.close();
		conn.disconnect();
	}

}
