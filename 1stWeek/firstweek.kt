fun main() {
    print("첫번째 정수를 입력하세요:")
    val valFirst = readLine()!!.toInt();
    print("두번째 정수를 입력하세요:")
    val valSecond = readLine()!!.toInt();
    print("세번째 정수를 입력하세요:")
    val valThird = readLine()!!.toInt();
    val sum = valFirst + valSecond + valThird
    print("$valFirst + $valSecond + $valThird = $sum"+"입니다.")
}
