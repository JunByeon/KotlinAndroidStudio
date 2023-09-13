/*
To Do List

1. getter / setter 모두 다 property로 바꾸기
--> 변수를 public(default)로 define하면 setter와 getter를 사용하지
않아도 외부에서 property만으로 접근이 가능해진다

2. Kotlin 주 생성자 이용하기
--> 주생성자와 부생성자를 함께 사용하자

3. null 안정성 고려해서 프로그램 짜기
--> ?과 ?:를 사용하자
 */


class Car(val name : String, var speed : Double = 0.0) {
    var distance = 0.0
    constructor(name : String) :
            this("$name", 0.0)
}

class Track {
    val cars = Array<Car?>(8) {_->null}
    var numCars = 0
    var time = 0.0

    fun addCar(c: Car) {
        cars[numCars] = c
        numCars += 1
    }

    fun timePassed(t: Double) {
        for (i in 0 until numCars) {
            val c = cars[i]
            if (c != null) {
                c.distance = c.distance + t * c.speed
            }
        }
        time += t
    }

    fun removeCar(num: Int) {
        cars[num] = null
    }
}

fun main() {
    val track = Track()

    val a = Car("Alpha")
    track.addCar(a)

    val b = Car("Bravo", 30.0)
    track.addCar(b)

    while (true) {
        track.timePassed(1.0)
        a.speed += 1.0
        if (a.distance > b.distance) {
            println("${a.name} passed ${b.name} at ${track.time}")
            break
        }
    }
}
