package p1;


public class StageBooster implements StageRocket{
    private int idStage;// ????? ???????
    private double weight;// ???
    private double weightFuel;// ??? ???????
    private double gasflowRate;// ???????? ????????? ?????
    private double fuelConsumption;// ?????? ???????
    private Rocket rocket;// ?????? ?? ??????

    public void setIdStage(int idStage) {
       this.idStage = idStage;
    }

    public int getIdStage() {
       return idStage;
    }

    public void setWeight(double weight) {
       this.weight = weight;
    }

    public double getWeight() {
       return weight;
    }

    public void setWeightFuel(double weightFuel) {
       this.weightFuel = weightFuel;
    }

    public double getWeightFuel() {
       return weightFuel;
    }

    public void setGasflowRate(double gasflowRate) {
       this.gasflowRate = gasflowRate;
    }

    public double getGasflowRate() {
       return gasflowRate;
    }

    public void setFuelConsumption(double fuelConsumption) {
       this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption() {
       return fuelConsumption;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public Rocket getRocket() {
        return rocket;
    }


    public static class Builder {
        private StageBooster newStageBooster; 
        
        public Builder() {
            newStageBooster = new StageBooster();
        }       
        public Builder idStage(int idStage) {
            newStageBooster.idStage = idStage;
            return this;
        }
        public Builder weight(double weight) {
            newStageBooster.weight = weight;
            return this;
        }
        public Builder weightFuel(double weightFuel) {
            newStageBooster.weightFuel = weightFuel;
            return this;
        }
        public Builder gasflowRate(double gasflowRate) {
            newStageBooster.gasflowRate = gasflowRate;
            return this;
        }
        public Builder fuelConsumption(double fuelConsumption) {
            newStageBooster.fuelConsumption = fuelConsumption;
            return this;
        }         
        public StageBooster build() {             
            return newStageBooster;
        }
    }




    public void checkStage()  throws CheckException {
            if(this.getWeightFuel() <= 0) throw new CheckException("??? ???????. ????????? ???????");
    }
    
    public void startStage() {
        
        //???????? ?????????? ???????
        if(rocket.nowStage != 0) {
            rocket.stagesList.remove(rocket.nowStage-1);
            System.out.println("-----------??????? ???????-------------");
        } else rocket.nowStage ++;

        System.out.println("?????????: " + rocket.getAcceler());
        System.out.println("????????? ??????: " + rocket.getFlightDistance());           
        System.out.println("???????? ??????: " + rocket.getSpeed());
        System.out.println("??? ??????: " + rocket.getWeightRocket());
        System.out.println("????? ??????: " + rocket.getTimeRocket() / 60 + " ???");
        System.out.println("???????? ????????? ???????: " + this.getIdStage());        
        double runTimeStageBooster = weightFuel / fuelConsumption;
        System.out.println("????????? ????? ??????? ????????? ???????: " + runTimeStageBooster);


        //???????? ???????
        int counter = (int) (runTimeStageBooster / rocket.getTimeStep());
        while (counter > 0) {

            //??????????? ?????????
            try {
                Thread.sleep( 1 );
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            double resultForce = gasflowRate * fuelConsumption
                       - Planet.EARTH.surfaceWeight(rocket.getWeightRocket(), rocket.getFlightDistance()) 
                       + Planet.MOON.surfaceWeight(rocket.getWeightRocket(), rocket.earthMoontDistance - rocket.getFlightDistance());

            rocket.setAcceler(resultForce / rocket.getWeightRocket());           
            
            this.setWeightFuel(weightFuel - fuelConsumption * rocket.getTimeStep()); 
            
            rocket.setFlightDistance(rocket.getFlightDistance() + rocket.getSpeed() * rocket.getTimeStep()  + rocket.getAcceler() * rocket.getTimeStep() * rocket.getTimeStep() / 2 );      
 
            rocket.setSpeed(rocket.getSpeed() + rocket.getAcceler() * rocket.getTimeStep());           
            //rocket.setSpeed( (resultForce / fuelConsumption) * Math.log( (rocket.getWeightRocket() / (rocket.getWeightRocket() - fuelConsumption * rocket.getTimeStep()) ) ) );

            rocket.setTimeRocket(rocket.getTimeRocket() + rocket.getTimeStep());
            
            counter--;
            
        }
        
        this.finishStage();

    }
   
    public void finishStage() {
       
        //?????? ????????? ??????
        rocket.stagesList.get(rocket.nowStage).startStage();
        
    }
    
}
