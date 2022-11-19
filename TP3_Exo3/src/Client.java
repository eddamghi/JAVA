import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    @Getter @Setter private long id;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String address;
    @Getter @Setter private String phoneNumber;
    @Getter @Setter private String email;

}
