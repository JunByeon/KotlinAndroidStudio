import java.lang.IllegalArgumentException

/*
* To Do List
* 1. 아래 코드에서 Track 클래스가 Car의 내부에 너무 깊숙히 개입하므로
*    Track 클래스에서 직접 Car의 speed를 보고 Car의 distance
*    를 수정한다(Car에게 시간이 지났다는 사실을 알리면 자동적으로 distance가
*     수정이 되도록 한다.
* 2. 대신 for 문을 다음과 같이 수정할 수 있도록 Car를
발전시키시오.
for( i in 0 until numCars ) {
cars[i].time = time
}
위 문장에도 오류가 숨어 있다. 적절히 수정하시오
* 3. main() 함수의 while() 문 시작 두줄도 다음과 같이 바뀔 수
있도록 Track 클래스와 main() 함수도 발전시키시오.
while( a.distance <= b.distance ) {
track.time += 1.0
4. 시간이 거꾸로 가면 IllegalArgumentException()을
던지도록 프로그램을 작성해 보시오. (추가점 0.5점)
* */


class Car(val name: String, var speed: Double = 0.0) {
    var distance: Double = 0.0

    var time = 0.0
        set(value) {
            if(value < field) throw IllegalArgumentException();
            distance += (value - field) * speed
            field = value
        }

}

class Track {
    private val cars = Array<Car?>(8) {_ -> null}

    private var numCars = 0

    var time = 0.0
        set(value) {
            if(value < field) throw IllegalArgumentException();
            for( i in 0 until numCars ) {
                val c = cars[i] ?: continue
                c.time = value
            }
            field = value
        }

    fun addCar(c: Car) {
        cars[numCars] = c;
        numCars += 1;
    }

    fun removeCar(num: Int) {
        cars[num] = null;
    }
}

fun main() {
    val track = Track();

    val a = Car("Alpha");
    track.addCar(a);

    val b = Car("Bravo", 30.0);
    track.addCar(b);

    while( a.distance <= b.distance) {
        track.time += 1.0
        a.speed += 1.0
    }

    println("${a.name} passed ${b.name} at ${track.time}");


}

