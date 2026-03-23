package my.zhamri.csc584enterprise_programming.model;

public class Student {
    private int id;
    private String name;
    private String matricNo;
    private String program;

    public Student() {}

    public Student(int id, String name, String matricNo, String program) {
        this.id = id;
        this.name = name;
        this.matricNo = matricNo;
        this.program = program;
    }

    public Student(String name, String matricNo, String program) {
        this.name = name;
        this.matricNo = matricNo;
        this.program = program;
    }

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMatricNo() { return matricNo; }
    public void setMatricNo(String matricNo) { this.matricNo = matricNo; }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }
}