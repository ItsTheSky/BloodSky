package info.itsthesky.BloodSky.tools;

import java.util.HashMap;

public class GDB {

	private static HashMap<String, Object> database = new HashMap<>();

	public static HashMap<String, Object> getGlobalDataBase() {
		return database;
	}

	public static Object getValue(String key) {
		if (database.containsKey(key)) {
			return database.get(key);
		} else {
			return "none";
		}
  	}

	public static void setValue(String key, Object value) {
		database.put(key, value);
	}

	public static void removeValue(String key) {
		database.remove(key);
	}
}
