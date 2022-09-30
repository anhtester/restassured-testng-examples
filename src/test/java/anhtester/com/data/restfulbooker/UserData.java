package anhtester.com.data.restfulbooker;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserData {

    private String name;
    private String job;

}