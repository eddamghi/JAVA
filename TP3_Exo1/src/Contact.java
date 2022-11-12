import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Contact {
    @Getter private String fullName;
    @Getter @Setter private String phoneNumber;
    @Override
    public boolean equals(Object object){
        if (this == object)
            return true;
        if (!(object instanceof Contact other))
            return false;
        return this.fullName.equals(other.getFullName()) && this.phoneNumber.equals(other.getPhoneNumber());
    }

}
