package casestudy;
import java.util.*;

public class CaseStudy {
static List<Student> sList = new ArrayList<Student>();
static CaseStudy caseStudy = new CaseStudy();
static Scanner userInput = new Scanner(System.in);
static int num = 1;
private double compo_01Avg;// used to store the average of component 01
private double compo_02Avg;// used to store the average of component 02
private double compo_03Avg;// used to store the average of component 03

                    // Answer for 3rd question
    public double getCompo_03Avg() {
        return compo_03Avg;
    }

    public void setCompo_03Avg() { // used to calculate the average of component 03.
        double compo_03Total=0;
        
        for(Student obj:sList){
            
            compo_03Total = compo_03Total+(obj.project02WithIct()*100/35);
        }
        
        this.compo_03Avg=compo_03Total/sList.size();
    }

    public double getCompo_02Avg() { 
        return compo_02Avg;
    }

    public void setCompo_02Avg() { // used to calculate the average of the component 02.
        double compo_02Total = 0;
        
        for(Student obj:sList){
            
            compo_02Total = compo_02Total+(obj.codingWithIct()*100/35);
        }
        
        this.compo_02Avg = compo_02Total/sList.size();
    }

    public double getCompo_01Avg() {
        return compo_01Avg;
    }

    public void setCompo_01Avg() { // used to calculate the average of the component 01.
        double compo_01Total = 0;
        
        for(Student obj:sList){
            
            compo_01Total = compo_01Total+(obj.project01WithICT()*100/30);
        }
        
        this.compo_01Avg=compo_01Total/sList.size();
    }

    public static void main(String[] args) {
        studentInfo();
        
        marksBelow40();
        
        moduleOverall();
        
        classAvg();
        
        stusBelowClassAvg();
        
        highestScorer();
        
        highestScorers();
        
        retakeStudents();
        
        resitStudents();
        
        gradeHolders();
    }
    
    public static void studentInfo(){// used to enter student details and their marks. Also, this method display the marks of the components out of 30% and 100%.
        String Regno;// used to store the student registration number
        String fName;// used to store student first name
        String lName;// used to store student last name
        double project01;// used to store student's marks for project 01
        double codingAssign;// used to store students marks for coding assignment
        double project02;// used  to store students marks for project 02
        double moduleMark = 0;// used to store students module mark
        double ict01;// used to store student's mark for ict01
        double ict02;// used to store student's mark for ict02
        double ict03;// used to store student's mark for ict03
        double activePart01;// used to store student's mark for active participation 01
        double activePart02;// used to store student's mark for active participation 02
        double activePart03;// used to store student's mark for active participation 03
        double compo_AvgIn100 = 0;// this variable calculates the value of each component out of 100.
        String userChoice="Y";//
        
            while(userChoice.equals("Y")||userChoice.equals("Y")){
                StringBuilder sb=new StringBuilder("-------Student entry ");
                sb.append(num);
                System.out.println(sb+"-------");
                Student student=new Student();
                
                student.setRegno(userInput, "Enter the student Registration number");
                System.out.println();
        
                System.out.println("Enter the student first name");
                fName = userInput.next();
                student.setfName(fName);
                System.out.println();
        
                System.out.println("Enter the student last name");
                lName = userInput.next();
                student.setlName(lName);
                System.out.println();
                
                System.out.println("Component 01: Project 01 with In-Class Test 01");
                project01 = validateMarks(userInput, "Enter marks for Project01");
                student.setProject01(project01);
                System.out.println();
            
                ict01 = validateMarks(userInput, "Enter marks for the In-Class-Test01");
                student.setIct01(ict01);
                System.out.println();
            
                activePart01 = validateMarks(userInput, "Enter the marks for Active Paritcipation 01");
                student.setActivePart01(activePart01); 
                System.out.println();
                
                System.out.println("Component 02: Coding Assignment with In-Class Test 02");
                codingAssign = validateMarks(userInput, "Enter marks for the coding assignment");
                student.setCodingAssign(codingAssign);
                System.out.println();
                
                ict02 = validateMarks(userInput, "Enter marks for the In-Class Test02");
                student.setIct02(ict02);
                System.out.println();
                
                activePart02 = validateMarks(userInput, "Enter marks for the Active Participation 02");
                student.setActivePart02(activePart02);
                System.out.println();
                
                System.out.println("Component 03: Project 02 with In-Class Test 03");
                ict03 = validateMarks(userInput, "Enter marks for the In-Class Test03");
                student.setIct03(ict03);
                System.out.println();
                
                project02 = validateMarks(userInput, "Enter marks for the Project02");
                student.setProject02(project02);
                System.out.println();
                
                activePart03 = validateMarks(userInput, "Enter marks for the Active Participation 03");
                student.setActivePart03(activePart03);
                System.out.println();
                
                System.out.println("Student Registration No: "+student.getRegno());
                System.out.println("Student Name           : "+student.getfName()+" "+student.getlName());
                moduleMark=student.project01WithICT()+student.codingWithIct()+student.project02WithIct();
                student.setModuleMark(moduleMark);
                System.out.println("Module Mark            : "+student.getModuleMark());
                System.out.println("Grade                  : "+student.gradeCalculator());
                System.out.println();
                
                System.out.println("Component 01: Project 01 with ICT");
                System.out.println("---------------------------------");
                System.out.println("Marks in 30%  = "+student.project01WithICT());
                compo_AvgIn100=(student.project01WithICT()*100/30);
                System.out.println("Marks in 100% = "+compo_AvgIn100);
                
                System.out.println();
                
                System.out.println("Component 02: Coding Assignment with ICT");
                System.out.println("----------------------------------------");
                System.out.println("Marks in 35%  = "+student.codingWithIct());
                compo_AvgIn100=(student.codingWithIct()*100/35);
                System.out.println("Marks in 100% = "+compo_AvgIn100);
                
                System.out.println();
                
                System.out.println("Component 03: Project 02 with ICT");
                System.out.println("---------------------------------");
                System.out.println("Marks in 35%  = "+student.project02WithIct());
                compo_AvgIn100 = (student.project02WithIct()*100/35);
                System.out.println("Marks in 100% = "+compo_AvgIn100);
                
                System.out.println("\n");
                
                sList.add(student);
                
                System.out.println("Do you want to continue?( Y / N )");
                
                userChoice=userInput.next();
                System.out.println();
                num++;        
            }
            
            caseStudy.setCompo_01Avg();
            caseStudy.setCompo_02Avg();
            caseStudy.setCompo_03Avg();
    }
    
    public static void marksBelow40(){
        double component01;
        int compo_Count01=0;
        double component02;
        int compo_Count02=0;
        double component03;
        int compo_Count03=0;
        
        System.out.println("THE NUMBER OF STUDENTS WHO HAVE SCORED LESS THAN 40 FOR EACH COMPONENT");
        System.out.println("----------------------------------------------------------------------");
        
        for(Student obj:sList ){
            
            component01=obj.project01WithICT()*100/30;
            
            if(component01<40){
                compo_Count01++;
            }
            
            component02=obj.codingWithIct()*100/35;
            
            if(component02<40){
                compo_Count02++;
            }
            
            component03=obj.project02WithIct()*100/35;
            if(component03<40){
                compo_Count03++;
            }
            
        }
        System.out.println("For the Component 01: Project 01 with In-class Test        = "+compo_Count01);
        System.out.println("For the component 02: Coding Assignment with In-class Test = "+compo_Count02);
        System.out.println("For the Component 03: Project 02 with In-class Test        = "+compo_Count03);
        System.out.println();
    }
    
    public static void moduleOverall(){
        System.out.println("OVERALL MARKS OF THE MODULE FOR EACH STUDENT:");
        System.out.println("---------------------------------------------");
        System.out.println("StudentID       Module Mark     Grade");
        
        for(Student obj:sList){
            System.out.println(obj.getRegno()+"    -    "+Math.round(obj.getModuleMark()*100)/100+"              "+obj.gradeCalculator());  
        }
    }
    
    public static void classAvg(){
        double totClassAvg=0;
        
        for(Student obj:sList){
            totClassAvg+=obj.getModuleMark();    
        }
        
        System.out.println();
        System.out.println("THE OVERALL CLASS AVERAGE = "+ totClassAvg/(num-1));
        System.out.println("\n");    
    }
    
    public static void stusBelowClassAvg(){
        double totClassAvg=0;
        int stuCount=0;
        String stuInfo;
        
        for(Student obj: sList){
            totClassAvg+=obj.getModuleMark();
        }
        
        System.out.println("DETAILS OF THE STUDENTS WHO HAVE SCORED LESS THAN THE CLASS AVERAGE:");
        System.out.println("--------------------------------------------------------------------");
        
        for(Student obj:sList){
            
            if (obj.getModuleMark()<totClassAvg/(num-1)){
                stuCount+=1;
                stuInfo="(StudentID)- "+obj.getRegno()+"; (First Name)- "+obj.getfName()+"; (Last Name)- "+obj.getlName()+"; (Module Average)- "+Math.round(obj.getModuleMark());
                System.out.println(stuInfo);
                System.out.println();   
            }
            
        }
        
        System.out.println(stuCount+" students have a module mark below the class average");
        System.out.println("\n");
    }
    
    public static void highestScorer(){
        String objInfo = null;
        double max=0;
        
        for(Student obj:sList){
            
            if (obj.getModuleMark()>=max){
                max=obj.getModuleMark();
                objInfo="(StudentID)- "+obj.getRegno()+"; (First Name)- "+obj.getfName()+"; (Last Name)- "+obj.getlName()+"; (Module Average)- "+Math.round(obj.getModuleMark());
            }
            
        }
        System.out.println("DETAILS OF THE HIGHEST SCORER FOR THE OVERALL MODULE:");
        System.out.println("-----------------------------------------------------");
        System.out.println(objInfo);
        System.out.println("\n");
    }
    public static void highestScorers(){// this method will look for the students who have scored highest for each component.
       double compo_01Max=0;//  used to store the maximum mark of component 1.
       double compo_02Max=0;//  used to store the maximum mark of component 2.
       double compo_03Max=0;// used to store the maximum mark of component 3.
       String stuInfoCompo_03=null;// the varible store the information of the student that scored the maximum mark for component 3.
       String stuInfoCompo_02=null;// the varibale store the information of the student that scored the maximum mark for component 2.
       String stuInfoCompo_01=null;// the variable store the information of the student that scored the maximum mark for component 1..
       
       System.out.println("DETAILS OF THE STUDENTS WHO SCORED HIGHEST FOR EACH COMPONENT:");
       System.out.println("--------------------------------------------------------------");
      
       for(Student obj:sList){ // this for-loop the list will assign all the Student objects in it to the variable reference obj. 
           
           if(obj.project01WithICT()>=compo_01Max){ 
               compo_01Max=obj.project01WithICT();// when the component1 mark of a student is maximum, that mark will be assigned to the variable compo01Max.
               stuInfoCompo_01="(StudentID)- "+obj.getRegno()+"; (First Name)- "+obj.getfName()+"; (Last Name)- "+obj.getlName()+"; (Module Average)- "+Math.round(obj.getModuleMark())+"; (Component 01 Mark)- "+Math.round(obj.project01WithICT()*100/30);
           }
       
           if(obj.codingWithIct()>=compo_02Max){
               compo_02Max=obj.codingWithIct();// when component 02 mark of a student is maximum, that mark will be assigned to the variable compo02Max.
               stuInfoCompo_02="(StudentID)- "+obj.getRegno()+"; (First Name)- "+obj.getfName()+"; (Last Name)- "+obj.getlName()+"; (Module Average)- "+Math.round(obj.getModuleMark())+"; (Component 02 Mark)- "+Math.round(obj.codingWithIct()*100/35);
           }
        
           if(obj.project02WithIct()>=compo_03Max){
               compo_03Max=obj.project02WithIct(); // when the component 03 mark of a student is maximum, that mark will be assigned to the variable compo03Max.
               stuInfoCompo_03="(StudentID)- "+obj.getRegno()+"; (First Name)- "+obj.getfName()+"; (Last Name)- "+obj.getlName()+"; (Module Average)- "+Math.round(obj.getModuleMark())+"; (Component 03 Mark)- "+Math.round(obj.project02WithIct()*100/35);
           }
           
        }
       
       System.out.println("For Component 01:");
       System.out.println(stuInfoCompo_01);// displaying information of the student who got highest marks for component 1.
       System.out.println();
       System.out.println("For Component 02:");
       System.out.println(stuInfoCompo_02);// displaying information of the student who got highest marks for component 2.
       System.out.println();
       System.out.println("For Component 03:");
       System.out.println(stuInfoCompo_03);//  displaying information of the student who got highest marks for component 3.
       System.out.println("\n");
    }
    public static void retakeStudents(){
        int retakeCount=0;
        Grade grade=null;
        System.out.println("DETAILS OF THE STUDENTS WHO ARE RE-TAKING:");
        System.out.println("------------------------------------------");
        
        List<Student>sList3=new ArrayList<Student>();
        
        for(Student obj:sList){
            
            if(obj.gradeCalculator()==grade.RETAKE){
                retakeCount++;
                sList3.add(obj);    
            }
            
        }
        
        Collections.sort(sList3, new Comparator<Student>(){
            public int compare(Student o1, Student o2) {
                return o1.getlName().compareTo(o2.getlName());
            }
        });
        
        for(int i=0; i<sList3.size(); i++){
            
            System.out.println("(Student ID)- "+sList3.get(i).getRegno()+"; (First Name)- "+sList3.get(i).getfName()+"; (Last Name)- "+sList3.get(i).getlName()+"; (Module Mark)- "+Math.round(sList3.get(i).getModuleMark()));
            System.out.println();
            
        }
        
        System.out.println(retakeCount+" Students are Re-taking");
        System.out.println("\n"); 
    }
    
    public static void resitStudents(){
        Grade grade=null;
        
        List<Student> compo_1sList=new ArrayList<Student>();
        List<Student> compo_2sList=new ArrayList<Student>();
        List<Student> compo_3sList=new ArrayList<Student>();
        
        for(Student obj:sList){
            
            if((obj.gradeCalculator()==grade.RESIT) && (obj.project01WithICT()*100/30)<40){
                compo_1sList.add(obj);
            }
            
        }
        
        for(Student obj:sList){
            
            if((obj.gradeCalculator()==grade.RESIT)&&(obj.codingWithIct()*100/35)<40){
                compo_2sList.add(obj);
            }
            
        }
        
        for(Student obj:sList){
            
           if((obj.gradeCalculator()==grade.RESIT)&&(obj.project02WithIct()*100/35)<40){
                compo_3sList.add(obj);
            }
           
        }
        
        Collections.sort(compo_1sList, new Comparator<Student>(){
            public int compare(Student o1, Student o2) {
                return o1.getlName().compareTo(o2.getlName());
            }
        });
        
        Collections.sort(compo_2sList, new Comparator<Student>(){
            public int compare(Student o1, Student o2) {
                return o1.getlName().compareTo(o2.getlName());
            }
        });
        
        Collections.sort(compo_3sList, new Comparator<Student>(){
            public int compare(Student o1, Student o2) {
                return o1.getlName().compareTo(o2.getlName());
            }
        });
        
        System.out.println("DETAILS OF THE STUDENTS WHO HAS A RESIT FOR EACH COMPONENT:");
        System.out.println("-------------------------------------------------------------");
        System.out.println("For Component 1: Project 1 with In-Class Test 01");
        
        for(int i=0; i<compo_1sList.size(); i++){
            
            System.out.println("(Student ID)- "+compo_1sList.get(i).getRegno()+"; (First Name)- "+compo_1sList.get(i).getfName()+"; (Last Name)- "+compo_1sList.get(i).getlName()+"; (Module Mark)- "+Math.round(compo_1sList.get(i).getModuleMark()));
            System.out.println();
            
        }
        
        System.out.println(compo_1sList.size()+" students has a resit for component 1 ");
        System.out.println();
        System.out.println("For Component 2: Coding Assignment with In-Class Test 01");
        
        for(int i=0; i<compo_2sList.size(); i++){
            
            System.out.println("(Student ID)- "+compo_2sList.get(i).getRegno()+"; (First Name)- "+compo_2sList.get(i).getfName()+"; (Last Name)- "+compo_2sList.get(i).getlName()+"; (Module Mark)- "+Math.round(compo_2sList.get(i).getModuleMark()));
            System.out.println();
            
        }
        
        System.out.println(compo_2sList.size()+" students has a resit for component 2");
        System.out.println();
        System.out.println("For Component 3: Project 2 with In-Class Test 01");
        
        for(int i=0; i<compo_3sList.size(); i++){
            
            System.out.println("(Student ID)- "+compo_3sList.get(i).getRegno()+"; (First Name)- "+compo_3sList.get(i).getfName()+"; (Last Name)- "+compo_3sList.get(i).getlName()+"; (Module Mark)- "+Math.round(compo_3sList.get(i).getModuleMark()));
            System.out.println();
            
        }
        
        System.out.println(compo_3sList.size()+" students has a resit for component 3");
        System.out.println("\n");
    }
    
    //Answer for the 11 th question
    public static void gradeHolders(){
        Grade grade=null;
        
        List<Student> hdList = new ArrayList<Student>();
        List<Student> dList = new ArrayList<Student>();
        List<Student> cList = new ArrayList<Student>();
        List<Student> pList = new ArrayList<Student>();
        
        for(Student obj: sList){
            
            if(obj.gradeCalculator()==grade.HD){
                hdList.add(obj);
            }
            
        }
        
        for(Student obj: sList){
            
            if(obj.gradeCalculator()==grade.D){
                 dList.add(obj);
            }
            
        }
        
        for(Student obj: sList){
            
            if(obj.gradeCalculator()==grade.C){
                cList.add(obj);
            }
            
        }
        
        for(Student obj: sList){
            
            if(obj.gradeCalculator()==grade.PASS){
                pList.add(obj);
            }
            
        }
        
        Collections.sort(hdList, new Comparator<Student>(){
            public int compare(Student o1, Student o2) {
                return Double.valueOf(o2.getModuleMark()).compareTo(o1.getModuleMark());
            }
        });
        
        Collections.sort(dList, new Comparator<Student>(){
            public int compare(Student o1, Student o2) {
                return Double.valueOf(o2.getModuleMark()).compareTo(o1.getModuleMark());
            }
        });
        
        Collections.sort(cList, new Comparator<Student>(){
            public int compare(Student o1, Student o2) {
                return Double.valueOf(o2.getModuleMark()).compareTo(o1.getModuleMark());
            }
        });
        
        Collections.sort(pList, new Comparator<Student>(){
            public int compare(Student o1, Student o2) {
                return Double.valueOf(o2.getModuleMark()).compareTo(o1.getModuleMark());
            }
        });
        
        System.out.println("LISTING STUDENTS BASED ON THEIR GRADE:");
        System.out.println("--------------------------------------");
        System.out.println("Students who achieved Higher Distinction(HD):");
        
        for(int i=0; i<hdList.size(); i++){
            
            System.out.println("(Student ID)- "+hdList.get(i).getRegno()+"; (Firs tName)- "+hdList.get(i).getfName()+"; (Last Name)- "+hdList.get(i).getlName()+"; (Module Mark)- "+Math.round(hdList.get(i).getModuleMark()));
            System.out.println();
            
        }
        
        System.out.println(hdList.size()+" students have a HD for the module");
        System.out.println();
        
        System.out.println("Students who achieved Distinction(D):");
        
        for(int i=0; i<dList.size(); i++){
            
            System.out.println("(Student ID)- "+dList.get(i).getRegno()+"; (First Name)- "+dList.get(i).getfName()+"; (Last Name)- "+dList.get(i).getlName()+"; (Module Mark)- "+Math.round(dList.get(i).getModuleMark()));
            System.out.println();
            
        }
        
        System.out.println(dList.size()+" students have a D for the module"+"\n");
        
        System.out.println("Students who achieved a Credit(C):");
        
        for(int i=0; i<cList.size(); i++){
            
            System.out.println("(Student ID)- "+cList.get(i).getRegno()+"; (First Name)- "+cList.get(i).getfName()+"; (Last Name)- "+cList.get(i).getlName()+"; (Module Mark)- "+Math.round(cList.get(i).getModuleMark()));
            System.out.println();
            
        }
        
        System.out.println(cList.size()+" students have a C for the module"+"\n");
        
        System.out.println("Student who achieved a PASS:");
        
        for(int i=0; i<pList.size(); i++){
            
            System.out.println("(Student ID)- "+pList.get(i).getRegno()+"; (First Name)- "+pList.get(i).getfName()+"; (Last Name)- "+pList.get(i).getlName()+"; (Module Mark)- "+Math.round(pList.get(i).getModuleMark()));
            System.out.println();
            
        }
        
        System.out.println(pList.size()+" students have a PASS for the module"+"\n");
    }
    
    public static double validateMarks(Scanner sc, String message){
        double marks;
        
        System.out.println(message);
        
        do{
            
            while (!sc.hasNextDouble()){
                
                System.err.println("Invalid input please enter a mark within the range of 0 to 100. Enter the mark below");
                sc.next();
                
            }
            marks=sc.nextInt();
            
            if(marks<0 || marks>100){
                
                System.err.println("Invalid marks, please input a mark within the range of 0 to 100. Enter the mark below");
                
            }
            
        }while(marks<0 || marks>100);
        
        return marks;
    }
    
    public static void componentAvearge(){
        
        System.out.println(caseStudy.compo_01Avg);
        System.out.println(caseStudy.compo_02Avg);
        System.out.println(caseStudy.compo_03Avg);
    }
}