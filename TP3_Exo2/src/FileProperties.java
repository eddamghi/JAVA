import lombok.Getter;

import java.io.File;

public class FileProperties extends ObjectProperties{
    public FileProperties(String path) {
        var file = new File(path);
        fullPath = file.getAbsolutePath();
        name = file.getName();
        isRead = file.canRead();
        isWrite = file.canWrite();
        isHidden = file.isHidden();
    }

}
