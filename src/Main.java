
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static final String rootPath = "C://Users//Admin//Games/";
    public static File temp;
    public static File file;

    public static void main(String[] args) {
//        createDirectoryTemp();
//        createDirectorySrc();
//        createDirectoryRes();
//        createDirectorySaveGames();
        // Создание папки temp
        createDirectoryTemp(rootPath + "temp/");
        createFileTemp(rootPath + "temp/", "temp.txt");
        createDirectory(rootPath + "src/");
        createDirectory(rootPath + "src/");
        createDirectory(rootPath + "src/main/");
        createDirectory(rootPath + "src/test/");
        createFile(rootPath + "src/main/", "main.java");
        createFile(rootPath + "src/main/", "Utils.java");
        createDirectory(rootPath + "res/");
        createDirectory(rootPath + "res/drawables");
        createDirectory(rootPath + "res/vectors");
        createDirectory(rootPath + "res/icons");
        createDirectory(rootPath + "savegames/");
    }

    public static void createDirectoryTemp(String path) {
        StringBuilder sbDir = new StringBuilder(); // Создаем StringBuilder внутри метода в момент создания файла*
        File createDir = new File(path);
        if (createDir.mkdirs()) {
            sbDir.append("Создан каталог " + createDir.getName() + ", путь: " + createDir.getAbsolutePath()+ "\n");
            System.out.println("Каталог " + createDir.getName()+ " создан");
        }
    }

    public static void createFileTemp(String pathFile, String nameFile){
        StringBuilder sbFile = new StringBuilder();
        try {
            temp = new File(pathFile, nameFile);
            if (temp.createNewFile()) {
                sbFile.append("Создан файл " + temp.getName() + " " + temp.getAbsolutePath()+ "\n");
                System.out.println("Файл temp.txt создался");
            }
        } catch (IOException e) {
            System.out.println("Файл temp.txt не создался");
        }
    }
    // Один общий метод для создания папок (Директорий)
    public static void createDirectory(String path) {
        StringBuilder sbDir = new StringBuilder(); // Создаем StringBuilder внутри метода в момент создания файла*
        File createDir = new File(path);
        if (createDir.mkdirs()) {
            sbDir.append("Создан каталог " + createDir.getName() + ", путь: " + createDir.getAbsolutePath()+ "\n");
            writeToFileTempDir(sbDir);
            System.out.println("Каталог " + createDir.getName()+ " создан");
        }
    }

    // Метод для создания файлов
    public static void createFile(String pathFile, String nameFile){
        StringBuilder sbFile = new StringBuilder();
        try {
            file = new File(pathFile, nameFile);
            if (file.createNewFile()) {
                sbFile.append("Создан файл " + file.getName() + " " + file.getAbsolutePath()+ "\n");
                writeToFileTempFile(sbFile);
                System.out.println("Файл "+ file.getName() + " создался");
            }
        } catch (IOException e) {
            System.out.println("Файл temp.txt не создался");
        }
    }

    public static void writeToFileTempDir(StringBuilder sb) {
        try (FileOutputStream fos = new FileOutputStream(temp, true)) {
            String text = sb.toString();
            byte[] buffer = text.getBytes();
            fos.write(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeToFileTempFile(StringBuilder sb) {
        try (FileOutputStream fos = new FileOutputStream(temp, true)) {
            String text = sb.toString();
            byte[] buffer = text.getBytes();
            fos.write(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    public static void createDirectoryTemp() {
        String tempPath = rootPath + "temp/"; // tempPath = C://Users//Admin//Games/temp/
        File createdTemp = new File(tempPath);
        if (createdTemp.mkdirs()) {
            System.out.println("Каталог temp создан");
        }

        try {
            file = new File(createdTemp, "temp.txt");  // temp - это объект типа File, созданный в самом начале
            if (file.createNewFile()) { // Команда для создания файла, находится в условии проверки
                System.out.println("Файл temp.txt создался");
                writeToFileTemp(createdTemp);
            }
        } catch (IOException e) {
            System.out.println("Файл temp.txt не создался");
        }

    }
    */

    public static void writeToFileTemp(File file) {
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Создан каталог " + file.getAbsolutePath()+ "\n");
            String text = sb.toString();
            byte[] buffer = text.getBytes();
            fos.write(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    public static void writeToFileTempFile(File file) {
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Создан файл " + file.getName()+ " в каталоге "+ file.getAbsolutePath()+"\n");
            String text = sb.toString();
            byte[] buffer = text.getBytes();
            fos.write(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
     */

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
/*
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
    }*/
}