package com.company;


public class ParkOut implements ParkVehicleOut{

    CalculateMoney calculateF = new CalculateFees();
    Controller call=new Controller();
    CaptureMyTime myTime=new CaptureTime();

        // override function that parks the vehicle out and calculate its fees and capture the departure time

    public Vehicle parkOut(Vehicle[] MyCars, Slot[] MySlots, int OutCar, int NumOfVehicles){
        for (int r = 0; r < MySlots.length; r++) {
            if (MySlots[r].CarId == OutCar)
                MySlots[r].setStatus(false);            //set the vehicle slot with false cuz its empty now
        }
        for (int j = 0; j < NumOfVehicles; j++) {
            if (MyCars[j].id == OutCar) {
                call = new Controller(myTime);
                MyCars[j].DepartureTime = call.TimeFun();
                call = new Controller(calculateF);
                MyCars[j].fees = call.FeesFun(MyCars[j]);       //controller that calculate fees
                MyCars[j].id= -1;
                return MyCars[j];

    }
}
        return null;
    }

}
