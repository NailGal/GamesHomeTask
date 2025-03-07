
import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static final String rootPath = "C://Users//Admin//Games/";
    public static File temp;

    public static void main(String[] args) {
        createDirectoryTemp();
        createDirectorySrc();
        createDirectoryRes();
        createDirectorySaveGames();

        GameProgress gm1 = new GameProgress(50, 10, 1, 158.2);
        GameProgress gm2 = new GameProgress(80, 30, 2, 100.1);
        GameProgress gm3 = new GameProgress(100, 50, 3, 525.3);

        File gm1File = saveGames(rootPath + "savegames", "save_1.dat", gm1);
        File gm2File = saveGames(rootPath + "savegames", "save_2.dat", gm2);
        File gm3File = saveGames(rootPath + "savegames", "save_3.dat", gm3);

        ArrayList<File> files = new ArrayList<>();
        files.add(gm1File);
        files.add(gm2File);
        files.add(gm3File);

        zipFiles(rootPath + "savegames", "savings.zip", files);

        deleteFiles(files);

    }

    public static void zipFiles(String path, String nameZip, ArrayList<File> files) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(path, nameZip));
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)
        ) {
            for (var file : files) {
                FileInputStream fileDataSaving = new FileInputStream(file.getAbsoluteFile());
                ZipEntry zipEntry = new ZipEntry(file.getName());

                zipOutputStream.putNextEntry(zipEntry);

                byte[] buffer = new byte[fileDataSaving.available()];
                fileDataSaving.read(buffer);
                zipOutputStream.write(buffer);

                zipOutputStream.closeEntry();
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
                writeToFileTempFile(temp);
            }
        } catch (IOException e) {
            System.out.println("Файл temp.txt не создался");
        }

    }

    public static void writeToFileTemp(File file) {
        try (FileOutputStream fos = new FileOutputStream(temp, true)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Создан каталог " + file.getAbsolutePath() + "\n");
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
            sb.append("Создан файл " + file.getName() + " в каталоге " + file.getAbsolutePath() + "\n");
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