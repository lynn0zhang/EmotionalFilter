import java.io.File;
import java.util.ArrayList;

/**
 * Created by kaiyanglyu on 12/1/16.
 */
public class FilesRename {
    public static void main(String args[]) {
        FilesRename rename = new FilesRename();
        rename.filesRename();

    }

    public void filesRename() {
        ArrayList<String> Paths = new ArrayList<>();
        Paths.add(Path.business);
        Paths.add(Path.entertainment);
        Paths.add(Path.politics);
        Paths.add(Path.sport);
        Paths.add(Path.tech);
        String[] abbr = {"B", "E", "P", "S", "T"};
        for (String path : Paths) {
            File[] files = new File(path).listFiles();
            for (File file : files) {
                file.renameTo(new File("RawDataSets//Merge//" + abbr[Paths.indexOf(path)] + file.getName()));
            }
        }

    }
}
