// class Robot {

//     public Robot(int width, int height) {
        
//     }
    
//     public void step(int num) {
        
//     }
    
//     public int[] getPos() {
        
//     }
    
//     public String getDir() {
        
//     }
// }

// /**
//  * Your Robot object will be instantiated and called as such:
//  * Robot obj = new Robot(width, height);
//  * obj.step(num);
//  * int[] param_2 = obj.getPos();
//  * String param_3 = obj.getDir();
//  */
class Robot {

    int w, h;
    int x, y;
    int dir; // 0=East,1=North,2=West,3=South
    int perimeter;

    public Robot(int width, int height) {
        w = width;
        h = height;
        x = 0;
        y = 0;
        dir = 0;
        perimeter = 2 * (w + h - 2);
    }

    public void step(int num) {

        if (perimeter == 0) return;

        num %= perimeter;

        // special case: if at origin and full loop
        if (num == 0 && x == 0 && y == 0) {
            dir = 3; // South
            return;
        }

        while (num > 0) {

            if (dir == 0) { // East
                int move = Math.min(num, w - 1 - x);
                x += move;
                num -= move;
                if (num > 0) dir = 1;
            }

            else if (dir == 1) { // North
                int move = Math.min(num, h - 1 - y);
                y += move;
                num -= move;
                if (num > 0) dir = 2;
            }

            else if (dir == 2) { // West
                int move = Math.min(num, x);
                x -= move;
                num -= move;
                if (num > 0) dir = 3;
            }

            else { // South
                int move = Math.min(num, y);
                y -= move;
                num -= move;
                if (num > 0) dir = 0;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}