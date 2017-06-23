package web._02_login.model;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;

import web._00_init.GlobalService;

public class OAuth_DeCode {

	public static GoogleIdToken.Payload getPayload_From_ID_Token(String tokenString) throws Exception {

		JacksonFactory jacksonFactory = new JacksonFactory();
		GoogleIdTokenVerifier googleIdTokenVerifier = new GoogleIdTokenVerifier(new NetHttpTransport(), jacksonFactory);

		GoogleIdToken token = GoogleIdToken.parse(jacksonFactory, tokenString);

		if (googleIdTokenVerifier.verify(token)) {
			GoogleIdToken.Payload payload = token.getPayload();
			if (!(GlobalService.getGoogleClientId()).equals(payload.getAudience())) {
				throw new IllegalArgumentException("Audience mismatch");
			} else if (!(GlobalService.getGoogleClientId()).equals(payload.getAuthorizedParty())) {
				throw new IllegalArgumentException("Client ID mismatch");
			}
			return payload;
		} else {
			throw new IllegalArgumentException("id token cannot be verified");
		}
	}
}