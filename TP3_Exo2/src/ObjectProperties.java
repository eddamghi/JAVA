import lombok.*;
public abstract class ObjectProperties {
    @Getter
    protected String fullPath;
    @Getter  protected String name;
    @Getter protected Boolean isRead;
    @Getter protected Boolean isWrite;
    @Getter protected Boolean isHidden;
    protected String getPermissionsString() {
        var output = "";
        if (isRead) output += "r";
        else  output += "-";
        if (isWrite) output += "w";
        else  output += "-";
        if (isHidden) output += "h";
        else  output += "-";
        return output;
    }


}
