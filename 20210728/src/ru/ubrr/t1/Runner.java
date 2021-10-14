package ru.ubrr.t1;


public class Runner {
  
    public static void main(String[] args) {

        Shape[] shapes = {
            new Circle(4.0), 
            new Ellipse(2.0,6.0),
            new Triangle(4.0,5.0,6.0),
            new IssoscelesTriangle(4.0,5.0),
            new EquilaterialTriangle(2.0,4.0),
            new RightTriangle(4.0,5.0,6.0),
            new Tetragon(4.0,5.0,30.0),
            new Parallelogramm(5.0,6.0),
            new Rectangle(4.0,5.0),
            new Square(2.0)
        };
   
        //����� ����� ��������
        double sumS = 0;
        for (Shape shape : shapes) {
            sumS += shape.getArea();
        }
        System.out.println("����� �������� = "+sumS);
            

        
               
        //������������ ����� ��� ������� ���� ����� �����������

        for (int i = 0; i < shapes.length; i++) {
            if(shapes[i] instanceof CloneableShape) {
                CloneableShape shapesClone = (CloneableShape)shapes[i];
                shapes[i] = (Shape)shapesClone.clone(2);
            }
        }
        
        //����� ������� �����
        System.out.println("������ �����:");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("�� " + shapes[i].id + ", ������� " + shapes[i].getArea() + ", ���� " + shapes[i].color + ", ��� ������ " + shapes[i].getClass().getSimpleName());
        }

        //������� �������
        double sumS_new = 0;
        for (Shape shape : shapes) {
            sumS_new += shape.getArea();
        }        
        System.out.println("������� ������� ��������: " + (sumS_new - sumS));
        
        
        //���-�� ����� �� ������
        System.out.println("���-�� ����� �� ������:");
        int colorNum = 0;
        int colorNumCircle = 0;
        int colorNumTriangle = 0;
        int colorNumTetragon = 0;
        
        for (Colors c : Colors.values()) {
            for (int i = 0; i < shapes.length; i++) {
              if(shapes[i].color.equals(c.toString())) {
                    colorNum++;
                    if(shapes[i] instanceof Circle) colorNumCircle++;
                    if(shapes[i] instanceof Triangle) colorNumTriangle++;
                    if(shapes[i] instanceof Tetragon) colorNumTetragon++;
                  }
              }
            System.out.println(c + ": ����� " + colorNum + ", ������� " + colorNumCircle + ", ����������� " + colorNumTriangle + ", ��������������� " + colorNumTetragon);
            colorNum = 0;
            colorNumCircle = 0;
            colorNumTriangle = 0;
            colorNumTetragon = 0;
            }
        }
}
