
package com.mycompany.ejercicioclase6;

import com.controllers.Controllers;
import com.models.Administrador;
import com.models.Servicio;
import com.models.Tarea;
import java.util.ArrayList;
import java.util.List;

public class EjercicioClase6 {

    public static void main(String[] args) {
        
        Controllers control = new Controllers ();
        Administrador admi = new Administrador("Juan");
        Tarea tarea1 = new Tarea ("Albañileria","reparacion y construccion de paredes");
        Tarea tarea2 = new Tarea ("Manicura","arreglos de uñas");
        Tarea tarea3 = new Tarea ("Fletero","traslado de paqueteria");
        List <Tarea> tareas = new ArrayList();
        tareas.add(tarea1);
        tareas.add(tarea2);
        tareas.add(tarea3);
        
        
        Servicio servi = new Servicio("servicio1",tareas);
        control.crearServicio(servi);
       control.crearAdministrador(admi);
       control.crearTarea(tarea1);
       control.eliminarTarea(4);
        
    }
}
