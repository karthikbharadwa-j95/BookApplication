package com.cts.digibook.jwtrequestandresponse;

import java.io.Serializable;


import lombok.Data;

@Data
public class JwtResponse implements Serializable{

	private final String jwtToken;
}

