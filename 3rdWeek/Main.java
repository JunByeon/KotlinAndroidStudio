class Car {
    Car(String _name, double _speed) {
        name = _name;
        speed = _speed;
    }

    Car(String _name) {
        this(_name, 0.0);
    }

    private String name;

    String getName() {
        return name;
    }
    private double speed = 0.0;

    double getSpeed() {
        return speed;
    }
    void setSpeed(double s) {
        speed = s;
    }

    private double distance = 0.0;

    double getDistance() {
        return distance;
    }

    void setDistance(double d) {
        distance = d;
    }
}

class Track {
    private Car cars[] = new Car[8]; // Kotlin에서는 Array<Car?>(8) {_->null}
    private int numCars = 0;
    private double time = 0.0;

    double getTime() {
        return time;
    }
    void addCar(Car c) {
        cars[numCars] = c;
        numCars += 1;
    }

    void timePassed(double t) {
        for( int i = 0; i < numCars; i++ ) {
            Car c = cars[i];
            c.setDistance(c.getDistance() + t * c.getSpeed());
        }
        time += t;
    }

    void removeCar(int num) {
        cars[num] = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Track track = new Track();

        Car a = new Car("Alpha");
        track.addCar(a);
        Car b = new Car("Bravo", 30.0);
        track.addCar(b);

        while(true) {
            track.timePassed(1.0);
            a.setSpeed(a.getSpeed() + 1.0);
            if( a.getDistance() > b.getDistance() ) {
                System.out.println(a.getName() + " passed " + b.getName() + " at " + track.getTime());
                break;
            }
        }
    }
}