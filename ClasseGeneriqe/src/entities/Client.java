package entities;

import lombok.Getter;

import java.io.Serializable;

public class Client implements Serializable {
    @Getter private long id;
    @Getter private String firstName;
    @Getter private String lastName;
    @Getter private String address;
    @Getter private String phoneNumber;
    @Getter private String email;

}
