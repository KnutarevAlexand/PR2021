package p1;


public class SpacePort { 
    
    private Rocket rocket;
    
    public void mount(Rocket rocket) {
        this.rocket = rocket;
    }
    
    public void launch() {
        System.out.println("-----------������ ������-----------");
        System.out.println("���-�� ��������: " + this.rocket.stagesList.size() + "���������: " + rocket.getAcceler() + "��������� ������: " + rocket.getFlightDistance() + "�������� ������: " + rocket.getSpeed() + "��� ������: " + rocket.getWeightRocket() + "����� ������: " + rocket.getTimeRocket() / 60 + " ���");
        
    }

}
