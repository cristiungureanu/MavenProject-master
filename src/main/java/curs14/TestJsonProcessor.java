package curs14;

public class TestJsonProcessor {

	public static void main(String[] args) {
		
		JsonProcessor obj = new JsonProcessor();
		obj.writeJson();
		obj.readJson("email");

	}

}
