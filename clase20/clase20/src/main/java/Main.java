import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Empresa empresa= new Empresa("52-87485-58","Arcos Dorados S.A.");
        Empleado emp1= new Empleado("Juan","Rodriguez",1154,56000);
        Empleado emp2= new Empleado("Jorge","Sanchez",2322,74000);
        Empleado emp3= new Empleado("Mario","Martinez",5420,46000);
        Empleado emp4= new Empleado("Santiago","Pereyra",7293,75000);
        empresa.agregarEmpleado(emp1);
        empresa.agregarEmpleado(emp2);
        empresa.agregarEmpleado(emp3);
        empresa.agregarEmpleado(emp4);
        // guardar la empresa en un archivo separando a los empleados mediante ;
        FileOutputStream fos=null;

        try{
            fos=new FileOutputStream("Empleados.txt");
            BufferedOutputStream buffer= new BufferedOutputStream(fos);

            for (Empleado empleado:empresa.getEmpleados()) {
                String linea=empleado.getNombre()+";"+empleado.getApellido()+";"+empleado.getLegajo()+";"+empleado.getSueldo()+"\n";
                buffer.write(linea.getBytes());
                System.out.println(linea);
            }
            buffer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
