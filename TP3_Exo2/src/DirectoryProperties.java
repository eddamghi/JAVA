import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DirectoryProperties extends ObjectProperties {
    private final List<FileProperties> subFiles = new ArrayList<>();
    private final List<DirectoryProperties> subDirectories = new ArrayList<>();

    public DirectoryProperties(String path){
        var dir = new File(path);
        fullPath = dir.getAbsolutePath();
        name = dir.getName();
        isRead = dir.canRead();
        isWrite = dir.canWrite();
        isHidden = dir.isHidden();
        for (String itemName : Objects.requireNonNull(dir.list())) {
            String itemPath = fullPath + File.separator + itemName;
            var item = new File(itemPath);
            if (item.isFile()){
                subFiles.add(new FileProperties(itemPath));
            }
            if(item.isDirectory()){
                subDirectories.add(new DirectoryProperties(itemPath));
            }
        }
    }
    private String getSubItems(int level){
        var indentation = "\t".repeat(level + 1);
        return "" + subFiles.stream()
                .map(f -> indentation + f.getPermissionsString() + "\t<FILE>\t" + f.getName())
                .reduce("", (a, b) -> a + "\n" + b) +
                subDirectories.stream()
                        .map(d -> indentation + d.getPermissionsString() + "\t<DIR>\t" + d.getName() + File.separator + d.getSubItems(level + 1))
                        .reduce("", (a,b) -> a + "\n" +b);
    }
    public void ls(){
        System.out.println(this.fullPath + File.separator + getSubItems(0));
    }

}
