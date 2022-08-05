package curs14;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonProcessor {

	public void writeJson() {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "TestUser"); // name = TestUser
		obj.put("email", "testUser@test.com");
		
		JSONArray list = new JSONArray();
		list.add("Obiect 1");
		list.add("Obiect 2");
		list.add("Obiect 3");
		list.add("Obiect 4");
		list.add("Obiect 5");
		
		obj.put("listaDeObiecte", list);
		
		
		try(FileWriter file = new FileWriter("test.json")) {
			
			file.write(obj.toJSONString());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readJson(String key) {
		
		JSONParser parser = new JSONParser();
		try {
			
			FileReader reader = new FileReader("test.json");
			JSONObject jsonObj = (JSONObject) parser.parse(reader);
			System.out.println(jsonObj);
			
			String obiect = (String) jsonObj.get(key);  //cast catre string
			System.out.println("Key:" + obiect);
			
			JSONArray obj1 = (JSONArray) jsonObj.get("listaDeObiecte");
			System.out.println("Json Array " + obj1);
		
		}catch(Exception e) {
			
		}
	}
	
}
