package web.servlet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is LoginServlet doGet method");
        //1.设置编码
        req.setCharacterEncoding("utf-8");
      /*  //2.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        //3.封装User 对象
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
        System.out.println(loginuser);*/
        //2.获取所有请求参数
        Map<String, String[]> map = req.getParameterMap();
        User loginuser = new User();
        try {
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //4.调用User.login方法了
//        UserDao dao = new UserDao();
//        User user = dao.login(loginuser);
        User user = loginuser; //不查数据库，直接复制

        //5.判断user
        if(user == null){
            System.out.println("登陆失败");
            req.getRequestDispatcher("failServlet").forward(req,resp);
        }else{
            System.out.println("登陆成功");
            req.setAttribute("user",user);
            req.getRequestDispatcher("successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
