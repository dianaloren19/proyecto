package com.proyectouno.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import com.proyectouno.proyecto.model.Student;
import com.proyectouno.proyecto.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class StudentController {
    //se van hacer los mapeos, implemento metodos donde exponen los datos
    //metodo que devuelva una lista de estudiantes
    //coloco la anotacion @GetMapping("/students") para ir a consultar una 
    //informacion del servidor y que el me la retorne esa informacion
    //llamo al repositorio es una forma de instanciar cololcarle un sobrenombre
    //Forma rapida de inyectar, form facil de llamr una clase que se usara en otro recurso
    //para que no sea nulla.
    @Autowired
    StudentRepository studentrepository;

    /*Forma tradiciona de  para inyectar
    public StudentController(StudentRepository studentRepository){
        this.studentrepository=studentRepository;
    }*/

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required=false) String name)
        List<Student> students = new ArrayList<Student>();//Inicializa vacia
        if(name==null){
            studentrepository.findAll().forEach(students::add);//forma de llenar elementos
        }else{
            studentrepository.findByName(name).forEach(students::add);
            return  new ResponseEntity<>(students, HttpStatus.OK);
            
            //SI HAY ERROR O EXCEPCION
            //return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    
    }
}   
