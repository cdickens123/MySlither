package de.mat2095.my_slither;


class Food {

    final int x, y;
    private final double size;
    private final double rsp;
    private final long spawnTime;
    private int color;
    private static final int food_colours[] = {
        0x000080,
        0x0000ff,
       0x00ffff,
        0x008000,
        0xffff00,
        0xffa500,
        0xfa8072,
        0xff0000,
        0xee82ee,
        0xbfff00,
        0xbfff00,
        0xbfff00,
        0xbfff00,
};

    Food(int x, int y, double size, boolean fastSpawn, int colorIndex) {
        //System.out.println("h");
        //System.out.println(colorIndex);
        this.x = x;
        this.y = y;
        this.size = size;
        this.rsp = fastSpawn ? 4 : 1;
        spawnTime = System.currentTimeMillis();
        this.color = food_colours[colorIndex];
    }

    int getColor()
    {
        return color;
    }

    double getSize() {
        return size;
    }

    double getRadius() {
        double fillRate = rsp * (System.currentTimeMillis() - spawnTime) / 1200;
        if (fillRate >= 1) {
            return size;
        } else {
            return (1 - Math.cos(Math.PI * fillRate)) / 2 * size;
        }
    }
}
