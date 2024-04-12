package org.sir.erplain.zsecurity.ws.restapi;

import org.sir.erplain.zsecurity.entity.Authority;
import org.sir.erplain.zsecurity.entity.Role;
import org.sir.erplain.zsecurity.entity.AppUser;
import org.sir.erplain.zsecurity.utils.SecurityParams;
import org.sir.erplain.zsecurity.jwt.JwtUtils;
import org.sir.erplain.zsecurity.ws.dto.request.LoginRequest;
import org.sir.erplain.zsecurity.ws.dto.response.JwtResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/login")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        AppUser userDetails = (AppUser) authentication.getPrincipal();
        List<String> authorities = userDetails
                .getAuthorities()
                .stream().map(Authority::getAuthority)
                .toList();

        JwtResponse response = new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), authorities);
        return ResponseEntity.ok(response);
    }
}
