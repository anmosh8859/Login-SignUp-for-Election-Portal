package ElectionPortal.controller;

import ElectionPortal.entity.Admin;
import ElectionPortal.entity.User;
import ElectionPortal.entity.Student;
import ElectionPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LogController {
    @Autowired
    private UserService userService;
    @RequestMapping("log")
    public String showLog(){
        System.out.println("running log");
        return "log";
    }

    @RequestMapping("validate")
    public @ResponseBody String validate(@RequestParam("id") String id,
            @RequestParam("userType") String userType){
        System.out.println("Validating...");
        String msg= "";
        if(userType.equals("admin")){
            Admin admin = userService.getAdmin(id);
            if(admin!=null) msg = id + " already exists, Try another one...";
        } else {
            Student student = userService.getStudent(id);
            if(student!=null) msg = id + "already exist, Try another one...";
        }
        return msg;
    }

    @RequestMapping("handle")
    public @ResponseBody String logHandler(@ModelAttribute("user") User user){
        System.out.println("Handler Awaken, Posting in User Details");
        System.out.println(user);
        String msg = "";
        String id = user.getId();
        if(user.getUserType().equals("admin")){
            Admin admin = userService.getAdmin(id);
            if(admin!=null){
                msg = id + " already exists, Try another one...";
                return msg;
            }
            admin = new Admin();
            admin.setId(user.getId());
            admin.setFullName(user.getFullName());
            admin.setUid(user.getUid());
            admin.setPassword(user.getPassword());
            msg = this.userService.createAdmin(admin);
            System.out.println(msg);
        } else {
            Student student = userService.getStudent(id);
            if(student!=null){
                msg = id + "already exist, Try another one...";
                return msg;
            }
            student.setId(user.getId());
            student.setFullName(user.getFullName());
            student.setUid(user.getUid());
            student.setPassword(user.getPassword());
            msg = this.userService.createStudent(student);
        }
        return msg;
    }

    @RequestMapping(path="/logIn", method=RequestMethod.POST)
    public String logIn(@RequestParam("signInUserType") String uT, @RequestParam("signInId") String id, @RequestParam("signInPass") String pass, Model m){
        if(uT.equals("admin")){
            Admin admin = this.userService.getAdmin(id);
            if(admin.getPassword().equals(pass)) m.addAttribute("details",admin);
            else return "redirect: validatePass";
        } else {
            Student student = this.userService.getStudent(id);
            if(student.getPassword().equals(pass)) m.addAttribute("details",student);
            else return "redirect: validatePass";
        }
        return "userDetails";
    }

    @RequestMapping("validateUserName")
    public @ResponseBody String validateLogIn(@RequestParam("signInUserType") String uT, @RequestParam("signInId") String id){
        System.out.println("Validating User Name...");
        if(uT.equals("admin")){
            Admin admin = this.userService.getAdmin(id);
            if(admin!=null) return "" ;
        } else {
            Student student = this.userService.getStudent(id);
            if(student!=null) return "";
        }
        return "Email id not registered...";
    }

    @RequestMapping("validatePass")
    public @ResponseBody String validatePass(@RequestParam("signInUserType") String uT, @RequestParam("signInId") String id, @RequestParam("signInPass") String pass){
        System.out.println("Validating Password...");
        if(uT.equals("admin")){
            Admin admin = this.userService.getAdmin(id);
            if(admin!=null && admin.getPassword().equals(pass)) return "";
        } else {
            Student student = this.userService.getStudent(id);
            if(student!=null && student.getPassword().equals(pass)) return "";
        }
        return "Incorrect Password...";
    }
}