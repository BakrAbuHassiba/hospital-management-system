import akka.actor.{Actor, ActorSystem, Props}

import scala.io.StdIn.{readInt, readLine}
import java.io.{File, FileOutputStream, PrintWriter}
import scala.io.Source
object Patients {



  class Patient() extends Actor {

    def receive = {
      case i : Int => {
        var costP = 0

        printf("please enter the service number where : \n 1 means add a patient \n 2 means change patient data \n 3 means show the patient info")
        var service = readInt()

        //var SalaryS = 0
        def AddPatient(): Int = {
          println("please enter the patient name")
          var NamePatient = readLine()
          println("please enter todays date")
          var InDate = readLine()
          println("please enter the leaving date")
          var OutDate = readLine()
          println("please enter the pain kind")
          var pain = readLine()
          println("please enter the cost")
          var costP = readInt()
          println("please enter the payment way")
          var payment = readLine()
          println("please enter the room number")
          var room = readInt()
          val writer = new PrintWriter("E:\\PL3Project 2\\pl3pro\\PatientsInfo\\" + NamePatient + ".txt")
          writer.write("The patient name is " + NamePatient + "\nHe entered the hospital in " + InDate + "\nHe s leaving date is " + OutDate + "\nHe s pain is " + pain + "\nHe will pay " + costP + " dollars\nHis payment way is " + payment + "\nHis room number is " + room)
          writer.close()
          println("Done")
          return costP
        }

        def ChangePatientData(NamePatient: String): Int = {

          println("please enter todays date")
          var InDate = readLine()
          println("please enter the leaving date")
          var OutDate = readLine()
          println("please enter the pain kind")
          var pain = readLine()
          println("please enter the cost")
          var costP = readInt()
          println("please enter the payment way")
          var payment = readLine()
          println("please enter the room number")
          var room = readInt()
          val writer = new PrintWriter("E:\\PL3Project 2\\pl3pro\\PatientsInfo\\" + NamePatient + ".txt")
          writer.write("The patient name is " + NamePatient + "\nHe entered the hospital in " + InDate + "\nHe s leaving date is " + OutDate + "\nHe s pain is " + pain + "\nHe will pay " + costP + " dollars\nHis payment way is " + payment + "\nHis room number is " + room)
          writer.close()
          println("Done")
          return costP
        }


        def ShowPatientInfo(NamePatient: String): Unit = {
          val reader = Source.fromFile("E:\\PL3Project 2\\pl3pro\\PatientsInfo\\" + NamePatient + ".txt")
          val lines = reader.getLines()
          for (line <- lines)
            println(line)

        }


        if (service == 1) {

          costP = AddPatient()
        }


        if (service == 2) {
          println("please enter the patient name")
          var NamePatient = readLine()
          costP = ChangePatientData(NamePatient)
        }
        if (service == 3) {
          println("please enter the patient name")
          var NamePatient = readLine()
          ShowPatientInfo(NamePatient)
        }



      }
    }



    {





    }













  }



  def main(args: Array[String]): Unit =

  {
    var SelectAct = 0
    println("Enter any number from 1 to 4 to do the following \n1 to use the patients system\n2 to use the medic workers system\n3 to use the system workers system\n4 to use the bills and gains system")
    SelectAct = readInt()

    if (SelectAct == 1)
      {
        val systemP = ActorSystem("SimpleSystem")
        val actorP = systemP.actorOf(Props[Patient],"actP")
        actorP ! 42
      }

    if (SelectAct == 2)
      {
        val systemWM = ActorSystem("SimpleSystem")
        val actorWM = systemWM.actorOf(Props[WorkersInMedic],"actWM")
        actorWM ! 42
      }

    if (SelectAct == 3)
    {
      val systemWS = ActorSystem("SimpleSystem")
      val actorWS = systemWS.actorOf(Props[WorkersInSystem],"actWS")
      actorWS ! 42
    }

    if (SelectAct == 4)
    {
      val systemG = ActorSystem("SimpleSystem")
      val actorG = systemG.actorOf(Props[Gain],"actG")
      actorG ! 42
    }




  }







}