import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {
    private String cuit;
    private String razonSocial;
    private List<Empleado> empleados;

    public Empresa(String c,String r){
        cuit=c;
        razonSocial=r;
        empleados=new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public String getCuit() {
        return cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
