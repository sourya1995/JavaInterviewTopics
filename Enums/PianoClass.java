package Enums;

enum PianoClass {
    JOHN, BEN, LUKE, RITA {
        @Override
        public String getSex() {
            return "Female";
        }

        @Override
        public String getLevel() {
            return "Intermediate";
        }
    }, //enum constant specific body
    TOM {
        @Override
        public String getSex() {
            return "Female";
        }

        @Override
        public String getLevel() {
            return "Advanced";
        }
    };

    public String getSex() {
        return "Male";
    }

    public String getLevel() {
        return "Beginner";
    }

    public static void main(String[] args) {
        PianoClass tom = PianoClass.TOM;
        System.out.println(tom.getSex());
        System.out.println(tom.getLevel());

        PianoClass rita = PianoClass.RITA;
        System.out.println(rita.getSex());
        System.out.println(rita.getLevel());
    }

}
