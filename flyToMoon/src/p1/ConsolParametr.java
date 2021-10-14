package p1;


public class ConsolParametr implements Runnable {
    
    private final long timeStep = 2;
    private Rocket rocket;
    
    
    public ConsolParametr(Rocket rocket) {
        this.rocket = rocket;
        
    }


    @Override
    public void run() {
        
        int count = 0;
        while(rocket.status == 1) {
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("����������: ���-�� ��������: " + this.rocket.stagesList.size() + " ���������: " + rocket.getAcceler() + " ��������� ������: " + rocket.getFlightDistance() + " �������� ������: " + rocket.getSpeed() + " ��� ������: " + rocket.getWeightRocket() + " ����� ������: " + rocket.getTimeRocket() / 60 + " ���");
        }
    }
}
