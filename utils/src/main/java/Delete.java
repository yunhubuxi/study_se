import java.io.File;

public class Delete {
    public static void main(String[] args) {


    }
    public static void deleteRemoteRepositories(File file) {
        if (null == file) {
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File childFile : files) {
                    deleteRemoteRepositories(childFile);
                }
            }
        } else {
            if (file.getName().equals("_remote.repositories")) {
                System.out.println(file.getAbsolutePath());
                file.delete();
            }
        }
    }

    public static void deleteLastUpdated(File file) {
        if (null == file) {
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File childFile : files) {
                    deleteLastUpdated(childFile);
                }
            }
        } else {
            if (file.getName().endsWith(".lastUpdated")) {
                System.out.println(file.getAbsolutePath());
                file.delete();
            }
        }
    }

}
