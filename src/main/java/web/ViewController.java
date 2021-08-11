package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({"/", "/about", "/posts", "/login", "/home"})
    public static String ShowView(){
return "foward:/index.html";
    }
}
