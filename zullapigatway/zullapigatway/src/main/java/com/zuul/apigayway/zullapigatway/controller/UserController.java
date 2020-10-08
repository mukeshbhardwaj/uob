/*
 * package com.zuul.apigayway.zullapigatway.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.user.userservice.model.User; import
 * com.user.userservice.service.UserService; //import
 * com.zuul.apigayway.zullapigatway.model.User;
 * 
 * @RestController
 * 
 * @RequestMapping("/users") public class UserController {
 * 
 * @Autowired UserService userService;
 * 
 * // @PostMapping("/register") // public String registerUser(@RequestBody User
 * user) { // // userService.addUser(user); // // return "user regisred"; // }
 * 
 * @PostMapping public ResponseEntity<User> saveUser(@RequestBody User user) {
 * 
 * return new ResponseEntity<>(userService.save(user), HttpStatus.OK); }
 * 
 * @GetMapping public ResponseEntity<List<User>> listUser() {
 * 
 * return new ResponseEntity<>(userService.findAll(), HttpStatus.OK); }
 * 
 * @GetMapping("/{id}") public ResponseEntity<User> getOne(@PathVariable int id)
 * {
 * 
 * return new ResponseEntity<>(userService.findById(id), HttpStatus.OK); }
 * 
 * @PutMapping("/{id}") public ResponseEntity<User> update(@RequestBody User
 * userDto) { return new ResponseEntity<>(userService.update(userDto),
 * HttpStatus.OK); }
 * 
 * @DeleteMapping("/{id}") public ResponseEntity delete(@PathVariable int id) {
 * userService.delete(id);
 * 
 * return new ResponseEntity("User deleted successfully.", HttpStatus.OK); }
 * 
 * }
 */