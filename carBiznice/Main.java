package carBiznice;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        ByCarService byCarService=new ByCarService();
        Scanner scanner = new Scanner(in);
        while (true){
            System.out.println("Online Avtomobil bozorga Xush kelibsiz ! ");
            System.out.println("1] Sign In !");
            System.out.println("2] Sign Up !");
            int choose=scanner.nextInt();
            switch (choose){
               case  1->{
                   byCarService.sign();
                }
                case  2->{
                   byCarService.signUp();
                }
                default -> System.out.println("Choose number is Invalid !");
            }
        }
    }
}
