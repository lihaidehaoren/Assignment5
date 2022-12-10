public abstract class Member {
    protected String memberId;
    protected char gender;
    protected int age;

    public Member(String info) {
        String[] parts = info.split(" ");
        this.memberId = parts[0];
        this.gender = parts[1].charAt(0);
        this.age = Integer.parseInt(parts[2]);
    }
    public String getMemberId(){
        return memberId;
    }

    public abstract double consume(int amount);
    public abstract String toString();
}