package anhtester.com.data.restfulbooker;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class Tokencreds {
    private String username;
    private String password;

}