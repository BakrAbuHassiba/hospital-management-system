import java.io.PrintWriter
import scala.io.Source
import scala.io.StdIn.{readInt, readLine}
import akka.actor.{Actor, ActorSystem, Props}

case class WorkersInMedic() extends Actor {

  def receive = {
    case i : Int => {
      printf("please enter the service number where : \n 1 means add medic worker \n 2 means change worker in medic data \n 3 means show the worker info")
      var service = readInt()

      var SalaryM = 0

      def AddMedicWorker(): Int = {
        println("please enter the worker name")
        var NameMedic = readLine()
        println("please enter his salary data")
        var SalaryM = readInt()
        println("please enter his department data")
        var depart = readLine()

        val writer = new PrintWriter("E:\\PL3Project 2\\pl3pro\\MedicWorker\\" + NameMedic + ".txt")
        writer.write("The worker name is " + NameMedic + " \nHis salary is " + SalaryM + " \nHe department is " + depart + " \n")
        writer.close()
        println("Done")
        return SalaryM
      }

      def ChangeMedicWorker(NameMedic: String): Int = {

        println("please enter his new salary data")
        var SalaryM = readInt()
        println("please enter his new department data")
        var depart = readLine()

        val writer = new PrintWriter("E:\\PL3Project 2\\pl3pro\\MedicWorker\\" + NameMedic + ".txt")
        writer.write("The worker name is " + NameMedic + " \nHis salary is " + SalaryM + " \nHe department is " + depart + " \n")
        writer.close()
        println("Done")
        return SalaryM
      }


      def ShowMedicWorkerInfo(NameMedic: String): Unit = {
        val reader = Source.fromFile("E:\\PL3Project 2\\pl3pro\\MedicWorker\\" + NameMedic + ".txt")
        val lines = reader.getLines()
        for (line <- lines)
          println(line)

      }


      if (service == 1) {

        SalaryM = AddMedicWorker()
      }


      if (service == 2) {
        println("please enter the medic worker name")
        var NameMedic = readLine()
        SalaryM = ChangeMedicWorker(NameMedic)
      }
      if (service == 3) {
        println("please enter the medic worker name")
        var NameMedic = readLine()
        ShowMedicWorkerInfo(NameMedic)
      }


    }
  }

}
