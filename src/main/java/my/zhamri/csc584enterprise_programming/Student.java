package my.zhamri.csc584enterprise_programming;

public class Student {

    private String name;
    private String matricNo;
    private String program;

    // No-arg constructor
    public Student() {}

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricNo() {
        return matricNo;
    }

    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
