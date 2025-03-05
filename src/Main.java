
import java.io.File;
import java.io.IOException;

public class Main {
    public static final String rootPath = "C://Users//Admin//Games/";

    public static void main(String[] args) {
        createDirectorySrc();
        createDirectoryRes();
        createDirectorySaveGames();
        createDirectoryTemp();

    }

    public static void createDirectoryTemp() {
        String srcPath = rootPath + "temp/";
        File createdSrcMain = new File(srcPath);
        if (createdSrcMain.mkdirs()) {
            System.out.println("Каталог temp создан");
        }
        try {
            File temp = new File(srcPath, "temp.txt");
            if (temp.createNewFile()) {
                System.out.println("Файл temp.txt создался");
            }
        } catch (IOException e) {
            System.out.println("Файл temp.txt не создался");
        }
    }

    public static void createDirectoryRes() {
        String srcPath = rootPath + "res/";
        File createdDrawables = new File(srcPath + "drawables");
        if (createdDrawables.mkdirs()) {
            System.out.println("Каталог res/drawables создан");
        }
        File createdVectors = new File(srcPath + "vectors");
        if (createdVectors.mkdirs()) {
            System.out.println("Каталог res/vectors создан");
        }
        File createdIcons = new File(srcPath + "icons");
        if (createdIcons.mkdirs()) {
            System.out.println("Каталог res/icons создан");
        }

    }

    public static void createDirectorySaveGames() {
        String srcPath = rootPath + "savegames/";
        File createdSrcMain = new File(srcPath);
        if (createdSrcMain.mkdirs()) {
            System.out.println("Каталог savegames создан");
        }
    }

    public static void createDirectorySrc() {
        String srcPath = rootPath + "src/";
        File createdSrcMain = new File(srcPath + "main");
        if (createdSrcMain.mkdirs()) {
            System.out.println("Каталог src/main создан");
        }

        try {
            File mainJava = new File(srcPath + "main/", "Main.java");
            if (mainJava.createNewFile()) {
                System.out.println("Файл Main.java создан");
            }
            File utilsJava = new File(srcPath + "main/", "Utils.java");
            if (utilsJava.createNewFile()) {
                System.out.println("Файл Utils.java создан");
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