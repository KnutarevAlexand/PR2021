package p1;


public class StageRowerMoon implements StageRocket{
    private int idStage;// ����� �������
    private double weight;// ���
    private double weightFuel;// ��� �������
    private double gasflowRate;// �������� ��������� �����
    private double fuelConsumption;// ������ �������
    private Rocket rocket;// ������ �� ������

    public void setIdStage(int idStage) {
       this.idStage = idStage;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public Rocket getRocket() {
        return rocket;
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

    public double getWeightFuel() {
       return weightFuel;
    }
    
    public double getGasflowRate() {
       return gasflowRate;
    }

    public double getFuelConsumption() {
       return fuelConsumption;
    }


    public static class Builder {
        private StageRowerMoon newStageRowerMoon; 
        
        public Builder() {
            newStageRowerMoon = new StageRowerMoon();
        }       
        public Builder idStage(int idStage) {
            newStageRowerMoon.idStage = idStage;
            return this;
        }
        public Builder weight(double weight) {
            newStageRowerMoon.weight = weight;
            return this;
        }
        public Builder weightFuel(double weightFuel) {
            newStageRowerMoon.weightFuel = weightFuel;
            return this;
        }
        public Builder gasflowRate(double gasflowRate) {
            newStageRowerMoon.gasflowRate = gasflowRate;
            return this;
        }
        public Builder fuelConsumption(double fuelConsumption) {
            newStageRowerMoon.fuelConsumption = fuelConsumption;
            return this;
        } 
        public StageRowerMoon build() {             
            return newStageRowerMoon;
        }
    }

   public void checkStage() {
    }
    
    public void startStage() {
        
             //�������� ���������� �������
             rocket.stagesList.remove(rocket.nowStage-1);
             System.out.println("-----------������� �������-------------");
             System.out.println("--------------��������� �����----------------");    

             //�������� ���������� ������ �� ���������� ������� ��������� ������� ��� �� �������� ������ (������������� ��������)
             while (rocket.getFlightDistance() < rocket.earthMoontDistance & rocket.getSpeed() > 0.0) {

                 double resultForce = //gasflowRate * fuelConsumption
                            - Planet.EARTH.surfaceWeight(rocket.getWeightRocket(), rocket.getFlightDistance()) 
                            + Planet.MOON.surfaceWeight(rocket.getWeightRocket(), rocket.earthMoontDistance - rocket.getFlightDistance());

                 rocket.setAcceler(resultForce / rocket.getWeightRocket());           
                 
                 //this.setWeightFuel(weightFuel - fuelConsumption * rocket.getTimeStep()); 
                 
                 rocket.setFlightDistance(rocket.getFlightDistance() + rocket.getSpeed() * rocket.getTimeStep()  + rocket.getAcceler() * rocket.getTimeStep() * rocket.getTimeStep() / 2 );      
                 
                 rocket.setSpeed(rocket.getSpeed() + rocket.getAcceler() * rocket.getTimeStep());
                 //rocket.setSpeed( (resultForce / fuelConsumption) * Math.log( (rocket.getWeightRocket() / (rocket.getWeightRocket() - fuelConsumption * rocket.getTimeStep()) ) ) );

                 rocket.setTimeRocket(rocket.getTimeRocket() + rocket.getTimeStep());
                 
                 //counter--;
             }
             
             if(rocket.getSpeed() <= 0.0) {
                 System.out.println("------------�������------------");
             }

             if(rocket.getFlightDistance() >= rocket.earthMoontDistance) {
                 System.out.println("---------������ �������� �� ����------------------");
             }

             rocket.status = 0;//��������� ������
             System.out.println("���������: " + rocket.getAcceler());
             System.out.println("��������� ������: " + rocket.getFlightDistance());           
             System.out.println("�������� ������: " + rocket.getSpeed());
             System.out.println("��� ������: " + rocket.getWeightRocket());
             System.out.println("����� ������: " + rocket.getTimeRocket() / 60 + " ���");

    }

    public void finishStage() {
        
        //������ ��������� ������
        rocket.stagesList.get(rocket.nowStage).startStage();           

    }
    
}
