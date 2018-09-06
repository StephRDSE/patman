package fr.bnpp.pf.patman.rest;

import java.util.HashSet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.bnpp.pf.patman.model.entities.Role;
import fr.bnpp.pf.patman.model.entities.User;
//import fr.bnpp.pf.patman.model.repositories.SecurityService;
//import fr.bnpp.pf.patman.model.validator.UserValidator;
//import fr.bnpp.pf.patman.rest.model.UserView;
//import fr.bnpp.pf.patman.services.SecurityServiceImpl;
import fr.bnpp.pf.patman.services.UserService;
//import fr.bnpp.pf.patman.services.UserServiceImpl;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

@RequestMapping(value = "/")
@RestController
//@Api("WebService User")
public class UserController {
	@Autowired
	private UserService userService;

//    @Autowired
//    private SecurityService securityService;

//    @Autowired
//    private UserValidator userValidator;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	@ResponseBody
	// @ApiOperation("Basic GET")
	public ResponseEntity<?> createUserWithEmailAndPassword(@RequestBody User user) {
		LOGGER.info("[REST-CALL] Call on getPersonDirect with prenom {}", user);

		// User user = UserView.toUser(userview);
		String originalPassword = user.getPassword();
		HashSet<Role> roles = new HashSet<Role>();
		Role r = new Role();
		r.setName("USER");
		roles.add(r);
		user.setRoles(roles);

		userService.save(user);
		// securityService.autologin(user.getEmail(), originalPassword);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> loginWithEmailAndPassword(@RequestBody User user) {
		// User user = UserView.toUser(userview);

		LOGGER.info("[REST-CALL] Call on findAll {}", userService.findAll());
		User userToVerif = userService.findByEmail(user.getEmail());

		for (User u : userService.findAll()) {
			if ((u.getEmail().equals(userToVerif.getEmail()) && (u.getPassword().equals(userToVerif.getPassword())))) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			}
		}

		return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);

//        LOGGER.info("[REST-CALL] Call PasswordEncoder {}",
//                new BCryptPasswordEncoder().matches(user.getPassword(), userToVerif.getPassword()));
//        if (userToVerif.getEmail().equals(user.getEmail())
//                && new BCryptPasswordEncoder().matches(user.getPassword(), userToVerif.getPassword())) {
//            securityService.autologin(user.getEmail(), user.getPassword());
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
//        }

	}

//	@RequestMapping(value = "/isAuth", method = RequestMethod.GET)
//	public boolean isAuth() throws ServletException {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		return authentication != null && !(authentication instanceof AnonymousAuthenticationToken)
//				&& authentication.isAuthenticated();
//
//	}

	@RequestMapping(value = "/successLogout")
	public HttpStatus successLogout() {
		return HttpStatus.OK;
	}

}
