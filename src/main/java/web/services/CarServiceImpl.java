package web.services;

import web.models.Car;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getFirstXCars(List<Car> cars, int count) {
        if (count < 5) {
            return cars.subList(0, count);
        } else {
            return cars;
        }
    }
}
