package presencial;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static List<Perro> crearColeccion15Perros(){
        //crear una colección con datos cargados
        List<Perro> canes= new ArrayList<>();
        String nombre;
        int edad;
        HashMap<Integer, String> nombresPosibles= new HashMap<>();
        nombresPosibles.put(1,"Dexter");
        nombresPosibles.put(2,"Chueco");
        nombresPosibles.put(3,"Simon");
        nombresPosibles.put(4,"Firulais");
        nombresPosibles.put(5,"Loki");
        nombresPosibles.put(6,"Thor");
        nombresPosibles.put(7,"Chucho");
        nombresPosibles.put(8,"Yoco");
        nombresPosibles.put(9,"Ludovico");
        nombresPosibles.put(10,"Deyse");
        nombresPosibles.put(11,"Tobi");
        nombresPosibles.put(12,"Wachin");
        nombresPosibles.put(13,"Chuletas");
        nombresPosibles.put(14,"Lupe");
        nombresPosibles.put(15,"Perro #3");
        nombresPosibles.put(16,"Pacun");
        nombresPosibles.put(17,"Manchita");
        nombresPosibles.put(18,"Chamby");
        nombresPosibles.put(19,"Pocoyo");
        nombresPosibles.put(20,"Ramon");

        for (int i=1;i<=15;i++){
            edad=(int)(Math.random()*14-1)+1;
            nombre=nombresPosibles.get((int)(Math.random()*20-1)+1);
            Perro can= new Perro(edad,nombre);
            canes.add(can);
        }
        return canes;
    }
    public static void main(String[] args) {
        List<Perro> perros= new ArrayList<>();
        perros=crearColeccion15Perros();
        //Guardar la colección en un archivo
        FileOutputStream fos= null;
        try{
            fos= new FileOutputStream("SalidaTexto.txt");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(perros);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Recuperar la colección de un archivo a una colección en Java
        List<Perro> perrosRecuperados= null;
        FileInputStream fosLectura= null;
        try{
            fosLectura= new FileInputStream("SalidaTexto.txt");
            ObjectInputStream ois= new ObjectInputStream(fosLectura);
            perrosRecuperados=(ArrayList)ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //mostrar la información de la recuperación desde el archivo por consola
        for (Perro perro:perrosRecuperados) {
            System.out.println(perro);
        }

    }
}
