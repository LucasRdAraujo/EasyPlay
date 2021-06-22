// package br.edu.infnet.easyplayapi.controller;

// import org.springframework.web.bind.annotation.RestController;

// import br.edu.infnet.easyplayapi.model.User;
// import br.edu.infnet.easyplayapi.service.UserService;
// import br.edu.infnet.easyplayapi.util.IdGenerator;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;

// @RestController
// @RequestMapping(value = "/api/v1/auth")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     @RequestMapping(value = "/register", method = RequestMethod.POST)
//     public User registerUser(@RequestParam("username") String username, @RequestParam("email") String email,
//             @RequestParam("password") String password) {

//         User user = new User();
//         if (username.isEmpty() || email.isEmpty() || password.isEmpty())
//             return user;

//         BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//         user.setId(IdGenerator.genId());
//         user.setUsername(username);
//         user.setEmail(email);
//         user.setPassword(passwordEncoder.encode(password));
//         userService.store(user);
//         return user;
//     }

// }
