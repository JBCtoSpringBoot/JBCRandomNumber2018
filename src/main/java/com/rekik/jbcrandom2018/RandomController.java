package com.rekik.jbcrandom2018;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.Scanner;

@Controller
public class RandomController {

    @RequestMapping("/")
    @ResponseBody
    public String showRandom(){

        Scanner scan= new Scanner(System.in);
        Random random = new Random();

        //Commented because it doesn't work
        /*long from = 1;
        long to = 100;
        int randomNumber = random.nextInt(to - from+1) + from;*/

        int from = 1;
        int to = 100;

        int randomNumber = random.nextInt(to - from+1) + from;

        int guessedNumber = 0;

        System.out.printf("The number is between %d and %d.\n", from, to);

        do{
            System.out.print("Guess what number is: ");
            guessedNumber = scan.nextInt();
           // scan.nextLine();

            System.out.println("The random number is "+ randomNumber);
            if(guessedNumber > randomNumber)
                System.out.println("Your guess it too high!");
            else if(guessedNumber < randomNumber)
                System.out.println("Your guess is too low!");
            else System.out.println("You got it!");
        }while (guessedNumber!=randomNumber);

        String randomStr = String.valueOf(randomNumber);

        //After the program is done you can see the random number on your browser http://localhost:8080/
        return "The random number is "+randomStr;

    }


}
