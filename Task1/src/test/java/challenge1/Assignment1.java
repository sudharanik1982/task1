package challenge1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Assignment1 {

	public void doesFileExist(String path) throws ParseException {
		try {
			File file = new File(path);
			if (file.exists() && !file.isDirectory()) {
				Object obj = new JSONParser().parse(new FileReader(path));
				JSONObject jsonObject = (JSONObject) obj;
				// Itr
				for (Object key : jsonObject.keySet()) {
					String keyStr = (String) key;
					Object keyvalue = jsonObject.get(keyStr);
					System.out.println(keyStr);
					String[] list = keyvalue.toString().split(",");
					for (String str : list)
						System.out.println(str.trim());

				}
			} else {
				throw new IOException("File not found");
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws ParseException {
		String path = ".//Resources//TestData.json";
		Assignment1 jr = new Assignment1();
		jr.doesFileExist(path);

	}

}
