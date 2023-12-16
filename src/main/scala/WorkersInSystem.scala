import java.io.PrintWriter
import scala.io.Source
import scala.io.StdIn.{readInt, readLine}
import akka.actor.{Actor, ActorSystem, Props}

 case class WorkersInSystem() extends Actor {

  def receive = {
    case i : Int => {
      printf("please enter the service number where : \n 1 means add a system worker \n 2 means change worker in system data \n 3 means show the worker info")
      var service = readInt()

      var SalaryS = 0

      def AddSystemWorker(): Int = {
        println("please enter the worker name")
        var NameSys = readLine()
        println("please enter his salary data")
        var SalaryS = readInt()
        println("please enter his department data")
        var depart = readLine()

        val writer = new PrintWriter("E:\\PL3Project 2\\pl3pro\\SystemWorker\\" + NameSys + ".txt")
        writer.write("The worker name is " + NameSys + " \nHis salary is " + SalaryS + " \nHe department is " + depart + " \n")
        writer.close()
        println("Done")
        return SalaryS
      }

      def ChangeSystemWorker(NameSys: String): Int = {

        println("please enter his new salary data")
        var SalaryS = readInt()
        println("please enter his new department data")
        var depart = readLine()

        val writer = new PrintWriter("E:\\PL3Project 2\\pl3pro\\SystemWorker\\" + NameSys + ".txt")
        writer.write("The worker name is " + NameSys + " \nHis salary is " + SalaryS + " \nHe department is " + depart + " \n")
        writer.close()
        println("Done")
        return SalaryS
      }


      def ShowSystemWorkerInfo(NameSys: String): Unit = {
        val reader = Source.fromFile("E:\\PL3Project 2\\pl3pro\\SystemWorker\\" + NameSys + ".txt")
        val lines = reader.getLines()
        for (line <- lines)
          println(line)

      }

      if (service == 1) {

        SalaryS = AddSystemWorker()
      }


      if (service == 2) {
        println("please enter the system worker name")
        var NameSys = readLine()
        SalaryS = ChangeSystemWorker(NameSys)
      }
      if (service == 3) {
        println("please enter the system worker name")
        var NameSys = readLine()
        ShowSystemWorkerInfo(NameSys)
      }


    }
  }


}
