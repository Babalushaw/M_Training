package com.example.demo;

import com.example.demo.entity.courses;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/hello")
    public String hello(){
        return "welcome to My API";
    }

    @GetMapping("/courses")
    public List<courses> getCourses(){

        return courseService.getCourses() ;
    }
    @GetMapping("/course/{id}")
    public courses getCourse(@PathVariable int id){

        return this.courseService.getCourse(id);
    }
    @PatchMapping("/addCourse")
    @PostMapping("/addCourse")
    public courses addCourses(@RequestBody courses Course){
        return this.courseService.addCourse(Course);
    }

    @PutMapping("/update")
    public courses update(@RequestBody courses Course){
        return this.courseService.update(Course);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        System.out.println(id+ " is of type " + ((Object)id).getClass().getSimpleName());
        try {
            this.courseService.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
@GetMapping("/{id}")
    public void d(@PathVariable String id){
        this.courseService.delete(Integer.parseInt(id));
}

}
