package br.com.ana.alves.araujo.pokemon.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClientHttp<T> {

	public T get(String url, Class<T> clazz) {

		HttpURLConnection connection = null;
		BufferedReader reader = null;
		String json = null;
		try {
			URL resetEndpoint = new URL(url);
			connection = (HttpURLConnection) resetEndpoint.openConnection();
			// Set request method to GET as required from the API
			connection.setRequestMethod("GET");
			connection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");

			// Read the response
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonSb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				jsonSb.append(line);
			}
			json = jsonSb.toString();

			// Converts JSON string to Java object
			ObjectMapper mapper = new ObjectMapper();
			// Converts to an array of Book
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}