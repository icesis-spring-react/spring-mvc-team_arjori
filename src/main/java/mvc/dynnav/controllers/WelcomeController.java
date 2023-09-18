package mvc.dynnav.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class WelcomeController {
    @GetMapping("/{username}")
    public String welcome(@CookieValue(defaultValue = "token") String token, @PathVariable String username) {
        if (username.equals(token))
            return "welcome";
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You don't have access to that resource.");
    }
}
