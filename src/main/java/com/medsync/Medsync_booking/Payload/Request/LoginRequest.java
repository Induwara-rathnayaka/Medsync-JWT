package com.medsync.Medsync_booking.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank
	private String username;

	@NotBlank
	private String password;

}
