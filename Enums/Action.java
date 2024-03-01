package Enums;

enum Action {

    DODGE {
        
        public boolean execute(Object player) {
            return player.dodge();
        }
    },

    ATTACK {
        public boolean execute(Object player) {
            return player.attack();
        }
    },

    JUMP {
        public boolean execute(Object player) {
            return player.jump();
        }
    },

    BLOCK {
        public boolean execute(Object player) {
            return player.block();
        }
    },

    NONE {
        public boolean execute(Object player) {
            return false;
        }
    };

    // Abstract method
    public abstract boolean execute(Object player);
}
