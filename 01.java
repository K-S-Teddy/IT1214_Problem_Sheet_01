class Student{
    private int studentId;
    private String name;
    private int daysAttended;

    public Student(int studentId,String name,int daysAttended){
        this.studentId=studentId;
        this.name=name;
        this.daysAttended=daysAttended;
    }
    public int getStudentId(){
        return studentId;
    }
    public String getName(){
        return name;
    }
    public int getDaysAttended(){
        return daysAttended;
    }

    public void setStudentId(int studentId){
        this.studentId=studentId;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDaysAttended(int daysAttended){
        this.daysAttended=daysAttended;
    }
    public String toString(){
        return "ID: "+studentId+", Name: "+name+", Days Attended: "+daysAttended;
    }

}

class Classroom{
    private Student[] students=new Student[10];
    private int count=0;

    public void addStudent(Student s){
        if(count<students.length){
            students[count++]=s;
        }
        else{
            System.out.println("Classroom is full.");
        }
    }

    public void updateAttendance(int studentId, int newDays){
        for(int i=0;i<count;i++){
            if(students[i].getStudentId()==studentId){
                students[i].setDaysAttended(newDays);
                return;
            }
        }
        System.out.println("Student ID not found. ");
    }

    public void displayAll(){
        for(int i=0;i<count;i++){
            System.out.println(students[i]);
        }
    }

}

 class AttendanceMain{
    public static void main(String[] args){
        Classroom classroom=new Classroom();

        classroom.addStudent(new Student(101,"Alice Smith",12));
        classroom.addStudent(new Student(102,"Bob Jones",15));
        classroom.addStudent(new Student(103,"Carol Lee",10));

        classroom.updateAttendance(102,16);
        classroom.updateAttendance(104,12);

        classroom.displayAll();
    }

}