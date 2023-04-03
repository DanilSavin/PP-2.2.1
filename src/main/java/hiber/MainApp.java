package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
        User slava = new User("Slava", "Perviy", "SP@mail.ru");
        User dima = new User("Dima", "Vtoroi", "DV@mail.ru");
        User ivan = new User("Ivan", "Tretiy", "IT@mail.ru");
        User vova = new User("Vova", "Chetvertiy", "VCH@mail.ru");
        Car audi = new Car("Audi", 7);
        Car uaz = new Car("Uaz", 50);
        Car gaz = new Car("Gaz", 66);
        Car jeep = new Car("Jeep", 80);
        userService.add(slava.setCar(audi).setUser(slava));
        userService.add(dima.setCar(uaz).setUser(dima));
        userService.add(ivan.setCar(gaz).setUser(ivan));
        userService.add(vova.setCar(jeep).setUser(vova));

        for (User user:userService.listUsers()){
            System.out.println(user + " " + user.getCar());
        }

//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println();
//        }

        context.close();
    }
}
