package ifsp.edu.br.deuquadra.dtos.Locatario;

public class LoginResponse {
    public String authToken;
    public String refreshToken;

    public LoginResponse(String accessToken, String refreshToken){
        this.authToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
