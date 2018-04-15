package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileManager {
	
	Gson gson = new GsonBuilder().create();
	
	public void loadLevel(int id) {
		String levelId = "00" + id;
		levelId = levelId.substring(levelId.length()-2);
		try (BufferedReader br = new BufferedReader(new FileReader("src/levels/" + levelId + ".txt"))) {
			String line;
			while((line = br.readLine()) != null) {
				//gson.fromJson(line, Class<Level>);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
