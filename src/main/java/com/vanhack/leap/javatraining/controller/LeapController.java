package com.vanhack.leap.javatraining.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vanhack.leap.javatraining.client.SpotifyClient;
import com.vanhack.leap.javatraining.model.spotify.Items;
import com.vanhack.leap.javatraining.model.spotify.Query;
import com.vanhack.leap.javatraining.model.spotify.Token;

@RestController
@RequestMapping("/leap")
public class LeapController {

	@Autowired
	private SpotifyClient spotifyClient;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name") String name) {
		return "Hello " + name;
	}

	@GetMapping("/songs")
	@HystrixCommand(fallbackMethod = "tracksFallback")
	public ResponseEntity<?> getSongsOf(@RequestParam(value = "query") String query) {
		
		Token token = spotifyClient.getToken();
		Query queryResponse = spotifyClient.getTracksBy(query, token.getAccess_token());

		List<String> songs = new ArrayList<>();

		for (Items item : queryResponse.getTracks().getItems()) {
			songs.add(item.getName());
		}

		return new ResponseEntity<>(songs, HttpStatus.OK);
	}

	public ResponseEntity<?> tracksFallback(@RequestParam(value = "query") String query) {
		List<String> songs = new ArrayList<>();

		songs.add("SONG 1");
		songs.add("SONG 2");
		songs.add("SONG 3");
		songs.add("SONG 4");
		songs.add("SONG 5");

		return new ResponseEntity<>(songs, HttpStatus.OK);
	}

}
