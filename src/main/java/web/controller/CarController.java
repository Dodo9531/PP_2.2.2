package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.services.CarService;
import web.services.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private final CarService carService = new CarServiceImpl();

    @GetMapping("/cars")
    public String getFirstXCars(ModelMap model, @RequestParam(required = false,defaultValue = "5") int count) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "model1", 2));
        cars.add(new Car(2, "model2", 4));
        cars.add(new Car(3, "model3", 6));
        cars.add(new Car(4, "model4", 8));
        cars.add(new Car(5, "model5", 10));
        cars.add(new Car(6, "model6", 12));
        if (count >= 5) {
            model.addAttribute("cars", cars);
        } else {
            model.addAttribute("cars", carService.getFirstXCars(cars, count));
        }
        return "cars";
    }
}
