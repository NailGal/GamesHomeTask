
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
        String tempPath = rootPath + "temp/";
        File createdTemp = new File(tempPath);
        if (createdTemp.mkdirs()) {
            System.out.println("Каталог temp создан");
        }

        try {
            temp = new File(createdTemp, "temp.txt");
            if (temp.createNewFile()) {
                System.out.println("Файл temp.txt создался");
                writeToFileTemp(createdTemp);
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

    public static void writeToFileTempFile(File file) {
        try (FileOutputStream fos = new FileOutputStream(temp, true)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Создан файл " + file.getName()+ " в каталоге "+ file.getAbsolutePath()+"\n");
            String text = sb.toString();
            byte[] buffer = text.getBytes();
            fos.write(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    public static void createDirectoryRes() {
        String resPath = rootPath + "res/";
        // Создание папки res
        File resPathDir = new File(resPath);
        if (resPathDir.mkdirs()) {
            System.out.println("Каталог res/ создан");
            try {
                writeToFileTemp(resPathDir);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        //Создание папки drawables
        File createdDrawables = new File(resPath + "drawables");
        if (createdDrawables.mkdirs()) {
            System.out.println("Каталог res/drawables создан");
            try {
                writeToFileTemp(createdDrawables);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        // создание папки vectors
        File createdVectors = new File(resPath + "vectors");
        if (createdVectors.mkdirs()) {
            System.out.println("Каталог res/vectors создан");
            try {
                writeToFileTemp(createdVectors);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        // создание папки icons
        File createdIcons = new File(resPath + "icons");
        if (createdIcons.mkdirs()) {
            System.out.println("Каталог res/icons создан");
            try {
                writeToFileTemp(createdIcons);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void createDirectorySaveGames() {
        String saveGamePath = rootPath + "savegames/";
        File createdSaveGamesDir = new File(saveGamePath);
        if (createdSaveGamesDir.mkdirs()) {
            System.out.println("Каталог savegames создан");
            try {
                writeToFileTemp(createdSaveGamesDir);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void createDirectorySrc() {
        String srcPath = rootPath + "src/";
        File srcPathDir = new File(srcPath);
        if (srcPathDir.mkdirs()) {
            System.out.println("Каталог src/ создан");
            try {
                writeToFileTemp(srcPathDir);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
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
                try {
                    writeToFileTempFile(mainJava);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            File utilsJava = new File(srcPath + "main/", "Utils.java");
            if (utilsJava.createNewFile()) {
                System.out.println("Файл Utils.java создан");
                try {
                    writeToFileTempFile(utilsJava);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            System.out.println("В ходе создания файлов произошла ошибка");
        }

        File createdSrcTest = new File(srcPath + "test");
        if (createdSrcTest.mkdirs()) {
            System.out.println("Каталог src/test создан");
            try {
                writeToFileTemp(createdSrcTest);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}