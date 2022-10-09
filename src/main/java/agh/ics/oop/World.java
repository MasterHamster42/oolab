package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("System wystartowal");
        String[] commends = {"f", "b", "l", "r"};
        run(string_to_direction(commends));
        System.out.println();
        System.out.println("System zakonczyl dzialanie");
    }
    public static void run(Direction[] commends){
        for (int i = 0; i < commends.length; i++) {
            switch (commends[i]) {
                case FORWARD -> System.out.print("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.print("Zwierzak idzie do tylu");
                case RIGHT -> System.out.print("Zwierzak skreca w prawo");
                case LEFT -> System.out.print("Zwierzak skreca w lewo");
                default -> {
                }
            }
            if (i < commends.length-1){
                System.out.println(", ");
            }
        }
    }
    public static Direction[] string_to_direction(String[] commands) {
        Direction[] enum_commands = new Direction[commands.length];
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "f" -> enum_commands[i] = Direction.FORWARD;
                case "b" -> enum_commands[i] = Direction.BACKWARD;
                case "r" -> enum_commands[i] = Direction.RIGHT;
                case "l" -> enum_commands[i] = Direction.LEFT;
                default -> {
                }
            }
        }
        return enum_commands;
    }
}
