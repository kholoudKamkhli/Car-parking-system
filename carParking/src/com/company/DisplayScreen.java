package com.company;

import java.util.Scanner;


public class DisplayScreen {

    int remaining,size,i;
    Garage MyGarage=new Garage();
    Scanner Input1 =new Scanner(System.in);
    Scanner Input2=new Scanner(System.in);
    Slot[] MySlots;
    Vehicle[] MyCars;
    boolean flag=true;
    Controller call =new Controller();
    DisplayMySlot DisplayObj= new DisplaySlot();
    //***************************************************************************************************************************

   public void StartProgram(){

       StartGarage();
       while(flag) {
                   ShowMenu();
                   int operation =  Input1.nextInt();
                   switch (operation) {
                       case 1 -> ParkVehicle();
                       case 2 -> DisplayAvailableSlots();
                       case 3 -> ParkOutVehicle();
                       case 4 -> CalculateGarageIncome();
                       case 5 -> flag = false;
           }
       }
   }
    //***************************************************************************************************************************
   public void ShowMenu(){
       System.out.println("""
               1- Park In Vehicle\s
               2- Display available Slots\s
               3- Park Out Vehicle\s
               4- Get Garage Income
               5- Calculate Number Of Vehicles
               6- Exit\s
               ---------------------""");
   }
    //***************************************************************************************************************************
    public void StartGarage(){

        System.out.println("Welcome to your Garage! \n --------------------- \n Enter number of garage slots");
         size = Input1.nextInt();
        MyCars = new Vehicle[1000];
        MySlots = new Slot[size];                   //create arr of slots
        remaining =size;
        for (int SlotID = 0; SlotID < size; SlotID++) {
            System.out.println("Enter width and depth for slot number " + (SlotID + 1));
            int width = Input1.nextInt();
            int depth = Input1.nextInt();
            MySlots[SlotID] = new Slot(width, depth, false, SlotID ,0);
        }
        System.out.println("Select a configuration \n 1- Best Fit     2-First come" );
        int num = Input1.nextInt();
        MyGarage = new Garage(num, MySlots, size);      //creating a new garage with info

    }


//***************************************************************************************************************************
public void ParkVehicle()
{
    ParkIn obj = null;
    if(remaining == 0)
        System.out.println("There's no empty slot for your vehicle ");
    else{
        System.out.println("Please identify your vehicle \n -enter width, depth of your vehicle");
        int w = Input1.nextInt();
        int d = Input1.nextInt();
        System.out.println("-enter your vehicle model year :");
        int y = Input1.nextInt();
        System.out.println("-enter your vehicle model name :");
        String m = Input2.nextLine();

        MyCars[i] = new Vehicle(w, d, i, y, m);
        System.out.println("-Your Vehicle ID is : "+ MyCars[i].getId());




        if (MyGarage.getConfiguration() == 1) {
            obj = new BestFit();}
        if (MyGarage.getConfiguration() == 2) {
            obj = new FirstCome();}

        call =new Controller(obj);
        
        
            Slot chosen = call.ParkInFun(MySlots,MyCars[i]);
            if (chosen == null)
                System.out.println( "There's no available slots" );
            else {
                System.out.println( "your parking slot is :" );
                System.out.println("-Slot Id: "+chosen.getId() +" -Slot dimensions :" +chosen.getWidth() + "," + chosen.getDepth() );    // chosen slot

                System.out.println( "\n--------------------");
                remaining--;
            }
            i++;
        }}


//************************************************************************************************************************

public void DisplayAvailableSlots()
{
        call = new Controller(DisplayObj);
            System.out.println("\n");
            if (remaining == 0) {
                System.out.println("There's no available slots");
            } else {
                System.out.println("Remaining available slots :");
                        call.DisplayFun(MySlots);                             //display all available slots

                System.out.println("\n");
            }
}
//************************************************************************************************************************

public void ParkOutVehicle(){
    ParkVehicleOut g = new ParkOut();
    call = new Controller(g);
    boolean f=false;
    System.out.println("Enter ID for your out car");
    int OutCar = Input1.nextInt();
    for (int j = 0; j < i; j++){
    if(OutCar == MyCars[j].id) {
        Vehicle OutVehicle = call.ParkOutFun(MyCars, MySlots, OutCar, i);
        System.out.println("Time : " + OutVehicle.getDepartureTime());
        System.out.println("Your fees is " + OutVehicle.GetFees());
        remaining++;
        f = true;
        break;
    }
    }
    if(f == false)
    System.out.println("There's no vehicle with the given ID");
    //break;


}

//************************************************************************************************************************

    public void CalculateGarageIncome(){
        CalculateTotal n= CalculateIncome.GetInstance();
        call = new Controller(n);
        System.out.println("Your Income is " + call.getMoney());

        }
}
