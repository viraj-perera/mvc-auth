package vipe.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vipe.test.model.Employee;
import vipe.test.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by viraj on 5/29/16.
 */
@Controller
public class AppController {

  @Autowired
  AuthenticationTrustResolver authenticationTrustResolver;

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private UserDetailsService userDetailsService;

  @RequestMapping("/home.html")
  public String home() {
    List<Employee> employees = employeeService.findAllEmployees();
    for (Employee employee : employees)
      System.out.println(employee.getName() + "--" + employee.getAge() + "--" + employee.getSalary());


    System.out.println("Home Controller");
    return "home";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginPage() {
    if (isCurrentAuthenticationAnonymous()) {
      return "login";
    } else {
      return "redirect:/list.html";
    }
  }

  /**
   * This method will list all existing users.
   */
  @RequestMapping(value = { "/list.html" }, method = RequestMethod.GET)
  public String listUsers(ModelMap model) {
    return "list";
  }

  @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
  public String accessDeniedPage(ModelMap model) {
    model.addAttribute("loggedinuser", getPrincipal());
    return "access_denied";
  }

  @RequestMapping(value="/logout", method = RequestMethod.GET)
  public String logoutPage (HttpServletRequest request, HttpServletResponse response){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null){
      //new SecurityContextLogoutHandler().logout(request, response, auth);
      //persistentTokenBasedRememberMeServices.logout(request, response, auth);
      SecurityContextHolder.getContext().setAuthentication(null);
    }
    return "redirect:/login?logout";
  }

  /**
   * This method returns true if users is already authenticated [logged-in], else false.
   */
  private boolean isCurrentAuthenticationAnonymous() {
    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    System.out.println("A U T H E N T I C A T I O N : "+authentication.getName());
    return authenticationTrustResolver.isAnonymous(authentication);
  }

  private String getPrincipal(){
    String userName = null;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
      userName = ((UserDetails)principal).getUsername();
    } else {
      userName = principal.toString();
    }
    return userName;
  }
}

