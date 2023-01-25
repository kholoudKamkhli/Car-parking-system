package com.company;

import java.time.LocalTime;

public class Controller {

  public ParkIn park;
  public DisplayMySlot dis;                //Interfaces and Abstraction classes objects as attirbutes
  public CalculateMoney fees;
  public CalculateTotal income;
  public ParkVehicleOut out;
  public CaptureMyTime Time;

  public Controller(){
  }
    public Controller(ParkVehicleOut out){
        this.out=out;
    }

    public Controller(CaptureMyTime Time){
      this.Time = Time;
  }
  public Controller(ParkIn park){
      this.park=park;
  }
  public Controller(DisplayMySlot dis){
      this.dis=dis;                                           //Controller constructors for each attirbute
  }
  public Controller(CalculateMoney fees){
      this.fees=fees;
  }
  public Controller(CalculateTotal income){
      this.income=income;
  }


                        // To make the controller depend on the abstraction not on the low level classes
                    // Controller Functions that calls the interfaces/ abstraction methods and override them

    public Slot ParkInFun(Slot[] arr, Vehicle car){
      return (park.parkIn( arr, car));
}

public LocalTime TimeFun(){
     return( this.Time.getTime());
}
public void DisplayFun(Slot[] ThisSlot){
      this.dis.display(ThisSlot);
    }


public long FeesFun(Vehicle car){
    return (this.fees.calculateMyFees(car)  );
}

public void IncomeFun(long m){
      this.income.calculateTotal(m);
}
public long getMoney(){
      return (this.income.getMoney());
}

public Vehicle ParkOutFun(Vehicle[] MyCars, Slot[] MySlots, int OutCarID, int NumOfVehicles){
      return (this.out.parkOut(MyCars,MySlots,OutCarID,NumOfVehicles));
}

}
