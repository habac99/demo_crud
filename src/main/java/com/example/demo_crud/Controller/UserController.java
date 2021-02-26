package com.example.demo_crud.Controller;
import com.example.demo_crud.DatabaseAccess.DataAccess;
import com.example.demo_crud.Model.User;
import org.mindrot.jbcrypt.BCrypt;
import scala.Int;

import javax.servlet.http.HttpSession;
import java.sql.*;


public class UserController {

    public UserController(){

    }
    public boolean SignUp(){
        return true;
    }
    public static boolean ValidateLogin(String email, String password){
        boolean status = false;
        try{
            Connection con = DataAccess.AccessDB();
            PreparedStatement ps = con.prepareStatement("select * from user where email=?");
            ps.setString(1,email.toLowerCase());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
//                String email2 = rs.getString("email");
                if (BCrypt.checkpw(password,rs.getString("password"))){
                    status = true;
//                    System.out.println(rs.getString("password"));
                }
            }else{
                System.out.println("sai cmnr");
            }
//            System.out.println(rs.getInt(1));
        }catch (Exception e){
            System.out.println(e);
        }
        return status;
    }
    public User getOneUser(String email){
        User user = new User();

        try {
            Connection con = DataAccess.AccessDB();
            PreparedStatement ps = con.prepareStatement("select  * from user where email=?");
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("iduser");
                String name = rs.getString("name");
                String uEmail= rs.getString("email");
                user.setId(id);
                user.setName(name);
                user.setEmail(uEmail);

            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return  user;
    }
//    public static void main(String[] args){
//        ValidateLogin("abc@gmail.com","123456");
//    }
}
