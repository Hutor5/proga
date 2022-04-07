package file;

import exceptions.*;

import java.io.*;

public class FileManager implements ReadWriteAble {
        private FileReader fileReader;
        private String path;

        public FileManager(String pth){
            path = pth;
        }
        public void setPath(String pth){
            path = pth;
        }

        public FileManager(){
            path = null;
        }
        public String read()
        {
            String str = "";
            try {
                if (path == null) throw new EmptyPathException();
                //FileReader reader = null;
                File file = new File(path);
                if (!file.exists()) throw new FileNotExistsException();
                if(!file.canRead()) throw new FileWrongPermissionsException("Невозможно прочесть файл");
                fileReader = new FileReader(file);
                int currectSymbol;
                while ((currectSymbol = fileReader.read()) != -1) {
                    str += ((char)currectSymbol);
                }
                fileReader.close();
            }
            catch(FileException e){
                System.err.println(e.getMessage());
            } catch (IOException e) {
                System.err.println("Нет доступа к файлу");
            }
            return str;
        }

        private void create(File file) throws CannotCreateFileException {
            try{
                file.createNewFile();
            } catch(IOException e){
                throw new CannotCreateFileException();
            }
        }
        public boolean write(String str){
            boolean res = true;
            try{
                if (path == null) throw new EmptyPathException();

                File file = new File(path);

                if(!file.exists()) {
                    System.out.println("Файл " + path +" не существует, создаём новый файл");
                    create(file);
                };
                if(!file.canWrite()) throw new FileWrongPermissionsException("Нет прав на запись в файл");
                try (PrintWriter writer = new PrintWriter(file)){
                    writer.print(str);
                }
            } catch(FileException e){
                System.err.println(e.getMessage());
                res = false;
            } catch (IOException e) {
                res = false;
                System.err.println("Нет доступа к файлу");
            }
            return res;
        }
}

