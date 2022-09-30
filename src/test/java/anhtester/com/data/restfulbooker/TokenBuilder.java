package anhtester.com.data.restfulbooker;

public class TokenBuilder {

    public static Tokencreds getToken() {
        return Tokencreds.builder()
                .username("admin")
                .password("password123")
                .build();
    }

}