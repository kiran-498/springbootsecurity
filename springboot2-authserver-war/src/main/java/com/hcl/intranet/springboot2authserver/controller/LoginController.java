package com.hcl.intranet.springboot2authserver.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.hcl.intranet.springboot2authserver.entity.Users;

@Controller
public class LoginController {
	
	@Autowired
	private TokenStore tokenStore;

	@GetMapping("/login")
	public String login(Model model,HttpServletRequest req) {  
model.addAttribute("username", "");  
model.addAttribute("password", "");  
//model.addAttribute("userAttributes", ""); 
System.out.println("user Name...." +req.getParameter("username"));
return "login"; 
		//return "login";
	}
	
	
	 @GetMapping
	    public String hello(Model model,HttpServletRequest req,SecurityContextHolder SecurityContextHolder/*,OAuth2Authentication auth1*/) {
	     
		 System.out.println("hellow world......"+req.getParameter("username"));
		 if (SecurityContextHolder != null && SecurityContextHolder.getContext().getAuthentication()!=null) {
			 SecurityContext securityContext = SecurityContextHolder.getContext();
			  /*  OAuth2AuthenticationToken oauth2Token = (OAuth2AuthenticationToken) 
			securityContext.getAuthentication();

			OAuth2AuthorizedClient client = clientService
			            .loadAuthorizedClient(oauth2Token.getAuthorizedClientRegistrationId(), 
			oauth2Token.getName());

			refreshToken = client.getRefreshToken().getTokenValue();*/
			// final OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth1.getDetails();
			    //token
			  //  String accessToken = details.getTokenValue();
			    //reference
			  //  final OAuth2AccessToken accessToken1 = tokenStore.readAccessToken(details.getTokenValue());
			   // clientid
			   // String clientId = auth1.getOAuth2Request().getClientId();
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			 auth.getDetails();
			 auth.getAuthorities();
			 Object pricipal = auth.getPrincipal();
			 String user="";
			 Users users = (Users)pricipal;
			 this.getOAuthTokenScopes();
			 
			 final OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth.getDetails();
			 String accessToken = details.getTokenValue();
			 final OAuth2AccessToken accessToken1 = tokenStore.readAccessToken(details.getTokenValue());
			 String clientId = ((OAuth2Authentication) auth).getOAuth2Request().getClientId();
			 
			 
			 this.getOauthToken(users);
		    }
		  return "index";
	    }
	 
	 @RequestMapping(value = "/perform_login", method = RequestMethod.POST)
	    public String performLogin(Model model,HttpServletRequest req) {
		// this.getOauthToken(model, req);
	        return "index";
	    }
	 
	 public String getOauthToken(Users user) {
			
		 if(user!=null ) {
			 
		
			// According OAuth documentation we need to send the client id and secret key in the header for authentication
			String credentials = "USER_CLIENT_APP:password";
			String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.add("Authorization", "Basic " + encodedCredentials);

//			HttpEntity<String> request = new HttpEntity<String>(headers);

			/*String access_token_url = "http://localhost:8080/oauth/token";
			access_token_url += "?code=" + code;
			access_token_url += "&grant_type=authorization_code";
			access_token_url += "&redirect_uri=http://localhost:8090/showEmployees";

			response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);*/
			
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
			map.add("username", user.getUsername());
			map.add("password",user.getPassword());
			map.add("grant_type", "password");

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

			RestTemplate restTemplate = new RestTemplate();
			String access_token_url = "http://localhost:8999/oauth/token";
			//ResponseEntity<String> response = restTemplate.postForEntity( access_token_url, request , String.class );

			//System.out.println("Access Token Response ---------" + response.getBody());
			//return response.getBody();
		 }
		 return "";
}
	 private Set<String> getOAuthTokenScopes() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    OAuth2Authentication oAuth2Authentication;

    if (authentication instanceof OAuth2Authentication) {
        oAuth2Authentication = (OAuth2Authentication) authentication;
    } else {
        throw new IllegalStateException("Authentication not supported!");
    }

    return oAuth2Authentication.getOAuth2Request().getScope();
}
}
