package casestudy;


import java.util.Scanner;


public class Student {
    private String Regno;
    private String fName;
    private String lName;
    private double project01;//
    private double codingAssign;//
    private double project02;//
    private double moduleMark;
    private double ict01;//
    private double ict02;//
    private double ict03;//
    private double activePart01;//
    private double activePart02;//
    private double activePart03;//
    
    
    Scanner userInput2=new Scanner(System.in);

    public double getModuleMark() {
        return moduleMark;
    }

    public void setModuleMark(double moduleMark) {
        this.moduleMark = moduleMark;
    }

    public String getRegno() {
        return Regno;
    }

    public void setRegno(Scanner sc, String message) {
        String input;
        System.out.println(message);
        input=sc.next();
        do{
            if(input.length()!=7){
                System.err.println("Error: Your registration number can have only seven characters. Re-Enter the student Registration number below");
                input=sc.next();
            }
        }while (input.length()!=7);
        this.Regno=input;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public double getProject01() {
        return project01;
    }

    public void setProject01(double project01) {
        this.project01 = project01;
    }

    public double getCodingAssign() {
        return codingAssign;
    }

    public void setCodingAssign(double codingAssign) {
        this.codingAssign = codingAssign;
    }

    public double getProject02() {
        return project02;
    }

    public void setProject02(double project02) {
        this.project02 = project02;
    }

    public double getIct01() {
        return ict01;
    }

    public void setIct01(double ict01) {
        this.ict01 = ict01;
    }

    public double getIct02() {
        return ict02;
    }

    public void setIct02(double ict02) {
        this.ict02 = ict02;
    }

    public double getIct03() {
        return ict03;
    }

    public void setIct03(double ict03) {
        this.ict03 = ict03;
    }

    public double getActivePart01() {
        return activePart01;
    }

    public void setActivePart01(double activePart01) {
        this.activePart01 = activePart01;
    }

    public double getActivePart02() {
        return activePart02;
    }

    public void setActivePart02(double activePart02) {
        this.activePart02 = activePart02;
    }

    public double getActivePart03() {
        return activePart03;
    }

    public void setActivePart03(double activePart03) {
        this.activePart03 = activePart03;
    }
    
    
    
    public double project01WithICT(){
        double project01;
        double ict01;
        double activePart01;
        double c1AverageIn30=0;
        double c1AverageIn100=0;
        project01=this.project01*20/100;//16
        ict01=this.ict01*70/100;//42
        activePart01=this.activePart01*10/100;//7//total=65
        c1AverageIn30=(project01+ict01+activePart01)*100/300;//21.6/30
        c1AverageIn100=c1AverageIn30*100/30;
        return c1AverageIn30;
    }
    
    public double codingWithIct(){
        double codingAssign=0;
        double ict02=0;
        double activePart02=0;
        double c2AverageIn35=0;
        double c2AverageIn100=0;
        codingAssign=this.codingAssign*50/100;
        ict02=this.ict02*40/100;
        activePart02=this.activePart02*10/100;
        c2AverageIn35=(codingAssign+ict02+activePart02)*100/350;
        c2AverageIn100=c2AverageIn35*100/35;
        
        return c2AverageIn35;
    }
    
    public double project02WithIct(){
        double ict03=0;
        double project02=0;
        double activePart03=0;
        double c3AverageIn35=0;
        double c3AverageIn100=0;
        ict03=this.ict03*60/100;
        project02=this.project02*30/100;
        activePart03=this.activePart03*10/100;
        c3AverageIn35=(ict03+project02+activePart03)*100/350;
        c3AverageIn100=c3AverageIn35*100/35;
        
        return c3AverageIn35;
    }
    
    public Grade gradeCalculator(){
        Grade grade=null;
        double qualifySet01=0;
        
        qualifySet01=(project01WithICT()+codingWithIct())*100/65;
        
        if(this.moduleMark<=49){
            grade=Grade.RETAKE;
        }else{
            if(this.moduleMark<=59){
                if(qualifySet01>=40&&(project02WithIct()*100/35)>=40){
                    grade=Grade.PASS;
                }else{
                    grade=Grade.RESIT;
                }
            }else{
                if(this.moduleMark<=69){
                    grade=Grade.C;
                    if(qualifySet01<40||(project02WithIct()*100/35)<40){
                        grade=Grade.RESIT;
                    }
                }else{
                    if(this.moduleMark<=79){
                        grade=Grade.D;
                        if(qualifySet01<40||(project02WithIct()*100/35)<40){
                           grade=Grade.RESIT;
                        }
                    }else{
                        if(this.moduleMark<=100){
                            grade=Grade.HD;
                            if(qualifySet01<40||(project02WithIct()*100/35)<40){
                                grade=Grade.RESIT;
                            }
                        }
                    }
                }
            }
        }
            
        
        return grade;
    }
}
