package com.cts.digibook.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.digibook.jwtrequestandresponse.JwtRequest;
import com.cts.digibook.jwtrequestandresponse.JwtResponse;
import com.cts.digibook.jwtutil.JwtUtil;

@RestController
@RequestMapping("/api/v1/digitalbooks/authors")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	private Logger log = Logger.getLogger(JwtAuthenticationController.class);

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest request) {
		System.out.println("Trying to get authenticated++++++++++");
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Invalid Username!", e);
		}
		UserDetails ud = userDetailsService.loadUserByUsername(request.getUserName());
		String jwt = jwtUtil.generateToken(ud);
		log.info("JWT---" + jwt);
		return new ResponseEntity<JwtResponse>(new JwtResponse(jwt), HttpStatus.OK);
		// return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
