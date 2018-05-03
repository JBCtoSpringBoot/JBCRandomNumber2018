package com.rekik.jbcrandom2018;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@Controller
public class RandomController {

    int randomNumber;
    Random random = new Random();

    /* int x = 1 + random.nextInt(100); Picks randon number from 1 to 100(inclusive)*/

    @RequestMapping("/")
    public String addNewRandom(Model model)
    {

        return "index";
    }

    @PostMapping("/saverandom")
    public String saveRandom(@Valid @RequestParam("myRandomGuess") int myRandomGuess, Model model)
    {

    String higher = "Your guess it too high!";
    String lower = "Your guess is too low!";
    String right = "You got it!";
    String answer = "";

        int from = 1;
        int to = 100;

        randomNumber = random.nextInt(to - from+1) + from;

        model.addAttribute("aRandom",randomNumber);

        if(myRandomGuess > randomNumber)
            answer = higher;
        else if(myRandomGuess < randomNumber)
           answer = lower;
        else
            answer = right;

        model.addAttribute("answer",answer);
        return "list";
    }


}
