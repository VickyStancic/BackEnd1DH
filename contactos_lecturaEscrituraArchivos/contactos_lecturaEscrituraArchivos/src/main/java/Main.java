import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Contacto> cargaDeContactos() {
        List <Contacto> contactosParaCargar = new ArrayList<>();

        Contacto contacto1 = new Contacto("Juan", "perez", "juanperez@gmail.com", "4567-9876");
        Contacto contacto2 = new Contacto("Laura", "Garcia", "Laura@gmail.com", "4787-9876");
        Contacto contacto3 = new Contacto("Martina", "Benitez", "BenitezM@gmail.com", "4567-2233");

        contactosParaCargar.add(contacto1);
        contactosParaCargar.add(contacto2);
        contactosParaCargar.add(contacto3);

        return contactosParaCargar;
    }


    public static void main(String[] args) {
    List<Contacto> listaContactos;
    listaContactos = cargaDeContactos();

    //Escritura

    FileOutputStream fos = null;
    try{
        fos = new FileOutputStream("listadoDeContactos.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(listaContactos);
        oos.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    //Lectura

    List<Contacto> listaContactosLeidos = null;
    FileInputStream fis = null;

    try{
        fis = new FileInputStream("listadoDeContactos.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
       listaContactosLeidos = (ArrayList)ois.readObject();
       ois.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

        for (Contacto contacto : listaContactosLeidos) {
            System.out.println(contacto);
        }

    }
}
