
// Creating a Data Structure to store the items
class playerStatistics(var year: Int, var playerName: String, var country: String, var matches: Int, var runs: Int, var wickets: Int) {}

object playerStatistics {
  def Desc[T: Ordering] = implicitly[Ordering[T]].reverse;

  // Insert Method to bind all the information
  def push_back(year: Int, playerName: String, country: String, matches: Int, runs: Int, wickets: Int): playerStatistics = {
    var playerInfo = new playerStatistics(year, playerName, country, matches, runs, wickets);
    return playerInfo;
  }

  def main(args: Array[String]): Unit = {
    //    var sc = new java.util.Scanner(System.in);
    //    println("How many player you want to insert?")
    //    var noOfPlayers = sc.nextInt();
    //    var lst = List();
    //    for(player <- 0 until noOfPlayers) {
    //      println(s"Enter player {$player+1} year");
    //      var year : Int = sc.nextInt();
    //      println(s"Enter player {$player+1} name");
    //      var playerName : String = sc.nextLine();
    //      println(s"Enter player {$player+1} country");
    //      var country : String = sc.nextLine();
    //      println(s"Enter player {$player+1} matches");
    //      var matches : Int = sc.nextInt();
    //      println(s"Enter player {$player+1} runs");
    //      var runs : Int = sc.nextInt();
    //      println(s"Enter player {$player+1} wickets");
    //      var wickets : Int = sc.nextInt();
    //      var lst = List(insert(year,playerName,country, matches,runs, wickets))
    //    }

    // Dummy Values
    var playerList = List(push_back(2020, "Alex", "South Africa", 24, 200, 55))
    playerList = playerList :+ push_back(2009, "John", "India", 21, 3200, 6)
    playerList = playerList :+ push_back(2008, "Peterson", "Pakistan", 22, 10, 3)
    playerList = playerList :+ push_back(2014, "Alia", "India", 24, 3220, 7)
    playerList = playerList :+ push_back(2018, "Manmohan", "Australia", 25, 2100, 57)
    playerList = playerList :+ push_back(2019, "Sachin", "India", 24, 22300, 577)
    playerList = playerList :+ push_back(2021, "Raj", "India", 22, 3000, 3)
    playerList = playerList :+ push_back(2019, "Raju", "New Zealand", 25, 2300, 14)

    // ================================================================================= //
    println("1. Player with the best highest run scored!");
    var playerWithHighestRun = playerList.sortBy(x => x.runs).reverse
    println(playerWithHighestRun(0).playerName)

    // ================================================================================= //
    println("2. Top 5 players by run scored!")
    //    println(playerWithHighestRun.take(5))
    for (player <- playerWithHighestRun.take(5)) {
      println(player.playerName)
    }

    // ================================================================================= //
    println("3. Top 5 players by wicket taken!")
    var playerWithHighestWickets = playerList.sortBy(x => x.wickets).reverse
    //    println(playerWithHighestWickets.take(5))
    for (player <- playerWithHighestWickets.take(5)) {
      println(player.playerName)
    }
    // ================================================================================= //
    println("4. Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored!")
    playerList = playerList.sortBy(x => x.wickets * 5).sortBy(x => x.runs * 0.05).reverse
    var cnt: Int = 1
    for (player <- playerList) {
      println(s"Rank $cnt --> " + player.playerName)
      cnt += 1;
    }
  }
}
