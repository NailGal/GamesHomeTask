
import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static final String rootPath = "C://Users//Admin//Games/";
    public static File temp;
    public static File file;

    public static void main(String[] args) {

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



        GameProgress game1 = new GameProgress(50, 10, 1, 158.2);
        GameProgress game2 = new GameProgress(80, 30, 2, 100.1);
        GameProgress game3 = new GameProgress(100, 50, 3, 525.3);

        File gm1File = saveGames(rootPath + "savegames", "save_1.dat", game1);
        File gm2File = saveGames(rootPath + "savegames", "save_2.dat", game2);
        File gm3File = saveGames(rootPath + "savegames", "save_3.dat", game3);

        ArrayList<File> files = new ArrayList<>();
        files.add(gm1File);
        files.add(gm2File);
        files.add(gm3File);

        zipFiles(rootPath + "savegames", "savings.zip", files);

        deleteFiles(files);

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

    public static void zipFiles(String path, String nameZip, ArrayList<File> files) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(path, nameZip));
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {
            for (File file : files) {
                try (FileInputStream fileDataSaving = new FileInputStream(file)) { // Исправлено: поток закрывается автоматически
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    zipOutputStream.putNextEntry(zipEntry);

                    byte[] buffer = new byte[fileDataSaving.available()];
                    fileDataSaving.read(buffer);
                    zipOutputStream.write(buffer);

                    zipOutputStream.closeEntry();
                } // FileInputStream закрывается здесь
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFiles(ArrayList<File> files) {
        for (File fileToDelete : files) {
            if (fileToDelete.exists()) {
                boolean isDeleted = fileToDelete.delete();
                if (isDeleted) {
                    System.out.println("Файл удален.");
                } else {
                    System.out.println("Не удалось удалить файл.");
                }
            } else {
                System.out.println("Файл не найден.");
            }
        }
    }

    public static File saveGames(String filepath, String filename, GameProgress gameProgress) {
        File fileNameSave = new File(filepath, filename);

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileNameSave);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(gameProgress);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fileNameSave;
    }

}