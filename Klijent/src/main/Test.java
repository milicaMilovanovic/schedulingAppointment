package main;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import paket.TerminType;
import paketSminkerski.MusterijaType;


public class Test {

	public static void main(String [] args) throws Exception {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//get
//		URL url = new URL("http://localhost:8080/RestZakazivanje/rest/frizer/all");
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//		conn.connect();
//		InputStream in = conn.getInputStream();
//
//		ObjectMapper mapper = new ObjectMapper();
//		List<FrizerType> frizeri = mapper.readValue(in,
//				mapper.getTypeFactory().constructCollectionType(List.class, FrizerType.class));
//
//		for (FrizerType f : frizeri)
//			System.out.println(f.getId());
//
//		conn.disconnect();
		
		//post
//		URL url = new URL("http://localhost:8080/RestZakazivanje/rest/terminFrizerski/zakazi");
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("POST");
//		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//		conn.setRequestProperty("charset", "utf-8");
//		conn.setDoOutput(true);
//		conn.connect();
//		
//		StringBuffer queryParam = new StringBuffer();
//		queryParam.append("id=");
//		queryParam.append(7);
//		queryParam.append("&");
//		queryParam.append("idMusterija=");
//		queryParam.append(1);
//		queryParam.append("&");
//		queryParam.append("farbanje=");
//		queryParam.append(true);
//		queryParam.append("&");
//		queryParam.append("sisanje=");
//		queryParam.append(true);
//		queryParam.append("&");
//		queryParam.append("feniranje=");
//		queryParam.append(true);
//		
//		
//		OutputStream output = conn.getOutputStream();
//		output.write(queryParam.toString().getBytes());
//		output.flush();
//		
//		conn.connect();
//		InputStream in = conn.getInputStream();
//
//		ObjectMapper mapper = new ObjectMapper();
//		boolean uspelo = mapper.readValue(in, mapper.getTypeFactory().constructType(Boolean.class));
//		conn.disconnect();
//		System.out.println("Uspeloooooooo " + uspelo);
//		System.out.println("ispis");
		
		URL url = new URL("http://localhost:8080/RestZakazivanje/rest/terminSminkerski/login");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("charset", "utf-8");
		conn.setDoOutput(true);
		conn.connect();
		
		StringBuffer queryParam = new StringBuffer();
		queryParam.append("ime=");
		queryParam.append("ime");
		queryParam.append("&");
		queryParam.append("password=");
		queryParam.append("ime");
		
		OutputStream output = conn.getOutputStream();
		output.write(queryParam.toString().getBytes());
		output.flush();
		
		conn.connect();
		InputStream in = conn.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		MusterijaType musterija = mapper.readValue(in, mapper.getTypeFactory().constructType(MusterijaType.class));
		System.out.println(musterija.getIme());
		conn.disconnect();
		
	}
	
}