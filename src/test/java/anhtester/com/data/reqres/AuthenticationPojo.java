package anhtester.com.data.reqres;

import lombok.Data;

@Data
public class AuthenticationPojo {

    private String email;
    private String password;

    public AuthenticationPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }

}