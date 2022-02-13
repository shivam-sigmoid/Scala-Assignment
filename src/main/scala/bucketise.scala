object bucketise {
  def truncateAt(x: Double, p: Int): Double = {
    // To Truncate the value
    val s = math.pow(10, p)
    (x * s).toInt / s
  }

  def bucket(num: Double): (Double, String, Double) = {
    // Used Mathematics to find the bucket in the range
    var initialValue: Double = (num / 0.05).floor * 0.05;
    var finalValue: Double = (num / 0.05).floor * 0.05 + 0.049;
    return (truncateAt(initialValue, 3),"-", truncateAt(finalValue, 3))
  }

  def main(args: Array[String]): Unit = {
    var numbers: Array[Double] = Array(12.05, 12.03, 10.33, 11.45, 13.5)
    for (number <- numbers) {
      print(s"The bucket at which value $number found is ")
      println(bucket(number))
    }
  }
}
