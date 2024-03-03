package OOP.Members;

public class ObjectMemberVStaticMember {
    static int staticCounter = 0;
    int memberCounter = 0;

    void increment() {
        staticCounter++;
        memberCounter++;
    }

    public static void main(String[] args) {
        final ObjectMemberVStaticMember o1 = new ObjectMemberVStaticMember();
        final ObjectMemberVStaticMember o2 = new ObjectMemberVStaticMember();
        o1.increment();
        o2.increment();
        o2.increment();

        System.out.println("o1 static counter " + o1.staticCounter);
        System.out.println("o1 member counter " + o1.memberCounter);
        System.out.println();
        System.out.println("o2 static counter " + o2.staticCounter);
        System.out.println("o2 member counter " + o2.memberCounter);
        System.out.println();
        System.out.println("ObjectMemberVsStaticMember.staticCounter = " +
                ObjectMemberVStaticMember.staticCounter);
    }
}
