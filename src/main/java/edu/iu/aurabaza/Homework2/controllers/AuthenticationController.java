package edu.iu.aurabaza.Homework2.controllers;
import edu.iu.aurabaza.Homework2.model.Customer;
import edu.iu.aurabaza.Homework2.repository.CustomerFileRepository;
import edu.iu.aurabaza.Homework2.repository.CustomerRepository;
import edu.iu.aurabaza.Homework2.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    CustomerRepository customerRepository;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService,
                                    CustomerRepository customerRepository) {

        this.authenticationManager = authenticationManager;

        //initializing the variables in the constructor

        this.tokenService = tokenService;

        this.customerRepository = customerRepository;
    }
    //signup api point
    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {

        //error handling
        try {
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            String passwordEncoded = bc.encode(customer.getPassword());
            customer.setPassword(passwordEncoded);
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //signin api point
    @PostMapping("/signin")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(customer.getUsername(), customer.getPassword()));
        return tokenService.generateToken(authentication);
    }
}