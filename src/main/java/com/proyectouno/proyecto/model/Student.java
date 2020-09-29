package com.proyectouno.proyecto.model;
//debilmente acoplado

//principio de responsabilidad simple
//codigo sea escalable,legible,
//testeable  framework Junit

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//Represnta el modelo de dominio del negocio,tablas de la BD, documentos
@Document(collection = "student")
public class Student {
    // encapsulacion
    @Id
    private String id;
    private String name;
    private String description;
    private boolean attend;

    // Constructor de la clase
    public Student() {
    }

    public boolean isAttend() {
        return attend;
    }

    public void setAttend(boolean attend) {
        this.attend = attend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Sobre escribir el constructor
    // Inyeccion inicializar unos valores es sinonimo de instanciar una clase
    public Student(String name, String description, boolean attend) {
        this.setName(name);
        this.setDescription(description);
        this.setAttend(attend);
        
    }
    //Metodo publico que expone un atributo privado a otro componente
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id= id;
    }
}
