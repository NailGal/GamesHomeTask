
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static final String rootPath = "C://Users//Admin//Games/";
    public static File temp;

    public static void main(String[] args) {
        createDirectoryTemp();
        createDirectorySrc();
        createDirectoryRes();
        createDirectorySaveGames();


    }

    public static void createDirectoryTemp() {
        String srcPath = rootPath + "temp/";
        File createdSrcMain = new File(srcPath);
        if (createdSrcMain.mkdirs()) {
            System.out.println("Каталог temp создан");

        }

        try {
            temp = new File(srcPath, "temp.txt");
            if (temp.createNewFile()) {
                System.out.println("Файл temp.txt создался");
                writeToFileTemp(createdSrcMain);
            }
        } catch (IOException e) {
            System.out.println("Файл temp.txt не создался");
        }

    }

    public static void writeToFileTemp(File file) {
        try (FileOutputStream fos = new FileOutputStream(temp, true)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Создан каталог " + file.getAbsolutePath()+ "\n");
            String text = sb.toString();
            byte[] buffer = text.getBytes();
            fos.write(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createDirectoryRes() {
        String srcPath = rootPath + "res/";
        File createdDrawables = new File(srcPath + "drawables");
        if (createdDrawables.mkdirs()) {
            System.out.println("Каталог res/drawables создан");
            try {
                writeToFileTemp(createdDrawables);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        File createdVectors = new File(srcPath + "vectors");
        if (createdVectors.mkdirs()) {
            System.out.println("Каталог res/vectors создан");
            try {
                writeToFileTemp(createdVectors);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        File createdIcons = new File(srcPath + "icons");
        if (createdIcons.mkdirs()) {
            System.out.println("Каталог res/icons создан");
            //writeToFileTemp(createdIcons);
        }
    }

    public static void createDirectorySaveGames() {
        String srcPath = rootPath + "savegames/";
        File createdSrcMain = new File(srcPath);
        if (createdSrcMain.mkdirs()) {
            System.out.println("Каталог savegames создан");
            try {
                writeToFileTemp(createdSrcMain);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void createDirectorySrc() {
        String srcPath = rootPath + "src/";
        File createdSrcMain = new File(srcPath + "main");
        if (createdSrcMain.mkdirs()) {
            System.out.println("Каталог src/main создан");
            try {
                writeToFileTemp(createdSrcMain);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        try {
            File mainJava = new File(srcPath + "main/", "Main.java");
            if (mainJava.createNewFile()) {
                System.out.println("Файл Main.java создан");
                //writeToFileTemp(mainJava);
            }
            File utilsJava = new File(srcPath + "main/", "Utils.java");
            if (utilsJava.createNewFile()) {
                System.out.println("Файл Utils.java создан");
                //writeToFileTemp(utilsJava);
            }
        } catch (IOException e) {
            System.out.println("В ходе создания файлов произошла ошибка");
        }

        File createdSrcTest = new File(srcPath + "test");
        if (createdSrcTest.mkdirs()) {
            System.out.println("Каталог src/test создан");

        }
    }
}