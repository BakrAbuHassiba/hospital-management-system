import java.io.PrintWriter
import scala.io.StdIn.{readInt, readLine}
import akka.actor.{Actor, ActorSystem, Props}

 case class Gain() extends Actor {

def receive = {
  case i : Int => {
    println("Please enter the total patients money for today")


    var CostP = readInt()

    def Gains(CostP: Int): Double = {


      var Total = CostP.toDouble
      var water = Total * 0.1
      var power = Total * 0.2
      var medicine = Total * 0.25
      var Salarys = Total * 0.3
      var Gain = Total * 0.15
      println("please enter todays date")
      var date = readLine()
      val writer = new PrintWriter("E:\\PL3Project 2\\pl3pro\\The gains\\ gain (" + date + ").txt")
      writer.write("in " + date + "\nWe payed " + water + " dollars for water\nWe payed " + power + " dollars for power\nWe payed " + medicine + " dollars for medicine\nwe payed " + Salarys + " dollars as salarys\nWe gained " + Gain + "dollars")
      writer.close()
      println("Done")

      return Gain

    }
    Gains(CostP)
  }
}

}
